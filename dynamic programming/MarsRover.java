import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class MarsRover {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        // Ask the position of the rover
        System.out.print("Enter the position of the rover : ");
        String positionInput = scanner.nextLine();

        // Ask the commands
        System.out.print("Enter the set of commands : ");
        String commands = scanner.nextLine();

        // Position of the rover
        int x = Integer.valueOf(positionInput.charAt(0) + "");
        int y = Integer.valueOf(positionInput.charAt(1) + "");
        String direction = positionInput.charAt(2) + "";

        // Create the rover object
        Rover rover = new Rover(x, y, direction);
        for(char command : commands.toCharArray()) {
            rover.takeCommand(command);
        }

        System.out.println(rover);

    }
}

class Direction {
    private String direction;
    private int angle;

    private static Map<String, Integer> direcationAngleMap = new HashMap<>();
    static {
        direcationAngleMap.put("E", 0);
        direcationAngleMap.put("N", 90);
        direcationAngleMap.put("W", 180);
        direcationAngleMap.put("S", 270);
    }

    public Direction(String direction) {
        this.direction = direction;
        this.angle = direcationAngleMap.get(direction);
    }

    public void rotate(char lOrR) {
        switch(lOrR) {
            case 'L' : this.angle += 90; break;
            case 'R' : this.angle -= 90; break;
        }

        if(this.angle == 360) {
            this.angle = 0;
        } else if(this.angle == -90) {
            this.angle = 270;
        }

        direcationAngleMap.forEach((direction, angle) -> {
            if(angle == this.angle) {
                this.direction = direction;
            }
        });
    }

    /**
     * @return the direction
     */
    public String getDirection() {
        return direction;
    }
}

class Rover {
    private int x;
    private int y;
    private Direction direction;

    public Rover(int x, int y, String direction) {
        this.x = x;
        this.y = y;
        this.direction = new Direction(direction);
    }

    public void takeCommand(char command) {
        if(command == 'L' || command == 'R') {
            this.direction.rotate(command);
        } else {

            switch(this.direction.getDirection()) {
                case "E" : this.x ++; break;
                case "N" : this.y ++; break;
                case "W" : this.x --; break;
                case "S" : this.y --; break;
            }
        }
    }

    @Override
    public String toString() {
        return this.x + " " + this.y + " " + this.direction.getDirection();
    }
}