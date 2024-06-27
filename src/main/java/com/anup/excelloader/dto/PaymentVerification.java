package com.anup.excelloader.dto;

import com.poiji.annotation.ExcelCellName;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PaymentVerification {
    @ExcelCellName("fraudCheck")
    private boolean fraudCheck;

    @ExcelCellName("cardVerify")
    private boolean cardVerify;
}
