import java.util.Scanner;

public class DND {
    static final int width = 10;
    static final int height = 10;
    public static final Map map = new Map(width, height, Map.TerrainType.VILLAGE);
    public static int[][] Cords = new int[width][height];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Player player = new Player(Classes.ClassType.MAGE, Classes.RaceType.ELF);
        System.out.println("Player created with class: " + player.className + " and race: " + player.raceName);
        System.out.println("Initial stats: " + player.stats);

        boolean running = true;
        while (running) {
            AI ai = new AI();
            ai.Run(player);
            map.printMap();

            String input = scanner.nextLine().toLowerCase();

            if (input.equals("exit")) {
                running = false;
            } else if (input.equals("up")) {
                General.Move(0);
            } else if (input.equals("right")) {
                General.Move(1);
            } else if (input.equals("down")) {
                General.Move(2);
            } else if (input.equals("left")) {
                General.Move(3);
            }
        }
        scanner.close();
    }

    public static int[][] getCords() {
        return Cords;
    }

    public static void setCords(int[][] Cords) {
        DND.Cords = Cords;
    }

    public static int getWidth() {
        return width;
    }
}
