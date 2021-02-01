/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionBancaire;

import java.util.Date;

/**
 *
 * @author Mahouta
 */
public class Opération {
    private Date date;
	private int type;
	private double montant;
	
	public Opération(Date date, int type, double montant)
	{
		this.date = date;
		this.type = type;
		this.montant = montant;
	}
	
	public String toString()
	{
		return "Date: " + date + " type: " + type + " montant: " + montant;
	}
	
}
