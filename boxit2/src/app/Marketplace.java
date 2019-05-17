package app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Marketplace {
    private Item[] inventory;
    private Box[] molds;
    private Box[] savedBoxes;
    private Box wip;
    //private String[] palettes;
    //private String[] categories;

    public Marketplace() {
        inventory = new Item[0];
        molds = null;
        savedBoxes = null;
        wip = new Box();
        //palettes = null;
        //categories = null;
    }

    public void uploadInventory(){
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("./src/app/assets/inventory.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print(records.toString());

        Item[] updatedInventory = new Item[0];
        for(List<String> a: records){
            Item item = new Item(a.get(0), a.get(1), a.get(2), a.get(3), Double.parseDouble(a.get(4)), Integer.parseInt(a.get(5)), Integer.parseInt(a.get(6)), Integer.parseInt(a.get(7)));

            Item[] latest = new Item[updatedInventory.length+1];
            System.arraycopy(updatedInventory, 0, latest, 0, updatedInventory.length);
            latest[updatedInventory.length] = item;
            updatedInventory = latest;
        }
        inventory = updatedInventory;
        System.out.print(inventory[48].getName());

    }

    public void buildMolds(){
        //Item[] emf = new Item[0];
        String[] emfSeed = {"MM51F94", "WD22R83", "IV45Y29", "XI41S33", "OE67K77"};
        String[] beautySeed = {"SQ36I87", "OC17I77", "SF96B32", "EZ37H86"};
        String[] zodiacSeed = {"NK60V60", "UK23H37", "BY70O82", "QT46J70", "OQ37M78"};
        molds = new Box[3];
        molds[0] = buildMold(emfSeed, true);
        molds[1] = buildMold(beautySeed, false);
        molds[2] = buildMold(zodiacSeed, true);
    }

    public Box buildMold(String[] seed, boolean curated){
        // Box(boolean curated, Item[] items, Item[][] alts)
        Item[] items = new Item[seed.length];
        Item[][] alts = new Item[seed.length][];
        int i = 0;
        for(String a: seed){
            items[i] = linearSearch(a);
            alts[i] = findAlts(items[i], curated);
            i++;
        }
        return new Box(curated, items, alts);
    }

    public Item[] findAlts(Item item, boolean curated){
        Item[] alts = Arrays.stream(inventory).filter(x -> x.getX() == item.getX()).toArray(Item[]::new);
        alts = Arrays.stream(alts).filter(x -> x.getY() == item.getY()).toArray(Item[]::new);

        if (curated){
            alts = Arrays.stream(alts).filter(x -> x.getCategory() == item.getCategory()).toArray(Item[]::new);
        }
        return alts;
    }

    public Item linearSearch(String id){
        int i =0;
        while (i<inventory.length){
            if(inventory[i].getId().equals(id)){
                return inventory[i];
            }
            i++;
        }
        return null;
    }

    //heapsort
    public void updateInventory(){

        int n = inventory.length;
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(inventory, n, i);

        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            Item temp = inventory[0];
            inventory[0] = inventory[i];
            inventory[i] = temp;

            // call max heapify on the reduced heap
            heapify(inventory, i, 0);
        }

        System.out.print("-"+inventory[0].getName());
        System.out.print("-"+inventory[1].getName());
        System.out.print("-"+inventory[2].getName());
        System.out.print("-"+inventory[48].getName());

    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    private void heapify(Item[] arr, int n, int i) {
        int largest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l].getPopularity() < arr[largest].getPopularity())
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r].getPopularity() < arr[largest].getPopularity())
            largest = r;

        // If largest is not root
        if (largest != i)
        {
            Item swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }

    }

    public void saveBox(String name){
        Box[] updatedSaved = new Box[savedBoxes.length+1];
        wip.setName(name);
        System.arraycopy(savedBoxes, 0, updatedSaved, 0, savedBoxes.length);
        updatedSaved[savedBoxes.length] = wip;
        savedBoxes = updatedSaved;
    }

    public Box boxIt(String palette, String[] categories){
        return wip;
    }

    public Box[] getMolds() {
        return molds;
    }

    public void setMolds(Box[] molds) {
        this.molds = molds;
    }

    public Box[] getSavedBoxes() {
        return savedBoxes;
    }

    public void setSavedBoxes(Box[] savedBoxes) {
        this.savedBoxes = savedBoxes;
    }

    public Box getWip() {
        return wip;
    }

    public void setWip(Box wip) {
        this.wip = wip;
    }
}
