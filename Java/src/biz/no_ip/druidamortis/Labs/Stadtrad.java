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
public class Stadtrad extends Fahrrad{
    private boolean licht;

    public void setLicht(boolean licht){
        this.licht = licht;
    }
    public boolean isLicht(){
        return this.licht;
    }
    
    
    
    
    public Stadtrad(String fahrer, String farbe, int richtung, double geschwindigkeit, boolean licht){
        super(fahrer, farbe, richtung, geschwindigkeit);
        this.licht = licht;
    }
    public Stadtrad(String fahrer, String farbe, boolean licht) {
        this(fahrer, farbe, 0, 0, licht);
        //oder super(fahrer, farbe); this.licht = licht;
    }
    public Stadtrad(){
        
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Fahrer: ").append(this.getFahrer()).append(", Farbe: ").append(this.getFarbe()).append(", Richtung: ").append(this.getRichtung()).append(", km/h: ").append(this.getKmh()).append(", Licht: ");
        if(isLicht())
            sb.append("an");
        if(!isLicht())
            sb.append("aus");
        return sb.toString();
    }
    
    
    public static void main(String args[]) {
        Fahrrad r = new Stadtrad("Thomas","schwarz", false); r.lenken(10);
        r.beschleunigen(0.3,9.8); ((Stadtrad)r).setLicht(true);
        System.out.println(r);
    }
}
