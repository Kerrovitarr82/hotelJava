package third;

public class CreateSecondPart implements ILineStep{

    @Override
    public IProductPart buildProductPart() {
        System.out.println("Шасси были созданы");
        return new Chassis("шасси");
    }
}
