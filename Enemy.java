public class Enemy {
    //fields - what an enemy IS
    private String name;
    private int health;
    private int ac; //armor class (1-20+)

    //attack 1
    private String attack1Name;
    private int attack1ToHit; //how likely attack 1 hits
    private String attack1Damage; //how much damage does attack 1 do

    //attack 2
    private String attack2Name;
    private int attack2ToHit; //how likely attack 2 hits
    private String attack2Damage; //how much damage does attack 2 do


    //constructor
    public Enemy(String name, int health, int ac) {
        this.name = name;
        this.health = health;
        this.ac = ac;
    }

    public String getName() {
        return name;
    }

    public int getAc() {
        return ac;
    }

    public void attack(Player player) {
        //random number between 1-20
        int toHit = (int)(1 + Math.random() * 20);

        //attack1
        toHit += attack1ToHit; //add the attack 1 modifier to hit
        //if attack1 hits
        if(toHit >= player.getAc()) {
            int damage = Dice.rollDice(attack1Damage);
            player.damage(damage);
            System.out.println(name + " " + attack1Name + " for " + damage +
                    " points of damage");
        }
        //else the enemy missed
        else {
            System.out.println(name + " attempts to " + attack1Name +
                    " but misses");
        }
    }

    public void damage(int dmg) {
        health -= dmg;
    }

    public boolean alive() {
        return health > 0;
    }

    public void setAttack1(String name, int hitModifier, String damageDie) {
        attack1Name = name;
        attack1ToHit = hitModifier;
        attack1Damage = damageDie;
    }

    public String toString() {
        return name + "\n" +
                "------------------\n" +
                "Health:  " + health + "\n" +
                "AC:      " + ac;
    }
}
