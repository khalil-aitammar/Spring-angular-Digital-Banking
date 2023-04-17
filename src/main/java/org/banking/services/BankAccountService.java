package org.banking.services;

import org.banking.entities.BankAccount;
import org.banking.entities.Customer;

public interface BankAccountService {
    Customer saveCustomer(Customer customer);
    BankAccount saveBankAccount(double initialBanlance,String type, Long customerId);
}
