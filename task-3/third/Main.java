package third;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.assembleProduct(new Builder());
        System.out.println();
    }
}
