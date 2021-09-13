package server.misaka.facade.api;

import artoria.beans.BeanUtils;
import artoria.common.Input;
import artoria.common.PageResult;
import artoria.common.Result;
import artoria.util.PagingUtils;
import server.misaka.persistence.entity.EventRecord;
import server.misaka.service.dto.EventRecordDTO;
import server.misaka.facade.vo.EventRecordVO;
import server.misaka.service.EventRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * EventRecordController.
 * @author Kahle
 * @date 2021-09-14T17:16:12.277+0800
 */
@Slf4j
@Controller
public class EventRecordController {

    @Autowired
    private EventRecordService eventRecordService;

    /*@ResponseBody
    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public Result<Object> hello(@RequestBody EventRecordVO eventRecordVO) {

        return new Result<Object>("Hello, World! ");
    }*/

}
