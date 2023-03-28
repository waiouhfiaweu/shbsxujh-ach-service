package com.cobiscorp.ecobis.isoprdservice.bsl.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResponseDtoTest {
    ResponseDto dto=new ResponseDto();
    @Test
    void probarStatusCode() {
        Integer code=new Integer(1);
        dto.setStatusCode(code);
        assertEquals(code,dto.getStatusCode());
    }

    @Test
    void probarStatusDesc() {
        dto.setStatusDesc("A");
        assertEquals("A",dto.getStatusDesc());
    }

    @Test
    void probarResult() {
        Boolean result=new Boolean(true);
        dto.setResult(result);
        assertEquals(result,dto.getResult());
    }
}