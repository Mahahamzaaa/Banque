/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionBancaire;

/**
 *
 * @author Mahouta
 */
public class Employé {

    private int id_emp;
    private String nom_emp;
    private String prenom_emp;
    private String date_naissance_emp;
    private String poste;
    private String login;
    private String password;
    /*
     public Employe() {
     Scanner sc = new Scanner(System.in);
     System.out.println("Donnez le code de l'employé");
     this.code= sc.nextInt();
     System.out.println("Donnez le nom de l'employé");
     this.nom = sc.next();
     System.out.println("Donnez le prénom de l'employé");
     this.prenom = sc.next();
     System.out.println("Donnez l'adresse de l'employé ");
     this.adresse = sc.next();
     System.out.println("Donnez le poste de l'employé ");
     }*/

    public Employé(int id_emp, String nom_emp, String prenom_emp, String date_naissance_emp, String poste,String login,String password) {
        this.id_emp =id_emp;
        this.nom_emp = nom_emp;
        this.prenom_emp = prenom_emp;
        this.date_naissance_emp = date_naissance_emp;
        this.poste = poste;
        this.login = login ;
        this.password = password ;
        
    }
//getter & setter : 

    public int getId_emp() {
        return id_emp;
    }

    public void setId_emp(int id_emp) {
        this.id_emp = id_emp;
    }

    public String getNom_emp() {
        return nom_emp;
    }

    public void setNom_emp(String nom_emp) {
        this.nom_emp = nom_emp;
    }

    public String getPrenom_emp() {
        return prenom_emp;
    }

    public void setPrenom_emp(String prenom_emp) {
        this.prenom_emp = prenom_emp;
    }

    public String getDate_naissance_emp() {
        return date_naissance_emp;
    }

    public void setDate_naissance_emp(String date_naissance_emp) {
        this.date_naissance_emp = date_naissance_emp;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
