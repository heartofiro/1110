package comp1110.ass2;

public class Rug {
    // Two-digit number represents rug I ??? 01
    public String id;
    // The colour of the rug
    public Colour colour;

    // The coordinate of the rug
    public Coordinate[] position;

    public Rug(String rugString) {

        // 7 charactors
        if (rugString.length() != 7) {
            System.out.println("Invalid playerString! playerString must be 7 characters.");
        } else {
            char colorChar = rugString.charAt(0);
            switch (colorChar) {
                case 'c':
                    this.colour = Colour.CYAN;
                    break;
                case 'y':
                    this.colour = Colour.YELLOW;
                    break;
                case 'r':
                    this.colour = Colour.RED;
                    break;
                case 'p':
                    this.colour = Colour.PURPLE;
                    break;
                default:
                    System.out.println("Can not identify player's color");
            }
        }
        // obtain colour from their owner
        this.id = rugString.substring(1, 3);

        // obtain rug's coordinate
        String coordString = rugString.substring(3);
        int x1 = Character.getNumericValue(coordString.charAt(0));
        int y1 = Character.getNumericValue(coordString.charAt(1));
        int x2 = Character.getNumericValue(coordString.charAt(2));
        int y2 = Character.getNumericValue(coordString.charAt(3));
        position = new Coordinate[] { new Coordinate(x1, y1), new Coordinate(x2, y2) };
    }

    public boolean overlaps() {
        return false;
    }

    // Check if rug is our of bounds
    public boolean outOfBounds() {
        for (Coordinate coord : this.position) {
            if (coord.getX() < 0 || coord.getX() > 7 || coord.getY() < 0 || coord.getY() > 7) {
                return true;
            }
        }
        return false;
    }

    //

}
