package s1.w1;

import java.util.Scanner;

public class BankAccount {
    private String accountId;
    private double balance;

    public BankAccount(String accountId , double balance){ //构造器
        this.accountId = accountId ;
        if(balance > 0) this.balance = balance ;
        else this.balance = 0 ;
    }

    public void deposit(double amount){ //方法
        if(amount >0) balance += amount;
    }

    public void withdraw(double amount){
        if(this.balance >= amount && amount > 0) {
            this.balance -= amount;
            System.out.println("成功扣费");
        }
        else System.out.println("余额不足或扣费金额非法");
    }

    public double getBalance(){
        return this.balance;
    }

}