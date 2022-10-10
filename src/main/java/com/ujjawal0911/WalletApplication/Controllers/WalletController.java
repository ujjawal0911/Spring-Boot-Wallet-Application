package com.ujjawal0911.WalletApplication.Controllers;

import com.ujjawal0911.WalletApplication.Models.Wallet;
import com.ujjawal0911.WalletApplication.Repositories.WalletRepository;
import com.ujjawal0911.WalletApplication.Services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WalletController {

    @Autowired
    private WalletService walletService;

    @RequestMapping("/wallets")
    public List<Wallet> getAllWallets() {
        return walletService.getAllWallets();
    }

}
