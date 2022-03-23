package third;

public class CreateThirdPart implements ILineStep{
    @Override
    public IProductPart buildProductPart() {
        System.out.println("Двигатель был создан");
        return new Engine("двигатель");
    }
}
