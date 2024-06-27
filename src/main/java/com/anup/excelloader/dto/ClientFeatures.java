package com.anup.excelloader.dto;

import com.poiji.annotation.ExcelCellName;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClientFeatures {
    @ExcelCellName("coBrandedCard")
    private boolean coBrandedCard;

    @ExcelCellName("joinWhileBooking") 
    private boolean joinWhileBooking;

    @ExcelCellName("allowBillingAddressToGuestAddress") 
    private boolean allowBillingAddressToGuestAddress;
}