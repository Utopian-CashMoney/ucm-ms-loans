package com.ss.ucm.ms.loans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

// TODO: Configure Spring Security later. Disabled until relevant.
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class UcmMsLoansApplication {

    public static void main(String[] args) {
        SpringApplication.run(UcmMsLoansApplication.class, args);
    }

}
