package com.banistmo.service.bsl.serv.config;

import com.banistmo.service.bsl.serv.impl.CreditCardSERVImpl;
import com.banistmo.service.bsl.serv.impl.MobileWalletSERVImpl;
import com.cobiscorp.ecobis.isoprdservice.bsl.serv.bsl.ICreditCard;
import com.cobiscorp.ecobis.isoprdservice.bsl.serv.bsl.IMobileWallet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BisAutoConfiguration {
    @Bean
    public IMobileWallet nequiMobileWalletValidation(){
        return new MobileWalletSERVImpl();
    }

    @Bean
    public ICreditCard creditCard(){
        return new CreditCardSERVImpl();
    }
}
