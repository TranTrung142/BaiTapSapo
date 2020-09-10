package com.sapo.edu.demo;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class PrinterFile implements Printer {

    private static final Logger logger = Logger.getLogger(DemoApplication.class);

    @Override
    public void printCustoner(Customer customer) {
        logger.info("CustomerId: " + customer.getAcctNo() + ", balance: " + customer.getBalance().toString());
    }

    @Override
    public void printMessage(String message) {
        //logger.info("\n"+message);
        logger.info(message);

    }
}
