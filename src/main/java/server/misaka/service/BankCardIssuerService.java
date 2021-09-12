package server.misaka.service;

import server.misaka.service.dto.BankCardIssuerDTO;

/**
 * BankCardIssuerService.
 * @author Kahle
 * @date 2021-09-13T14:10:35.213+0800
 */
public interface BankCardIssuerService {

    /**
     * 根据 银行卡号 查询 银行卡发行商信息
     */
    BankCardIssuerDTO issuerInfo(String bankCardNumber);

}
