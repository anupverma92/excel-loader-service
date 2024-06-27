package com.anup.excelloader.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class GatewayPreference {
    private String gatewayId;
    private int preference;
    private boolean isGatewayActive;
}
