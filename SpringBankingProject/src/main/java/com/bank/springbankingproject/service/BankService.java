package com.bank.springbankingproject.service;

import com.bank.springbankingproject.Exceptions.NoAccountFoundException;
import com.bank.springbankingproject.model.Account;
import com.bank.springbankingproject.model.Instruction;
import com.bank.springbankingproject.repo.AccountRepo;
import com.bank.springbankingproject.repo.InstructionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankService {

    @Autowired
    private AccountRepo aRepo;

    @Autowired
    private InstructionRepo iRepo;

    public String validateAccount(Account debitAccount, Account creditAccount, Double amount){
        Optional<Account> byIdDebit = aRepo.findByIdAndBankAndCurrencyAndBranch(debitAccount.getId(),debitAccount.getBank(),debitAccount.getCurrency(),debitAccount.getBranch());
        Account debitAccountInfo = byIdDebit.orElseThrow(() -> new NoAccountFoundException("Debit Account Not found"));
        iRepo.save(new Instruction(debitAccountInfo.getId(), debitAccountInfo.getCurrency(), "Debit", amount, debitAccountInfo.getBank(), debitAccountInfo.getBranch()));
        Optional<Account> byIdCredit = aRepo.findByIdAndBankAndCurrencyAndBranch( creditAccount.getId(),creditAccount.getBank(),creditAccount.getCurrency(),creditAccount.getBranch());
        Account creditAccountInfo = byIdCredit.orElseThrow(() -> new NoAccountFoundException("Credit Account Not found"));
        iRepo.save(new Instruction(debitAccountInfo.getId(), debitAccountInfo.getCurrency(), "Credit", amount, debitAccountInfo.getBank(), debitAccountInfo.getBranch()));

        return "Transaction is successful";
    }
}
