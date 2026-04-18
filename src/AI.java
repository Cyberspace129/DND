public class AI {
    public static void Run(Player player) {
        Player AI = new Player(Classes.ClassType.WARRIOR, Classes.RaceType.HUMAN);

        AI ai = new AI();
        General.Print("AI is running...");
        General.Print("Player stats: " + ai.new GetPlayerStats().getPlayerStats(player));
        General.Print("Player inventory: " + java.util.Arrays.toString(ai.new GetInventory().getInventory(player)));
        General.Print("Player equipped items: " + java.util.Arrays.toString(ai.new GetEquippedItems().getEquippedItems(player)));
        General.Print("Map info: " + ai.new GetMapInfo().getMap());

        Stats selfStats = ai.new GetSelfStats().getSelfStats(AI);
        General.Print("AI stats: " + selfStats);
        Item[] selfInventory = ai.new GetInventory().getInventory(AI);
        General.Print("AI inventory: " + java.util.Arrays.toString(selfInventory));
        Item[] selfEquippedItems = ai.new GetEquippedItems().getEquippedItems(AI);
        General.Print("AI equipped items: " + java.util.Arrays.toString(selfEquippedItems));
    }
    // getting the opponets stats 
    class GetPlayerStats {
        
        public Stats getPlayerStats(Player player) {
            return player.stats;
        }

        public Player getPlayer(Player player) {
            return player;
        }
    }
    class GetPlayerItems {
        public Player.bodySlot getPlayerItems(Player player, int index) {
            return player.BodyMap[index];
        }
    }

    // getting map info
    class GetMapInfo {
        public Map getMap() {
            return DND.map;
        }
    }

    // getting self stats
    class GetSelfStats {
        public Stats getSelfStats(Player player) {
            return player.stats;
        }
    }
    class GetInventory {
        public Item[] getInventory(Player player) {
            Item[] inventory = new Item[21];
            for (int i = 0; i < 21; i++) {
                inventory[i] = player.BodyMap[i % player.BodyMap.length].getItem();
            }
            return inventory;
        }
    }
    class GetEquippedItems {
        public Item[] getEquippedItems(Player player) {
            Item[] equippedItems = new Item[player.BodyMap.length];
            for (int i = 0; i < player.BodyMap.length; i++) {
                equippedItems[i] = player.BodyMap[i].getItem();
            }
            return equippedItems;
        }
    }



    public AI() {
        GetPlayerItems playerItems = new GetPlayerItems();
        GetMapInfo mapInfo = new GetMapInfo();
        GetPlayerStats selfStats = new GetPlayerStats();
        GetInventory inventory = new GetInventory();
        GetEquippedItems equippedItems = new GetEquippedItems();
    }
}
