import java.util.HashMap;

public class Piece {
    private String name;
    private Integer team;
    private Integer nbCase;
    
    public Piece() {
    		
    }

    public Piece(String name, Integer team) {
        this.name = name;
        this.team = team;
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
	
}
