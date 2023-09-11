package com.example.beneficiariotest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BeneficiarioTestApplicationTests {

    @Test
    void contextLoads() {
        String[] args = {};

        assertDoesNotThrow(() -> BeneficiarioTestApplication.main(args));
    }

}
