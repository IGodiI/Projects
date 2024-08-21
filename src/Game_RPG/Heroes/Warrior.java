package Game_RPG.Heroes;
import Game_RPG.Enemys.Enemy;

public class Warrior extends Hero {
    private int attack; // Воин наносит от 20 до 30 урона
    private double def = 0.7; // По умолчанию Воин получает 70% урона.
    private double defModify = 1;
    private double attackModify = 1;
    private static final int MAX_HP = 150;

    public Warrior(String name) {
        super(name, MAX_HP);
    }

    public void berserk (){  // После вхождение в состояние берсерка Воин получает 150% урона и наносит 200%.
        attackModify = 2;
        defModify = 1.5;
        System.out.println(super.getName() + " became a berserker.");
    }

    public void normal (){
        attackModify =1;
        defModify = 1;
        System.out.println(super.getName() + " calmed down.");
    }

    public void attackEnemy(Enemy enemy) {
        if (enemy.isAlive()&& super.isAlive()) {
            attack = random.nextInt(20,31);
            System.out.println("Warrior " + super.getName() + " chops the enemy for " + attack*attackModify + " points of damage.");
            enemy.takeDamage((int) (attack*attackModify));
            if (random.nextInt(1, 21) > 15 && defModify == 1.5) // Воин может выйти из режима берсерка после атаки по врагам с небольшим шансом и условием того, что он сейчас в режиме берсерка.
            normal();
        }
    }

    public void takeDamage(int damage) {
        int reducedDamage = (int) Math.floor((damage * def)*defModify); // Воин снижает урон по себе на 30% и значение полученного урона округляется
        super.takeDamage(reducedDamage);
        if (random.nextInt(1, 21) > 15 && defModify == 1) {  // Воин может войти в режим берсерка после атаки по нему с небольшим шансом и условием того, что он сейчас не в режиме берсерка.
            berserk();
        }
        super.takeDamage(damage);
        System.out.println(super.getName() + " take " + damage + " damage.");
    }

    @Override
    public String toString() {
        return super.getName() + " " + super.getHealth();
    }
}
