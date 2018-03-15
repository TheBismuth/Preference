package ru.home.games;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pack {

    private List<Card> pack;

    public Pack() {
        pack = new ArrayList<>();
    }

    public void newPack(){
        pack.add(new Card(Card.Suit.HEARTS, Card.Rank.SEVEN));
        pack.add(new Card(Card.Suit.HEARTS, Card.Rank.EIGHT));
        pack.add(new Card(Card.Suit.HEARTS, Card.Rank.NINE));
        pack.add(new Card(Card.Suit.HEARTS, Card.Rank.TEN));
        pack.add(new Card(Card.Suit.HEARTS, Card.Rank.JACK));
        pack.add(new Card(Card.Suit.HEARTS, Card.Rank.QUEEN));
        pack.add(new Card(Card.Suit.HEARTS, Card.Rank.KING));
        pack.add(new Card(Card.Suit.HEARTS, Card.Rank.ACE));

        pack.add(new Card(Card.Suit.CLUBS, Card.Rank.SEVEN));
        pack.add(new Card(Card.Suit.CLUBS, Card.Rank.EIGHT));
        pack.add(new Card(Card.Suit.CLUBS, Card.Rank.NINE));
        pack.add(new Card(Card.Suit.CLUBS, Card.Rank.TEN));
        pack.add(new Card(Card.Suit.CLUBS, Card.Rank.JACK));
        pack.add(new Card(Card.Suit.CLUBS, Card.Rank.QUEEN));
        pack.add(new Card(Card.Suit.CLUBS, Card.Rank.KING));
        pack.add(new Card(Card.Suit.CLUBS, Card.Rank.ACE));

        pack.add(new Card(Card.Suit.DIAMONDS, Card.Rank.SEVEN));
        pack.add(new Card(Card.Suit.DIAMONDS, Card.Rank.EIGHT));
        pack.add(new Card(Card.Suit.DIAMONDS, Card.Rank.NINE));
        pack.add(new Card(Card.Suit.DIAMONDS, Card.Rank.TEN));
        pack.add(new Card(Card.Suit.DIAMONDS, Card.Rank.JACK));
        pack.add(new Card(Card.Suit.DIAMONDS, Card.Rank.QUEEN));
        pack.add(new Card(Card.Suit.DIAMONDS, Card.Rank.KING));
        pack.add(new Card(Card.Suit.DIAMONDS, Card.Rank.ACE));

        pack.add(new Card(Card.Suit.SPADES, Card.Rank.SEVEN));
        pack.add(new Card(Card.Suit.SPADES, Card.Rank.EIGHT));
        pack.add(new Card(Card.Suit.SPADES, Card.Rank.NINE));
        pack.add(new Card(Card.Suit.SPADES, Card.Rank.TEN));
        pack.add(new Card(Card.Suit.SPADES, Card.Rank.JACK));
        pack.add(new Card(Card.Suit.SPADES, Card.Rank.QUEEN));
        pack.add(new Card(Card.Suit.SPADES, Card.Rank.KING));
        pack.add(new Card(Card.Suit.SPADES, Card.Rank.ACE));
    }

    public void shuffle(){
        Collections.shuffle(pack);
    }

    public List<Card> getNextCards(){
        List<Card> result = new ArrayList<>();
        result.add(getCard());
        result.add(getCard());
        return result;
    }

    private Card getCard(){
        return this.pack.remove(this.pack.size() - 1);
    }

}
