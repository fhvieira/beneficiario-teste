package com.example.beneficiariotest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class BeneficiarioTestApplicationTests {

    @Test
    void contextLoads() {
        String[] args = {};

        assertDoesNotThrow(() -> BeneficiarioTestApplication.main(args));
    }

}
