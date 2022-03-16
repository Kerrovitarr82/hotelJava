package third;

public class CarAssemblyLine implements IAssemblyLine {

    @Override
    public IProduct assembleProduct(IProduct iProduct) {
        Part body = (Body) new CreateFirstPart().buildProductPart();
        iProduct.installFirstPart(body);

        Part chassis = (Chassis) new CreateSecondPart().buildProductPart();
        iProduct.installSecondPart(chassis);

        Part engine = (Engine) new CreateThirdPart().buildProductPart();
        iProduct.installThirdPart(engine);

        Car car = new Car(body, chassis, engine);
        System.out.println("Машина собрана");

        return car;
    }
}
