
public class Piece {
    private String name;
    private Integer team;
    private Integer nbCase;
    

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

	public boolean checkAround(Plateau p, Integer row, Integer col) {
		return false;
	}
	
	public boolean checkValidDeplacement(Plateau p, Integer row, Integer col, Integer oldRow, Integer oldCol) {
		return true;
	}
	
}
