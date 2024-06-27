package com.anup.excelloader.dto;

import java.util.ArrayList;
import java.util.List;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelCellRange;
import com.poiji.annotation.ExcelSheet;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ExcelSheet("ClientConfig")
@ToString
public class ClientConfiguration {
    @ExcelCellName("ClientID")
    private String clientID;

    @ExcelCellName("PNSMID")
    private String mid;

    @ExcelCellName("Ecode")
    private String enterpriseCode;

    @ExcelCellName("GPBU")
    private String gpbu;

    @ExcelCellName("BU")
    private String bu;

    @ExcelCellName("Channel")
    private String channel;

    @ExcelCellName("CardAcceptanceType")
    private String cardAcceptanceType;

    @ExcelCellName("PaymentVerificationProvider")
    private String paymentVerificationProvider;

    @ExcelCellName("SupportedPaymentTenders")
    private List<String> supportedPaymentTenders;

    @ExcelCellRange
    private ResortInformation resortInformation;

    @ExcelCellRange
    private AccessToken accessToken;

    @ExcelCellRange
    private ClientFeatures clientFeatures;

    @ExcelCellRange
    private PaymentConfigs paymentConfigs;

    @ExcelCellRange
    private PaymentVerification paymentVerification;

    @ExcelCellRange
    private PaymentAuth paymentAuth;

    @ExcelCellRange
    private GatewayConfig gatewayConfig;

    public List<GatewayPreference> getGatewayPreferenceList(){
        List<GatewayPreference> gatewayPreferenceList;
        List<String> gatewayPreference = gatewayConfig.getGatewayPreference();
        List<Boolean> isGatewayActive = gatewayConfig.getIsGatewayActive();
        gatewayPreferenceList = new ArrayList<>(gatewayPreference.size());
        for (int i = 0; i < gatewayPreference.size(); i++) {
            String id = gatewayPreference.get(i);
            boolean isActive = ((isGatewayActive.get(i) != null) ? isGatewayActive.get(i) : false);
            GatewayPreference gp = new GatewayPreference(id, (i+1), isActive);
            gatewayPreferenceList.add(gp);
        }
        return gatewayPreferenceList;
    }
}