package biz.no_ip.druidamortis.Labs;


public class Rectangle {
    private double length;
    private double width;
    
    public void setLength(double a){
        if(a > 1.0 && a < 20.0){
            this.length = a;
        }
        else{
            if(a > 20.0)
                this.length = 20.0;
            if(a < 1.0)
                this.length = 1.0;
        }
    }
    
    public void setWidth(double a){
        if(a > 1.0 && a < 20.0){
            this.width = a;
        }
        else{
            if(a > 20.0)
                this.width = 20.0;
            if(a < 1.0)
                this.width = 1.0;
        }
    }
    
    public Rectangle(double a, double b){
        this.setWidth(a);
        this.setLength(b);
    }
    
    public Rectangle(){
        this(1.0, 1.0);
    }
    public double area(){
        return this.width * this.length;
    }
    
    public double perimeter(){
        return 2 * this.width + 2 * this.length;
    }
    
    public double getWidth(){
        return this.width;
    }
    
    public double getLength(){
        return this.length;
    }
}
