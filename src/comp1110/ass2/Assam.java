package comp1110.ass2;
//
public class Assam
{
    public enum Rotation {NORTH, EAST, SOUTH, WEST}

    // The location of Assam on the board
    public static IntPair assamPosition;

    // The current orientation of Assam
    public static Rotation assamOrientation;

    /**
     * Constructor for Assam - creates an instance of Assam using a given String
     * @param assamString a String representing the state of Assam
     */
   public Assam(String assamString)
   {
       if(assamString.length() != 4) System.out.println("Invalid assamString! assamString must be 4 characters.");
       if(assamString.charAt(0) != 'A') System.out.println("Invalid assamString! assamString must start with 'A'.");
       Assam.assamPosition = assamStringToIntPair(assamString);
       Assam.assamOrientation = assamStringToOrientation(assamString);
   }

    /**
     * Method to convert an assamString into an IntPair, which also checks the validity of the coordinates
     * @param assamString a string representing the state of Assam
     * @return a valid IntPair
     */
   IntPair assamStringToIntPair (String assamString)
   {
       if(assamString.length() != 4) System.out.println("Invalid assamString! assamString must be 4 characters.");

       char assamPosX = assamString.charAt(1);
       char assamPosY = assamString.charAt(2);

       // Ensure that the coordinate strings are valid
       if(Character.isDigit(assamPosX) && Character.isDigit(assamPosY))
       {
           int posX = Character.getNumericValue(assamPosX);
           int posY = Character.getNumericValue(assamPosY);
           if(posX <= 7 && posY <= 7) return new IntPair (posX, posY);
           else
           {
               System.out.println("Invalid assamString! coordinate strings must be within the board.");
               return null;
           }
       }
       else
       {
           System.out.println("Invalid assamString! coordinate strings must be integers.");
           return null;
       }
   }
   Rotation assamStringToOrientation(String assamString)
   {
       if(assamString.length() != 4) System.out.println("Invalid assamString! assamString must be 4 characters.");
       char assamOrientation = assamString.charAt(3);
       switch (assamOrientation)
       {
           case 'N' -> { return Rotation.NORTH; }
           case 'E' -> { return Rotation.EAST; }
           case 'S' -> { return Rotation.SOUTH; }
           case 'W' -> { return Rotation.WEST; }
           default ->
           {
               System.out.println("Invalid assamString! Orientation must be either N, E, S or W.");
               return null;
           }
       }
   }
    /**
     * Updates the position of Assam
     * @param newPosition an IntPair for the new position coordinates
     */
   public void updatePosition(IntPair newPosition)
   {
       int posX = newPosition.getX();
       int posY = newPosition.getY();
       if(posX >= 0 && posX <= 7 && posY >= 0 && posY <= 7) assamPosition = new IntPair (posX, posY);
       else System.out.println("Invalid position! newPosition must be within the board.");
   }

    /**
     * updatePosition method overloaded for use with assamStrings
     * @param assamString a string representing the state of Assam
     */
   public void updatePosition(String assamString)
   {
       updatePosition(assamStringToIntPair(assamString));
   }

    /**
     * Updates the orientation of Assam
     * @param newOrientation a new Rotation for Assam
     */
    public void updateOrientation(Rotation newOrientation)
    {
        assamOrientation = newOrientation;
    }

    /**
     * updateOrientation method overloaded for use with assamStrings
     * @param assamString a string representing the state of Assam
     */
    public void updateOrientation(String assamString)
    {
        updateOrientation(assamStringToOrientation(assamString));
    }

    // If Assam moves out of the board, return a new position based on his old position
    public IntPair positionAfterMovingOut(IntPair oldPosition)
    {
        return null;
    }
}
