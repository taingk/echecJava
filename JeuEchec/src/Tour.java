import java.util.*;

public class Tour extends Piece {
	public Tour(int team) {
		super("Tour", team);
	}

	@Override
    public boolean checkCollision(Plateau p, Integer n, Integer l){ 
    	if (n + 1 > p.getPlateau().length &&
    		l + 1 > p.getPlateau().length &&
    		n - 1 > p.getPlateau().length &&
    		l - 1 > p.getPlateau().length ){
    		return false;
	}

	else if(p.getPlateau()[n+1][l].getPiece()!=null&& // si devant n'est pas null
	p.getPlateau()[n-1][l].getPiece()!=null&& // si derriere n'est pas null
	p.getPlateau()[n][l+1].getPiece()!=null&& // si a droite n'est pas null
	p.getPlateau()[n][l-1].getPiece()!=null) // si a gauche n'est pas null
	{
		System.out.println("Vous avez rencontré un obsctacle");
		return true;
	}
	else{
		return false;
		}
	}
}