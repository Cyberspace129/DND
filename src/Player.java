public class Player {
    public Stats stats;

    public enum SlotType {
        HEAD,
        CHEST,
        LEGS,
        FEET,
        HAND_LEFT,
        HAND_RIGHT
    }

    public class Slot {
        private final Item.Properties.Usage usage;
        private Item item;

        public Slot(Item.Properties.Usage usage) {
            this.usage = usage;
        }

        public boolean canEquip(Item item) {
            return item.getProperties().getUsage() == usage;
        }

        public boolean equip(Item item) {
            if (!canEquip(item)) return false;
            this.item = item;
            return true;
        }

        public Item unequip() {
            Item old = item;
            item = null;
            return old;
        }

        public void interact(Player player) {
            if (item == null) return;

            switch (item.getProperties().getItemType()) {
                case WEAPON -> System.out.println("Swing weapon!");
                case ARMOR -> System.out.println("Armor passive effect applied!");
                case POTION -> usePotion(player);
                default -> System.out.println("Item has no interaction.");
            }
        }

        private void usePotion(Player player) {
            System.out.println("Potion consumed!");
            item.setDurability(item.getDurability() - 1);
        }
    }

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
