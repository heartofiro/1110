package comp1110.ass2;

public class Rug {
    // Two-digit number represents rug I
    public int rugID;
    // The colour of the rug
    public Colour rugColour;

    // The coordinate of the rug
    public static IntPair[] rugPosition;

    public Rug(String rugString){

        // 7 charactors
        if (rugString.length() != 7){
            System.out.println("Invalid playerString! playerString must be 7 characters.");
        }else{
        char colorChar = rugString.charAt(0);
        switch (colorChar) {
            case 'c':
                this.rugColour = Colour.CYAN;
                break;
            case 'y':
                this.rugColour = Colour.YELLOW;
                break;
            case 'r':
                this.rugColour = Colour.RED;
                break;
            case 'p':
                this.rugColour = Colour.PURPLE;
                break;
            default:
                System.out.println("Can not identify player's color");
        }
        }
        // obtain colour from their owner
        String idString = rugString.substring(1, 3);
        rugID = Integer.parseInt(idString);
        // obtain rug's number starting from 00 with the order of placement

        // obtain rug's coordinate
        String coordString = rugString.substring(3);
        int x1 = Character.getNumericValue(coordString.charAt(0));
        int y1 = Character.getNumericValue(coordString.charAt(1));
        int x2 = Character.getNumericValue(coordString.charAt(2));
        int y2 = Character.getNumericValue(coordString.charAt(3));
        rugPosition = new IntPair[] {new IntPair(x1, y1), new IntPair(x2, y2)};
    }
    public boolean overlaps(){
    return false;}

    //Check if rug is our of bounds
    public boolean outOfBounds() {
        for (IntPair coord : this.rugPosition) {
            if (coord.getX() < 0 || coord.getX() > 7 || coord.getY() < 0 || coord.getY() > 7) {
                return true;
            }
        }
        return false;
    }



}





