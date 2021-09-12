package server.misaka.facade.api;

import artoria.beans.BeanUtils;
import artoria.common.Input;
import artoria.common.PageResult;
import artoria.common.Result;
import artoria.util.PagingUtils;
import server.misaka.persistence.entity.BankCardIssuer;
import server.misaka.service.dto.BankCardIssuerDTO;
import server.misaka.facade.vo.BankCardIssuerVO;
import server.misaka.service.BankCardIssuerService;
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
 * BankCardIssuerController.
 * @author Kahle
 * @date 2021-09-13T14:10:35.213+0800
 */
@Slf4j
@Controller
public class BankCardIssuerController {

    @Autowired
    private BankCardIssuerService bankCardIssuerService;

    /*@ResponseBody
    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public Result<Object> hello(@RequestBody BankCardIssuerVO bankCardIssuerVO) {

        return new Result<Object>("Hello, World! ");
    }*/

}
