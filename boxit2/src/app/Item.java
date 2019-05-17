package app;

import javafx.scene.image.Image;

import java.io.File;

public class Item {

    private String id;
    private String name;
    private String palette;
    private String category;
    private double price;
    private int popularity;
    private int x;
    private int y;
    private Image image;
    private Image alt_image;

    public Item(String id, String name, String palette, String category, double price, int popularity, int x, int y) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.palette = palette;
        this.category = category;
        this.price = price;
        this.popularity = popularity;
        this.id = id;
        //this.image = new Image("app/assets/inventory/" + id + ".png");
        // app/assets/inventory/AA11C19.png
        //getClass().getResource("za.jpg").toExternalForm()
        //this.image = new Image(getClass().getResource("./src/app/assets/inventory/" + id + ".png").toExternalForm());
        //this.alt_image = new Image(getClass().getResource("./src/app/assets/alts/" + id + ".png").toExternalForm());
        this.image = new Image(new File("./src/app/assets/inventory/" + id + ".png").toURI().toString());
        this.alt_image = new Image(new File("./src/app/assets/alts/" + id + ".png").toURI().toString());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Image getAlt_image() {
        return alt_image;
    }

    public void setAlt_image(Image alt_image) {
        this.alt_image = alt_image;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
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
