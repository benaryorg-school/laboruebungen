/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package biz.no_ip.druidamortis.Labs;

/**
 *
 * @author michael
 */
public class Konto{
    private double kontostand;
    private Person inhaber;
    
    public void setKontostand(double kontostand){
        this.kontostand = kontostand;
    }
    public void setInhaber(Person inhaber){
        this.inhaber = inhaber;
    }
    public double getKontostand(){
        return this.kontostand;
    }
    public Person getInhaber(){
        return this.inhaber;
    }
    
    public Konto(String name, String vorname, double kontostand){
        this.inhaber = new Person(name, vorname);
        this.kontostand = kontostand;
    }
    public Konto(String name, String vorname){
        this(name, vorname, 0);
    }
    public Konto(){
        this("N.N", "N.N");
    }
    public static void vergleich(Konto a, Konto b){
        if(a.getKontostand() > b.getKontostand())
            System.out.println(a.inhaber.getName() + " hat mehr Geld auf dem Konto als " + b.inhaber.getName());
        if(a.getKontostand() == b.getKontostand())
            System.out.println(a.inhaber.getName() + " und " + b.inhaber.getName() + " haben den gleichen Kontostand");
        if(a.getKontostand() < b.getKontostand())
            System.out.println(b.inhaber.getName() + " hat mehr Geld auf dem Konto als " + a.inhaber.getName());
    }
    
    
    public static void main(String []args) {
        Konto konto1 = new Konto ("Schmidt", "Hans", 500.0);
        Konto konto2 = new Konto ("Krause", "Peter", 1500.0);
        Konto konto3 = new Konto ("Bauer", "Harald", 500.0);
        Konto.vergleich (konto1, konto2);
        Konto.vergleich (konto2, konto3);
        Konto.vergleich (konto1, konto3);
    }
}
