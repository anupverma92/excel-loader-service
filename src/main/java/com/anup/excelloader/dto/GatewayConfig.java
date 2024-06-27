package com.anup.excelloader.dto;

import java.util.List;

import com.poiji.annotation.ExcelCellName;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GatewayConfig {

    @ExcelCellName("gatewayPreference")
    private List<String> gatewayPreference;

    @ExcelCellName("isGatewayActive")
    private List<Boolean> isGatewayActive;

}