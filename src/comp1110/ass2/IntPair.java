package comp1110.ass2;

public class IntPair
{
    private final int x;
    private final int y;

    /**
     * Constructor for an IntPair instance
     * @param xPos x
     * @param yPos y
     */
    public IntPair(int xPos, int yPos)
    {
        this.x = xPos;
        this.y = yPos;
    }

    /**
     * Returns the x value of an IntPair
     * @return x
     */
    public int getX()
    {
        return x;
    }

    /**
     * Returns the y value of an IntPair
     * @return y
     */
    public int getY()
    {
        return y;
    }

    /**
     * Override of toString() to ensure IntPairs strings are appropriately represented
     * @return a string about an IntPair's values
     */
    @Override
    public String toString()
    {
        return String.format("(%s, %s)", this.x, this.y);
    }

    /**
     * Proper implementation of equals() method for IntPairs
     * @param o the object to compare
     * @return whether two IntPairs have the same values
     */
    @Override
    public boolean equals(Object o)
    {
        if(o == null) return false;
        else if(o.getClass() == getClass())
        {
            return ((IntPair) o).getX() == x && ((IntPair) o).getY() == y;
        }
        // If, for whatever reason, the compared object is not an IntPair
        else
        {
            return false;
        }
    }
}
