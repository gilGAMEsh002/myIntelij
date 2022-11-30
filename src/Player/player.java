package Player;
import Card.card;
public class player {
    public int Blind;   //1,2分别为小盲与大盲
    public card[] handCard = new card[2];   //两张手牌
    public int chip = 2000;
    public int pay; //最小下注额为100

    /*分析并选择*/
    public void play(){

    }



    public boolean Check(player player2, int stages){

        return true;
    }

    public boolean Call(player player2, int stages){


        return true;
    }

    public boolean Raise(player player2,int stages){


        return true;
    }

    public boolean Fold(player player2,int stages){


        return true;
    }
}
