package com.Momo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean istrue = true;
        int cappuccino =0, espresso =0, blackTea =0, latte=0, herbalTea=0, macchiato=0, americano=0 ;
        int coldPress =0, hotChocolate =0, coffee=0, chaiTea =0, mocha =0 ;

        //Creation of an arrayLast
        ArrayList<String> addFileItem = new ArrayList<>();
        LinkedList<Double> costToMake = new LinkedList<>();
        LinkedList<Double> price = new LinkedList<>();
        String [] lineSeperate;
        do {
            try {
                System.out.println("How many cappuccino drinks were sold today?");
                cappuccino = input.nextInt();
                System.out.println("How many espresso drinks were sold today? ");
                espresso = input.nextInt();
                System.out.println("How many latte drinks were sold today?");
                latte = input.nextInt();
               System.out.println("How many black tea drinks were sold today?");
                blackTea = input.nextInt();
               System.out.println("How many herbal tea drinks were sold today?");
                herbalTea = input.nextInt();
                System.out.println("How many macchiato drinks were sold today");
                macchiato = input.nextInt();
                System.out.println("How many americano drinks were sold today?");
                americano = input.nextInt();
                System.out.println("How many cold press drinks were sold today?");
                coldPress = input.nextInt();
                System.out.println("How many hot chocolate drinks were sold today?");
                hotChocolate = input.nextInt();
                System.out.println("How many coffee drinks were sold today?");
                coffee = input.nextInt();
                System.out.println("How many chai tea were sold today?");
                chaiTea = input.nextInt();
                System.out.println("How many mocha were sold today?");
                mocha = input.nextInt();
                istrue = false;

            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("Please enter an integer!!!");            }

        }while (istrue);

        try {
            //Reading of the coffee file by the reader
            FileReader readThisFile = new FileReader("coffee.txt");
            // reading of the filereader file by the bufferReader
            BufferedReader report = new BufferedReader(readThisFile);
            String line = report.readLine();
            while (line != null) {
                //Adding of each line from the coffee file to the ArrayList which stores
                lineSeperate = line.split(";");
                String line2= lineSeperate[1];
                Double cost = Double.parseDouble(line2);
                costToMake.add(cost);
                String line3= lineSeperate[2];
                Double priceOfTea = Double.parseDouble(line3);
                price.add(priceOfTea);
                addFileItem.add(line);

                line = report.readLine();
            }
            report.close();
        } catch (IOException e) {

            System.out.println("File Not Found!");//An exception which reads file not fun when appropriate file can't be found
        }catch (IndexOutOfBoundsException e){
            System.out.println("Index out of bound!");
        }

      try {
          /*The code below writes the sales report base on the user input. It also calculates the
          the expenses, revenues and profit based on the data within the coffee.txt file.
           */
          /* initiatialization of the FileWriter and creates the file SalesReport.txt
          to write te daily sales report    */

          FileWriter salesreport = new FileWriter("SaleReport.txt");
          salesreport.write(String.format("Cappucino sold:%d, Expenses: $%.2f, Revenue: $%.2f, " +
                  "Profit: $%.2f%n", cappuccino, expenses(costToMake.get(0), cappuccino), totalRevnue(price.get(0),
                  cappuccino), totalRevnue(price.get(0),
                  cappuccino) - expenses(costToMake.get(0), cappuccino)));
          salesreport.write(String.format("Espresso sold: %d, Expenses: $%.2f, Revenue: $%.2f" +
                  " Profit: $%.2f%n",espresso, expenses(costToMake.get(1), espresso),
                  totalRevnue(price.get(1), espresso),
                  totalRevnue(price.get(1), espresso) - expenses(costToMake.get(1), espresso)));
          salesreport.write(String.format("Latte sold: %d, Expenses: $%.2f, Revenue: $%.2f, Profit: $%.2f%n",
                  latte, expenses(costToMake.get(2), latte), totalRevnue(price.get(2), latte),
                  totalRevnue(price.get(2), latte)-expenses(costToMake.get(2), latte)));
          salesreport.write(String.format("Black Tea Sold: %d, Expenses: $%.2f, Revenue: $%.2f, Profit: $%.2f%n",
                  blackTea, expenses(costToMake.get(3), blackTea), totalRevnue(price.get(3), blackTea),
                  totalRevnue(price.get(3), blackTea)-expenses(costToMake.get(3), blackTea)));
          salesreport.write(String.format("Herbal Tea sold: %d, Expenses: $%.2f, Revenue: $%.2f, Profit: $%.2f%n",
                  herbalTea, expenses(costToMake.get(4), herbalTea), totalRevnue(price.get(4), herbalTea),
                  totalRevnue(price.get(4), herbalTea)-expenses(costToMake.get(4), herbalTea)));
          salesreport.write(String.format("Macchiato sold: %d, Expenses: $%.2f, Revenue: $%.2f, Profit: $%.2f%n",
                  macchiato, expenses(costToMake.get(5), macchiato), totalRevnue(price.get(5), macchiato),
                  totalRevnue(price.get(5), macchiato)- expenses(costToMake.get(5), macchiato)));
          salesreport.write(String.format("Americano Sold: %d, Expenses: $%.2f, Revenue: $%.2f, Profit: $%.2f%n",
                  americano, expenses(costToMake.get(6), americano), totalRevnue(price.get(6), americano),
                  totalRevnue(price.get(6), americano)-expenses(costToMake.get(6), americano)));
          salesreport.write(String.format("Cold Press Sold: %d, Expenses: $%.2f. Revenue: $%.2f, Profit: $%.2f%n",
                  coldPress, expenses(costToMake.get(7), coldPress), totalRevnue(price.get(7), coldPress),
                  totalRevnue(price.get(7), coldPress)-expenses(costToMake.get(7), coldPress) ));
          salesreport.write(String.format("Hot Chocolate Sold: %d, Expenses: $%.2f, Revenue: $%.2f, Profit: $%.2f%n",
                  hotChocolate, expenses(costToMake.get(8), hotChocolate), totalRevnue(price.get(8), hotChocolate),
                  totalRevnue(price.get(8), hotChocolate)-expenses(costToMake.get(8), hotChocolate)));
          salesreport.write(String.format("Coffee Sold: %d, Expenses: $%.2f, Revenue: $%.2f, Profit: $%.2f%n",
                  coffee, expenses(costToMake.get(9), coffee), totalRevnue(price.get(9), coffee),
                  totalRevnue(price.get(9), coffee)-expenses(costToMake.get(9), coffee)));
          salesreport.write(String.format("Chai Sold: %d, Expenses: $%.2f, Revenue: $%.2f, Profit: $%.2f%n",
                  chaiTea, expenses(costToMake.get(10), chaiTea), totalRevnue(price.get(10), chaiTea),
                  totalRevnue(price.get(10), chaiTea)-expenses(costToMake.get(10), chaiTea)));
          salesreport.write(String.format("Mocha tea sold: %d, Expenses: $%.2f, Revenue: $%.2f, Profit: $%.2f%n",
                  mocha, expenses(costToMake.get(11), mocha), totalRevnue(price.get(11), mocha),
                  totalRevnue(price.get(11), mocha)-expenses(costToMake.get(11), mocha)));
          salesreport.close();
      }catch (IOException e){
          System.out.println("File Not Found");


      }catch (IndexOutOfBoundsException h){
          System.out.println("Index out of bound");
      }


    }
    //A method that calculates and returns the expenses
    public static double expenses(double costTomake, int typeSold ){
        double totalExpeses = costTomake*typeSold;
        return totalExpeses;
    }
    //A method that calculate and returns the total revenue.
    public static  double totalRevnue(Double price, int amountSold){
        double totalRev = price*amountSold;
        return totalRev;


    }

}
