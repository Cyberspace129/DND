public class Stats {
    public int strength; // Strength
    public int dexterity; // Dexterity
    public int constitution; // Constitution
    public int intelligence; // Intelligence
    public int wisdom; // Wisdom
    public int charisma; // Charisma
    public int speed; // speed
    public int health; // health
    public int perception; // perception

    public Stats(int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma, int speed, int health) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.speed = speed;
        this.charisma = charisma;
        this.health = health;
        this.perception = perception;
    }

    class damages {
        public int durations; // turns
        public int damage;
        public int strength;

        public damages(int durations, int damage, int strength) {
            this.durations = durations;
            this.damage = damage;
            this.strength = strength;
        }        
    }

    
}
