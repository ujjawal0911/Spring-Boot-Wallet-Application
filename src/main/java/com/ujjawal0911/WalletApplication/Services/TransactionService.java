package com.ujjawal0911.WalletApplication.Services;

import com.ujjawal0911.WalletApplication.Models.AccountTransaction;
import com.ujjawal0911.WalletApplication.Models.Wallet;
import com.ujjawal0911.WalletApplication.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    // get all transactions based on walletId
    public List<AccountTransaction> getAllTransaction(int walletId) {
        return transactionRepository.findByWalletWalletId(walletId);
    }

    // create a new transaction
    public AccountTransaction createTransaction(int amount, Wallet wallet) {
        AccountTransaction accountTransaction = new AccountTransaction(amount, wallet);
        accountTransaction.setPerformedAt(LocalDateTime.now());
        transactionRepository.save(accountTransaction);
        return accountTransaction;
    }
}
