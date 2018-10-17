package com.company;

import com.company.Operations.DAO.SetRandomNumber;
import com.company.Operations.DAO.Title;
import com.company.Operations.Number.NB;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("----------------四则运算-CLM---------------");
        System.out.println("请输入题目个数!");
        SetRandomNumber setRandomNumber =new SetRandomNumber();
        NB nb =new NB();
        nb.setAmount(setRandomNumber.ReadNumber());
        Title title =new Title(nb.getAmount());
        String[] titleNumber= title.GetTitles();
        Scanner scanner =new Scanner(System.in);
        int[] answer=new int[nb.getAmount()];
        for (String s:titleNumber) {
            int i=0;
            System.out.println(s);
            System.out.println("请输入答案");
           answer[i]=scanner.nextInt();
          i++;
        }

        System.out.println("答案：");
        int fenshu=0;
        int[] answers =title.GetAnswer();
        for(int i=0;i<answers.length;i++){
            System.out.println(answers[i]);
            if(answers[i]==answer[i]){
                fenshu=fenshu+100/answers.length;
            }
        }
        System.out.println("最终得分是："+fenshu);

    }
}
