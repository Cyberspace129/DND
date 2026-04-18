public class Item {
    public int durability;
    public int weight;
    public int value;
    public Properties properties;

    public static class Properties {

        public Usage getUsage() {
            return usage;
        }

        public void setUsage(Usage usage) {
            this.usage = usage;
        }

        public Enchantment getEnchantment() {
            return enchantment;
        }

        public void setEnchantment(Enchantment enchantment) {
            this.enchantment = enchantment;
        }

        public Material getMaterial() {
            return material;
        }

        public void setMaterial(Material material) {
            this.material = material;
        }

        public Rarity getRarity() {
            return rarity;
        }

        public void setRarity(Rarity rarity) {
            this.rarity = rarity;
        }

        public ItemType getItemType() {
            return itemType;
        }

        public void setItemType(ItemType itemType) {
            this.itemType = itemType;
        }
        public enum ItemType {
            WEAPON,
            ARMOR,
            POTION,
            SCROLL,
            RING,
            AMULET,
            FOOD,
            TOOL
        }

        public enum Rarity {
            COMMON,
            UNCOMMON,
            RARE,
            EPIC,
            LEGENDARY
        }

        public enum Material {
            IRON,
            STEEL,
            WOOD,
            LEATHER,
            CLOTH,
            GLASS,
            GEMSTONE
        }

        public enum Enchantment {
            FIRE,
            FROST,
            LIGHTNING,
            POISON,
            HOLY,
            CURSE
        }

        public enum Usage {
            ONE_HAND,
            TWO_HANDS,
            HEAD,
            BODY,
            LEGS,
            FEET,
            HANDS,
            NECK,
            FINGER
        }

        public ItemType itemType;
        public Rarity rarity;
        public Material material;
        public Enchantment enchantment;
        public Usage usage;

        @Override
        public String toString() {
            return "Properties [itemType=" + itemType + ", rarity=" + rarity + ", material=" + material
                    + ", enchantment=" + enchantment + ", usage=" + usage + "]";
        }
    }

    public Item(int durability, int weight, int value, Properties properties) {
        this.durability = durability;
        this.weight = weight;
        this.value = value;
        this.properties = properties;
    }

    public Properties getProperties() {
        return properties;
    }
    
    public int getDurability() {
        return durability;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
