package com.ujjawal0911.WalletApplication.Controllers;

import com.ujjawal0911.WalletApplication.Models.AccountTransaction;
import com.ujjawal0911.WalletApplication.Services.TransactionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @ApiOperation(value = "Gives all the transactions related to a particular wallet Id.")
    @RequestMapping(value = "/get-all-transactions/{walletId}", method = RequestMethod.GET)
    public List<AccountTransaction> getAllTransactions(@PathVariable int walletId) {
        return transactionService.getAllTransaction(walletId);
    }
}
