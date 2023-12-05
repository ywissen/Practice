package com.bank.springbankingproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentInstruction {

    Account debitAccount;

    Account creditAccount;

    Double amount;
}
