package com.banistmo.service.bsl.serv.impl;

import com.cobis.core.ach.service.CobisCatalogService;
import com.cobiscorp.cobisv.commons.context.Context;
import com.cobiscorp.cobisv.commons.context.ContextManager;
import com.cobiscorp.cobisv.commons.context.Session;
import com.cobiscorp.ecobis.isoswitchservice.bsl.dto.AchMessage;
import com.cobiscorp.ecobis.isoswitchservice.bsl.serv.bsl.ICreateOrderACH;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class CreateCustomOrderImplTest {
    @InjectMocks
    CreateCustomOrderImpl createCustomOrder;

    @Mock
    CobisCatalogService cobisCatalog;

    @Mock
    ICreateOrderACH createOrderACHSERVImpl;

    @Test
    void shouldSameBankWhenFalseReturn(){
        Context context = mock(Context.class);
        Session session = mock(Session.class);
        try(MockedStatic<ContextManager> contextManager = Mockito.mockStatic(ContextManager.class)) {
            contextManager.when(() -> ContextManager.getContext())
                    .thenReturn(context);
            Mockito.when(context.getSession()).thenReturn(session);
            Mockito.when(session.getBackEndId()).thenReturn("v1");
            Boolean bool = createCustomOrder.isSameBank(getAchMessage());
            Assertions.assertFalse(bool);
        }
    }

    @Test
    void shouldCreateOrderWhenSuccessfulCreated(){
        com.cobiscorp.ecobis.isoswitchservice.bsl.dto.AchMessage achMessage;
        Mockito.when(createOrderACHSERVImpl.newAchMessageResponse(any())).thenReturn(new AchMessage());
        achMessage = createCustomOrder.createOrder(getAchMessage());
        Assertions.assertNotNull(achMessage);
    }

    com.cobiscorp.ecobis.isoswitchservice.bsl.dto.AchMessage getAchMessage(){
        com.cobiscorp.ecobis.isoswitchservice.bsl.dto.AchMessage achMessage =
                new AchMessage();
        Map<String, Object> info = new HashMap<>();
        Map<String, Object> order = new HashMap<>();
        order.put("receiverCode", "202");
        info.put("order", order);
        achMessage.setInfo(info);
        return achMessage;
    }
}