public class Piece {
    private String name;
    private Integer team;

    public Piece() {

    }

    public Piece(String name, Integer team) {
        this.name = name;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public int getTeam() {
        return team;
    }

}
