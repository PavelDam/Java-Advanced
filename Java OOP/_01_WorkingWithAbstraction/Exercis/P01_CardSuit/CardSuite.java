package _01_WorkingWithAbstraction.Exercise.P01_CardSuit;

public enum CardSuite {
    CLUBS,
    DIAMONDS,
    HEARTS,
    SPADES;

    public static void printAll() {
        for (CardSuite card : CardSuite.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", card.ordinal(), card);
        }
    }

}
