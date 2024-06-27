package com.anup.excelloader.dto;

import com.poiji.annotation.ExcelCellName;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PaymentConfigs {
    @ExcelCellName("isPartialAuthAllowed") 
    private boolean isPartialAuthAllowed;

    @ExcelCellName("cardCheck") 
    private boolean cardCheck;

    @ExcelCellName("cardVerify") 
    private boolean cardVerify;

    @ExcelCellName("isWalletSupported") 
    private boolean isWalletSupported;

    @ExcelCellName("adhocRefund") 
    private boolean adhocRefund;
}