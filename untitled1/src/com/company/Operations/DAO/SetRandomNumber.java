package com.company.Operations.DAO;

import java.util.Random;
import java.util.Scanner;

public class SetRandomNumber {
      int number=0;
      public int SetNumber(){
          int rnumber;
          Random random =new Random();
          rnumber= random.nextInt(99);
          return rnumber;
      }

      public int ReadNumber(){
        Scanner scanner =new Scanner(System.in);
        number=scanner.nextInt();
        return number;
    }

    public int RandomNuber(){
        Random random =new Random();
        int symbolNumber= random.nextInt(5);
        return  symbolNumber;
    }

      public String Symbol(){
          String[] symblo ={"+","-","*","/"};
          int sNumber;
          Random random=new Random();
          sNumber =random.nextInt(3);
           return symblo[sNumber];
      }



}
