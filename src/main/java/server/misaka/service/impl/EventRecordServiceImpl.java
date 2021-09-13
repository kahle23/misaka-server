package server.misaka.service.impl;

import artoria.beans.BeanUtils;
import artoria.util.CollectionUtils;
import artoria.common.Paging;
import artoria.util.PagingUtils;
import artoria.common.Input;
import artoria.common.PageResult;
import artoria.common.Result;
import artoria.exception.VerifyUtils;
import server.misaka.persistence.entity.EventRecord;
import server.misaka.persistence.mapper.EventRecordMapper;
import server.misaka.service.EventRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.misaka.service.dto.EventRecordDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static artoria.common.Constants.ONE;
import static artoria.common.Constants.SYSTEM;
import static artoria.common.Errors.PARAMETER_IS_REQUIRED;

/**
 * EventRecordServiceImpl.
 * @author Kahle
 * @date 2021-09-14T17:16:12.277+0800
 */
@Slf4j
@Service
public class EventRecordServiceImpl implements EventRecordService {

    @Autowired
    private EventRecordMapper eventRecordMapper;

    @Override
    public void add(EventRecordDTO eventRecordDTO) {
        VerifyUtils.notNull(eventRecordDTO, PARAMETER_IS_REQUIRED);
        Date nowDate = new Date();
        EventRecord eventRecord =
                BeanUtils.beanToBean(eventRecordDTO, EventRecord.class);
        eventRecord.setCreatorId(SYSTEM);
        eventRecord.setCreateTime(nowDate);
        eventRecord.setUpdaterId(SYSTEM);
        eventRecord.setUpdateTime(nowDate);
        eventRecord.setAliveFlag(ONE);
        int effect = eventRecordMapper.insertSelective(eventRecord);
        VerifyUtils.isTrue(effect == ONE, "事件记录增加失败！");
    }

}
