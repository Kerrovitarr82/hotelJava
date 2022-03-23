package third;

public abstract class Part implements IProductPart {
    private String name;

    public Part(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
