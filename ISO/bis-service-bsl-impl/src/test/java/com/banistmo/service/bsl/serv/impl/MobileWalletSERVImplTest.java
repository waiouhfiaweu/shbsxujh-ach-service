package com.banistmo.service.bsl.serv.impl;

import com.cobis.core.ach.service.CobisParameterService;
import com.cobiscorp.ecobis.isoswitchservice.bsl.dto.AchMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
class MobileWalletSERVImplTest {
    @InjectMocks
    MobileWalletSERVImpl mobileWalletSERVImpl;

    @Mock
    CobisParameterService cobisParameter;
    @Test
    void shouldValidateMobileWalletAccountReturnTrue(){
        AchMessage achMessage = new AchMessage();
        achMessage.setInfo(new HashMap());
        Map<String, Object> order = new HashMap<>();
        order.put("receiverAccountNumber", "50767086740");
        achMessage.getInfo().put("order", order);
        Mockito.when(cobisParameter.getParameter(null, "ACH", "CTCD", String.class)).thenReturn("507");
        Mockito.when(cobisParameter.getParameter(null, "ACH", "FICN", String.class)).thenReturn("6");
        mobileWalletSERVImpl.validateMobileWalletAccount(achMessage);
        boolean response=true;
        Assertions.assertTrue(response, "Passed");
    }

    @Test
    void shouldValidateMobileWalletAccountReturnFalse(){
        AchMessage achMessage = new AchMessage();
        achMessage.setInfo(new HashMap());
        Map<String, Object> order = new HashMap<>();
        order.put("receiverAccountNumber", "50777086740");
        achMessage.getInfo().put("order", order);
        Mockito.when(cobisParameter.getParameter(null, "ACH", "CTCD", String.class)).thenReturn("507");
        Mockito.when(cobisParameter.getParameter(null, "ACH", "FICN", String.class)).thenReturn("6");
        mobileWalletSERVImpl.validateMobileWalletAccount(achMessage);
        boolean response=true;
        Assertions.assertTrue(response, "Passed");
    }
}