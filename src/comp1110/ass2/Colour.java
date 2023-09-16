package comp1110.ass2;


public enum Colour {
    CYAN("c"), YELLOW("y"), RED("r"), PURPLE("p"), BLANK("b");

    private final String name;

    Colour(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }};



