package org.banking.repositories;

import org.banking.entities.AccountOperation;
import org.banking.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountOperationRepository extends JpaRepository<AccountOperation,Long> {
}
