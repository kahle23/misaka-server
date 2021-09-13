package server.misaka.service;

import artoria.common.Input;
import artoria.common.PageResult;
import artoria.common.Result;
import server.misaka.persistence.entity.EventRecord;
import server.misaka.service.dto.EventRecordDTO;

import java.util.List;

/**
 * EventRecordService.
 * @author Kahle
 * @date 2021-09-14T17:16:12.277+0800
 */
public interface EventRecordService {

    /**
     * 增加事件记录
     */
    void add(EventRecordDTO eventRecordDTO);

}
