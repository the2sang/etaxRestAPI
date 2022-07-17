package com.kepco.etax.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EtaxRestApiApplication {


    private static final Logger logger = LoggerFactory.getLogger(EtaxRestApiApplication.class);
    public static void main(String[] args) {

        logger.info("Staring Etax Open API Service");

        SpringApplication.run(EtaxRestApiApplication.class, args);
    }

}
