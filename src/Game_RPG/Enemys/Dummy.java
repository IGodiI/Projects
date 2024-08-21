package Game_RPG.Enemys;
import Game_RPG.Heroes.Hero;
import java.util.List;

public class Dummy extends Enemy{
    private final static int ATTACK = 1;  // Манекен атакует для проверки активации умений героев
    private final static int MAX_HP = 1000;

    public Dummy(List<Enemy> enemies){
        super(MAX_HP);
    }


    @Override
    public void attackHeroes(Hero hero) {
        if (super.isAlive()&& hero.isAlive()) {
            System.out.println("Without doing anything, the dummy caused " + ATTACK + " damage");
            hero.takeDamage(ATTACK);
        }
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        System.out.println("Dummy take " + damage + " damage.");
    }
}
