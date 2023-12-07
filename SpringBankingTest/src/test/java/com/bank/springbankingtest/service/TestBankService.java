package com.bank.springbankingtest.service;

import com.bank.springbankingtest.model.Account;
import com.bank.springbankingtest.model.Instruction;
import com.bank.springbankingtest.repo.AccountRepo;
import com.bank.springbankingtest.repo.InstructionRepo;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

public class TestBankService {

    private static BankService service;

    private static AccountRepo repoAccount;

    private static InstructionRepo repoInstruction;

    @BeforeAll
    public static void setUp(){
        service = new BankService();
        repoAccount = Mockito.mock(AccountRepo.class);
        repoInstruction = Mockito.mock(InstructionRepo.class);
    }

    @Test
    public void testValidateAccount(){
        service.setARepo(repoAccount);
        service.setIRepo(repoInstruction);
        Account debitAccount = new Account("INR", "John Doe", "HDFC");
        debitAccount.setId(123456L);
        Account creditAccount = new Account("INR", "John Doe", "HDFC");
        creditAccount.setId(98765L);
        Mockito.when(repoAccount.findByIdAndBankAndCurrencyAndBranch(debitAccount.getId(),debitAccount.getBank(),debitAccount.getCurrency(),debitAccount.getBranch())).thenReturn(Optional.of(debitAccount));
        Mockito.when(repoInstruction.save(any(Instruction.class))).thenReturn(new Instruction(4567321L, "INR", "Credit", 1234.345, "SBI", "CPP"));
        Mockito.when(repoAccount.findByIdAndBankAndCurrencyAndBranch(creditAccount.getId(),creditAccount.getBank(),creditAccount.getCurrency(),creditAccount.getBranch())).thenReturn(Optional.of(creditAccount));
        String s = service.validateAccount(debitAccount, creditAccount, 123.345);

        Assertions.assertEquals("Transaction is successful",s);
    }


    @AfterAll
    public  static void cleanUp(){
        service = null;
        repoAccount = null;
        repoInstruction = null;
    }
}
