package GestionBancaire;
import java.util.Date;

public class CompteCourant extends Compte implements Comparable{

    public double getDecouvertAutorise() {
        return decouvertAutorise;
    }
	
	private double decouvertAutorise;
	
	public CompteCourant(int code, double solde, double decouvertAutorise)
	{
		super(solde,code);
		this.decouvertAutorise = decouvertAutorise;
	}
	
	public void retirer(double montant)
	{
		Opération O = new Opération(new Date(), 1, montant);
		addOpération(O);
		if(this.solde+this.decouvertAutorise > montant) 
			this.solde -= montant;
	}
	
	public String toString()
	{
		return "code: " + this.code +  "	solde: " + this.solde + " decouvertautoris�: "+this.decouvertAutorise;
	}
	
	public int compareTo(Object c)
	{
		if(c != null)
		{
			CompteCourant cc;
			cc = (CompteCourant) c;
			if(this.decouvertAutorise > cc.decouvertAutorise) return 1;
			else if(this.decouvertAutorise == cc.decouvertAutorise) return 0;
			
		}
		return -3;
	}
	
}
