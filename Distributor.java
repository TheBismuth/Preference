package ru.home.games;

import java.util.*;

public class Distributor {

    private static List<Card> pack;

    public Distributor() {
    }

    public static Card getRandomCard() {
        Random rand = new Random();
        int index = pack.size() - 1;
        Card result = pack.get(index);
        pack.remove(result);
        return result;
    }


    public static void giveCardToPlayer(Player playerName, Card card) {
    }
}
