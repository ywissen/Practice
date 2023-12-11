package com.bank.springbankingproject.controller;

import com.bank.springbankingproject.Exceptions.NoAccountFoundException;
import com.bank.springbankingproject.model.Account;
import com.bank.springbankingproject.model.Instruction;
import com.bank.springbankingproject.model.PaymentInstruction;
import com.bank.springbankingproject.repo.AccountRepo;
import com.bank.springbankingproject.repo.InstructionRepo;
import com.bank.springbankingproject.service.BankService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/bank")
@Data
public class BankController {

    @Autowired
    private AccountRepo repo;

    @Autowired
    private InstructionRepo iRepo;

    @Autowired
    private BankService service;

    @GetMapping("/account/{aId}")
    public Mono<Account> getAccountDetails(@PathVariable Long aId){
        Account user = repo.findById(aId).orElseThrow(() -> new NoAccountFoundException("Record Not found with id "+aId));
       return Mono.just(user);
    }

    @PostMapping("/doPayment")
    public ResponseEntity<String> doPayment(@RequestBody PaymentInstruction paymentInstruction){
        Account idDebit = paymentInstruction.getDebitAccount();
        Account idCredit = paymentInstruction.getCreditAccount();
        Double amount = paymentInstruction.getAmount();
        return new ResponseEntity<String>(service.validateAccount(idDebit,idCredit,amount), HttpStatus.OK);
    }

    @GetMapping("/instructions")
    public Flux<Instruction> findAllInstructions(){
        return Flux.fromIterable(iRepo.findAll());
    }
}
