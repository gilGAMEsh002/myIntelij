# 对需要增删改的地方的批注
1. player下的方法Check,Call等的形参可以不要stages
    由于涉及框架更改,故暂不处理,调用方法时仍加入stages
2. 从turn开始流程和flop都是相同的,可以优化
3. 缺少判断:玩家筹码不足以下注的情况
4. 可以优化:赢下一局游戏的操作
5. fold操作中,isFold置为true后,还得还原回false,不然下次还会执行continue
6. scanner就不用关了
7. 下注规则?