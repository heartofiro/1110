package comp1110.ass2;

public class Block {
    private Colour colour;
    private String id;
    
    public Block(Colour colour, String id) {
        this.colour = colour;
        this.id = id;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public Colour getColour() {
        return this.colour;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId() {
        return this.id;
    }
}
