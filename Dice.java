public class Dice {

    /*
     * Given "2d8+3" rollDice will simulate the
     * rolling of 2 8-sided die and +3 to the result
     */
    public static int rollDice(String roll) {
        int dLoc = roll.indexOf("d");
        int plusLoc = roll.indexOf("+");

        //  01234
        // "2d8+3"
        //dLoc is 1
        //plusLoc is 3

        int howManyDie = Integer.parseInt(roll.substring(0,dLoc));
        int howManySides = Integer.parseInt(roll.substring(dLoc+1,plusLoc));
        int modifier = Integer.parseInt(roll.substring(plusLoc+1));

        int total = 0;
        //roll each die individually
        for(int i=1; i <= howManyDie; i++) {
            total += (int)(1 + Math.random() * howManySides);
        }
        total += modifier;
        return total;
    }
}
