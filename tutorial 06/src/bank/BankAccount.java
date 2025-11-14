package bank;

/**
 * BankAccount is the Implementation of the abstract class BankInfo,
 * which provides default account functionalities like deposit and withdraw.
 */
public class BankAccount extends BankInfo {


    public BankAccount(int initialBalance) {
        super(initialBalance);
    }

    public BankAccount(BankInfo original) {
        super(original);
    }





}

