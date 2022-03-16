package third;

public class Builder implements IProduct{
    IProductPart body;
    IProductPart chassis;
    IProductPart engine;

    Builder(IProductPart body, IProductPart chassis, IProductPart engine) {
        this.body = body;
        this.chassis = chassis;
        this.engine = engine;
    }

    Builder(){}

    @Override
    public void installFirstPart(IProductPart productPart) {
        System.out.println("Кузов установлен");
    }

    @Override
    public void installSecondPart(IProductPart productPart) {
        System.out.println("Шасси установлены");
    }

    @Override
    public void installThirdPart(IProductPart productPart) {
        System.out.println("Двигатель установлен");
    }
}
