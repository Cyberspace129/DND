public class Player {
    public Stats stats;
    public General general;

    public Player(Stats stats) {
        this.stats = stats;
        this.general = new General();
    }
    public Stats getStats() {
        return stats;
    }
    public General.Time damage(Player.effects P_effect , General.Turn turn) {
        if (P_effect.cold == Player.effects.cold) {
            this.stats.speed -= P_effect.cold.strength * 2;
        }
        if (P_effect.acid == Player.effects.acid) {
            this.stats.health -= Player.effects.acid.strength * Player.effects.acid.damage;
        }
        if (P_effect.posion == Player.effects.posion) {
            this.stats.health -= Player.effects.posion.strength * Player.effects.posion.damage;
        }
        if (P_effect.burn == Player.effects.burn) {
            this.stats.health -= Player.effects.burn.strength * Player.effects.burn.damage;
        }
        if (P_effect.blindness == Player.effects.blindness) {
            this.stats.perception -= Player.effects.blindness.strength * 2;
        }
        if (P_effect.invisibility == Player.effects.invisibility) {
            this.stats.perception -= Player.effects.invisibility.strength * 2;
        }
        if (P_effect.stuned == Player.effects.stuned) {
            this.stats.speed -= Player.effects.stuned.strength * 2;
        }
        if (P_effect.charmed == Player.effects.charmed) {
            this.stats.charisma -= Player.effects.charmed.strength * 2;
        }
        
    }
    
    static class damages {
        public int strength;
        public damages(int a, int b, int c) {
            this.strength = a;
        }
    }

    class effects {
        // Damage types
        public damages cold         = new damages(4,0,1);
        public damages acid         = new damages(4,2,1);
        public damages posion       = new damages(4,4,1);
        public damages burn         = new damages(4,0,1);
        public damages blindness    = new damages(4,0,1);
        public damages invisibility = new damages(4,0,1);
        public damages stunded      = new damages(4,0,1);
        public damages charmed      = new damages(4,0,1);
    }


    
}
