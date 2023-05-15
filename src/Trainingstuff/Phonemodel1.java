package Trainingstuff;

public enum Phonemodel1{
    LG("LG",5588),
    PIXEL("PIXEL",6666),
    HUAWEI("HUAWEI",8888),
    SAMSUNG("SAMSUNG",9399),
    IPHONE("IPHONE",9999);


    private final String name;
    private final int price;
    private Phonemodel1(String name,int price){
        this.name=name;
        this.price=price;
    }
    public int getPrice(){
        return price;
    }

}
