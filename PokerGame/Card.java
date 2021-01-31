package PokerGame;

public class Card {
    //花色
    private String suit;
    //点数
    private String rank;

    public Card(String suit, String rank){
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "(" + suit + rank + ")";
    }
}
