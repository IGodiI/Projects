package Game_RPG.Enemys;
import Game_RPG.Heroes.Hero;

import java.util.List;
import java.util.Random;

public abstract class Enemy implements Mortal {
    private int health;
    Random random = new Random();

    public Enemy(int health) {
        this.health = health;
        List<Enemy> enemies;
    }

    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }

    public void takeDamage(int damage) {
        if (isAlive())
        health -= damage;
    }

    public abstract void attackHeroes(Hero hero);

    @Override
    public boolean isAlive() {
        return getHealth() > 0;
    }

    @Override
    public String toString() {
        return "Enemy" +
                " health " + health;
    }
}
