package Trainingstuff;

import java.util.ArrayList;

public class Pokemon {
    private String name;
    private int HP;
    private int maxHP;
    private int attack;
    private int speed;
    private ArrayList<Skill> skills=new ArrayList<>(1);
    public Pokemon(String name,int maxHP,int attack,int speed,Skill...skills){
        this.attack=attack;
        this.HP=maxHP;
        this.name=name;
        this.maxHP=maxHP;
        this.speed=speed;
        for(Skill a:skills){
            a.setMaxPP(a.getMaxPP());
            a.setPP(a.getMaxPP());
            Skill skill=new Skill(a.getName(),a.getType(),a.getPower(),a.getMaxPP());
            this.skills.add(skill);
        }
    }
    public boolean isAlive(){
        return this.HP>0;
    }

    public void useSkillTo(Pokemon target,Skill skill){
        if(skill.getPP()>0){
            if(skill.getType()== Skill.Type.Attack){
                target.setHP(target.getHP()-skill.getPower()*attack);
            }
            if(skill.getType()== Skill.Type.Heal){
                target.setHP(target.getHP()+ skill.getPower());
            }
        }
    }
    public String toString(){
        String b;
        b=(this.name+":"+" "+this.HP+"/"+this.maxHP);
        return b;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHP() {
        return this.HP;
    }

    public void setHP(int HP) {
        if(HP>this.maxHP){
            this.HP=this.maxHP;
        }else if(HP<0){
            this.HP=0;
        }else{
            this.HP = HP;
        }
    }

    public int getMaxHP() {
        return this.maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getAttack() {
        return this.attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public ArrayList<Skill> getSkills() {
        return this.skills;
    }

    public void setSkills(ArrayList<Skill> skills) {
        this.skills = skills;
    }
}
