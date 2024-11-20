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

    public void setName(String name) {
        this.name = name;
    }
    public void damage(int dmg) {
        health -= dmg;
    }

    public String toString() {
        return name + "\n" +
                "-----------------\n" +
                "health: " + health;
    }
}
