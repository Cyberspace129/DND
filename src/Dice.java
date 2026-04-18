import java.util.Random;

public class Dice {
    private Random random;

    public Dice() {
        this.random = new Random();
    }

    public int rollD6() {
        return random.nextInt(6) + 1;
    }
    public int rollD12() {
        return random.nextInt(12) + 1;
    }
    public int rollD10() {
        return random.nextInt(10) + 1;
    }
    public int RollDN(int n) {
        return random.nextInt(n) + 1;
    }

}
