package com.ujjawal0911.WalletApplication.Repositories;

import com.ujjawal0911.WalletApplication.Models.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserAccount, Integer> {
}
