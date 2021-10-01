package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

	    try{
            CommandLine myC = new CommandLine(line);
            System.out.println();
            System.out.println(myC);
        }catch (IllegalArgumentException e){
            System.out.println( e.getMessage());
        }



    }
}
