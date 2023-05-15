package Trainingstuff;

public class Sphere extends GraphicObject {
    private ObjectColor color;
    private double radius;


    public Sphere(ObjectColor color,double radius) {
        this.radius = radius;
        this.color = color;
    }

    public String toString(){
        return(String.format("Sphere: r=%.2f",radius));
    }

    @Override
    public double surfaceMeanSize() {
        double area;
        area=4.00*Math.PI*Math.pow(radius,2);
        return area;
    }

    @Override
    public double volume() {
        double volume;
        volume=(4.00/3.00)*Math.PI*Math.pow(radius,3);
        return volume;
    }

    public ObjectColor getColor() {
        return color;
    }

    public void setColor(ObjectColor color) {
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
