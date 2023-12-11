package com.bank.springbankingproject.repo;

import com.bank.springbankingproject.model.Account;
import com.bank.springbankingproject.model.Instruction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstructionRepo extends JpaRepository<Instruction,Long> {
}
