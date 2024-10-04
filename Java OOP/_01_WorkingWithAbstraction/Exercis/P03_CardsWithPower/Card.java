package _01_WorkingWithAbstraction.Exercise.P03_CardsWithPower;

import _01_WorkingWithAbstraction.Exercise.P02_CardRank.CardRank;

public class Card {
    private int cardRank;
    private int cardSuite;

    public Card(int cardRank, int cardSuite) {
        this.cardRank = cardRank;
        this.cardSuite = cardSuite;
    }

    private int calculateCardPower() {
        return cardRank + cardSuite;
    }

    public void printCardInfo(String rank, String suite) {
        System.out.printf("Card name: %s of %s; Card power: %d", CardRank.valueOf(rank), CardSuite.valueOf(suite), calculateCardPower());
    }
}
