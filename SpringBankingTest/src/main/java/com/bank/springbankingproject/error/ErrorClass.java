package com.bank.springbankingproject.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorClass {

    private String msg;
    private String reason;
}
