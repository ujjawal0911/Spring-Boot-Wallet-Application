package com.ujjawal0911.WalletApplication.Repositories;

import com.ujjawal0911.WalletApplication.Models.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Integer> {
}
