package Practice6.entity;

public class AlcBeer extends Beer {

    private String turnover;

    public AlcBeer(String name, String type, boolean al, String manufacturer, Ingredient[] ingredients,
                   String transparency, boolean filter, String nutritionalValue, Spill spill, String turnover) {
        super(name, type, al, manufacturer, ingredients, transparency, filter, nutritionalValue, spill);
        this.turnover = turnover;
    }

    public AlcBeer(){}

    public String getTurnover() {
        return turnover;
    }

    public void setTurnover(String turnover) {
        this.turnover = turnover;
    }

    @Override
    public String toString() {
        return "AlcBeer{" +
                "turnover='" + turnover + '\''
                +super.toString()+
                '}';
    }
}
