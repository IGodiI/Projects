package Game_RPG.Enemys;
import Game_RPG.Heroes.Hero;
import java.util.List;

public class Goblin extends Enemy{
    private static final int MAX_HP = 50;
    private int attack = random.nextInt(10,21);
    private List<Enemy> enemies;

    public Goblin(List<Enemy> enemies) {
        super(MAX_HP);
        this.enemies = enemies;

    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        System.out.println("Goblin take " + damage + " damage");
        if (random.nextInt(1,21)>15) {
            gang();
            System.out.println("Goblin calm gang");  // Гоблин зовёт помощника. Помощник реализован через костыль (типа он меняется местами со старым гоблином).
        }
    }

    public void gang(){
        super.setHealth(50);

    }

    public void attackHeroes(Hero hero) {
        if (super.isAlive() && hero.isAlive()) {
            System.out.println("Goblin attacks furiously for " + attack + " damage.");
            hero.takeDamage(attack);
        }
    }

    @Override
    public String toString() {
        return "Goblin " + super.getHealth();
    }

    @Override
    public boolean isAlive() {
        if (getHealth()>0){
            return true;
        }else {
            System.out.println("Goblin are DEAD");
            return false;
        }
    }
}
