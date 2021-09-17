public class Piece {
    private String color;
    private String name;
    private String type;

    public Piece(String color, String name, String type) {
        this.color = color;
        this.name = name;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return color + name + type;
    }
}
