package Card;
import Player.*;
public class cardSet {
    public String name;     //高排到皇家同花顺
    public int weight = 1;      //1到10

    /*得到牌型weight最大的*/
    public String getMax(card[] HandCard,card[] FiledCard,int stages){
        int n = HandCard.length+FiledCard.length;//2到5到6到7
        for(int i=0;i<n;i++){

        }

        return name;
    }

    /*找数字相同的牌有多少*/
    /*
    * 0     高牌
    * 2     两对
    * 3     三条
    * 3+2   葫芦
    * 4     四条
    * */
    public String same_card_calculate(card[] allCardOfPlayer,int stages){



        return "YiDui";
    }

    public static void main(String[] args) {

    }

}
