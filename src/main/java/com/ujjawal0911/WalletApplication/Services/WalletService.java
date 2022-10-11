package com.ujjawal0911.WalletApplication.Services;

import com.ujjawal0911.WalletApplication.Models.AccountTransaction;
import com.ujjawal0911.WalletApplication.Models.Type;
import com.ujjawal0911.WalletApplication.Models.Wallet;
import com.ujjawal0911.WalletApplication.Repositories.TransactionRepository;
import com.ujjawal0911.WalletApplication.Repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private TransactionRepository transactionRepository;

    public List<Wallet> getAllWallets() {
        List<Wallet> wallets = new ArrayList<>();
        walletRepository.findAll().forEach(wallets::add);
        return wallets;
    }

    public Wallet depositMoney(int walletId, int amount) {

        Wallet wallet = walletRepository.findById(walletId);
        wallet.setBalance(wallet.getBalance() + amount);
        walletRepository.save(wallet);

        AccountTransaction accountTransaction = transactionService.createTransaction(amount, wallet);
        accountTransaction.setType(Type.DEPOSIT);
        transactionRepository.save(accountTransaction);

        return wallet;
    }

    public Wallet withdrawMoney(int walletId, int amount) {

        Wallet wallet = walletRepository.findById(walletId);
        wallet.setBalance(wallet.getBalance() - amount);
        walletRepository.save(wallet);

        AccountTransaction accountTransaction = transactionService.createTransaction(amount, wallet);
        accountTransaction.setType(Type.WITHDRAWAL);
        transactionRepository.save(accountTransaction);

        return wallet;
    }
}
