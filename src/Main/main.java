package Main;
import Player.player;

import java.util.Scanner;


public class main {

    static int stages = 1;
    static int rounds = 1;

    /*发牌*/
    public static void giveCard(int stages){

    }

    /*1.preflop*/
    public static void preflop(player player1,player player2){

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

        switch (stages){
            case 1: {
                System.out.println("第"+stages+"轮:preflop");

                preflop(player1,player2);
                break;
            }
            case 2: {
                System.out.println("第"+stages+"轮:flop");

                flop(player1,player2);
                break;
            }
            case 3: {
                System.out.println("第"+stages+"轮:turn");

                turn(player1,player2);
                break;
            }
            case 4: {
                System.out.println("第"+stages+"轮:river");

                river(player1,player2);
                break;
            }
            case 5: {
                System.out.println("第"+stages+"轮:比牌");

                PK(player1,player2);
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
