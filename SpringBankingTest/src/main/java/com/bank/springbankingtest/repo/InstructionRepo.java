package com.bank.springbankingtest.repo;

import com.bank.springbankingtest.model.Instruction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructionRepo extends JpaRepository<Instruction,Long> {
}
