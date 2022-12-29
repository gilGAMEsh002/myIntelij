package Card;
import java.util.*;
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
    public static int judgeCards(card[] temp) {
        //weight记录每总牌型的大小
        int weight = -1;
        boolean isSameColor = false;//是否是同一花色
        boolean isShunZi = false;//是否是顺子
        //先判断这手牌是否是同花
        Set<Integer> colorSet = new HashSet<>();
        for (int i = 0; i < temp.length; i++) {
            colorSet.add(temp[i].color);
        }
        //如果是同花
        if (colorSet.size() == 1) {
            isSameColor = true;
        }
        Set<Integer> numberSet = new HashSet<>();
        List<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < temp.length; i++) {
            numberSet.add(temp[i].number);
            numberList.add(temp[i].number);
        }
        //将numberList排序
        Collections.sort(numberList);
        int cha = numberList.get(temp.length - 1) - numberList.get(0);
        //如果是顺子
        if (cha == temp.length - 1 && numberSet.size() == temp.length) {
            isShunZi = true;
        }
        //开始判断牌型
        if (isSameColor && isShunZi) {

            if (numberList.get(numberList.size() - 1) == 14) {

                weight = 9;
            } else {

                weight = 9;
            }
        } else if (isSameColor) {

            weight = 6;
        } else if (isShunZi) {

            weight = 5;
        } else if (numberSet.size() == temp.length) {

            weight = 1;
        } else if (numberSet.size() == temp.length - 1) {

            weight = 2;
        } else {
            //map的key存牌的面值，map的值存同样牌的牌
            Map<Integer, List<card>> map = new HashMap<>();
            for (int i = 0; i < temp.length; i++) {
                card card = temp[i];
                //判断该牌是否存在map的key中
                if (map.containsKey(card.number)) {
                    List<card> list1 = map.get(card.number);
                    list1.add(card);
                }
                //如果不存在
                else {
                    List<card> list1 = new ArrayList<>();
                    list1.add(card);
                    map.put(card.number, list1);
                }
            }
            //如果map的长度为2，有两种可能  4带1 或者 3带2
            if (map.size() == 2) {
                boolean is4dai1 = false;
                for (Map.Entry<Integer, List<card>> entry : map.entrySet()) {
                    //entry的值是一个List
                    if (entry.getValue().size() == 4) {
                        is4dai1 = true;
                        break;
                    }
                }
                //开始判断
                if (is4dai1) {

                    weight = 8;
                } else {

                    weight = 7;
                }
            }
            //map.size()=3有两种可能:两对，三条
            else if (map.size() == 3) {
                boolean isLiangDui = false;
                for (Map.Entry<Integer, List<card>> entry : map.entrySet()) {
                    //entry的值是一个List
                    if (entry.getValue().size() == 2) {
                        isLiangDui = true;
                        break;
                    }
                }
                if (isLiangDui) {

                    weight = 3;
                } else {

                    weight = 4;
                }
            }
        }
        return weight;
    }

    public static int judge67Cards2(card[] ca1, card[] ca2) {
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
        card[][] c2 = new card[l][5];
        String[] rs = new String[l];           //返回结果
        String str = "";                     //将第一种排列存入数组RS（即所有1都在左边的情况）
        for (int x = 0; x < n; x++) {
            str = str + c1[x] + "";
        }
        rs[0] = str;
        //将第一种结果存在c2中
        for (int i = 0; i < c2[0].length; i++) {
            c2[0][i]=c1[i];
        }
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
                    int num=0;
                    for (int kk = 0; kk < m; kk++)    //通过构造数组下标，得到需要的返回串
                    {
                        if (s[kk] == 1) {
                            c2[k][num]=c1[kk];
                            returnstr = returnstr + c1[kk] + "";
                            num++;
                        }
                    }
                    rs[k] = returnstr;           //将串存入RS数组，用于返回
                    i = m;                       //转换了第一个10后，就要跳出该次FOR循环，所以将i直接置成m
                    k++;                       //rs返回数组下标向后推一位，用于存储下个返回串
                }
            }
        } while (flag == true);
        int maxWeight = 0;

        //System.out.println("---------------------------------");
        for (int i = 0; i < c2.length; i++) {
            maxWeight = judgeCards(c2[i])>maxWeight?judgeCards(c2[i]):maxWeight;
        }
        return maxWeight;
    }



}
