package Trainingstuff;
import  java.lang.Math;

public class Cone extends GraphicObject {
    private ObjectColor color;
    private double radius;
    private double length; //for all test data, the length is larger than radius

    public Cone(ObjectColor color ,double radius, double length) {
        this.radius = radius;
        this.length = length;
        this.color=color;
    }

    public String toString(){
        return(String.format("Cone: r=%.2f, l=%.2f",radius ,length));
    }

    @Override
    public double surfaceMeanSize() {
        double area;
        area=Math.PI*Math.pow(radius,2)+Math.PI*radius*length;
        return area;
    }


    @Override
    public double volume() {
        double volume;
        volume=(1.00/3.00)*Math.PI*Math.pow(radius,2)*Math.sqrt(Math.pow(length,2)-Math.pow(radius,2));
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

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
}