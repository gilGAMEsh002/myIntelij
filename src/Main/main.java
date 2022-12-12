package Main;
import Player.*;
import Card.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import static Card.cardSet.judge67Cards2;


public class main {

    static int stages = 1;
    static int rounds = 1;
    static int chipPool = 0;
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
        for (int i = 0; i < 9; i++) {
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
    public static void preflop(playerAI player1,playerAI player2){


            //player1先开始
            //player1做选择Call,Raise,Fold
            //Scanner scanner = new Scanner(System.in);
            System.out.println("请player1选择: 1.Call  2.Raise 3.Fold");
            //String choice = scanner.nextLine();人类操作就保留,AI操作就注释掉,用下面两行代码
            String choice = "";
            choice = player1.getPreflop_choice(player2);
            switch (choice){
                case "1"->{
                    player1.Call(player2,stages);
                    chipPool += player1.pay;
                }
                case "2"->{
                    player1.Raise(player2,stages);
                    chipPool += player1.pay;
                }
                case "3"->{
                    player1.Fold(player2,stages);
                    player2.chip += chipPool;//player1认输,把筹码池的筹码都给player2
                    rounds++;
                }
            }
            //System.out.println("现在player1的筹码数:"+player1.chip);
            //System.out.println("现在筹码池的筹码数:"+chipPool);

            if(player1.isFold)return;//判断是否直接结束,player2不再操作

            System.out.println("请player2选择: 1.Call  2.Raise 3.Fold 4.Check");
            choice = scanner.nextLine();
            switch (choice){
            case "1"->{
                player2.Call(player1,stages);
                chipPool += player2.pay;
            }
            case "2"->{
                player2.Raise(player1,stages);
                chipPool += player2.pay;
            }
            case "3"->{
                player2.Fold(player1,stages);
                player1.chip += chipPool;//player2认输,把筹码池的筹码都给player21
                rounds++;
            }
            case "4"->{
                player2.Check(player1,stages);
            }
            }
            stages++;
    }

    /*2.flop*/
    public  static void flop(playerAI player1,playerAI player2){
        //player2先开始
        //player2做选择Call,Raise,Fold

        System.out.println("请player2选择: 1.Call  2.Raise 3.Fold");
        String choice = scanner.nextLine();
        switch (choice){
            case "1"->{
                player2.Call(player1,stages);
                chipPool += player2.pay;
            }
            case "2"->{
                player2.Raise(player1,stages);
                chipPool += player2.pay;
            }
            case "3"->{
                player2.Fold(player1,stages);
                player1.chip += chipPool;//player2认输,把筹码池的筹码都给player1
                rounds++;
            }
        }
        if(player2.isFold)return;//判断是否直接结束,player1不再操作

        System.out.println("请player1选择: 1.Call  2.Raise 3.Fold 4.Check");
        choice = player1.getFlop_choice(player2);
        switch (choice){
            case "1"->{
                player1.Call(player2,stages);
                chipPool += player1.pay;
            }
            case "2"->{
                player1.Raise(player2,stages);
                chipPool += player1.pay;
            }
            case "3"->{
                player1.Fold(player2,stages);
                player2.chip += chipPool;//player2认输,把筹码池的筹码都给player21
                rounds++;
            }
            case "4"->{
                player1.Check(player2,stages);
            }
        }
        stages++;
    }

    /*3.turn*/
    public  static void turn(playerAI player1,playerAI player2){
        //player2先开始
        //player2做选择Call,Raise,Fold

        System.out.println("请player2选择: 1.Call  2.Raise 3.Fold");
        String choice = scanner.nextLine();
        switch (choice){
            case "1"->{
                player2.Call(player1,stages);
                chipPool += player2.pay;
            }
            case "2"->{
                player2.Raise(player1,stages);
                chipPool += player2.pay;
            }
            case "3"->{
                player2.Fold(player1,stages);
                player1.chip += chipPool;//player2认输,把筹码池的筹码都给player1
                rounds++;
            }
        }
        if(player2.isFold)return;//判断是否直接结束,player1不再操作

        System.out.println("请player1选择: 1.Call  2.Raise 3.Fold 4.Check");
        choice = player1.getFlop_choice(player2);
        switch (choice){
            case "1"->{
                player1.Call(player2,stages);
                chipPool += player1.pay;
            }
            case "2"->{
                player1.Raise(player2,stages);
                chipPool += player1.pay;
            }
            case "3"->{
                player1.Fold(player2,stages);
                player2.chip += chipPool;//player2认输,把筹码池的筹码都给player21
                rounds++;
            }
            case "4"->{
                player1.Check(player2,stages);
            }
        }
        stages++;
    }

    /*4.river*/
    public  static void river(playerAI player1,playerAI player2){
        //player2先开始
        //player2做选择Call,Raise,Fold

        System.out.println("请player2选择: 1.Call  2.Raise 3.Fold");
        String choice = scanner.nextLine();
        switch (choice){
            case "1"->{
                player2.Call(player1,stages);
                chipPool += player2.pay;
            }
            case "2"->{
                player2.Raise(player1,stages);
                chipPool += player2.pay;
            }
            case "3"->{
                player2.Fold(player1,stages);
                player1.chip += chipPool;//player2认输,把筹码池的筹码都给player1
                rounds++;
            }
        }
        if(player2.isFold)return;//判断是否直接结束,player1不再操作

        System.out.println("请player1选择: 1.Call  2.Raise 3.Fold 4.Check");
        choice = player1.getFlop_choice(player2);
        switch (choice){
            case "1"->{
                player1.Call(player2,stages);
                chipPool += player1.pay;
            }
            case "2"->{
                player1.Raise(player2,stages);
                chipPool += player1.pay;
            }
            case "3"->{
                player1.Fold(player2,stages);
                player2.chip += chipPool;//player2认输,把筹码池的筹码都给player21
                rounds++;
            }
            case "4"->{
                player1.Check(player2,stages);
            }
        }
        stages++;
    }

    /*5.PK*/
    public  static void PK(playerAI player1,playerAI player2,Heguan heguan){

        //判断最大牌型的算法放这
        //比较player1和player2的最大牌型,谁的最大牌型更大,谁赢
        int player1_weight = judge67Cards2(player1.handCard,heguan.FiledCard);
        int player2_weight = judge67Cards2(player2.handCard,heguan.FiledCard);

       if (player1_weight>player2_weight){
           System.out.println("本局player1胜");
           player1.chip+=chipPool;
       }else if(player1_weight<player2_weight){
            System.out.println("本局player2胜");
            player2.chip+=chipPool;
        }else {
           System.out.println("平局");
           player1.chip+=chipPool/2;
           player2.chip+=chipPool/2;
       }



        stages++;
    }

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
    playerAI player1 = new playerAI();
    playerAI player2 = new playerAI();
    Heguan heguan = new Heguan();

    player1.Blind =1;
    player2.Blind =2;

    boolean start = true;


        while(start){
            System.out.printf("----------------------------第%d局--------------------------\n",rounds);
            chipPool = 0;
            stages =1;
            //下盲注
            player1.pay = 50;
            player1.chip = player1.chip - player1.pay;
            player2.pay = 100;
            player2.chip = player2.chip - player2.pay;
            chipPool  = player1.pay+player2.pay;

            System.out.printf("筹码池: %d\n",chipPool);
        System.out.println("player1剩余筹码:"+player1.chip);
        System.out.println("player2剩余筹码:"+player2.chip);
        fapai(player1,player2,heguan);
        //stages = scanner.nextInt();//手动输入stages

//            switch (stages) {
//                case 1 -> {
                    System.out.println("*****第" + stages + "轮:preflop*****");
                    System.out.println("场牌:             ");
                    System.out.println("player1的手牌:"+ player1.handCard[0].printCard()+player1.handCard[1].printCard());
                    System.out.println("player2的手牌:"+ player2.handCard[0].printCard()+player2.handCard[1].printCard());
                    preflop(player1, player2);

                    //依次判断是否有人Fold,是否需要直接结束本局游戏
                    if(player1.isFold){
                        System.out.println("p1Fold");
                        player1.isFold = false;
                        continue;

                    }else{
                        if(player2.isFold){
                            System.out.println("p2Fold");
                            player2.isFold = false;
                            continue;
                        }
                    }


                    //显示对局情况
                    System.out.println("*****player1下注:"+player1.pay);
                    System.out.println("*****player2下注:"+player2.pay);
                    System.out.println("*****当前筹码池:"+chipPool);
//                }
//                case 2 -> {
                    System.out.println("第" + stages + "轮:flop");
                    System.out.println("场牌:"+heguan.nowFiledCard(stages));
                    flop(player1, player2);

                    //依次判断是否有人Fold,是否需要直接结束本局游戏
                    if(player2.isFold){
                        System.out.println("p2Fold");
                        player2.isFold = false;
                        continue;
                    }else{
                        if(player1.isFold){
                            System.out.println("p1Fold");
                            player1.isFold = false;
                            continue;
                        }

                    }

                    //显示对局情况
                    System.out.println("*****player1下注:"+player1.pay);
                    System.out.println("*****player2下注:"+player2.pay);
                    System.out.println("*****当前筹码池:"+chipPool);


 //               }
 //               case 3 -> {
                    System.out.println("第" + stages + "轮:turn");
                    System.out.println("场牌:"+heguan.nowFiledCard(stages));
                    turn(player1, player2);

                    //依次判断是否有人Fold,是否需要直接结束本局游戏
                    if(player2.isFold){
                        System.out.println("p2Fold");
                        player2.isFold = false;
                        continue;
                    }else {
                        if(player1.isFold){
                            System.out.println("p1Fold");
                            player1.isFold = false;
                            continue;
                        }
                    }


                    //显示对局情况
                    System.out.println("*****player1下注:"+player1.pay);
                    System.out.println("*****player2下注:"+player2.pay);
                    System.out.println("*****当前筹码池:"+chipPool);
//                }
//                case 4 -> {
                    System.out.println("第" + stages + "轮:river");
                    System.out.println("场牌:"+heguan.nowFiledCard(stages));


                    //依次判断是否有人Fold,是否需要直接结束本局游戏
                    if(player2.isFold){
                        System.out.println("p2Fold");
                        player2.isFold = false;
                        continue;
                    }else{
                        if(player1.isFold){
                            System.out.println("p1Fold");
                            player1.isFold = false;
                            continue;
                        }

                    }

                    //显示对局情况
                    System.out.println("*****player1下注:"+player1.pay);
                    System.out.println("*****player2下注:"+player2.pay);
                    System.out.println("*****当前筹码池:"+chipPool);

//                }
//                case 5 -> {
                    System.out.println("第" + stages + "轮:比牌");
            System.out.println("player1的手牌:"+ player1.handCard[0].printCard()+player1.handCard[1].printCard());
            System.out.println("player2的手牌:"+ player2.handCard[0].printCard()+player2.handCard[1].printCard());
            System.out.println("场牌:"+heguan.nowFiledCard(stages));
            PK(player1, player2,heguan);

//
//                }
 //           }


        rounds++;//本局游戏结束
            System.out.println("本局游戏结束");
        if(player1.chip<=0||player2.chip<=0){
            System.out.println("游戏结束,胜利者是:player"+(player1.chip>player2.chip?1:2));
            start = false;
        }

            //break;
    }

    }
}
