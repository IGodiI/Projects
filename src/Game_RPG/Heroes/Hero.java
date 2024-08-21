package Game_RPG.Heroes;
import java.util.Random;
import Game_RPG.Enemys.Enemy;

public abstract class Hero implements Mortal{
    private String name;
    private int health;


    Random random = new Random();

    public Hero(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setHealth(int health) {
        this.health = health;
    }

    public void takeDamage (int damage){
        health -= damage;
    }

    @Override
    public boolean isAlive() {
        if (getHealth()>0){
            return true;
        }else {
            System.out.println(this.name + " are DEAD");
            return false;
        }
    }

    public abstract void attackEnemy(Enemy enemy);
}
