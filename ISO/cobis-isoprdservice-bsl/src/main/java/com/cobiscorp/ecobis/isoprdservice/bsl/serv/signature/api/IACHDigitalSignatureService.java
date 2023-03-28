package com.cobiscorp.ecobis.isoprdservice.bsl.serv.signature.api;

public interface IACHDigitalSignatureService {

    Object sign(String key, Object toSign, String elementToSign);

}
