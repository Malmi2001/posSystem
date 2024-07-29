public class PizzaCount {
    private int totalPizzas;

    public PizzaCount(){
       totalPizzas=0;
    }
    public void pizzaCounter(){
        totalPizzas++;
    }
    public int getTotalPizzas(){
        return totalPizzas;
    }
}
