public class Stats {
    public int strength;
    public int dexterity;
    public int constitution;
    public int intelligence;
    public int wisdom;
    public int charisma;
    public int speed;
    public int health;
    public int perception;

    public Stats(int strength, int dexterity, int constitution,
                 int intelligence, int wisdom, int charisma,
                 int speed, int health, int perception) {

        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.speed = speed;
        this.health = health;
        this.perception = perception;
    }

    // Copy (prevents template mutation bugs)
    public Stats copy() {
        return new Stats(
            strength, dexterity, constitution,
            intelligence, wisdom, charisma,
            speed, health, perception
        );
    }

    // Combine two stat objects
    public static Stats combine(Stats a, Stats b) {
        return new Stats(
            a.strength + b.strength,
            a.dexterity + b.dexterity,
            a.constitution + b.constitution,
            a.intelligence + b.intelligence,
            a.wisdom + b.wisdom,
            a.charisma + b.charisma,
            a.speed + b.speed,
            a.health + b.health,
            a.perception + b.perception
        );
    }

    @Override
    public String toString() {
        return "Stats {" +
                "STR=" + strength +
                ", DEX=" + dexterity +
                ", CON=" + constitution +
                ", INT=" + intelligence +
                ", WIS=" + wisdom +
                ", CHA=" + charisma +
                ", SPD=" + speed +
                ", HP=" + health +
                ", PER=" + perception +
                '}';
    }
}
