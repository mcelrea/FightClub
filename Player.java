public class Player {
    //(1) the fields - what IS a player
    private String name;
    private int health;
    private int ac; //armor class

    //(2) constructor - what requirements for new Players?
    public Player(String name) {
        this.name = name;
        health = 10;
        ac = 12; //40% chance to hit
    }

    //getters and setters
    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    public int getAc() {
        return ac;
    }

    public void attack(Enemy enemy) {
        enemy.damage(3);
        System.out.println(name + " hits for 3 damage");
    }

    public void slash(Enemy enemy) {
        int toHit = Dice.rollDice("1d20+2");
        //check to see if we hit the enemy
        if(toHit >= enemy.getAc()) {
            int dmg = Dice.rollDice("1d6+2");
            enemy.damage(dmg);
            System.out.println("You slashed " +
                    enemy.getName() + " for " +
                    dmg + " points of damage.");
        }
        else { //player missed
            System.out.println("You tried to slash " +
                    enemy.getName() + " but missed.");
        }
    }

    public void bash(Enemy enemy) {
        int toHit = Dice.rollDice("1d20+5");
        //check to see if we hit the enemy
        if(toHit >= enemy.getAc()) {
            int dmg = Dice.rollDice("1d4+1");
            enemy.damage(dmg);
            System.out.println("You shield bashed " +
                    enemy.getName() + " for " +
                    dmg + " points of damage.");
        }
        else { //player missed
            System.out.println("You tried to shield bash " +
                    enemy.getName() + " but missed.");
        }
    }

    public void setName(String name) {
        this.name = name;
    }
    public void damage(int dmg) {
        health -= dmg;
    }

    public String toString() {
        return name + "\n" +
                "-----------------\n" +
                "Health: " + health + "\n" +
                "AC:     " + ac;
    }
}
