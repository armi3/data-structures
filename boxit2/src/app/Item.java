package app;

public class Item {
    private int[] xy;
    private String name;
    private String palette;
    private String category;
    private double price;
    private int popularity;

    public Item(int[] xy, String name, String palette, String category, double price, int popularity) {
        this.xy = xy;
        this.name = name;
        this.palette = palette;
        this.category = category;
        this.price = price;
        this.popularity = popularity;
    }

    public int[] getXy() {
        return xy;
    }

    public void setXy(int[] xy) {
        this.xy = xy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPalette() {
        return palette;
    }

    public void setPalette(String palette) {
        this.palette = palette;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }
}
