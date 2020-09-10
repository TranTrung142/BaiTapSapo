package com.sapo.edu.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    @Autowired
    private Printer printer;

    @Autowired
    private Atm bidvAtm;

    private static final Logger logger = Logger.getLogger(DemoApplication.class);

    public void menu(){
        System.out.println("Moi ban chon tac vu:");
        System.out.println("1. Truy van tai khoan.");
        System.out.println("2. Gui tien.");
        System.out.println("3. Rut tien.");
    }
    public void thucHien(int chose){

    }


    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String accountNo;
        String pin;
        BigDecimal balance;

        //Printer printer = new PrinterConsole();
        printer.printMessage("Nhap ten tai khoan: ");
        accountNo = scanner.nextLine();
        logger.info(accountNo);
        printer.printMessage("Nhap ma pin: ");
        pin = scanner.nextLine();
        logger.info(pin);
        printer.printMessage("Nhap so tien cua ban: ");
        balance = scanner.nextBigDecimal();
        logger.info(balance);

        Customer customer = new Customer(accountNo, pin, balance);
        int test =1;
        while (test == 1){
            int chose;
            do{
                menu();
                chose = scanner.nextInt();
            }while (chose>3 || chose<1);
            if(chose == 1){
                bidvAtm.displayCustomerInfo(customer);
            }else if(chose == 2){   //gui tien
                printer.printMessage("Nhap so tien muon gui:");
                BigDecimal tien = scanner.nextBigDecimal();
                bidvAtm.deposit(customer,tien);
            }else if(chose == 3){   //rut tien
                printer.printMessage("Nhap ro tien muon rut:");
                BigDecimal tien = scanner.nextBigDecimal();
                bidvAtm.withDraw(customer, tien);
            }
            System.out.println("Ban muon tiep tuc hay khong? (1:co, 2:khong)");
            test=scanner.nextInt();
        }

//        menu();
//        int chose = scanner.nextInt();
//        while (chose>3 || chose<1){
//            menu();
//        }
//        if(chose == 1){
//            bidvAtm.displayCustomerInfo(customer);
//        }else if(chose == 2){   //gui tien
//            printer.printMessage("Nhap so tien muon gui:");
//            BigDecimal tien = scanner.nextBigDecimal();
//            bidvAtm.deposit(customer,tien);
//        }else if(chose == 3){   //rut tien
//            printer.printMessage("Nhap ro tien muon rut:");
//            BigDecimal tien = scanner.nextBigDecimal();
//            bidvAtm.withDraw(customer, tien);
//        }

        //Demo function
        //Atm bidvAtm = new BidvAtm();
        /*
        bidvAtm.printCurrentMoney();
        bidvAtm.displayCustomerInfo(customer);
        bidvAtm.withDraw(customer, new BigDecimal(200000)); //rut tien
        bidvAtm.printCurrentMoney();
        bidvAtm.withDraw(customer, new BigDecimal(10000000));
        bidvAtm.printCurrentMoney();
        bidvAtm.deposit(customer,new BigDecimal(1000000)); //gui tien
        bidvAtm.printCurrentMoney();*/
    }
}
