package Practice6.entity;

public class NonAlcBeer extends Beer {

    public NonAlcBeer(String name, String type, boolean al, String manufacturer, Ingredient[] ingredients,
                      String transparency, boolean filter, String nutritionalValue, Spill spill) {
        super(name, type, al, manufacturer, ingredients, transparency, filter, nutritionalValue, spill);
    }

    public NonAlcBeer(){}

}
