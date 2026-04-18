public class Map {
    public int width;
    public int height;

    private int[][] terrainGrid;
    private final Dice dice = new Dice(); // 🔥 always initialized

    // 🔥 Main terrain type
    public enum TerrainType {
        VILLAGE,
        MOUNTAIN,
        FOREST,
        DESERT,
        RANDOM
    }

    // 🔥 Sub-structures (kept as you wanted)
    public enum VillageBuildingType {
        INN,
        BLACKSMITH,
        MARKET,
        TAVERN,
        TEMPLE,
        HOUSE
    }

    public enum MountainType {
        SNOWY,
        ROCKY,
        VOLCANIC,
        FORESTED
    }

    public enum ForestType {
        DENSE,
        SPARSE,
        ENCHANTED,
        HAUNTED
    }

    public enum DesertType {
        SANDY,
        ROCKY,
        OASIS,
        DUNES
    }

    // 🔥 Constructor now generates map properly
    public Map(int width, int height, TerrainType terrain) {
        this.width = width;
        this.height = height;

        generateMap(terrain);
    }

    // =========================
    // 🔥 GENERATION METHODS
    // =========================

    private int[][] generateVillage() {
        terrainGrid = new int[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                terrainGrid[i][j] = dice.RollDN(VillageBuildingType.values().length);
            }
        }
        return terrainGrid;
    }

    private int[][] generateMountain() {
        terrainGrid = new int[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                terrainGrid[i][j] = dice.RollDN(MountainType.values().length);
            }
        }
        return terrainGrid;
    }

    private int[][] generateForest() {
        terrainGrid = new int[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                terrainGrid[i][j] = dice.RollDN(ForestType.values().length);
            }
        }
        return terrainGrid;
    }

    private int[][] generateDesert() {
        terrainGrid = new int[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                terrainGrid[i][j] = dice.RollDN(DesertType.values().length);
            }
        }
        return terrainGrid;
    }

    private void generateRandomTerrain() {
        int terrain = dice.RollDN(4);

        switch (terrain) {
            case 1 -> generateVillage();
            case 2 -> generateMountain();
            case 3 -> generateForest();
            case 4 -> generateDesert();
        }
    }

    // =========================
    // 🔥 MAIN GENERATOR
    // =========================

    public void generateMap(TerrainType terrain) {
        switch (terrain) {
            case VILLAGE -> generateVillage();
            case MOUNTAIN -> generateMountain();
            case FOREST -> generateForest();
            case DESERT -> generateDesert();
            case RANDOM -> generateRandomTerrain();
        }
    }

    // =========================
    // 🔥 PRINTING
    // =========================

    public void printMap() {
        if (terrainGrid == null) {
            System.out.println("Map not generated.");
            return;
        }

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.print(terrainGrid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] getMap() {
        return terrainGrid;
    }
}
