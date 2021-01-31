package PokerGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Poker {
    public static final String[] suits = {"♥", "♠", "♣", "♦"};

    private static List<Card> buypoker(){
        List<Card> poker = new ArrayList<>();
        //外层循环四种花色
        for(int i = 0; i < 4; i++){
            //内层循环13张牌
            for(int j = 2; j < 11; j++){
                poker.add(new Card(suits[i], ""+j));
            }
            poker.add(new Card(suits[i], "J"));
            poker.add(new Card(suits[i], "Q"));
            poker.add(new Card(suits[i], "K"));
            poker.add(new Card(suits[i], "A"));
        }
        poker.add(new Card("", "big Joker"));
        poker.add(new Card("", "small Joker"));
        return poker;
    }

    private static void shuffle(List<Card> poker){
        //从后向前遍历, 把当前元素和前面随机一个元素交换
        //到第1个元素时, 就全部洗完了
        Random r = new Random();
        for(int i = poker.size()-1; i > 0; i--){
            int tem = r.nextInt(i);
            my_swap(poker, i, tem);
        }
    }
    private static void my_swap(List<Card> poker , int i, int tem){
        Card t = poker.get(i);
        poker.set(i, poker.get(tem));
        poker.set(tem, t);
    }

    public static void main(String[] args) {
        //1.创建一副牌
        List<Card> poker = buypoker();
        System.out.println(poker);

        //2.洗牌
        shuffle(poker);
        //Collections.shuffle(poker);
        System.out.println(poker);

        //3.发牌(每个玩家五张牌, 三个玩家)
//        List<Card> player1 = new ArrayList<>();
//        List<Card> player2 = new ArrayList<>();
//        List<Card> player3 = new ArrayList<>();
        List<List<Card>> players = new ArrayList<>();
        players.add(new ArrayList<>());
        players.add(new ArrayList<>());
        players.add(new ArrayList<>());
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 3; j++){
                Card top = poker.remove(0);
                List<Card> player = players.get(j);
                player.add(top);
            }
        }

        //4.展示手牌
        for(int i = 0; i < players.size(); i++){
            List<Card> player = players.get(i);
            System.out.println(i + "玩家的手牌是: " + player);
        }
    }
}
