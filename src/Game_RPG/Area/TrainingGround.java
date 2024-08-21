package Game_RPG.Area;

import Game_RPG.Enemys.Dummy;
import Game_RPG.Enemys.Enemy;
import Game_RPG.Enemys.Goblin;
import Game_RPG.Enemys.Slime;
import Game_RPG.Heroes.Archer;
import Game_RPG.Heroes.Hero;
import Game_RPG.Heroes.Mage;
import Game_RPG.Heroes.Warrior;

import java.util.ArrayList;
import java.util.List;

public class TrainingGround {
    public static void main(String[] args) {

        List<Hero> heroes= new ArrayList<Hero>();
        List<Enemy> enemies = new ArrayList<Enemy>();

        Warrior war = new Warrior("Bob");
        Archer arch = new Archer("Tom");
        Mage mag = new Mage("Rick");


        Dummy dummy = new Dummy(enemies);

        heroes.add(war);
        heroes.add(mag);
        heroes.add(arch);

        enemies.add(dummy);


        while (dummy.isAlive()&& war.isAlive()) {  // Тренировка война до победного с манекеном
            war.attackEnemy(dummy);
            arch.attackEnemy(dummy);
            mag.attackEnemy(dummy);
            dummy.attackHeroes(war);
            System.out.println();
        }
        System.out.println(war);
        System.out.println(dummy);

//        while (dummy.isAlive()&& arch.isAlive()) {  // Тренировка лучника до победного с манекеном
//            arch.attackEnemy(dummy);
//            dummy.attackHeroes(arch);
//            System.out.println();
//        }
//        System.out.println(arch);
//        System.out.println(dummy);
//
//        while (dummy.isAlive()&& mag.isAlive()) {  // Тренировка мага до победного с манекеном
//            mag.attackEnemy(dummy);
//            dummy.attackHeroes(mag);
//            System.out.println();
//        }
//        System.out.println(mag);
//        System.out.println(dummy);
    }
}
