package third;

public class Car implements IAssemblyLine {

    @Override
    public IProduct assembleProduct(IProduct iProduct) {
        Body body = (Body) new CreateFirstPart().buildProductPart();
        iProduct.installFirstPart(body);

        Chassis chassis = (Chassis) new CreateSecondPart().buildProductPart();
        iProduct.installSecondPart(chassis);

        Engine engine = (Engine) new CreateThirdPart().buildProductPart();
        iProduct.installThirdPart(engine);

        Builder builder = new Builder(body, chassis, engine);
        System.out.println("Машина собрана");

        return builder;
    }
}
