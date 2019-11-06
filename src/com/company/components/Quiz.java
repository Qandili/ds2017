package com.company.components;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Quiz {
    int a;
    int b;
    int c;
    int d;
    double result=0;
    ArrayList<Integer> integers;
    ArrayList<String> operators;

    public Quiz() {
        operators=new ArrayList<>();
        integers=new ArrayList<>();
        fillintegeres();
        fillOperators();
    }
    public double calculateValue(){
        System.out.println(integers);
        System.out.println(operators);
        int cache=1;

        for (int i = 0; i <integers.size() ; i++) {
            if (i<operators.size() && operators.get(i).equals("*")){
                cache=integers.get(i);
                result+=cache*integers.get(i+1);
                System.out.println("*"+result);
                i++;
            }else {
            if (i<operators.size()){
            switch (operators.get(i)){
                case "+":
                    System.out.println(integers.get(i));
                    result+=integers.get(i);
                    System.out.println(i+" "+result);
                    break;
                case "-":
                    result-=integers.get(i);
                    break;
                case "/":
                    result/=integers.get(i);
                    break;
            }
                    }else {
                result+=integers.get(operators.size());
            }
            }

                }
        System.out.println("calculateValue");
        System.out.println(result);
        return result;
    }
    public String randomQuestion(){
        String question="";
        Collections.shuffle(operators);
        for (int i = 0; i <4 ; i++) {
            if (i!=3){
                question+=String.valueOf(integers.get(i))+operators.get(i);

            }else {
                question+=String.valueOf(integers.get(i));
            }

        }
        return question;
    }

    public  int getRandomNumber(int min,int max){
        Random random =new Random();
        return random.nextInt(max + 1 - min) + min;
    }
    public void fillOperators(){
        operators.add("+");
        operators.add("*");
        operators.add("+");
    }
    public void fillintegeres(){
        a=getRandomNumber(2,10);
        b=getRandomNumber(4,9);
        c=getRandomNumber(1,6);
        d=getRandomNumber(1,6);
        integers.add((a));
        integers.add(b);
        integers.add(c);
        integers.add(d);
    }
}
