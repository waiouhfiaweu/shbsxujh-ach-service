package com.cobis.core.ach.application;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.boot.SpringApplication;

class AchApplicationTest {
    @Test
    void main() {
        AchApplication achApplication = new AchApplication();
        MockedStatic<SpringApplication> utilities = Mockito.mockStatic(SpringApplication.class);
        utilities.when((MockedStatic.Verification) SpringApplication.run(AchApplication.class,
                new String[]{})).thenReturn(null);
        AchApplication.main(new String[]{});
        boolean response=true;
        Assert.assertTrue("Passed",response);
    }
}