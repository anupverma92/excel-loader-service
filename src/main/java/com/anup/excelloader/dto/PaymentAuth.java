package com.anup.excelloader.dto;

import com.poiji.annotation.ExcelCellName;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PaymentAuth {
    @ExcelCellName("fraudCheck")
    private boolean fraudCheck;

    @ExcelCellName("authorize")
    private boolean authorize;

    @ExcelCellName("capture")
    private boolean capture;
}
