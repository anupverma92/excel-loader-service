package com.anup.excelloader;


import com.anup.excelloader.repository.ExcelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.ArgumentMatchers.anyString;


@SpringBootTest
class ExcelLoaderApplicationTest {


    @Autowired
    ExcelLoaderApplication excelLoaderApplication;

    @MockBean
    ExcelRepository excelRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        }

    @Test
    void configLoaderTest() {
        Mockito.when(excelRepository.findByClientID(anyString())).thenReturn(null);

        String[] args = new String[]{};
        excelLoaderApplication.run(args);
        assertThatCode(() -> excelLoaderApplication.run(args)).doesNotThrowAnyException();
    }
}
