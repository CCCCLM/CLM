package com.company.Operations.DAO;

import com.company.Operations.Number.NB;

import java.util.Random;

public class Title {
    int number;
    int[] answers;
    int numberS;
    int[] numberB;
    String[] SymbolNumber1;
    public String[] RandomSymbolNumber(){
        SetRandomNumber setRandomNumber=new SetRandomNumber();
        int symbolNumber=setRandomNumber.RandomNuber();
        if(symbolNumber<=1){
            symbolNumber=2;
        }
        String[] numberSymbol=new String[symbolNumber];
        for(int i=0;i<numberSymbol.length;i++) {
            numberSymbol[i] = setRandomNumber.Symbol();
        }
        numberS=numberSymbol.length;
       SymbolNumber1=numberSymbol;
        return numberSymbol;
    }

    public int[] RandomNumbers(){
        SetRandomNumber setRandomNumber  =new SetRandomNumber();
        int numbers=numberS;
        int[] numberA=new int[numbers+1];
        for(int i=0;i<numberA.length;i++){
            numberA[i]=setRandomNumber.SetNumber();
        }
        numberB=numberA;
        return  numberA;
    }

    public int Calculation(){
        int[] numberA=numberB;
        String[] numberSymbol=SymbolNumber1;
        int answer=0;
        int h=0;
        int l=0;
        int z=0;
         for(int i=0;i<numberSymbol.length;i++){
             if(i>=1&&z==1){
                 h=i;
                 i--;
             }
             if(numberSymbol[i].equals("*")){
               answer= numberA[i]*numberA[i+1];
               numberA[i]=answer;
               for(int j=i;j<numberSymbol.length;j++){
                     if(j<numberSymbol.length-1){
                         numberA[j+1]=numberA[j+2];
                         numberSymbol[j]=numberSymbol[j+1];
                         numberSymbol[j+1]="a";
                     }
                 }
                 z=1;

                     l++;

             }
             if(numberSymbol[i].equals("/")){
                 answer=numberA[i]/numberA[i+1];
                 numberA[i]=answer;
                 for(int j=i;j<numberSymbol.length;j++){
                     if(j<numberSymbol.length-1) {
                         numberA[j + 1] = numberA[j + 2];
                         numberSymbol[j] = numberSymbol[j + 1];
                         numberSymbol[j+1]="b";
                     }
                 }
                 z=1;
                     l++;

             }
             if(h!=0) {
                 i = h;
                 h = 0;
             }
         }
         for(int i=0;i<numberSymbol.length-l;i++){
             if(i>=1){
                 h=i;
                 i--;
             }
             if(numberSymbol[i].equals("-")){
                 answer= numberA[i]-numberA[i+1];
                 numberA[i]=answer;
                 for(int j=i;j<numberSymbol.length;j++){
                     if(j<numberSymbol.length-1) {
                         numberA[j + 1] = numberA[j + 2];
                         numberSymbol[j] = numberSymbol[j + 1];
                     }
                 }
                 if(h!=0) {
                     l++;
                 }
             }
             if(numberSymbol[i].equals("+")){
                 answer=numberA[i]+numberA[i+1];
                 numberA[i]=answer;
                 for(int j=i;j<numberSymbol.length;j++){
                     if(j<numberSymbol.length-1) {
                         numberA[j + 1] = numberA[j + 2];
                         numberSymbol[j] = numberSymbol[j + 1];
                     }
                 }
                 if(h!=0) {
                     i++;
                 }
             }
             if(h!=0) {
                 i = h;
                 h=0;
             }
         }
         return answer;
    }

    public Title(int number1){
        number=number1;
    }


      public String GetTitle() {
          String[] numberSymbol = RandomSymbolNumber();
          int[] numberA = RandomNumbers();
          String title = "";
          for (int i = 0; i < numberSymbol.length; i++) {
                  title = title + numberA[i] + numberSymbol[i];
              if (i == numberSymbol.length-1) {
                  title = title + numberA[i+1];
              }
          }
          return title;
      }

      public String[] GetTitles(){
           String[] titles=new String[number];
          answers=new int[number];
           for(int i=0;i<number;i++){
               titles[i]=GetTitle();
               answers[i]=Calculation();
           }
           return titles;
      }

      public int[] GetAnswer(){
        return   answers;
      }

}
