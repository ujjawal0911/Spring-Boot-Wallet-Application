package com.ujjawal0911.WalletApplication.Controllers;

import com.ujjawal0911.WalletApplication.Models.Wallet;
import com.ujjawal0911.WalletApplication.Services.WalletService;
import io.swagger.annotations.ApiOperation;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WalletController {

    @Autowired
    private WalletService walletService;

    @ApiOperation(value = "Get all wallets from the database.")
    @RequestMapping(value = "/wallets", method = RequestMethod.GET)
    public List<Wallet> getAllWallets() {
        return walletService.getAllWallets();
    }

    @ApiOperation(value = "Deposit Money given wallet Id.")
    @RequestMapping(value = "/deposit-money/{walletId}", method = RequestMethod.POST)
    public Wallet depositMoney(@PathVariable int walletId, @RequestBody String amount) {
        JSONObject jsonObject = new JSONObject(amount);
        int value = jsonObject.getInt("amount");
        return walletService.depositMoney(walletId, value);
    }

    @ApiOperation(value = "Withdraw Money given wallet Id.")
    @RequestMapping(value = "/withdraw-money/{walletId}", method = RequestMethod.POST)
    public Wallet withdrawMoney(@PathVariable int walletId, @RequestBody String amount) {
        JSONObject jsonObject = new JSONObject(amount);
        int value = jsonObject.getInt("amount");
        return walletService.withdrawMoney(walletId, value);
    }
}
