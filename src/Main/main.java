package Main;
import Player.*;
import Card.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;


public class main {

    static int stages = 1;
    static int rounds = 1;

    /*发牌
    * 给分别给p1,p2,两张手牌
    * 给h1五张场牌
    * */
    /*发牌*/
    public static void fapai(player p1,player p2,Heguan h1){
        ArrayList<card>list=new ArrayList<>();
        int color[]={1,2,3,4};
        int[] number = {2,3,4,5,6,7,8,9,10,11,12,13,14};
        //将52张牌存入牌盒
        for (int i = 0; i < color.length; i++) {
            for (int j = 0; j < number.length; j++) {
                list.add(new card(number[j],color[i]))  ;
            }
        }
//        for (int i = 0; i < list.size(); i++) {
//            System.out.print(list.get(i)+" ");
//        }
        //打乱扑克
        Collections.shuffle(list);
        //取头七张
        card t1[]=new card[2];
        card t2[]=new card[2];
        card t3[]=new card[5];
        for (int i = 0; i < 7; i++) {
            if(i<=1) {
                t1[i] = list.get(i);
            }
            else if(i>1&&i<=3){
                t2[i-2]=list.get(i);
            }
            else{
                t3[i-4]=list.get(i);
            }
        }
        p1.setHandCard(t1);
        p2.setHandCard(t2);
        h1.setFiledCard(t3);
    }


    //随机给两名玩家中的一人赋大盲,另一人赋小盲
    /*1.preflop*/
    public static void preflop(player player1,player player2){

            //下盲注
            player1.pay = 50;
            player1.chip = player1.chip - player1.pay;
            player2.pay = 100;
            player2.chip = player2.chip - player2.pay;

            //player1做选择Call,Raise,Fold
            Scanner scanner = new Scanner(System.in);
            System.out.println("请player1选择: 1.Call  2.Raise 3.Fold");
            String choice = scanner.nextLine();
            switch (choice){
                case "1"->{
                    player1.Call(player2,stages);
                }
                case "2"->{
                    player1.Raise(player2,stages);
                }
                case "3"->{
                    player1.Fold(player2,stages);

                }
            }
            System.out.println("请player2选择: 1.Call  2.Raise 3.Fold 4.Check");
            choice = scanner.nextLine();
            switch (choice){
            case "1"->{
                player2.Call(player1,stages);
            }
            case "2"->{
                player2.Raise(player1,stages);
            }
            case "3"->{
                player2.Fold(player1,stages);
            }
            case "4"->{
                player2.Check(player1,stages);
            }
            }
    }

    /*2.flop*/
    public  static void flop(player player1,player player2){

    }

    /*3.turn*/
    public  static void turn(player player1,player player2){

    }

    /*4.river*/
    public  static void river(player player1,player player2){

    }

    /*5.PK*/
    public  static void PK(player player1,player player2){

    }

    public static void main(String[] args) {
    player player1 = new player();//我,AI
    player player2 = new player();
    Heguan heguan = new Heguan();

    player1.Blind =1;
    player2.Blind =2;

    int chipPool = 0;
    Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.printf("----------------------------第%d局--------------------------",rounds);
        System.out.printf("筹码池: %d\n",chipPool);
        System.out.println("player1剩余筹码:"+player1.chip);
        System.out.println("player2剩余筹码:"+player2.chip);
        fapai(player1,player2,heguan);
        stages = scanner.nextInt();//手动输入stages

            switch (stages) {
                case 1 -> {
                    System.out.println("第" + stages + "轮:preflop");
                    System.out.println("场牌:             ");
                    System.out.println("player1的手牌:"+ Arrays.toString(player1.handCard));
                    System.out.println("player2的手牌:"+ Arrays.toString(player2.handCard));
                    preflop(player1, player2);

                }
                case 2 -> {
                    System.out.println("第" + stages + "轮:flop");
                    System.out.println("场牌:"+heguan.nowFiledCard(2));
                    flop(player1, player2);

                }
                case 3 -> {
                    System.out.println("第" + stages + "轮:turn");

                    turn(player1, player2);

                }
                case 4 -> {
                    System.out.println("第" + stages + "轮:river");

                    river(player1, player2);

                }
                case 5 -> {
                    System.out.println("第" + stages + "轮:比牌");

                    PK(player1, player2);

                }
            }

        //stages++;

        if(player1.chip==0||player2.chip==0||stages==5){
            break;
        }

    }

    }
}
