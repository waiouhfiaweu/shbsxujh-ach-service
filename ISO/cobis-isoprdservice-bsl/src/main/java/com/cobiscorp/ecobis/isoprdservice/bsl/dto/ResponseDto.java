package com.cobiscorp.ecobis.isoprdservice.bsl.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ResponseDto  implements Cloneable, Serializable {
    Integer statusCode;
    String statusDesc;
    Boolean result;
}
