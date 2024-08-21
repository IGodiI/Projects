package Game_RPG.Enemys;
import Game_RPG.Heroes.Hero;

import java.util.List;

public class Slime extends Enemy implements Mortal {
    private static final int MAX_HP = 30;  // Слайм имеет мало очков здоровья, но убить его можно только сильной атакой.
    private int acidAttack = 1;  // Слайм сначала цепляется к противнику постепенно обволакивая его.
    private int absorptionAttack = random.nextInt(50,60);  // После определённого времени слайм целиком обволакивает героя и начинает поглощать его.
    private int absorbtion = 0;  // Через 5 раундов слайм начинает поглощение.

    public Slime(List<Enemy> enemies) {
        super(MAX_HP);
    }

    @Override
    public void takeDamage(int damage) {  // Если атака слабее 30 единиц, то она не наносит слайму урона.
        if (damage<30) {
            damage = 1;
            System.out.println("Weak attack. Slime take " + damage + " damage.");
        }else {
            super.takeDamage(damage);
            System.out.println("Strong attack. Slime take " + damage + " damage.");
        }
    }

    @Override
    public void attackHeroes(Hero hero) {
        if (super.isAlive()&& hero.isAlive()) {
            if (absorbtion >= 5) {
                System.out.println("Slime began to absorb " + hero.getName() + " and deal " + absorptionAttack + " damage.");
                hero.takeDamage(absorptionAttack);
            }
            System.out.println("Slime latched onto " + hero.getName() + " and dealt " + acidAttack + " damage.");
            hero.takeDamage(acidAttack);
            absorbtion++;
        }
    }

    @Override
    public String toString() {
        return "Slime " + super.getHealth();
    }

    @Override
    public boolean isAlive() {
        if (getHealth()>0){
            return true;
        }else {
            System.out.println("Slime are DEAD");
            return false;
        }
    }
}
