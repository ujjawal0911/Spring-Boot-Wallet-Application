package com.ujjawal0911.WalletApplication.Repositories;

import com.ujjawal0911.WalletApplication.Models.AccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<AccountTransaction, Integer> {
    public List<AccountTransaction> findByWalletWalletId(int walletId);
}
