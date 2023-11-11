package org.example;

public class BankAccount {
    private double amount;

    public double getAmount() {
        return amount;
    }

    public void deposit(double sum) {
        this.amount += sum;
    }

    public void withDraw(int sum) throws LimitException {
        if (sum > amount) {
            throw new LimitException("Указанная сумма " + (double)sum + " больше чем остаток на счете (" + amount + ")", amount);
        }
        amount -= sum;
    }
}
