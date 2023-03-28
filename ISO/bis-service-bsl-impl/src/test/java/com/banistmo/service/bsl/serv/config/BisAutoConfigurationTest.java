package com.banistmo.service.bsl.serv.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BisAutoConfigurationTest {
    BisAutoConfiguration bisAutoConfiguration = new BisAutoConfiguration();
    @Test
    void nequiMobileWalletValidation() {
        bisAutoConfiguration.nequiMobileWalletValidation();
        boolean response=true;
        Assertions.assertTrue(response, "Passed");
    }

    @Test
    void creditCard() {
        bisAutoConfiguration.creditCard();
        boolean response=true;
        Assertions.assertTrue(response, "Passed");
    }
}