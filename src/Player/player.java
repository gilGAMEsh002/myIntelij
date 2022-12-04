package Player;
import Card.card;
public class player {
    public int Blind;   //1,2分别为小盲与大盲
    public card[] handCard = new card[2];   //两张手牌
    public int chip = 2000;
    public int pay; //最小下注额为100
    public boolean flag;//是否是该玩家进行操作

    /*分析并选择*/
    public void play(){

    }

    public void setHandCard(card[] handCard) {
        this.handCard = handCard;
    }

   //check不进行任何操作，将操作权由player1移动到player2
    public boolean Check( player player2,int stages){
        if(stages>1&&stages<=3){
                this.flag = false;
                player2.flag = true;
                this.pay=0;
                this.chip=this.chip-this.pay;
        }
        return this.flag;
    }
    //跟注，获取player1的pay
    public boolean Call( player player2,int stages){
        this.pay=player2.pay;
        this.chip=this.chip-this.pay;
        return true;
    }
    //加注
    public boolean Raise(player player2,int stages){
        if(stages>=1){
            this.pay*=player2.pay;
            this.chip=this.chip-this.pay;
            return true;
        }
        return  false;
    }
    //弃牌
    public boolean Fold(player player2,int stages){
        player2.flag=false;

        return true;
    }
}
