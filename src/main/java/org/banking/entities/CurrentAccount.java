package org.banking.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@DiscriminatorValue("CC")
@DiscriminatorColumn(name = "TYPE",length=4, discriminatorType = DiscriminatorType.STRING)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrentAccount extends BankAccount {
    private double overDraft;
}
