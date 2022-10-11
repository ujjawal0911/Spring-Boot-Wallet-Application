package com.ujjawal0911.WalletApplication.Models;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
public class AccountTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;
    @ManyToOne
    private Wallet wallet;
    private int amount;

    @Enumerated(EnumType.STRING)
    private Type type;
    private LocalDateTime performedAt;

    public AccountTransaction() {

    }

    public AccountTransaction(int amount, Wallet wallet) {
        this.wallet = wallet;
        this.amount = amount;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDateTime getPerformedAt() {
        return performedAt;
    }

    public void setPerformedAt(LocalDateTime performedAt) {
        this.performedAt = performedAt;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
