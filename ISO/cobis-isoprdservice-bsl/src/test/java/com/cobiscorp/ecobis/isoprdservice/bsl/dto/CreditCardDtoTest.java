package com.cobiscorp.ecobis.isoprdservice.bsl.dto;

import org.junit.jupiter.api.Test;

import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardDtoTest {
    CreditCardDto dto=new CreditCardDto();
    //
    @Test
    void getCalendar() {
        GregorianCalendar calendar=new GregorianCalendar();
        dto.setCalendar(calendar);
        assertEquals(calendar,dto.getCalendar());
    }
    //
    @Test
    void getHora() {
        dto.setHora("12:01");
        assertEquals("12:01",dto.getHora());
    }

    @Test
    void probarSsn() {
        dto.setSsn("ssn");
        assertEquals("ssn",dto.getSsn());
    }

    @Test
    void probarParamUserTcCobis() {
        dto.setParamCityTcCobis(null);
        assertNull(dto.getParamUserTcCobis());
    }

    @Test
    void probarParamCityTcCobis() {
        dto.setParamCityTcCobis("paramCityTcCobis");
        assertEquals("paramCityTcCobis",dto.getParamCityTcCobis());
    }

    @Test
    void probarCalendarFechaVencimiento() {
        GregorianCalendar calendar=new GregorianCalendar();
        dto.setCalendarFechaVencimiento(calendar);
        assertEquals(calendar,dto.getCalendarFechaVencimiento());
    }

    @Test
    void probarReceiverAccountNumber() {
        dto.setReceiverAccountNumber("12345");
        assertEquals("12345",dto.getReceiverAccountNumber());
    }

    @Test
    void probarAmount() {
        dto.setAmount(null);
        assertNull(dto.getAmount());
    }

    @Test
    void getOriginatorNumberOrder() {
        dto.setOriginatorNumberOrder("originatorNumberOrder");
        assertEquals("originatorNumberOrder",dto.getOriginatorNumberOrder());
    }

    @Test
    void probarParamCmovTcCobis() {
        dto.setParamCmovTcCobis("paramCmovTcCobis");
        assertEquals("paramCmovTcCobis",dto.getParamCmovTcCobis());
    }

    @Test
    void probarCreditCardSize() {
        Integer size=new Integer(10);
        dto.setCreditCardSize(size);
        assertEquals(size,dto.getCreditCardSize());
    }
}