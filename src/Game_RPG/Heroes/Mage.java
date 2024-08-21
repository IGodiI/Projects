package Game_RPG.Heroes;
import Game_RPG.Enemys.Enemy;




public class Mage extends Hero{
    private int coolDown;  // Маг может произносить заклинание "Огненный шар" через каждые 2 шага, но начинает произнесение заклинания с нуля.
    private int magDamage;  // Урон от огненного шара прописывается случайным дальше.
    private int stickDamage;  // Урон от удара посохом прописывается случайным дальше.
    private static final int MAX_HP = 50;

    public Mage(String name) {
        super(name, MAX_HP);
    }


    public void takeDamage(int damage) {
        if (random.nextInt(1,21)<10){  // При получении урона маг может потерять концентрацию и время произношения заклинания увеличится
            coolDown--;
            System.out.println("Mage lost his concentration");
            if (coolDown < 0)
                coolDown = 0;
        }
        super.takeDamage(damage);
        System.out.println(super.getName() + " take " + damage + " damage.");
    }

    public void attackEnemy(Enemy enemy) {
        if (enemy.isAlive()&& super.isAlive()) {
            if (coolDown >= 2) {
                magDamage = random.nextInt(40,61);
                System.out.println("Mage " + super.getName() + " launch a fireball to the enemy for " + magDamage + " points of damage.");
                enemy.takeDamage(magDamage);
                coolDown -= 2;
            } else {
                stickDamage = random.nextInt(5,16);
                System.out.println("Mage " + super.getName() + " struck with his staff for " + stickDamage + " points of damage.");
                enemy.takeDamage(stickDamage);
                if (random.nextInt(1,21)>15){  // Если повезёт, то маг может сбросить время перезарядки умения
                    coolDown = 2;
                }
                coolDown++;  // Если не повезёт - восстановится только одно значение

            }
        }
    }

    @Override
    public String toString() {
        return super.getName()+ " " + super.getHealth();
    }
}
