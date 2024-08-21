package Game_RPG.Area;

import Game_RPG.Enemys.Enemy;
import Game_RPG.Enemys.Goblin;
import Game_RPG.Enemys.Slime;
import Game_RPG.Heroes.Archer;
import Game_RPG.Heroes.Hero;
import Game_RPG.Heroes.Mage;
import Game_RPG.Heroes.Warrior;

import java.util.ArrayList;
import java.util.List;

public class BattleGround {
    public static void main(String[] args) {

        List<Hero> heroes= new ArrayList<Hero>();
        List<Enemy> enemies = new ArrayList<Enemy>();

        Warrior war = new Warrior("Bob");
        Mage mag = new Mage("Charles");
        Archer arch = new Archer("Tom");

        Goblin goblin = new Goblin(enemies);
        Slime slime = new Slime(enemies);

        heroes.add(war);
        heroes.add(mag);
        heroes.add(arch);

        enemies.add(goblin);
        enemies.add(slime);

//        while ((goblin.isAlive()|| slime.isAlive())&& war.isAlive()) {  // Сражение война до победного со слизью и гоблином
//            war.attackEnemy(goblin);
//            goblin.attackHeroes(war);
//            war.attackEnemy(slime);
//            slime.attackHeroes(war);
//        }
//        System.out.println(war);
//        System.out.println(goblin);
//        System.out.println(slime);

//        while ((goblin.isAlive()|| slime.isAlive())&& arch.isAlive()) {  // Сражение лучника до победного со слизью и гоблином
//            arch.attackEnemy(goblin);
//            goblin.attackHeroes(arch);
//            arch.attackEnemy(slime);
//            slime.attackHeroes(arch);
//        }
//        System.out.println(arch);
//        System.out.println(goblin);
//        System.out.println(slime);

//        while ((goblin.isAlive()|| slime.isAlive())&& mag.isAlive()) {  // Сражение мага до победного со слизью и гоблином
//            mag.attackEnemy(goblin);
//            goblin.attackHeroes(mag);
//            mag.attackEnemy(slime);
//            slime.attackHeroes(mag);
//        }
//        System.out.println(mag);
//        System.out.println(goblin);
//        System.out.println(slime);

    }
}
