package third;

public class CreateFirstPart implements ILineStep{
    @Override
    public IProductPart buildProductPart() {
        System.out.println("Кузов был создан");
        return new Body("кузов");
    }
}
