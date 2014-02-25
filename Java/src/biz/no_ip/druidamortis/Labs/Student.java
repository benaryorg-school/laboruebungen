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
public class Student extends Person{
    private int matrikelnummer;
    
    public void setMatrikelnummer(int matrikelnummer){
        if(matrikelnummer > 0)
           this.matrikelnummer = matrikelnummer;
    }
    public int getMatrikelnummer(){
        return this.matrikelnummer;
    }
    
    public Student(String name, String vorname, int matrikelnummer){
        super(name, vorname);
        this.setMatrikelnummer(matrikelnummer);
    }
    public Student(){
        this("N.N", "N.N", 0);
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName()).append(" ").append(this.getVorname()).append(" ").append(this.matrikelnummer);
        return sb.toString();
    }
    
    
    public static Student[] search(Student[]f, String pattern){
        int count = 0;
        for (Student f1 : f) {
            if (f1.getName().contains(pattern)) {
                count++;
            }
        }
        Student[] ret = new Student[count];
        for(int j=0;j<count;j++)
            for (Student f1 : f) {
                if (f1.getName().contains(pattern)) {
                    ret[j] = new Student(f1.getName(), f1.getVorname(), f1.getMatrikelnummer());
                }
            }
        return ret;
    }
    
    public static void main(String []args) {
        Student s1 = new Student("Huber", "Karl", 123456);
        System.out.println( s1 ); // Ausgabe: "Huber Karl, 123456"
        
        
        String[] vn = {"Alfred", "Bernd", "Carola", "Dieter", "Erich", "Gerda", "Hans", "Jochen", "Karin", "Maike"};
        String[] nn = {"Adler", "Baron", "Claus", "Dimov", "Eliot", "Gatti", "Heine","Jahn", "Kozak", "Miller"};
        int [] mn = {12345, 45671, 23456, 11111, 45667, 98712, 23456, 65123, 12634, 22222 };
        
        Student[] students = new Student[vn.length];
        for(int i = 0;i < vn.length; i++)
            students[i] = new Student(vn[i], nn[i], mn[i]);
        
        Student[] a = search(students, "a");
        
        
    }
}
