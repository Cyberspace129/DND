public class Effect {
    public enum EffectType {
        COLD,
        ACID,
        POISON,
        BURN,
        BLINDNESS,
        INVISIBILITY,
        STUNNED,
        CHARMED
    }

    public EffectType type;
    public int duration;
    public int damage;
    public int strength;

    public Effect(EffectType type, int duration, int damage, int strength) {
        this.type = type;
        this.duration = duration;
        this.damage = damage;
        this.strength = strength;
        }
}
