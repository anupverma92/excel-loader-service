package com.anup.excelloader.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Config {

    private String configName;

    private Object configValue;
}
