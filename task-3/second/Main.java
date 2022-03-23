package second;

public class Main {
    public static void main(String[] args) {
        Flower rose = new Rose();
        Flower tulip = new Tulip();
        Flower narcissus = new Narcissus();
        Flower[] bouquet = {rose, tulip, narcissus, rose, rose};
        int sum = 0;
        System.out.println("В букет входят: \n");
        for (Flower flower: bouquet){
            sum += flower.getPrice();
            System.out.println(flower);
        }

        System.out.println("\nСтоимость букета: " + sum);
    }
}
