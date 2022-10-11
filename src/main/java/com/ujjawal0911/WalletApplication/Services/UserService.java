package com.ujjawal0911.WalletApplication.Services;

import com.ujjawal0911.WalletApplication.Models.UserAccount;
import com.ujjawal0911.WalletApplication.Models.Wallet;
import com.ujjawal0911.WalletApplication.Repositories.UserRepository;
import com.ujjawal0911.WalletApplication.Repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private WalletRepository walletRepository;

    public List<UserAccount> getAllUsers() {
        List<UserAccount> userAccounts = new ArrayList<>();
        userRepository.findAll().forEach(userAccounts::add);
        return userAccounts;
    }

    public UserAccount getUser(int userId) {
        return userRepository.findById(userId);
    }

    public UserAccount createUser(UserAccount userAccount) {
        Wallet wallet = new Wallet();

        userAccount.setWallet(wallet);
        wallet.setUser(userAccount);

        userRepository.save(userAccount);
        walletRepository.save(wallet);
        return userAccount;
    }

    public UserAccount updateUser(UserAccount userAccount) {
        userRepository.save(userAccount);
        return userAccount;
    }

    public void deleteUser(UserAccount userAccount) {
        userRepository.delete(userAccount);
    }

}
