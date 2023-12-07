package com.bank.springbankingtest.repo;

import com.bank.springbankingtest.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepo extends JpaRepository<Account,Long> {
    Optional<Account> findByIdAndBankAndCurrencyAndBranch(Long id, String bank, String currency, String branch);
}
