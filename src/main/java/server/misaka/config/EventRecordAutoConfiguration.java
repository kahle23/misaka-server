package server.misaka.config;

import artoria.event.*;
import artoria.spring.ApplicationContextUtils;
import artoria.time.DateUtils;
import artoria.util.Assert;
import artoria.util.StringUtils;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import server.misaka.service.EventRecordService;
import server.misaka.service.dto.EventRecordDTO;

import java.util.Map;

/**
 * 事件记录器配置.
 * @author Kahle
 */
@Configuration
@AutoConfigureBefore({EventAutoConfiguration.class})
@EnableConfigurationProperties({EventProperties.class})
public class EventRecordAutoConfiguration {
    private static Logger log = LoggerFactory.getLogger(EventAutoConfiguration.class);
    @Value("${spring.application.name:unknown}")
    private String serverAppId;

    @Autowired
    public EventRecordAutoConfiguration(EventProperties eventProperties) {
        Assert.notNull(eventProperties, "Parameter \"eventProperties\" must not null. ");
        //this.eventProperties = eventProperties;
    }

    @Bean
    public EventProvider eventProvider(EventProperties eventProperties) {
        Assert.notNull(eventProperties, "Parameter \"eventProperties\" must not null. ");
        String destination = eventProperties.getDestination();
        String anonymousIdName = eventProperties.getAnonymousIdName();
        String tokenIdName = eventProperties.getTokenIdName();
        String clientAppIdName = eventProperties.getClientAppIdName();
        if (StringUtils.isBlank(destination)) { destination = "event_record"; }
        EventProvider eventProvider = new HttpEventProvider(
                serverAppId, destination, anonymousIdName, tokenIdName, clientAppIdName) {
            @Override
            protected void push(Event event) {
                show(event);
                try {
                    EventRecordService eventRecordService =
                            ApplicationContextUtils.getBean(EventRecordService.class);
                    EventRecordDTO eventRecordDTO = new EventRecordDTO();
                    eventRecordDTO.setEventCode(event.getCode());
                    eventRecordDTO.setEventTime(DateUtils.parse(event.getTime()));
                    eventRecordDTO.setDistinctId(event.getDistinctId());
                    eventRecordDTO.setAnonymousId(event.getAnonymousId());

                    Map<Object, Object> properties = event.getProperties();
                    eventRecordDTO.setClientId((String) properties.get("clientId"));
                    eventRecordDTO.setClientAppId((String) properties.get("clientAppId"));
                    eventRecordDTO.setClientDeviceId((String) properties.get("clientDeviceId"));
                    eventRecordDTO.setClientUserAgent((String) properties.get("clientUserAgent"));
                    eventRecordDTO.setClientNetAddress((String) properties.get("clientNetAddress"));
                    eventRecordDTO.setInterfaceId((String) properties.get("interfaceId"));
                    eventRecordDTO.setServerId((String) properties.get("serverId"));
                    eventRecordDTO.setServerAppId((String) properties.get("serverAppId"));
                    properties.remove("clientId");
                    properties.remove("clientAppId");
                    properties.remove("clientDeviceId");
                    properties.remove("clientUserAgent");
                    properties.remove("clientNetAddress");
                    properties.remove("interfaceId");
                    properties.remove("serverId");
                    properties.remove("serverAppId");
                    eventRecordDTO.setPropertiesJson(JSON.toJSONString(properties));
                    eventRecordService.add(eventRecordDTO);
                }
                catch (Exception e) {
                    log.error("Save event record error. ", e);
                }
            }
        };
        EventUtils.setEventProvider(eventProvider);
        log.info("The event tools was initialized success. ");
        return eventProvider;
    }

}
