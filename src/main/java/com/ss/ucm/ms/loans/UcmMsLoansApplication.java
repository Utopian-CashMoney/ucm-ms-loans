package com.ss.ucm.ms.loans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


/**
 * Main Application
 * 
 * 
 * @author Charvin Patel
 */

// TODO: Configure Spring Security later. Disabled until relevant.
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
//@SpringBootApplication
public class UcmMsLoansApplication {

    public static void main(String[] args) {
        SpringApplication.run(UcmMsLoansApplication.class, args);
    }

}
