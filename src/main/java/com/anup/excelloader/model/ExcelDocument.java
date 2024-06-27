package com.anup.excelloader.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "excel_collection")
public class ExcelDocument {
    @Id
    private String id;

    private String clientID;

    private String mid;

    private String enterpriseCode;

    private String gpbu;

    private String bu;

    private String channel;

    private String cardAcceptanceType;

    private String paymentVerificationProvider;

    private List<Config> clientConfigs;

    @JsonIgnore
    private LocalDate createDate;

}
