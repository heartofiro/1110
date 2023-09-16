package comp1110.ass2;

public class Board {

    //Board can contain 7*7 element arrays
    public int tileRugid;

    public Block[][] boardTailes = new Block[7][7];

    public Colour tileColor;

    public Board (String boardString){
        if (boardString.charAt(0) != 'B'){
            System.out.println("boardString must start with 'B'");
        } else if (boardString.length() != 148) {
            System.out.println("boardString must contain 148 chars");
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

        for (int i = 1 ; i < boardString.length() ; i+=3){
            String tileString = boardString.substring(i , i+3);
            if (tileString == "n00"){
                continue;
            }

            String idString = tileString.substring(1,3);

            try {
                tileRugid = Integer.parseInt(idString);
            } catch (NumberFormatException e) {
                System.out.println("The string is not a valid integer.");
            }

            char colorChar = tileString.charAt(0);
            switch (colorChar) {
                case 'c' -> this.tileColor = Colour.CYAN;
                case 'y' -> this.tileColor = Colour.YELLOW;
                case 'r' -> this.tileColor = Colour.RED;
                case 'p' -> this.tileColor = Colour.PURPLE;
                default -> System.out.println("Can not identify tile's color");
            }

        }
    }

    public Colour getTileColor() {
        return tileColor;
    }

    public int getTileRugid() {
        return tileRugid;
    }
    public void placeRug(Rug rug) {
        // first piece of rug
        boardTailes[rug.position[0].getX()][rug.position[0].getY()] = new Block(rug.colour, rug.rugID);
        // second piece of rug
        boardTailes[rug.position[1].getX()][rug.position[1].getY()] = new Block(rug.colour, rug.rugID);
    }
}
//