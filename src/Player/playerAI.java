package Player;

import Card.*;
import Main.Heguan;

public class playerAI extends player {

    //1.call 2.raise 3.fold
    String preflop_choice="";
    String flop_choice="";
    String turn_choice="";
    String river_choice="";


    public String getPreflop_choice(playerAI player2,int stages){
        card HandCard1 = this.handCard[0];
        card HandCard2 = this.handCard[1];
        String choice = "";

        /*如果两张牌都小于10且不成对,就应该Fold了.至于都小于10但成对的情况就跟住*/
        if(HandCard1.number<10&&HandCard2.number<10&&HandCard2.number!=HandCard1.number){
            System.out.println("AI选择3.fold");
            choice = "3";
        }
        else {
            if(stages==1&&player2.pay<=800){
                choice = "2";
            }else if(stages==1&&player2.pay<=3200) {
                choice = "1";
            }else {
                choice = "3";
            }

        }
        System.out.println("AI选择"+choice);

        return choice;
    }

    public String getFlop_choice(playerAI player2, Heguan heguan){
        card HandCard1 = this.handCard[0];
        card HandCard2 = this.handCard[1];
        String choice = "";



        return "1";
    }


    public String getTurn_choice_choice(playerAI player2){



        return "1";
    }

    public String getRiver_choice_choice(playerAI player2){



        return "1";
    }


}
