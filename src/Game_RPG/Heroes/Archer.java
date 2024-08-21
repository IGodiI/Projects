package Game_RPG.Heroes;

import Game_RPG.Enemys.Enemy;


public class Archer extends Hero{
    private  static  final int MAX_HP = 100;
    private int attack;  // Лучник наносит от 10 до 20 урона
    private int critAttack;
    public Archer(String name) {
        super(name, MAX_HP);
    }

    @Override
    public void takeDamage(int damage) {
        if (random.nextInt(1,21)>15) {  // Если повезёт, лучник может увернуться от удара, полностью игнорируя урон
            super.takeDamage(damage *= 0);
            System.out.println(super.getName() + " dodged.");
        }
        super.takeDamage(damage);
        System.out.println(super.getName() + " take " + damage + " damage.");
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        if (enemy.isAlive()&& super.isAlive()) {
            attack = random.nextInt(10,21);
            critAttack = attack * 5;
            if (random.nextInt(1,21)>15) { // Если повезёт, лучник может нанести пятикратный критический урон по противнику
                System.out.println("Archer " + super.getName() + " critical shot the enemy for " + critAttack + " points of damage.");
                enemy.takeDamage(critAttack);
            } else {
                System.out.println("Archer " + super.getName() + " shot the enemy for " + attack + " points of damage.");
                enemy.takeDamage(attack);
            }

        }
    }

    @Override
    public String toString() {
        return super.getName()+ " " + super.getHealth();
    }
}

