package ru.home.games;

import java.util.Arrays;
import java.util.Objects;

public class Card {

    private Suit suit;
    private Rank rank;
    private Player player;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Integer getWeight() {
        return this.suit.getWeight() + this.rank.getWeight();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Card)) {
            return false;
        }
        Card card = (Card) o;
        return Objects.equals(suit, card.suit) &&
                Objects.equals(rank, card.rank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, rank);
    }

    @Override
    public String toString() {
        return String.format("%-6s - %s", rank.getRankName(), suit.getSuitName());
    }

    /**
     * Масти карт
     */
    enum Suit {

        HEARTS("Черви", 4),
        CLUBS("Трефы", 3),
        DIAMONDS("Бубны", 2),
        SPADES("Пики", 1);

        private String s;
        private Integer i;

        private Integer vip = 1;

        Suit(String s, Integer i) {
            this.s = s;
            this.i = i;
        }

        /**
         * Получение козырной масти
         *
         * @return
         */
        public static Suit getVip() {
            return Arrays.stream(values()).filter(Suit::isVip).findFirst().get();
        }

        /**
         * Получение веса карты по мастям
         *
         * @return
         */
        public Integer getWeight() {
            return this.i * vip;
        }

        /**
         * Получение название масти
         *
         * @return
         */
        public String getSuitName() {
            return this.s;
        }

        public void setVip() {
            vip = 100;
        }

        /**
         * Является ли карта козырем: true - да , false - нет
         *
         * @return
         */
        public boolean isVip() {
            return this.vip > 1;
        }
    }

    /**
     * Достоинства карт
     */
    enum Rank {
        SEVEN("7", 7),
        EIGHT("8", 8),
        NINE("9", 9),
        TEN("10", 10),
        JACK("Валет", 11),
        QUEEN("Дама", 12),
        KING("Король", 13),
        ACE("Туз", 14);

        private String s;
        private Integer i;

        Rank(String s, Integer i) {
            this.s = s;
            this.i = i;
        }

        public Integer getWeight() {
            return this.i;
        }

        public String getRankName() {
            return this.s;
        }
    }
}
