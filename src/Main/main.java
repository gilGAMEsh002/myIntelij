package Main;
import Player.player;
import Card.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;


public class main {

    static int stages = 1;
    static int rounds = 1;

    /*发牌*/
    public static void Fapai(player p1,player p2,Heguan h1){
        ArrayList<card> list=new ArrayList<>();
        int[] color ={1,2,3,4};
        int[] number = {2,3,4,5,6,7,8,9,10,11,12,13,14};
        int cardWeight[]={0,1,2,3,4,5,6,7,8,9,10,11,12};
        //将52张牌存入牌盒
        for (int j : color) {
            for (int k : number) {
                list.add(new card(k, j,cardWeight[k]));
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        //打乱扑克
        Collections.shuffle(list);
        /*取头七张作为游戏用牌*/

        for (int i = 0; i < 7; i++) {
            if(i<=1) {                          //前两张给p1作handCard
                p1.handCard[i] = list.get(i);
            }
            else if(i==2||i==3){                //后两张给p2作handCard
                p2.handCard[i-2]=list.get(i);
            }
            else{                               //最后5张作FiledCard
                h1.FiledCard[i-4]=list.get(i);
            }
        }
    }
    static Scanner sc=new Scanner(System.in);
    //随机赋大小盲
    //preflop   默认小盲赋值后，小盲进行操作
    public static void preflop(player player1,player player2){
        Random ra=new Random();
        player1.Blind=ra.nextInt(2)+1;
        if(player1.Blind==1) {
            player2.Blind=2;
            player1.pay = 50;
            player2.pay = 100;
            player1.chip-=player1.pay;
            player2.chip-=player2.pay;
            System.out.println("选择小盲的操作  :1 Call,2 Fold,3 Raise");
            int choice=sc.nextInt();
            switch (choice){
                case 1->player1.Call(player2,1);
                case 2->player1.Fold(player2,1);
                case 3->player1.Raise(player2,1);
                default -> System.out.println("error");
            }
        }
        else{
            player2.Blind=1;
            player1.pay=100;
            player2.pay=50;
            player1.chip-=player1.pay;
            player2.chip-=player2.pay;
        }
        System.out.println("player1：  "+player1.Blind);
        System.out.println("player2：  "+player2.Blind);

        changeBLind(player1,player2);

    }

    /*2.flop*/
    public  static void flop(player player1,player player2){

        System.out.println("选择操作  " +
                "1：check  " +
                "2：Call  " +
                "3：Raise  " +
                "4：Fold  ");
        int caozuo=sc.nextInt();
            //判断是谁操作
            if(player1.Blind>player2.Blind){
                System.out.println("player1在操作");
                    player1.flag=true;
                    player2.flag=false;
                    switch (caozuo){
                        case 1-> System.out.println(player1.Check(player2, 2));
                        case 2-> System.out.println(player1.Call( player2, 2));
                        case 3-> System.out.println(player1.Raise( player2, 2));
                        case 4-> System.out.println(player1.Fold(player1, 2));
                        default -> System.out.println("error");
                    }

            }
            else{
                System.out.println("player2在操作");
                player2.flag=true;
                player1.flag=false;
                switch (caozuo){
                    case 1-> System.out.println(player2.Check( player1, 2));
                    case 2-> System.out.println(player2.Call( player1, 2));
                    case 3-> System.out.println(player2.Raise( player1, 2));
                    case 4-> System.out.println(player2.Fold(player2, 2));
                    default -> System.out.println("error");
                }
            }
        System.out.println("player1：  "+player1.Blind);
        System.out.println("player2：  "+player2.Blind);

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
    //交换两人的盲值
    public static void changeBLind(player p1,player p2){
        int temp=p1.Blind;
        p1.Blind=p2.Blind;
        p2.Blind=temp;
    }


    public static void main(String[] args) {
    player player1 = new player();//我,AI
    player player2 = new player();

    player1.Blind =1;
    player2.Blind =2;


    int chipPool = 0;
    Scanner scanner = new Scanner(System.in);
        System.out.println("----------------------------牌局--------------------------");
        while(true){

        System.out.printf("筹码池: %d\n",chipPool);
        System.out.println("player1剩余筹码:"+player1.chip);
        System.out.println("player2剩余筹码:"+player2.chip);
        stages = scanner.nextInt();

            switch (stages) {
                case 1 -> {
                    System.out.println("第" + stages + "轮:preflop");
                    preflop(player1, player2);
                    chipPool+=player1.pay;
                    chipPool+= player2.pay;


                    break;
                }
                case 2 -> {
                    System.out.println("第" + stages + "轮:flop");

                    flop(player1, player2);
                    flop(player1,player2);
                    chipPool+=player1.pay;
                    chipPool+= player2.pay;
                    //每一轮都要交换盲值
                    changeBLind(player1,player2);
                    break;
                }
                case 3 -> {
                    System.out.println("第" + stages + "轮:turn");

                    turn(player1, player2);
                    break;
                }
                case 4 -> {
                    System.out.println("第" + stages + "轮:river");

                    river(player1, player2);
                    break;
                }
                case 5 -> {
                    System.out.println("第" + stages + "轮:比牌");

                    PK(player1, player2);
                    break;
                }
            }

        //stages++;

        if(player1.chip==0||player2.chip==0||stages==5){
            break;
        }
    }

    }
}
