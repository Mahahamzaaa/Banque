package GestionBancaire;
import java.util.ArrayList;

import java.util.Iterator;
import java.util.Date;

abstract public class Compte {
	
	protected int code;
	protected double solde;

	
	//protected Opération[] Opération;
	protected ArrayList<Opération> Opération;
	
	//public static final int nbOpération = 100;
	//private int nbLigneReel;
	
	public Compte(double solde,int code)
	{
		this.solde = solde;
		this.code = code;
		//this.nbLigneReel = -1;
		//this.transaction = new Transaction[nbTransact];
		Opération = new ArrayList<Opération>();
	}
	
	
        public double getSolde() {
            return solde;
        }
        
	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public void deposer(double montant)
	{
		Opération O = new Opération(new Date(), 0, montant);
		addOpération(O);
		this.solde += montant;
	}
	
	public void retirer(double montant)
	{
		Opération O = new Opération(new Date(), 1, montant);
		addOpération(O);
		this.solde -= montant;
	}
	
	abstract public String toString();
	
	public void addOpération(Opération O)
	{
		Opération.add(O);
	}
	
	

	public void afficher()
	{
		System.out.println(this.Opération.size());
		
		Iterator<Opération> it =  Opération.iterator();
		while(it.hasNext() )
		{
			System.out.println(it.next());
		}
	}
}
