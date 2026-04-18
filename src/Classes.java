import java.util.HashMap;
import java.util.Map;

public class Classes {

    private final Map<String, Stats> classMap = new HashMap<>();
    private final Map<String, Stats> raceMap = new HashMap<>();

    public Classes() {
        initClasses();
        initRaces();
    }
    private void initRaces() {
        raceMap.put("human", new Stats(5, 5, 5, 5, 5, 5, 5, 5, 5));
        raceMap.put("elf", new Stats(5, 10, 5, 5, 5, 5, 5, 5, 10));
        raceMap.put("dwarf", new Stats(10, 5, 10, 5, 5, 5, 5, 5, 5));
        raceMap.put("halfling", new Stats(5, 10, 5, 5, 5, 5, 5, 5, 10));
        raceMap.put("gnome", new Stats(5, 5, 5, 10, 5, 5, 5, 5, 10));
        raceMap.put("half-elf", new Stats(5, 5, 5, 5, 5, 7, 5, 5, 7));
        raceMap.put("half-orc", new Stats(10, 5, 5, 5, 5, 3, 5, 10, 5));
        raceMap.put("tiefling", new Stats(5, 5, 5, 10, 5, 7, 5, 5, 7));
        raceMap.put("dragonborn", new Stats(10, 5, 5, 5, 5, 5, 5, 10, 5));
    }

    private void initClasses() {
        classMap.put("mage", new Stats(5, 5, 7, 10, 5, 3, 5, 10, 7));
        classMap.put("warrior", new Stats(10, 5, 3, 5, 5, 7, 5, 10, 7));
        classMap.put("rogue", new Stats(5, 10, 5, 5, 5, 7, 10, 7, 10));
        classMap.put("cleric", new Stats(5, 5, 10, 5, 10, 5, 5, 10, 7));
        classMap.put("ranger", new Stats(5, 7, 5, 5, 5, 7, 10, 7, 10));
        classMap.put("paladin", new Stats(7, 5, 10, 5, 7, 5, 5, 10, 7));
        classMap.put("bard", new Stats(5, 5, 5, 7, 5, 10, 5, 7, 10));
        classMap.put("monk", new Stats(5, 10, 5, 5, 7, 5, 10, 7, 10));
        classMap.put("druid", new Stats(5, 5, 7, 5, 10, 5, 5, 10, 7));
        classMap.put("barbarian", new Stats(10, 5, 7, 5, 5, 3, 5, 10, 7));
        classMap.put("sorcerer", new Stats(5, 5, 5, 10, 5, 7, 5, 7, 10));
        classMap.put("warlock", new Stats(5, 5, 5, 10, 5, 7, 5, 7, 10));
    }
    public Stats getClassStats(String className) {
        Stats stats = classMap.get(className.toLowerCase());

        if (stats == null) {
            throw new IllegalArgumentException("Invalid class name: " + className);
        }

        return stats;
    }
    public void setStats(String className, String statName, int value) {
        Stats stats = getClassStats(className);

        switch (statName.toLowerCase()) {
            case "strength", "str" -> stats.strength = value;
            case "dexterity", "dex" -> stats.dexterity = value;
            case "constitution", "con" -> stats.constitution = value;
            case "intelligence", "int" -> stats.intelligence = value;
            case "wisdom", "wis" -> stats.wisdom = value;
            case "charisma", "cha" -> stats.charisma = value;
            case "speed" -> stats.speed = value;
            case "health", "hp" -> stats.health = value;
            case "perception", "per" -> stats.perception = value;
            default -> throw new IllegalArgumentException("Invalid stat name: " + statName);
        }
    }
    public void ModStats(String className, String statName, int value) {
        Stats stats = getClassStats(className);

        switch (statName.toLowerCase()) {
            case "strength", "str" -> stats.strength += value;
            case "dexterity", "dex" -> stats.dexterity += value;
            case "constitution", "con" -> stats.constitution += value;
            case "intelligence", "int" -> stats.intelligence += value;
            case "wisdom", "wis" -> stats.wisdom += value;
            case "charisma", "cha" -> stats.charisma += value;
            case "speed" -> stats.speed += value;
            case "health", "hp" -> stats.health += value;
            case "perception", "per" -> stats.perception += value;
            default -> throw new IllegalArgumentException("Invalid stat name: " + statName);
        }
    }
    public void showClassStats(String className) {
        Stats stats = getClassStats(className);

        System.out.println("Stats for " + className + ":");
        System.out.println(stats);
    }

    public Stats finalStats(String className, String raceName) {
        Stats classStats = getClassStats(className);
        Stats raceStats = raceMap.get(raceName.toLowerCase());

        if (raceStats == null) {
            throw new IllegalArgumentException("Invalid race name: " + raceName);
        }

        return combine(classStats, raceStats);
    }

    private Stats combine(Stats a, Stats b) {
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

}