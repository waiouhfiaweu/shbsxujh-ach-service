package com.cobiscorp.ecobis.isoprdservice.bsl.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardPropertiesDtoTest {
    CreditCardPropertiesDto dto=new CreditCardPropertiesDto();
    @Test
    void probarEndpoint() {
        dto.setEndpoint("endpoint");
        assertEquals("endpoint",dto.getEndpoint());
    }

    @Test
    void probarTimeout() {
        dto.setTimeout("timeout");
        assertEquals("timeout",dto.getTimeout());
    }

    @Test
    void probarSimulatedCallTimeout() {
        dto.setSimulatedCallTimeout("simulatedCallTimeout");
        assertEquals("simulatedCallTimeout",dto.getSimulatedCallTimeout());
    }

    @Test
    void probarUserCobis() {
        dto.setUserCobis("userCobis");
        assertEquals("userCobis",dto.getUserCobis());
    }

    @Test
    void probarIpOrigin() {
        dto.setIpOrigin("192.168.0.1");
        assertEquals("192.168.0.1",dto.getIpOrigin());
    }

}