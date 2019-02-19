package vn.codegym.model;

public class Product {
    private int code;
    private String name;
    private float price;
    private String madein;

    public Product() {
    }

    public Product(int code, String name, float price, String madein) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.madein = madein;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getMadein() {
        return madein;
    }

    public void setMadein(String madein) {
        this.madein = madein;
    }
}
