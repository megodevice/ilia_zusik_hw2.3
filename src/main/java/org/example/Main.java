package org.example;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(15000.00);
        double draw = 6000;
        while (true) {
            try {
                System.out.println("На счету: " + bankAccount.getAmount());
                bankAccount.withDraw((int) draw);
                System.out.println("Со счета снято: " + draw + ", осталось: " + bankAccount.getAmount());
            } catch (LimitException e) {
                System.out.println(e.getMessage());
                System.out.println("Снимаем остаток в: " + e.getRemainingAmount());
                try {
                    bankAccount.withDraw((int) e.getRemainingAmount());
                } catch (LimitException ex) {
                    System.out.println(ex.getMessage());
                    break;
                }
                System.out.println("Нас счету: " + bankAccount.getAmount());
                break;
            }
        }

    }
}