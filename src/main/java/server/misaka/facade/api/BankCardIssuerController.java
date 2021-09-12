package server.misaka.facade.api;

import artoria.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import server.misaka.service.BankCardIssuerService;

import static server.misaka.UrlMapping.BANK_CARD_ISSUER_INFO;

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

    /**
     * 根据 银行卡号 查询 银行卡发行商信息
     */
    @ResponseBody
    @RequestMapping(value = BANK_CARD_ISSUER_INFO, method = RequestMethod.GET)
    public Result<Object> issuerInfo(String bankCardNumber) {

        return new Result<Object>(bankCardIssuerService.issuerInfo(bankCardNumber));
    }

}
