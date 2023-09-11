package comp1110.ass2;

public class Tile
{
    // The position of the tile
    public Coordinate tileCoord;

    // Is the tile currently empty or occupied?
    public enum State {EMPTY, OCCUPIED}

    // The rug(s) placed on this tile
    Rug[] contents;

    // Does the tile currently contain Assam?
    public boolean containsAssam;

    /* Constructor for the Tile class, which takes a coordinate
    and also checks if it contains Assam */
    public Tile(Coordinate coord)
    {
        // Set the tile coordinate

        // Check if assamPosition == tile coordinate
    }
}
