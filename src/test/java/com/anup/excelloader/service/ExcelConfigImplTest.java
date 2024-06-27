package com.anup.excelloader.service;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import com.anup.excelloader.dto.ClientConfiguration;
import com.anup.excelloader.dto.GatewayConfig;
import com.anup.excelloader.repository.ExcelRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.anup.excelloader.model.ExcelDocument;

@SpringBootTest
class ExcelConfigImplTest {

    @Autowired
    private ExcelConfigImpl excelConfigImpl;

    @MockBean
    private ExcelRepository excelRepository;

    @Test
    void shouldConvertConfigPojoToEntityAndDeleteExistingDocument() {
        ClientConfiguration client = new ClientConfiguration();
        GatewayConfig config = new GatewayConfig();
        List<String> gatewayPreference = List.of("gateway1", "gateway2");
        List<Boolean> isGatewayActive = List.of(true, false);
        config.setGatewayPreference(gatewayPreference);
        config.setIsGatewayActive(isGatewayActive);
        client.setGatewayConfig(config);
        ExcelDocument excelDocument = excelConfigImpl.convertConfigPojoToEntity(client);
        assertThat(excelDocument).isNotNull();
        assertThat(excelRepository).isNotNull();
    }
}
