package com.cobiscorp.ecobis.isoprdservice.bsl.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CreditCardPropertiesDto implements Cloneable, Serializable {

    String endpoint;
    String timeout;
    String simulatedCallTimeout;
    String userCobis;
    String ipOrigin;
}
