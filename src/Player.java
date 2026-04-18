public class Player {
    public Stats stats;
    public Classes.ClassType className;
    public Classes.RaceType raceName;

    public class bodySlot {
        private final Item.Properties.Usage usage;
        private Item item;

        public bodySlot(Item.Properties.Usage usage) {
            this.usage = usage;
        }

        public Item getItem() {
            return item;
        }

        public Item.Properties.Usage getUsage() {
            return usage;
        }

        public boolean isEmpty() {
            return item == null;
        }

        public boolean setItem(Item item) {
            if (item.getProperties().getUsage() != usage) return false;

            this.item = item;
            return true;
        }

        public Item removeItem() {
            Item old = item;
            item = null;
            return old;
        }
    }



    public final bodySlot[] BodyMap = new bodySlot[] {
        new bodySlot(Item.Properties.Usage.HEAD),
        new bodySlot(Item.Properties.Usage.BODY),
        new bodySlot(Item.Properties.Usage.LEGS),
        new bodySlot(Item.Properties.Usage.FEET),
        new bodySlot(Item.Properties.Usage.HANDS),
        new bodySlot(Item.Properties.Usage.NECK),
        new bodySlot(Item.Properties.Usage.FINGER),
        new bodySlot(Item.Properties.Usage.ONE_HAND),
        new bodySlot(Item.Properties.Usage.TWO_HANDS)
    };

    public class Slot {
        private final Item[] Inventory = new Item[21]; // 7 rows of 3 columns for inventory
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

        public Item[] unequip() {
            Item old = item;
            for (int c = 0; c < Inventory.length; c++) {
                if (Inventory[c] == null) {
                    Inventory[c] = old;
                    break;
                }
            }
            item = null;
            return Inventory;
        }

        public Item getEquipped() {
            return item;
        }

        public Item[] getInventory() {
            return Inventory;
        }   

        public void EquipArmor(Item item) {
            if (item.getProperties().getItemType() != Item.Properties.ItemType.ARMOR) {
                throw new IllegalArgumentException("Item is not armor");
            }
            equip(item);
        }

        public void interact(Player player) {
            if (item == null) return;

            switch (item.getProperties().getItemType()) {
                case WEAPON -> System.out.println("Swing weapon!");
                case ARMOR -> System.out.println("Armor passive effect applied!");

                default -> System.out.println("Item has no interaction.");
            }
        }

    }

    public Player(Classes.ClassType classType, Classes.RaceType raceType) {
        this.className = classType;
        this.raceName = raceType;
        this.stats = Classes.combine(
            Classes.getClassStats(classType),
            Classes.getRaceStats(raceType)
        );
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
