package second;

public abstract class Flower {
    private int price;
    private String name;

    Flower(String name, int price){
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " стоимостью " + price;
    }
}
