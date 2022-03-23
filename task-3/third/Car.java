package third;

public class Car implements IProduct{
    Part body;
    Part chassis;
    Part engine;

    Car(){}

    @Override
    public void installFirstPart(IProductPart productPart) {
        System.out.println("Кузов установлен");
        this.body = (Part) productPart;
    }

    @Override
    public void installSecondPart(IProductPart productPart) {
        System.out.println("Шасси установлены");
        this.chassis = (Part) productPart;
    }

    @Override
    public void installThirdPart(IProductPart productPart) {
        System.out.println("Двигатель установлен");
        this.engine = (Part) productPart;
    }

    @Override
    public String toString() {
        return "Car{" +
                "body=" + body.getName() +
                ", chassis=" + chassis.getName() +
                ", engine=" + engine.getName() +
                '}';
    }
}
