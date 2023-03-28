package com.cobiscorp.ecobis.isoprdservice.bsl.serv.bsl;

public interface ICreateCustomOrder {
    Boolean isSameBank(com.cobiscorp.ecobis.isoswitchservice.bsl.dto.AchMessage aParameter);

    com.cobiscorp.ecobis.isoswitchservice.bsl.dto.AchMessage createOrder(
            com.cobiscorp.ecobis.isoswitchservice.bsl.dto.AchMessage aParameter);
}
