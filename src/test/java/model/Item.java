package model;

public class Item {
    private String name;
    private String price;
    private String uri;

    public Item(String name,String price,String uri)
    {
        this.name=name;
        this.price=price;
        this.uri=uri;
    }

    public String getName(){return name;}

    public String setName(String name){return this.name=name;}
}
