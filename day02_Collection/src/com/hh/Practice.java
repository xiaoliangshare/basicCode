package com.hh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
       需求：三个人斗地主，实现准备牌，洗牌，发牌，看牌操作
*/
public class Practice {
    public static void main(String[] args) {
        //准备扑克牌
        List<String> pokerBox=new ArrayList<>();
        List<String> colors=new ArrayList<>();
        List<String> numbers=new ArrayList<>();
        colors.add("♥");
        colors.add("♦");
        colors.add("♠");
        colors.add("♣");
        for (int i = 2; i <= 10; i++) {
            numbers.add(i+"");
        }
        numbers.add("J");
        numbers.add("Q");
        numbers.add("K");
        numbers.add("A");
        for(String color:colors){
            for(String number: numbers){
                String card=color+number;
                pokerBox.add(card);
            }
        }
        pokerBox.add("小☺");
        pokerBox.add("大☠");
        //洗牌
        Collections.shuffle(pokerBox);

        //发牌
        List<String> playA=new ArrayList<>();
        List<String> playB=new ArrayList<>();
        List<String> playC=new ArrayList<>();
        List<String> dipai=new ArrayList<>();
        for(int i=0;i<pokerBox.size();i++){
            if (i<51){
                if(i%3==0){
                    playA.add(pokerBox.get(i));
                }else if (i%3==1){
                    playB.add(pokerBox.get(i));
                }else{
                    playC.add(pokerBox.get(i));
                }
            }else{
                dipai.add(pokerBox.get(i));
            }
        }

        //看牌
        System.out.println("playA:"+playA);
        System.out.println("playB:"+playB);
        System.out.println("playC:"+playC);
        System.out.println("dipai:"+dipai);
    }
}
