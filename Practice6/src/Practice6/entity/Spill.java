package Practice6.entity;

public class Spill {

    private String objem;
    private String material;

    public Spill(String objem, String material){
        this.objem=objem;
        this.material=material;
    }

    public String getObjem() {
        return objem;
    }

    public void setObjem(String objem) {
        this.objem = objem;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
