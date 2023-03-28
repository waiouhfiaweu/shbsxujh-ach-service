package com.banistmo.service.bsl.serv.impl;

import com.cobis.core.ach.service.CobisCatalogService;
import com.cobiscorp.ecobis.isoprdservice.bsl.serv.bsl.ICreateCustomOrder;
import com.cobiscorp.ecobis.isoswitchservice.bsl.serv.bsl.ICreateOrderACH;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import com.cobiscorp.cobisv.commons.context.Session;
import com.cobiscorp.cobisv.commons.context.Context;
import com.cobiscorp.cobisv.commons.context.ContextManager;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Log4j2
public class CreateCustomOrderImpl implements ICreateCustomOrder {
    @Autowired
    private CobisCatalogService cobisCatalog;

    @Autowired
    private ICreateOrderACH createOrderACHSERVImpl;

    public Boolean isSameBank(com.cobiscorp.ecobis.isoswitchservice.bsl.dto.AchMessage aParameter){
        Context context = ContextManager.getContext();
        Session session = context.getSession();
        String currentBank;
        Map<String, Object> aParameterCrud = aParameter.getInfo();
        Map<String, Object> order = (Map<String, Object>) aParameterCrud.get("order");
        currentBank = cobisCatalog.getValue(session.getBackEndId(), "ach_bancos_participantes",
                String.valueOf(order.get("receiverCode")));
        return "BANISTMO".equals(currentBank);
    }

    public com.cobiscorp.ecobis.isoswitchservice.bsl.dto.AchMessage createOrder(
            com.cobiscorp.ecobis.isoswitchservice.bsl.dto.AchMessage aParameter){
        return createOrderACHSERVImpl.newAchMessageResponse(aParameter);
    }

}

