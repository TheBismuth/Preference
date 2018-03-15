package ru.home.games;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculation {

    private Integer bullet;
    private Integer mountain;
    private Map<Player, Integer> whists;
    private Double total;

    public Calculation() {
        bullet = 0;
        mountain = 0;
        total = 0.0D;
    }

    public static Map<Player, Calculation> buildCalculations(List<Player> players) {
        Map<Player, Calculation> result = new HashMap<>();
        players.forEach(player -> {
            List<Player> prom = new ArrayList<>(players);
            Calculation calc = new Calculation();
            calc.setWhists(buildWhist(prom));
            result.put(player, calc);
        });
        return result;
    }

    private static Map<Player, Integer> buildWhist(List<Player> players) {
        Map<Player, Integer> result = new HashMap<>();
        players.forEach(player -> result.put(player, 0));
        return result;
    }

    public Integer getBullet() {
        return bullet;
    }

    public void setBullet(Integer bullet) {
        this.bullet = bullet;
    }

    public Integer getMountain() {
        return mountain;
    }

    public void setMountain(Integer mountain) {
        this.mountain = mountain;
    }

    public Map<Player, Integer> getWhists() {
        return whists;
    }

    public void setWhists(Map<Player, Integer> whists) {
        this.whists = whists;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
