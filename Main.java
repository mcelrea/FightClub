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
        //main game loop
        while(p1.getHealth() > 0) {
            //handle player choice
            if(choice.equals("slash")) {
                p1.slash(e1);
            }

            //check if the player killed the enemy
            if(!e1.alive()) {
                System.out.println("You vanquished the enemy");
                e1 = createNewEnemy(2);
            }
            else { //the enemy is still alive
                e1.attack(p1);
            }

            if(p1.getHealth() > 0) {
                choice = getPlayerChoice();
            }
        }

        System.out.println("\n\nGAME OVER\n\n");
    }

    public static Enemy createNewEnemy(int level) {
        Enemy temp = new Enemy("Enemy", 3+(level*2), 11);
        temp.setAttack1("Slash", level*2, "2d6+1");
        return temp;
    }

    public static String getPlayerChoice() {
        System.out.print("Enter choice: ");
        String choice = scrn.next();
        return choice;
    }

    public static Player createNewPlayer() {
        System.out.print("Enter new player name: ");
        String nameInput = scrn.next();
        return new Player(nameInput);
    }
}