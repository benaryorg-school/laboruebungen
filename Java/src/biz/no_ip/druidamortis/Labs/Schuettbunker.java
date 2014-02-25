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
public class Schuettbunker {
    private int max;
    private int[] silos;
    private int siloAnzahl;
    private int kranPos;
    
    public Schuettbunker(){
        this(1, 1);
    }
    public Schuettbunker(int anzahl, int max){
        this.setSiloAnzahl(anzahl);
        this.setMax(max);
        this.silos = new int[this.siloAnzahl];
    }
    
    
    public void setMax(int max){
        if(max > 0)
            this.max = max;
    }
    public void setSiloAnzahl(int anzahl){
        if(anzahl > 0)
            this.siloAnzahl = anzahl;
    }
    public void setKranPos(int pos){
        if(pos >= 0 && pos < this.max)
            this.kranPos = pos;
    }
    public int getMax(){
        return this.max;
    }
    public int getSiloAnzahl(){
        return this.siloAnzahl;
    }
    public int getKranPos(){
        return this.kranPos;
    }
    public void nachLinks(int i){
        if(this.getKranPos()-i >= 0)
            this.setKranPos(this.getKranPos()-i);
        else
            this.setKranPos(0);
    }
    public void nachRechts(int i){
        if(this.getKranPos()+i <= max)
            this.setKranPos(this.getKranPos()+i);
        else
            this.setKranPos(max);
    }
    public void fuell(int x){
        if(this.silos[this.kranPos] + x <= max)
            this.silos[this.kranPos]+=x;
        else
            this.silos[this.kranPos] = max;
    }
    public int gibAlles(){
        int tmp = this.silos[this.kranPos];
        this.silos[this.kranPos] = 0;
        return tmp;
    }
    @Override
    public String toString(){
        StringBuilder a = new StringBuilder();
        for (int i = 0; i < silos.length; i++) {
            a.append(i+1).append(": ").append(silos[i]).append("\n");
        }
        a.append("Kran: ").append(this.getKranPos()+1);
        return a.toString();
    }
    public static void main(String []args) {
        Schuettbunker sb = new Schuettbunker(5,10); // 5 Silos, Maximalwert 10
        sb.fuell(4);
        sb.fuell(1);
        sb.nachRechts(2); // Kran 2 Positionen nach rechts
        sb.fuell(20); // Maximalwert 10
        sb.nachRechts(2); // Kran 2 Positionen nach rechts
        sb.fuell(1);
        sb.nachLinks(42); // ganz nach Links, keine Randueberschreitung
        int temp = sb.gibAlles();
        sb.nachRechts(1);
        sb.fuell(temp);
        System.out.println(sb);
    }
}
