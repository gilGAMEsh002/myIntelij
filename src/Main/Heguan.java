package Main;
import Card.*;


public class Heguan {
    //公选牌
    public card[] FiledCard=new card[5];


    public Heguan() {
    }

    public card getFiledCard(int i) {
        return FiledCard[i];
    }

    public void setFiledCard(card[] card) {
        this.FiledCard = card;
    }
}


