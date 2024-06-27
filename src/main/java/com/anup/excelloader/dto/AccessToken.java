package com.anup.excelloader.dto;

import com.poiji.annotation.ExcelCellName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccessToken {

    @ExcelCellName("GatewayID") 
    private String gatewayID;

    @ExcelCellName("TokenValue") 
    private String tokenValue;
}