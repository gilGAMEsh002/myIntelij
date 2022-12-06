package Player;
import Card.card;

import java.sql.SQLOutput;

public class player {
    public int Blind;   //1,2分别为小盲与大盲
    public card[] handCard = new card[2];   //两张手牌
    public int chip = 2000;
    public int pay; //最小下注额为100
    public boolean isFold = false;//用isFold来判断是否执行continue

    /*分析并选择*/
    public void play(){

    }

    public void setHandCard(card[] handCard) {
        this.handCard = handCard;
    }

    /**
     * Check,Call等方法的参数全部变为另一个player与stages(stages可能也会删除)
     */

    public void Check(player player,int stages){
        //过牌,什么也不做
    }
    //跟注，获取player1的pay
    public void Call(player player, int stages){
        this.pay = player.pay;              //下注,同上一个人的下注
        this.chip = this.chip - this.pay;   //从玩家的筹码中扣掉下注
    }
    //加注
    public void Raise(player player,int stages){

        this.pay = 2*player.pay;
        this.chip = this.chip - this.pay;

    }
    //弃牌
    public boolean Fold(player player,int stages){

        this.isFold = true;
        System.out.println("player"+this.Blind+"弃牌,本局游戏结束");
        return true;
    }
}
