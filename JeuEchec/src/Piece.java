import java.util.HashMap;

public class Piece {
    private String name;
    private Integer team;
    private Integer nbCase;
    private Integer row;
    private Integer col;

    public Piece(String name, Integer team) {
        this.name = name;
        this.team = team;
    }
    
    public Piece(String name, Integer team, Integer nbCase) {
        this.name = name;
        this.team = team;
        this.nbCase = nbCase;
    }

    public String getName() {
        return name;
    }

    public Integer getTeam() {
        return team;
    }
    
	public Integer getNbCase() {
		return nbCase;
	}

	public void setNbCase(Integer nbCase) {
		this.nbCase = nbCase;
	}

	public boolean checkValidDeplacement(Plateau p, Integer row, Integer col, Integer oldRow, Integer oldCol) {
		return true;
	}

	public boolean checkTrajectoire(Plateau p, Integer team, Integer oldRow, Integer oldCol, Integer nbDestination) {
		return false;
	}

	public boolean checkTrajectoire(Plateau p, Integer oldRow, Integer oldCol, Integer nbDestination, HashMap<String, String> hDirection) {
		return false;
	}
	
	public boolean checkTrajectoire(Plateau p, Integer oldRow, Integer oldCol, Integer nbDestination, String direction) {
		return false;
	}


}
