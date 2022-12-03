package Main;
import Player.player;
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
    //随机赋大小盲
    /*1.preflop*/
    public static void preflop(player player1,player player2){
            player1.pay = 50;
            player2.pay = 100;


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
        System.out.println("----------------------------牌局--------------------------");
        while(true){

        System.out.printf("筹码池: %d\n",chipPool);
        System.out.println("player1剩余筹码:"+player1.chip);
        System.out.println("player2剩余筹码:"+player2.chip);
        fapai(player1,player2,heguan);
        stages = scanner.nextInt();

            switch (stages) {
                case 1 -> {
                    System.out.println("第" + stages + "轮:preflop");
                    System.out.println("场牌:             ");
                    System.out.println("player1的手牌:"+ Arrays.toString(player1.handCard));
                    System.out.println("player2的手牌:"+ Arrays.toString(player2.handCard));
                    preflop(player1, player2);
                    break;
                }
                case 2 -> {
                    System.out.println("第" + stages + "轮:flop");
                    System.out.println("场牌:"+heguan.nowFiledCard(2));
                    flop(player1, player2);
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
