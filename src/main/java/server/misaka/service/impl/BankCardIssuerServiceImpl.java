package server.misaka.service.impl;

import artoria.beans.BeanUtils;
import artoria.util.CollectionUtils;
import artoria.common.Paging;
import artoria.util.PagingUtils;
import artoria.common.Input;
import artoria.common.PageResult;
import artoria.common.Result;
import artoria.exception.VerifyUtils;
import server.misaka.persistence.entity.BankCardIssuer;
import server.misaka.persistence.mapper.BankCardIssuerMapper;
import server.misaka.service.BankCardIssuerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static artoria.common.Errors.PARAMETER_IS_REQUIRED;

/**
 * BankCardIssuerServiceImpl.
 * @author Kahle
 * @date 2021-09-13T14:10:35.213+0800
 */
@Slf4j
@Service
public class BankCardIssuerServiceImpl implements BankCardIssuerService {

    @Autowired
    private BankCardIssuerMapper bankCardIssuerMapper;

}
