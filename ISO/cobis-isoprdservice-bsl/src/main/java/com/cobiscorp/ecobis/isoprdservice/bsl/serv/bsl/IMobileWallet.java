package com.cobiscorp.ecobis.isoprdservice.bsl.serv.bsl;
import com.cobiscorp.ecobis.isoswitchservice.bsl.dto.AchMessage;

public interface IMobileWallet {
    boolean validateMobileWalletAccount(AchMessage achMessage);
}
