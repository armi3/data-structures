package app;

import java.util.Arrays;
import java.util.Date;

public class Box {
    private boolean curated;
    private Item[] items;
    private Item[][] alts;
    private String name;
    private Date[] deliveryDates;
    private int subscription;

    public Box(boolean curated, Item[] items, Item[][] alts) {
        this.curated = curated;
        this.items = items;
        this.alts = alts;
        this.name = null;
        this.deliveryDates = null;
        this.subscription = 0;
    }

    public Box() {
    }

    public Date[] getDeliveryDates() {
        return deliveryDates;
    }

    public void setDeliveryDates(Date[] deliveryDates) {
        this.deliveryDates = deliveryDates;
    }

    public int getSubscription() {
        return subscription;
    }

    public void setSubscription(int subscription) {
        this.subscription = subscription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCurated() {
        return curated;
    }

    public void setCurated(boolean curated) {
        this.curated = curated;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public Item[][] getAlts() {
        return alts;
    }

    public void setAlts(Item[][] alts) {
        this.alts = alts;
    }


//    public void updateAlts(){
//        Item[][] updatedAlts = new Item[0][];
//        for(Item[] a: alts){
//            Item[] updatedItemAlts = new Item[0];
//            for(Item b: a){
//                if(Arrays.asList(this.categories).contains(b.getCategory()) && this.palette.equals(b.getPalette())){
//                    Item[] latest = new Item[updatedItemAlts.length];
//                    System.arraycopy(updatedItemAlts, 0, latest, 0, latest.length);
//                    updatedItemAlts = latest;
//                }
//            }
//            Item[][] latest = new Item[updatedAlts.length][];
//            System.arraycopy(updatedAlts, 0, latest, 0, latest.length);
//            updatedAlts = latest;
//        }
//        setAlts(updatedAlts);
//    }


}
