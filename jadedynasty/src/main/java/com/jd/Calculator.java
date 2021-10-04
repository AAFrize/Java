package com.jd;

public class Calculator {
    public static void main(String[] args) {
        Referals botit = new Reborn();
        System.out.println("By botits: " + botit.bSh(120, 135));

        Referals bonir = new NotReborn();
        System.out.println("By bonirs: " + bonir.bSh(120, 150));

        Referals board = new NotReborn();
        System.out.println("By boards: " + board.bSh(120, 135, true, 4));
    }
}
