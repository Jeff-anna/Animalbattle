package Trainingstuff;

public class Skill {
    public enum Type {Attack, Heal}

    private String name;
    private Type type;
    private int power;
    private int PP;
    private int maxPP;



    public Skill(String name, Type type, int power, int PP) {
        this.name = name;
        this.type = type;
        this.power = power;
        this.PP = PP;
        this.maxPP=PP;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public int getPower() {
        return power;
    }

    public int getPP() {
        return this.PP;
    }

    public int getMaxPP() {
        return maxPP;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setPP(int PP) {
        if(PP<0){
            this.PP=0;
        }else if(PP>maxPP){
            this.PP=maxPP;
        }else{
            this.PP = PP;
        }
    }

    public void setMaxPP(int maxPP) {
        this.maxPP=maxPP;
    }
    public String toStirng(){
        return (""+PP);
    }
}
