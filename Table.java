package ru.home.games;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Table {

    private List<Player> players;
    private Map<Player, Calculation> calculations;
    private List<Card> prikup;
    private List<Card> cardIntable;

    public Table() {
        this.players = Player.createPlayers();
    }

    public Boolean runGame() {
        distribution();
        new TradeProcess().trade(players);
        for (int i = 0; i < 10; i++) {
            this.cardIntable = new ArrayList<>();
            for(Player player : this.players){
                if(this.cardIntable.size() == 0){
                    this.cardIntable.add(player.getCard());
                }else{
                    this.cardIntable.add(player.getCardBySuit(this.cardIntable.get(0).getSuit()));
                }
            }
            cardIntable.sort((o1, o2) -> {
                return o1.getWeight() > o2.getWeight() ? -1 : 1;
            });
            cardIntable.get(0).getPlayer().incrementBribe();
            int a = 2;
        }

        return null;
    }

    /**
     * Раздача карт
     */
    private void distribution() {
//        System.out.println("Раздача карт");
        players.forEach(Player::clearBribe);//очистка взяток для всех игроков
        Pack pack = new Pack();
        pack.newPack();
        pack.shuffle();
        int iR = (new Random().nextInt(3) + 1);//получение рандомного круга раздачи в диапазоне 1-4
        //Раздача карт
        for (int i = 0; i < 6; i++) {
            if (iR == i) {//в прикуп
                this.prikup = pack.getNextCards();
            } else {//игрокам
                players.forEach(f -> f.addCards(pack.getNextCards()));
            }
        }
    }

    public List<Card> getPrikup() {
        return prikup;
    }

    public void setPrikup(List<Card> prikup) {
        this.prikup = prikup;
    }
}
