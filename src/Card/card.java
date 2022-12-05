package Card;

public class card {
    int number ;              //2,3,4,5,6,7,8,9,10,11,12,13,14}
    int color ;    //1为♥,2为♦,3为♠,4为♣

    boolean exitCard = true;    //牌存在为:true
    int cardWeight;

    public card(int number, int color) {
        this.number = number;
        this.color = color;
    }

    @Override
    public String toString() {
        String value="";
        switch (color){
            case 1->value+="♥";
            case 2->value+="♦";
            case 3->value+="♠";
            case 4->value+="♣";

        }
        switch (number){
            case 11->value+="J";
            case 12->value+="Q";
            case 13->value+="K";
            case 14->value+="A";
            default -> value+=number;
        }
        return "card"+value;

    }


}
