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

    public int getTeam() {
        return team;
    }
    
    
	public boolean checkCollision(Plateau p, Integer n, Integer l) {
		return false;
	}

	public Integer getNbCase() {
		return nbCase;
	}

	public void setNbCase(Integer nbCase) {
		this.nbCase = nbCase;
	}
	


}
