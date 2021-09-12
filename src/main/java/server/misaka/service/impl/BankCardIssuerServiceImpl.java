package server.misaka.service.impl;

import artoria.beans.BeanUtils;
import artoria.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.misaka.persistence.entity.BankCardIssuer;
import server.misaka.persistence.mapper.BankCardIssuerMapper;
import server.misaka.service.BankCardIssuerService;
import server.misaka.service.dto.BankCardIssuerDTO;

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

    @Override
    public BankCardIssuerDTO issuerInfo(String bankCardNumber) {
        if (StringUtils.isBlank(bankCardNumber)) { return null; }
        String iin = bankCardNumber.substring(0, 6);
        BankCardIssuer bankCardIssuer = bankCardIssuerMapper.findByIin(iin);
        if (bankCardIssuer == null) {
            iin = bankCardNumber.substring(0, 7);
            bankCardIssuer = bankCardIssuerMapper.findByIin(iin);
        }
        if (bankCardIssuer == null) {
            iin = bankCardNumber.substring(0, 8);
            bankCardIssuer = bankCardIssuerMapper.findByIin(iin);
        }
        if (bankCardIssuer == null) {
            iin = bankCardNumber.substring(0, 9);
            bankCardIssuer = bankCardIssuerMapper.findByIin(iin);
        }
        if (bankCardIssuer == null) {
            iin = bankCardNumber.substring(0, 5);
            bankCardIssuer = bankCardIssuerMapper.findByIin(iin);
        }
        if (bankCardIssuer == null) {
            iin = bankCardNumber.substring(0, 4);
            bankCardIssuer = bankCardIssuerMapper.findByIin(iin);
        }
        if (bankCardIssuer == null) {
            iin = bankCardNumber.substring(0, 10);
            bankCardIssuer = bankCardIssuerMapper.findByIin(iin);
        }
        if (bankCardIssuer == null) {
            iin = bankCardNumber.substring(0, 3);
            bankCardIssuer = bankCardIssuerMapper.findByIin(iin);
        }
        if (bankCardIssuer == null) { return null; }
        BankCardIssuerDTO result = BeanUtils.beanToBean(bankCardIssuer, BankCardIssuerDTO.class);
        result.setBankCardNumber(bankCardNumber);
        return result;
    }

}
