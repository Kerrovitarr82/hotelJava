package third;

public class Main {
    public static void main(String[] args) {
        CarAssemblyLine carAssemblyLine = new CarAssemblyLine();
        Car car = new Car();
        carAssemblyLine.assembleProduct(car);
        System.out.println(car);
    }
}
