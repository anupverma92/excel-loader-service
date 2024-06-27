package com.anup.excelloader;

import java.io.File;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.anup.excelloader.dto.ClientConfiguration;
import com.anup.excelloader.model.ExcelDocument;
import com.anup.excelloader.service.ExcelConfigImpl;
import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class ExcelLoaderApplication implements CommandLineRunner {

    public static final String ARGS = "Client Id {}: {}";

    private final ExcelConfigImpl excelConfigImpl;

    @Value("${config.excelPath}")
    private String configExcelPath;

    private static final Logger LOG = LoggerFactory.getLogger(ExcelLoaderApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ExcelLoaderApplication.class, args);
    }

    @Override
    public void run(String... args) {
        LOG.info("EXECUTING : command line runner");
        PoijiOptions poijiOptions = PoijiOptions.PoijiOptionsBuilder.settings()
                .headerCount(2) // since we have two header rows
                .addListDelimiter(";")
                .build();

        List<ClientConfiguration> clientConfigs = Poiji.fromExcel(new File(configExcelPath),
                ClientConfiguration.class, poijiOptions);

        for (int i = 0; i < clientConfigs.size(); ++i) {
            ClientConfiguration client = clientConfigs.get(i);
            LOG.info(ARGS, i+1, client.getClientID());
            LOG.info(ARGS, i+1, client.getGatewayConfig());
            ExcelDocument excelDocument = excelConfigImpl.convertConfigPojoToEntity(client);
            excelConfigImpl.saveClientDocument(excelDocument);
            LOG.info("Data saved in db");
        }
    }

}
