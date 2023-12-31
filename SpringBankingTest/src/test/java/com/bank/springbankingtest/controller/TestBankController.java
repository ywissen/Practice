package com.bank.springbankingtest.controller;


import com.bank.springbankingproject.Exceptions.NoAccountFoundException;
import com.bank.springbankingproject.controller.BankController;
import com.bank.springbankingproject.model.Account;
import com.bank.springbankingproject.model.Instruction;
import com.bank.springbankingproject.model.PaymentInstruction;
import com.bank.springbankingproject.repo.AccountRepo;
import com.bank.springbankingproject.repo.InstructionRepo;
import com.bank.springbankingproject.service.BankService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.assertArg;
import static org.mockito.Mockito.*;

import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class TestBankController {

    @Mock
    private static AccountRepo repoAccount;

    @InjectMocks
    private static BankController bankController;



    @BeforeAll
    public static void setUp(){
        bankController = new BankController();

    }


    @ParameterizedTest
    @ValueSource(longs = {1L,2L,3L,4L})
    @DisplayName("Test get Account with valid Details")
    public void testGetAccountDetails(Long accountId) {
        Account mockAccount = new Account("INR", "John Doe", "HDFC");
        when(repoAccount.findById(accountId)).thenReturn(Optional.of(mockAccount));

        Mono<Account> result = bankController.getAccountDetails(accountId);

        assertEquals(mockAccount, result.block());


    }

    @Test
    @DisplayName("Test get Account with In Valid Details")
    public void testAccountDetailsNotFound(){
        Long accountId = 1L;

        when(repoAccount.findById(accountId)).thenReturn(Optional.empty());
        assertThrows(NoAccountFoundException.class,()->{
            bankController.getAccountDetails(accountId).block();
        });
    }

    @Test
    @DisplayName("Test do payment method")
    public void testDoPayment(){

        BankService service = mock(BankService.class);
        bankController.setService(service);
        Account debitAccount = new Account("INR", "John Doe", "HDFC");
        Account creditAccount = new Account("INR", "John Doe", "HDFC");
        PaymentInstruction paymentInstruction = new PaymentInstruction(debitAccount,creditAccount,1025.367);
        when(service.validateAccount(debitAccount,creditAccount,1025.367)).thenReturn("Transaction is successful");
        ResponseEntity<String> stringResponseEntity = bankController.doPayment(paymentInstruction);

        assertEquals(HttpStatus.OK,stringResponseEntity.getStatusCode());
        assertEquals("Transaction is successful",stringResponseEntity.getBody());
    }

    @Test
    @DisplayName("Test find all Instructions")
    public void testFindAllInstructions(){
        InstructionRepo mock = mock(InstructionRepo.class);
        bankController.setIRepo(mock);
        List<Instruction> expected = Arrays.asList(new Instruction(1234567L,"INR","Debit",1234.345,"HDFC","CPP"),
                new Instruction(4567321L,"INR","Credit",1234.345,"SBI","CPP"));
        when(mock.findAll()).thenReturn(expected);
        List<Instruction> actual = bankController.findAllInstructions().collectList().block();
        assertEquals(expected,actual);
    }

    @AfterAll
    public static  void cleanUp(){
        bankController=null;
    }
}
