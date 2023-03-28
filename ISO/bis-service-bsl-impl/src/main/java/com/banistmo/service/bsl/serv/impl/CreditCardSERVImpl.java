package com.banistmo.service.bsl.serv.impl;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.cobiscorp.ecobis.isoprdservice.bsl.dto.CreditCardDto;
import com.cobiscorp.ecobis.isoprdservice.bsl.dto.CreditCardPropertiesDto;
import com.cobiscorp.ecobis.isoprdservice.bsl.dto.ResponseDto;
import com.cobiscorp.ecobis.isoprdservice.bsl.serv.bsl.ICreditCard;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@XRayEnabled
public class CreditCardSERVImpl implements ICreditCard {

    @Override
    public void validateAccountTC() {
        return;
    }

    @Override
    public ResponseDto execTCAccount(CreditCardDto aCreditCardDto,
                                     CreditCardPropertiesDto creditCardPropertiesDto, Map aFeatureToggle) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setResult(Boolean.FALSE);
        return responseDto;
    }

	@Override
	public void validateErrorTC(com.cobiscorp.ecobis.achnetworkmanagement.bsl.dto.Request aParameter) {
		return;
	}
}
