package com.banistmo.service.bsl.serv.impl;

import com.cobis.core.ach.service.CobisParameterService;
import com.cobiscorp.ecobis.isoprdservice.bsl.serv.bsl.IMobileWallet;
import com.cobiscorp.ecobis.isoswitchservice.bsl.dto.AchMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MobileWalletSERVImpl implements IMobileWallet {

    @Autowired
    private CobisParameterService cobisParameter;

    @Override
    public boolean validateMobileWalletAccount(AchMessage achMessage) {
        Map<String, Object> wInfo = achMessage.getInfo();
        Map<String, Object> wOrder = (Map<String, Object>) wInfo.get("order");
        String receiverAccountOrder = (String) wOrder.get("receiverAccountNumber");
        final int COUNTER = 3;
        String countryCode = receiverAccountOrder.substring(0, COUNTER);
        String firstCelNumber = Character.toString(receiverAccountOrder.charAt(COUNTER));
        String targetCountryCode = cobisParameter.getParameter(null, "ACH", "CTCD", String.class);
        String targetFirstCelNumber = cobisParameter.getParameter(null, "ACH", "FICN", String.class);
        return (countryCode.contains(targetCountryCode) && firstCelNumber.contains(targetFirstCelNumber));
    }
}
