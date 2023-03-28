package com.banistmo.service.bsl.serv.impl;

import com.cobiscorp.ecobis.isoprdservice.bsl.dto.ResponseDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CreditCardSERVImplTest {
    @Test
    void execTCAccountAndValidateAccountTCAndValidateErrorTC() {
        CreditCardSERVImpl creditCard = new CreditCardSERVImpl();
        creditCard.validateAccountTC();
        creditCard.validateErrorTC(null);
        ResponseDto response=creditCard.execTCAccount(null,null,null);
        Assertions.assertEquals(Boolean.FALSE,response.getResult());
    }
}