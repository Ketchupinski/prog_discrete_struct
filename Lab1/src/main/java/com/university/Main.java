package com.university;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        var scan = new Scanner(System.in);

        System.out.println("p: ");
        boolean p = scan.nextBoolean();

        System.out.println("q: ");
        boolean q = scan.nextBoolean();

        var tOne = new TaskOne(p, q);
        tOne.printResults();

        System.out.println("====================================\nTask two\n====================================");

        TaskTwo.printResult();
    }
}
