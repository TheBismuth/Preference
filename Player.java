package ru.home.games;

import java.util.*;

public class Player {

    private String playerName;
    private State state;
    private Role role;
    private List<Card> cards;
    private Integer bribe;//Взятка
    private Map<Card.Suit, List<Card>> sortedCards;



    private double supposedStake;

    public Player(String name) {
        this.playerName = name;
        this.cards = new ArrayList<>();
        this.clearBribe();
        this.sortedCards = new HashMap<>();
        this.supposedStake = 0;
    }

    public static List<Player> createPlayers() {
        List<Player> result = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Player player = new Player("Player " + (i + 1));
            Boolean exists = result.stream().filter(f -> f.getState() == State.ACTIVE).count() > 0;
            if (new Random().nextBoolean() && !exists) {
                player.setState(State.ACTIVE);
            } else {
                player.setState(State.PLAYER);
            }
            result.add(player);
        }
        result.sort((o1, o2) -> {
            if (o1.getState() == State.ACTIVE) {
                return -1;
            } else {
                return 1;
            }
        });
        return result;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void chooseVIP() {
        Card.Suit suit = getSortedCards().entrySet().stream().sorted(Comparator.comparing(e -> e.getValue().size(),
                (o1, o2) -> o1 > o2 ? -1:1)).findFirst().get().getKey();
        suit.setVip();
//        System.out.println("Назначен козырь - " + suit.getSuitName());
    }

    public void addCards(List<Card> cards) {
        cards.forEach(card -> card.setPlayer(this));
        this.cards.addAll(cards);

        for (Card card : cards) {
            if (sortedCards.keySet().contains(card.getSuit())) {
                sortedCards.get(card.getSuit()).add(card);
            } else {
                List<Card> list = new ArrayList<>();
                list.add(card);
                sortedCards.put(card.getSuit(), list);
            }
        }
    }

    public List<Card> getCards() {
        return cards;
    }

    public Map<Card.Suit, List<Card>> getSortedCards() {
        return sortedCards;
    }

    //todo нужно доделать логику хода игроком пока берется рандомная карта из имеющихся у игрока
    public Card getCard() {
        Card card = this.getCards().get(new Random().nextInt(getCards().size()));
        this.cards.remove(card);
        return card;

    }

    public Card getCardBySuit(Card.Suit suit) {
        //Получение первой попавшейся по масти
        Card card = this.cards.stream().filter(c -> c.getSuit() == suit).findFirst().orElse(
                cards.stream().filter(c1 -> c1.getSuit() == Card.Suit.getVip()).findFirst().orElse(
                        cards.stream().findAny().get()
                )
        );
        this.cards.remove(card);
        return card;
        //todo доделать логику получения козыря если нет масти
        //todo доделать логику бития карт по достоинству (если есть больше и нужно

    }

    public double getSupposedStake() {
        return supposedStake;
    }

    public void setSupposedStake(double supposedStake) {
        this.supposedStake = supposedStake;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Добалвение взятки
     */
    public void incrementBribe() {
        this.bribe++;
    }

    /**
     * Очистка счетчика взяток
     */
    public void clearBribe() {
        this.bribe = 0;
    }

    public Integer getBribe() {
        return bribe;
    }

    enum Role {
        WINNER,
        PASS,
        WHIST
    }

    private enum State {
        PLAYER,
        ACTIVE
    }
}
