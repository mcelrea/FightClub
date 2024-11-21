import java.util.Scanner;

public class Main {

    static Scanner scrn = new Scanner(System.in);

    public static void main(String[] args) {

        /*
         * TEMP CODE
         */


        /*
         * Start of Real Code
         */
        Player p1 = createNewPlayer();
        Enemy e1 = new Enemy("Skeleton", 3, 8);
        e1.setAttack1("Bite", 2, "1d4+1");

        System.out.println("New Player Created!!!!\n\n");
        System.out.println(p1);
        System.out.println();

        String choice = getPlayerChoice();
        boolean canEnemyAttack = false;
        //main game loop
        while(p1.getHealth() > 0) {
            //handle player choice
            if(choice.equals("slash")) {
                p1.slash(e1);
                canEnemyAttack = true;
            }
            else if(choice.equals("bash")) {
                p1.bash(e1);
                canEnemyAttack = true;
            }
            else if(choice.equals("status")) {
                System.out.println(p1);
            }
            else if(choice.equals("potion")) {
                p1.useHpPotion();
            }
            else if(choice.equals("quit")) {
                p1.damage(10000);
            }

            //check if the player killed the enemy
            if(!e1.alive()) {
                System.out.println("You vanquished the enemy");
                e1.dies(p1);
                e1 = createNewEnemy(2);
            }
            else if (canEnemyAttack) { //the enemy is still alive
                e1.attack(p1);
            }

            if(p1.getHealth() > 0) {
                canEnemyAttack = false;
                choice = getPlayerChoice();
            }
        }

        System.out.println("\n\nGAME OVER\n\n");
    }

    public static Enemy createNewEnemy(int level) {
        int randomNum = (int)(1 + Math.random() * 3);

        Enemy temp;
        if(randomNum == 1) {
            temp = new Enemy("Zombie", 4 + (level * 2), 7);
            temp.setAttack1("Bite", level * 2, "1d4+1");
        }
        if(randomNum == 2) {
            temp = new Enemy("Small Dragon", 10 + (level * 2), 14);
            temp.setAttack1("Fire Breath", level * 2, "2d4+4");
        }
        else {
            temp = new Enemy("Goblin", 3 + (level * 2), 11);
            temp.setAttack1("Slash", level * 2, "2d6+1");
        }

        System.out.println("\nA NEW ENEMY HAS APPEARED.....\n");
        System.out.println(temp);

        return temp;
    }

    public static String getPlayerChoice() {
        System.out.print("\nEnter choice: ");
        String choice = scrn.next();
        return choice;
    }

    public static Player createNewPlayer() {
        System.out.print("Enter new player name: ");
        String nameInput = scrn.next();
        return new Player(nameInput);
    }
}