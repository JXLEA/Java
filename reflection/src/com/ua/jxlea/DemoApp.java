package com.ua.jxlea;

import com.bobocode.data.Accounts;

import java.util.Comparator;

public class DemoApp {
    public static void main(String[] args) {
        Comparator<Account> accountComparator = new RandomFieldComparator<>(Account.class);
        System.out.println(accountComparator);
        Accounts.generateAccountList(10)
                .stream()
                .sorted(accountComparator)
                .forEach(System.out::println);
    }
}
