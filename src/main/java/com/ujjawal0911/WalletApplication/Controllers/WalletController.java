package com.ujjawal0911.WalletApplication.Controllers;

import com.ujjawal0911.WalletApplication.Models.Wallet;
import com.ujjawal0911.WalletApplication.Repositories.WalletRepository;
import com.ujjawal0911.WalletApplication.Services.WalletService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WalletController {

    @Autowired
    private WalletService walletService;

    @RequestMapping("/wallets")
    public List<Wallet> getAllWallets() {
        return walletService.getAllWallets();
    }

    @RequestMapping(value = "/deposit-money/{walletId}", method = RequestMethod.POST)
    public Wallet depositMoney(@PathVariable int walletId, @RequestBody String amount) {
        JSONObject jsonObject = new JSONObject(amount);
        int value = jsonObject.getInt("amount");
        return walletService.depositMoney(walletId, value);
    }

    @RequestMapping(value = "/withdraw-money/{walletId}", method = RequestMethod.POST)
    public Wallet withdrawMoney(@PathVariable int walletId, @RequestBody String amount) {
        JSONObject jsonObject = new JSONObject(amount);
        int value = jsonObject.getInt("amount");
        return walletService.withdrawMoney(walletId, value);
    }
}
