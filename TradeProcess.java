package ru.home.games;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TradeProcess {


    void trade(List<Player> players) {
//        System.out.println("Начало торговли.");

        // Определение предполагаемой ставки
        for (Player player : players) {
            for (Card.Suit suit : player.getSortedCards().keySet()) {
                player.setSupposedStake(player.getSupposedStake() + calculate(player.getSortedCards().get(suit)));
            }
        }

        Double max = Math.max(players.get(0).getSupposedStake(),
                Math.max(players.get(1).getSupposedStake(), players.get(2).getSupposedStake()));
        for (Player player: players) {
            if (max == player.getSupposedStake()) {
                player.setRole(Player.Role.WINNER);
//                System.out.println("Победитель торгов - " + player.getPlayerName());
                player.chooseVIP();
            }
        }
    }


    private double calculate(List<Card> cards) {
        double supposedStack = 0;

        List<Card.Rank> ranks = cards.stream().map(Card::getRank).collect(Collectors.toList());

        if (ranks.containsAll(Arrays.asList(Card.Rank.ACE, Card.Rank.KING, Card.Rank.QUEEN, Card.Rank.JACK,
                Card.Rank.TEN, Card.Rank.NINE, Card.Rank.EIGHT, Card.Rank.SEVEN)))
            return 8;
        else if (ranks.containsAll(Arrays.asList(Card.Rank.ACE, Card.Rank.KING, Card.Rank.QUEEN, Card.Rank.JACK,
                Card.Rank.TEN, Card.Rank.NINE, Card.Rank.EIGHT)))
            return 7;
        else if (ranks.containsAll(Arrays.asList(Card.Rank.ACE, Card.Rank.KING, Card.Rank.QUEEN, Card.Rank.JACK,
                Card.Rank.TEN, Card.Rank.NINE)))
            return 6;
        else if (ranks.containsAll(Arrays.asList(Card.Rank.ACE, Card.Rank.KING, Card.Rank.QUEEN, Card.Rank.JACK,
                Card.Rank.TEN)))
            return 5;
        else if (ranks.containsAll(Arrays.asList(Card.Rank.ACE, Card.Rank.KING, Card.Rank.QUEEN, Card.Rank.JACK)))
            return 4;
        else if (ranks.containsAll(Arrays.asList(Card.Rank.ACE, Card.Rank.KING, Card.Rank.QUEEN)))
            return 3;
        else if (ranks.containsAll(Arrays.asList(Card.Rank.ACE, Card.Rank.KING, Card.Rank.QUEEN)))
            return 4;
        else if (ranks.containsAll(Arrays.asList(Card.Rank.KING, Card.Rank.QUEEN, Card.Rank.JACK)))
            return 2;

        for (Card.Rank rank : ranks) {
            switch (rank) {
                case ACE:
                    supposedStack += 1;
                    break;
                case KING:
                    supposedStack += 0.8;
                    break;
                case QUEEN:
                    supposedStack += 0.6;
                    break;
                case JACK:
                    supposedStack += 0.5;
            }
        }
        return supposedStack;
    }

}
