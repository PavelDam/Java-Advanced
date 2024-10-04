package _01_WorkingWithAbstraction.Exercise.P03_CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rank = scanner.nextLine();
        String suit = scanner.nextLine();

        Card card = new Card(CardRank.valueOf(rank).getPower(), CardSuite.valueOf(suit).getPower());

        card.printCardInfo(rank, suit);
    }
}
