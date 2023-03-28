package com.cobiscorp.ecobis.isoprdservice.bsl.serv.bsl;

import com.cobiscorp.ecobis.isoprdservice.bsl.dto.CreditCardDto;
import com.cobiscorp.ecobis.isoprdservice.bsl.dto.CreditCardPropertiesDto;
import com.cobiscorp.ecobis.isoprdservice.bsl.dto.ResponseDto;

import java.util.Map;

public interface ICreditCard {

	void validateAccountTC();

	ResponseDto execTCAccount(CreditCardDto aCreditCardDto,
							  CreditCardPropertiesDto creditCardPropertiesDto, Map aFeatureToggle);

	void validateErrorTC(com.cobiscorp.ecobis.achnetworkmanagement.bsl.dto.Request aParameter);

}
