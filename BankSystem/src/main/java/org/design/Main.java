package org.design;

import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {
    BankSystem bankSystem = new BankSystem(new ArrayList<BankAccount>(), new ArrayList<Transaction>());
    Bank bank = new Bank(new ArrayList<BankBranch>(), bankSystem, 10000);

    BankBranch branch1 = bank.addBranch("123 Main St", 1000);
    BankBranch branch2 = bank.addBranch("456 st", 1000);

    branch1.addTeller(new BankTeller(1));
  //  branch1.addTeller(new BankTeller(2));
    branch2.addTeller(new BankTeller(3));
   // branch2.addTeller(new BankTeller(4));

    int customerId1 = branch1.openAccount("Alice");
    int customerId2 = branch1.openAccount("Bob");
    int customerId3 = branch2.openAccount("Cindy");

    branch1.deposit(customerId1, 100);
    branch1.deposit(customerId2, 200);
    branch2.deposit(customerId3, 300);

    branch1.withdraw(customerId1, 50);

    bank.printTransactions();
        /*  Possible Output:
            Teller 1 opened account 0
            Teller 2 opened account 1
            Teller 3 opened account 2
            Teller 1 deposited 100 to account 0
            Teller 2 deposited 200 to account 1
            Teller 4 deposited 300 to account 2
            Teller 2 withdrew 50 from account 0
        */
    bank.collectCash(0.4);
  }
}