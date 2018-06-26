package Practice6.entity;

import java.util.Arrays;

public class Beer {

    private String name;
    private String type;
    private boolean al;
    private String manufacturer;
    private Ingredient[] ingredients;
    private String transparency;
    private boolean filter;
    private String nutritionalValue;
    private Spill spill;

    Beer(String name, String type, boolean al, String manufacturer, Ingredient[] ingredients,
         String transparency, boolean filter, String nutritionalValue, Spill spill) {
        this.name = name;
        this.type = type;
        this.al = al;
        this.manufacturer = manufacturer;
        this.ingredients = ingredients;
        this.transparency = transparency;
        this.filter = filter;
        this.nutritionalValue = nutritionalValue;
        this.spill = spill;
    }

    Beer(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isAl() {
        return al;
    }

    public void setAl(boolean al) {
        this.al = al;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Ingredient[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredient[] ingredients) {
        this.ingredients = ingredients;
    }

    public String getTransparency() {
        return transparency;
    }

    public void setTransparency(String transparency) {
        this.transparency = transparency;
    }

    public boolean isFilter() {
        return filter;
    }

    public void setFilter(boolean filter) {
        this.filter = filter;
    }

    public String getNutritionalValue() {
        return nutritionalValue;
    }

    public void setNutritionalValue(String nutritionalValue) {
        this.nutritionalValue = nutritionalValue;
    }

    public Spill getSpill() {
        return spill;
    }

    public void setSpill(Spill spill) {
        this.spill = spill;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", al=" + al +
                ", manufacturer='" + manufacturer + '\'' +
                ", ingredients=" + Arrays.toString(ingredients) +
                ", transparency='" + transparency + '\'' +
                ", filter=" + filter +
                ", nutritionalValue='" + nutritionalValue + '\'' +
                ", spill=" + spill +
                '}';
    }
}
