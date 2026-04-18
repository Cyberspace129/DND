public class Player {
    public Stats stats;

    public Player(Stats stats) {
        this.stats = stats;
    }

    public void applyEffect(Effect effect) {
        switch (effect.type) {
            case COLD -> stats.speed -= effect.strength * 2;
            case ACID -> stats.health -= effect.strength * effect.damage;
            case POISON -> stats.health -= effect.strength * effect.damage;
            case BURN -> stats.health -= effect.strength * effect.damage;
            case BLINDNESS -> stats.perception -= effect.strength * 2;
            case INVISIBILITY -> stats.perception -= effect.strength * 2;
            case STUNNED -> stats.speed -= effect.strength * 2;
            case CHARMED -> stats.charisma -= effect.strength * 2;
            default -> throw new IllegalStateException("Unexpected value: " + effect.type);
        }
    }
}
