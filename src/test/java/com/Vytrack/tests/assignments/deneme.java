package com.Vytrack.tests.assignments;

public class deneme {

    public static void main(String[] args) {
        String s="of 9&nbsp;";
        String []ss=s.split(" ");
        System.out.println((ss[1].split("&")[0]));

    }
}
