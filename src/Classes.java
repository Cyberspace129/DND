import java.util.EnumMap;

public class Classes {

    // Enums for class, race, and stats  
    public enum ClassType {
        MAGE, WARRIOR, ROGUE, CLERIC, RANGER,
        PALADIN, BARD, MONK, DRUID,
        BARBARIAN, SORCERER, WARLOCK
    }

    public enum RaceType {
        HUMAN, ELF, DWARF, HALFLING,
        GNOME, HALF_ELF, HALF_ORC,
        TIEFLING, DRAGONBORN
    }

    public enum StatType {
        STRENGTH, DEXTERITY, CONSTITUTION,
        INTELLIGENCE, WISDOM, CHARISMA,
        SPEED, HEALTH, PERCEPTION
    }

    private static final EnumMap<ClassType, Stats> classMap = new EnumMap<>(ClassType.class);
    private static final EnumMap<RaceType, Stats> raceMap = new EnumMap<>(RaceType.class);

    static {
        initClasses();
        initRaces();
    }

    public Classes() {
    }

    private static void initClasses() {
        classMap.put(ClassType.MAGE,       new Stats(5, 5, 7, 10, 5, 3, 5, 10, 7));
        classMap.put(ClassType.WARRIOR,    new Stats(10, 5, 3, 5, 5, 7, 5, 10, 7));
        classMap.put(ClassType.ROGUE,      new Stats(5, 10, 5, 5, 5, 7, 10, 7, 10));
        classMap.put(ClassType.CLERIC,     new Stats(5, 5, 10, 5, 10, 5, 5, 10, 7));
        classMap.put(ClassType.RANGER,     new Stats(5, 7, 5, 5, 5, 7, 10, 7, 10));
        classMap.put(ClassType.PALADIN,    new Stats(7, 5, 10, 5, 7, 5, 5, 10, 7));
        classMap.put(ClassType.BARD,       new Stats(5, 5, 5, 7, 5, 10, 5, 7, 10));
        classMap.put(ClassType.MONK,       new Stats(5, 10, 5, 5, 7, 5, 10, 7, 10));
        classMap.put(ClassType.DRUID,      new Stats(5, 5, 7, 5, 10, 5, 5, 10, 7));
        classMap.put(ClassType.BARBARIAN,  new Stats(10, 5, 7, 5, 5, 3, 5, 10, 7));
        classMap.put(ClassType.SORCERER,   new Stats(5, 5, 5, 10, 5, 7, 5, 7, 10));
        classMap.put(ClassType.WARLOCK,    new Stats(5, 5, 5, 10, 5, 7, 5, 7, 10));
    }

    private static void initRaces() {
        raceMap.put(RaceType.HUMAN,      new Stats(5, 5, 5, 5, 5, 5, 5, 5, 5));
        raceMap.put(RaceType.ELF,        new Stats(5, 10, 5, 5, 5, 5, 5, 5, 10));
        raceMap.put(RaceType.DWARF,      new Stats(10, 5, 10, 5, 5, 5, 5, 5, 5));
        raceMap.put(RaceType.HALFLING,   new Stats(5, 10, 5, 5, 5, 5, 5, 5, 10));
        raceMap.put(RaceType.GNOME,      new Stats(5, 5, 5, 10, 5, 5, 5, 5, 10));
        raceMap.put(RaceType.HALF_ELF,   new Stats(5, 5, 5, 5, 5, 7, 5, 5, 7));
        raceMap.put(RaceType.HALF_ORC,   new Stats(10, 5, 5, 5, 5, 3, 5, 10, 5));
        raceMap.put(RaceType.TIEFLING,   new Stats(5, 5, 5, 10, 5, 7, 5, 5, 7));
        raceMap.put(RaceType.DRAGONBORN, new Stats(10, 5, 5, 5, 5, 5, 5, 10, 5));
    }

    // SAFE: returns copy
    public static Stats getClassStats(ClassType type) {
        return classMap.get(type).copy();
    }

    public static Stats getRaceStats(RaceType type) {
        return raceMap.get(type).copy();
    }

    public Stats finalStats(ClassType classType, RaceType raceType) {
        return Stats.combine(
                getClassStats(classType),
                getRaceStats(raceType)
        );
    }

    public static Stats combine(Stats s1, Stats s2) {
        return new Stats(
            s1.health + s2.health,
            s1.speed + s2.speed,
            s1.strength + s2.strength,
            s1.dexterity + s2.dexterity,
            s1.constitution + s2.constitution,
            s1.intelligence + s2.intelligence,
            s1.wisdom + s2.wisdom,
            s1.charisma + s2.charisma,
            s1.perception + s2.perception
        );
    }

    // One unified modifier
    public static void modifyStat(Stats stats, StatType type, int value, boolean additive) {
        switch (type) {
            case STRENGTH -> stats.strength = additive ? stats.strength + value : value;
            case DEXTERITY -> stats.dexterity = additive ? stats.dexterity + value : value;
            case CONSTITUTION -> stats.constitution = additive ? stats.constitution + value : value;
            case INTELLIGENCE -> stats.intelligence = additive ? stats.intelligence + value : value;
            case WISDOM -> stats.wisdom = additive ? stats.wisdom + value : value;
            case CHARISMA -> stats.charisma = additive ? stats.charisma + value : value;
            case SPEED -> stats.speed = additive ? stats.speed + value : value;
            case HEALTH -> stats.health = additive ? stats.health + value : value;
            case PERCEPTION -> stats.perception = additive ? stats.perception + value : value;
        }
    }
}
