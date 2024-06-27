package com.anup.excelloader.dto;

import com.poiji.annotation.ExcelCellName;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
@ToString
public class ResortInformation {
    @ExcelCellName("ResortCode")
    private String resortCode;

    @ExcelCellName("ResortName")
    private String resortName;

    @ExcelCellName("ResortAddressLine")
    private String resortAddressLine;

    @ExcelCellName("ResortCity")
    private String resortCity;

    @ExcelCellName("ResortState")
    private String resortState;

    @ExcelCellName("ResortCountry")
    private String resortCountry;

    @ExcelCellName("ResortPostalCode")
    private String resortPostalCode;
}