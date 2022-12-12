package Card;
import Player.*;
public class cardSet {
    public String name;     //高排到皇家同花顺
    public int weight = 1;      //1到10


    /*找数字相同的牌有多少*/
    /*
    * 0     高牌
    * 2     两对
    * 3     三条
    * 3+2   葫芦
    * 4     四条
    * */

    //判断五张牌的
    public static int judgeCards2(card[] cards) {
        int len = cards.length;
        //记录牌型大小
        int weight = 0;
        //对牌按从小到大排序
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (cards[j].number > cards[j + 1].number) {
                    card temp = cards[j];
                    cards[j] = cards[j + 1];
                    cards[j + 1] = temp;
                }
            }
        }
        //判断同花
        boolean isTongHua = true;
        //判断顺子
        boolean isShunZi = true;
        //对牌型进行判断
        int color = cards[0].color;
        for (int i = 0; i < len; i++) {
            if (i > 1) {
                if (cards[i].number - cards[i - 1].number != 1)
                    isShunZi = false;
            }
            if (color != cards[i].color) {
                isTongHua = false;
                break;
            }
        }
        if (isTongHua && isShunZi) {
            weight = 9;
        } else if (isTongHua) {
            weight = 6;
        } else if (isShunZi) {
            weight = 5;
        } else {
            //统计数组中重复的数
            int count = 1;
            //统计重复数的类型
            int num2 = 0;
            int num3 = 0;
            int num4 = 0;
            for (int i = 0; i < len; i++) {
                if (i == len - 1) {
                    switch (count) {
                        case 2 -> num2++;
                        case 3 -> num3++;
                        case 4 -> num4++;
                    }
                    break;
                }
                if (cards[i].number == cards[i + 1].number) {
                    count++;
                } else {
                    switch (count) {
                        case 2 -> num2++;
                        case 3 -> num3++;
                        case 4 -> num4++;
                    }
                    count = 1;
                }
            }
            if (num2 == 1 && num3 == 0) {
                weight = 2;
            } else if (num2 == 2) {
                weight = 3;
            } else if (num3 == 1 && num2 == 0) {
                weight = 4;
            } else if (num3 == 1 && num2 == 1) {
                weight = 7;
            } else if (num4 == 1) {
                weight = 8;
            } else {
                weight = 1;
            }
        }
      /*  switch (weight){
            case 1-> System.out.println("杂牌");
            case 2-> System.out.println("一对");
            case 3-> System.out.println("两对");
            case 4-> System.out.println("三条");
            case 5-> System.out.println("顺子");
            case 6-> System.out.println("同花");
            case 7-> System.out.println("葫芦");
            case 8-> System.out.println("四条");
            case 9-> System.out.println("同花顺");
            default -> System.out.println("error");*/
        return weight;
    }

    public static int judge67Cards2(card[] ca1,card ca2[]) {
        card[] c1=new card[ca1.length+ca2.length];
        for (int i = 0; i < c1.length; i++) {
            if(i<ca1.length){
                c1[i]=ca1[i];
            }
            else{
                c1[i]=ca2[i-ca1.length];
            }
        }
        int m = c1.length;  //参数数组长度
        int n = 5;
        int l = 1;               //构造数组长度标志
        for (int s = m; s > m - 5; s--) //获得排列数组长度L
        {
            l = l * s;
        }
        for (int z = 5; z > 1; z--) {
            l = l / z;
        }
        card c2[][] = new card[l][5];
        String[] rs = new String[l];           //返回结果
        String str = "";                     //将第一种排列存入数组RS（即所有1都在左边的情况）
        for (int x = 0; x < n; x++) {

            str = str + c1[x] + "";
        }
        rs[0] = str;

        int[] s = new int[m];    //构造下标数组
        boolean flag = true;     //循环开关
        int k = 1;               //返回结果数组长度（自增长）

        for (int i = 0; i < m; i++)   //初始化构造下标数组
        {
            if (i < n)
                s[i] = 1;
            else
                s[i] = 0;
        }
        do {
            flag = false;                        //初始FLAG
            int zerocount = 0;                  //10转换01前的0的个数
            for (int i = 0; i < m - 1; i++) {
                if (s[i] == 0)                   //记录前0个数（非0即1），可以通过这个参数进行1的前移
                {
                    zerocount++;
                }
                if (s[i] == 1 && s[i + 1] == 0)        //10变成01
                {
                    s[i] = 0;
                    s[i + 1] = 1;

                    flag = true;                 //如果成功转换，flag设置为0，如果没有证明所以1已经移动到最后，故可以跳出DO循环

                    for (int j = 0; j < i; j++)       //10转换01前的所有1前移操作
                    {
                        if (j < i - zerocount)
                            s[j] = 1;
                        else
                            s[j] = 0;
                    }
                    String returnstr = "";       //用于存储变化后的构造数组
                    for (int kk = 0; kk < m; kk++)    //通过构造数组下标，得到需要的返回串
                    {
                        if (s[kk] == 1) {
                            returnstr = returnstr + c1[kk] + "";
                        }
                    }
                    rs[k] = returnstr;           //将串存入RS数组，用于返回
                    i = m;                       //转换了第一个10后，就要跳出该次FOR循环，所以将i直接置成m
                    k++;                       //rs返回数组下标向后推一位，用于存储下个返回串
                }
            }
        } while (flag == true);
        int maxWeight = 0;
        //将rs字符串的内容赋值到c2中并找到最大牌型的weight值
        for (int i = 0; i < rs.length; i++) {
            for (int j = 0; j < 5; j++) {
                c2[i][j] = new card(rs[i].charAt(2 * j + 1) - 48, rs[i].charAt(2 * j) - 48);
            }
            maxWeight = judgeCards2(c2[i])>maxWeight?judgeCards2(c2[i]):maxWeight;
        }
        return maxWeight;
    }


}
