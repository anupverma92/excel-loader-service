package com.anup.excelloader.service;

import java.util.ArrayList;
import java.util.List;

import com.anup.excelloader.dto.ClientConfiguration;
import com.anup.excelloader.repository.ExcelRepository;
import org.springframework.stereotype.Service;

import com.anup.excelloader.model.ExcelDocument;
import com.anup.excelloader.model.Config;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ExcelConfigImpl {

    private final ExcelRepository excelRepository;

    public ExcelDocument convertConfigPojoToEntity(ClientConfiguration client) {

        ExcelDocument excelDocument = new ExcelDocument();
        excelDocument.setClientID(client.getClientID());
        excelDocument.setMid(client.getMid());
        excelDocument.setEnterpriseCode(client.getEnterpriseCode());
        excelDocument.setGpbu(client.getGpbu());
        excelDocument.setBu(client.getBu());
        excelDocument.setChannel(client.getChannel());
        excelDocument.setCardAcceptanceType(client.getCardAcceptanceType());

        Config config = new Config("ResortDetails", client.getResortInformation());
        Config configToken = new Config("AccessToken", client.getAccessToken());
        Config configFeatures = new Config("ClientFeatures", client.getClientFeatures());
        Config configPayment = new Config("PaymentConfigs", client.getPaymentConfigs());
        Config configVerification = new Config("PaymentVerification", client.getPaymentVerification());
        Config configPaymentAuth = new Config("PaymentAuth", client.getPaymentAuth());
        Config configSupportedPayment = new Config("SupportedPaymentTenders", client.getSupportedPaymentTenders());
        Config configGatewayPreference = new Config("GatewayPreference",client.getGatewayPreferenceList());

        List<Config> configList = new ArrayList<>();
        configList.add(config);
        configList.add(configToken);
        configList.add(configFeatures);
        configList.add(configPayment);
        configList.add(configVerification);
        configList.add(configPaymentAuth);
        configList.add(configSupportedPayment);
        configList.add(configGatewayPreference);
        excelDocument.setClientConfigs(configList);


        excelDocument.setPaymentVerificationProvider(client.getPaymentVerificationProvider());
        deleteClientDocument(client.getClientID());
        return excelDocument;
    }

    public void deleteClientDocument(String clientID) {
        List<ExcelDocument> existingDocList = excelRepository.findByClientID(clientID);
        if(existingDocList != null){
            for (ExcelDocument existingDoc : existingDocList) {
                excelRepository.delete(existingDoc);
            }
        }
    }

    public void saveClientDocument(ExcelDocument clientDoc) {
        excelRepository.save(clientDoc);
    }

}
