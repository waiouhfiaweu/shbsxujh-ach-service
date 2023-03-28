package com.cobiscorp.ecobis.isoprdservice.bsl.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.GregorianCalendar;

@Getter
@Setter
public class CreditCardDto implements Cloneable, Serializable {

    GregorianCalendar calendar;
    String hora;
    String ssn;
    String paramUserTcCobis;
    String paramCityTcCobis;
    GregorianCalendar calendarFechaVencimiento;
    String receiverAccountNumber;
    BigDecimal amount;
    String originatorNumberOrder;
    String paramCmovTcCobis;
    Integer creditCardSize;
}
