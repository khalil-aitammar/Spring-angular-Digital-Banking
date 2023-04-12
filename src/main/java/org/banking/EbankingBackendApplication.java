package org.banking;

import org.banking.entities.CurrentAccount;
import org.banking.entities.Customer;
import org.banking.entities.SavingAccount;
import org.banking.enums.AccountStatus;
import org.banking.repositories.AccountOperationRepository;
import org.banking.repositories.BankAccountRepository;
import org.banking.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class  EbankingBackendApplication {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SpringApplication.run(EbankingBackendApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CustomerRepository customerRepository,
                            BankAccountRepository bankAccountRepository,
                            AccountOperationRepository accountOperationRepository){
        return args -> {
            Stream.of("Hassan","Yassine","Aicha").forEach(name->{
                Customer custemer = new Customer();
                custemer.setName(name);
                custemer.setEmail(name+"@gmail.com");
                customerRepository.save(custemer);
            });
            customerRepository.findAll().forEach(customer -> {
                CurrentAccount currentAccount = new CurrentAccount();
                currentAccount.setBalance(Math.random()*90000);
                currentAccount.setCreatedAt(new Date());
                currentAccount.setStatus(AccountStatus.CREATED);
                currentAccount.setOverDraft(9000);
                bankAccountRepository.save(currentAccount);

                SavingAccount savingAccount = new SavingAccount();
                savingAccount.setBalance(Math.random()*90000);
                savingAccount.setCreatedAt(new Date());
                savingAccount.setStatus(AccountStatus.CREATED);
                savingAccount.setInterstRate(6.4);
                bankAccountRepository.save(savingAccount);

            });
        };


    }




}
