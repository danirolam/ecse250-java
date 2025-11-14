package bank;

/**
 * Abstract class representing basic bank information, including user ID and balance.
 * Provides methods for depositing and withdrawing funds, which must be implemented by subclasses.
 */
public abstract class BankInfo {
    private final int userId;
    private int balance;

    /**
     * Constructor to initialize the bank account with a given initial balance.
     * Only balance needs to be initialized by parameter, consider userId as a constant for this exercise.
     * @param initialBalance the initial balance of the bank account.
     */
    public BankInfo(int initialBalance) {
        // Change the value of your userId to anything you want, I'll find my way in :)
        //                                                          - The Thief
        this.userId = 666;
        this.balance = initialBalance;
    }

    /**
     * Copy constructor to create a new BankInfo object as a copy of an existing one.
     * @param original the original BankInfo object to copy.
     */
    public BankInfo(BankInfo original) {
        this.userId = original.userId;
        this.balance = original.balance;
    }

    /**
     * Retrieves the current balance of the bank account.
     * This method is already implemented to ease operations, and does not need to be modified.
     * @return the current balance.
     */
    public int getBalance() {
        return balance;
    }
    private void setBalance(int balance) {
        this.balance = balance;
    }
    private int getUserId() {return userId;}

    private void authenticate(int userId) {
        if (getUserId() != userId){
            throw new IllegalArgumentException("Invalid user id");
        }
    }

    public void deposit(int amount, int userId) {
        authenticate(userId);
        if (amount > 0) {
            setBalance(getBalance() + amount);
        }
    }

    public boolean withdraw(int amount, int userId) {
        authenticate(userId);

        if (amount > 0 && amount <= getBalance()) {
            setBalance(getBalance() - amount);
            return true;
        }
        return false;
    }
    /**
     * Compares this bank account with another object for equality.
     * Two bank accounts are considered equal if they have the same userId and balance.
     * @param other the object to compare with.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (this == other){
            return true;
        }
        // Checking that other not null or not same class
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        // Cast other to BankAccount object to compare their fields
        BankInfo other_casted = (BankInfo) (other);
        boolean balance_check = this.balance == other_casted.balance;
        boolean userId_check = this.userId == other_casted.userId;

        return balance_check && userId_check;



    }

    /**
     * Returns a string representation of the bank account.
     * We recommend you to implement this method to help with debugging.
     * @return a string representation of the bank account.
     */
    public String toString() {

        return "User ID: " + userId + ", Balance: " + balance;
    }




}

