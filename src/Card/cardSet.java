package Card;

public class cardSet {
    public String name;     //高排到皇家同花顺
    public int weight = 1;      //1到10
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
    public String same_card_calculate(card[] HandCard,card[] FiledCard,int stages){
        int num= HandCard.length+FiledCard.length;
        card temp[]=new card[num];
        //将手牌和公选牌复制到temp中
        for (int i = 0; i < HandCard.length; i++) {
            temp[i]=HandCard[i];
        }
        for (int i = 0; i < FiledCard.length; i++) {
            temp[i+HandCard.length]=FiledCard[i];
        }
        //bia
        for (int i = 0; i < temp.length; i++) {

        }
        return "YiDui";
    }

}
