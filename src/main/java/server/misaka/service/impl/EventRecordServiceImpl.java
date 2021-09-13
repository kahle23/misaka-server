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

import java.util.ArrayList;
import java.util.List;

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

}
