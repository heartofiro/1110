package comp1110.ass2;

public class Board {

    /*
     * Board string example:
     * Bp07p07r07r07r06r09r08y06r01c06p00r06r09c09y15c13p12p00n00y09c09y15r05y03y14c01y09n00c05c15c15r14n00r13r13n00r15r15r04n00n00n00n00n00n00n00n00p13p13
     */

    // Board can contain 7*7 element arrays
    public Block boardTailes[][] = new Block[7][7];

    public Board(String boardString) {
        if (!boardString.startsWith("B")) {
            return;
        }

        int column = 0, row = 0;
        for (int i = 1; i < boardString.length(); i += 3) {
            boardTailes[column][row] = new Block(Colour.valueOf(boardString.substring(i, i + 1)),
                    boardString.substring(i + 1, i + 3));

            if (row < boardTailes.length) {
                row++;
            } else {
                column++;
                row = 0;
            }
        }
    }

    public void placeRug(Rug rug) {
        // first piece of rug
        boardTailes[rug.position[0].getX()][rug.position[0].getY()] = new Block(rug.colour, rug.id);
        // second piece of rug
        boardTailes[rug.position[1].getX()][rug.position[1].getY()] = new Block(rug.colour, rug.id);
    }
}
