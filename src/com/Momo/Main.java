package com.Momo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean istrue = true;
        String teaName;
        Double priceOfTea;
        int numberItem=0;
        String[] lineSeperate;
        Double cost;

        try {
            //Reading of the coffee file by the reader
            FileReader readThisFile = new FileReader("coffee.txt");
            // reading of the filereader file by the bufferReader
            BufferedReader report = new BufferedReader(readThisFile);
            String line = report.readLine();
            FileWriter mySalesReport = new FileWriter("saleReport.txt");

            while (line != null) {
                //Assigning the variable for the coffee.txt
                lineSeperate = line.split(";");
                teaName = lineSeperate[0];
                String line2 = lineSeperate[1];
                cost = Double.parseDouble(line2);
                String line3 = lineSeperate[2];
                priceOfTea = Double.parseDouble(line3);


                do {
                    try {
                        System.out.println("How many " + teaName + " did you today?");

                        numberItem = input.nextInt();
                        if(numberItem>0) {

                            istrue = false;
                        }
                    } catch (InputMismatchException e) {
                        input.nextLine();
                        System.out.println("Please enter right number");
                        istrue = true;
                    }
                }while (istrue);
                mySalesReport.write(String.format("%s sold: %d, Expenses: $%.2f, Revenue: $%.2f%n", teaName,
                        numberItem, expenses(cost, numberItem),  totalRevnue(priceOfTea, numberItem )));



            }
            mySalesReport.close();
            report.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
    //A method that calculates and returns the expenses for the eact product
    public static double expenses(double cost, int typeSold ){
        double totalExpeses = cost*typeSold;
        return totalExpeses;
    }
    //A method that calculate and returns the total revenue.
    public static  double totalRevnue(Double price, int amountSold){
        double totalRev = price*amountSold;
        return totalRev;


    }

}
