package tests;

import app.Item;
import app.Marketplace;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MarketplaceTest {

    @Test
    public void testBuildMold() {
        Marketplace m = new Marketplace();
        Item item1 = new Item("SQ36I87", "Cucumber mask", "cold", "beauty", 15, 4, 5, 5);
        Item item2 = new Item("AA11C19", "Pomegranate mask", "warm", "beauty", 15, 2, 5, 5);
        Item item3 = new Item("UI91G86", "Blueberry mask", "cold", "beauty", 15, 3, 5, 5);
        Item item4 = new Item("OC17I77", "Kawaii cosmetic bag", "warm", "beauty", 70, 7, 3, 5);
        Item item5 = new Item("NK60V60", "Pisces Moleskine", "neutral", "zodiac", 300, 11, 4, 5);
        Item[] inventory = {item1, item2, item3, item4, item5};
        String[] seed = {"SQ36I87", "OC17I77"};
        Assert.assertEquals(m.buildMold(seed, true, inventory).getItems()[0].getId(), "SQ36I87");
    }

    @Test
    public void testFindAlts() {
        Marketplace m = new Marketplace();
        Item item1 = new Item("SQ36I87", "Cucumber mask", "cold", "beauty", 15, 4, 5, 5);
        Item item2 = new Item("AA11C19", "Pomegranate mask", "warm", "beauty", 15, 2, 5, 5);
        Item item3 = new Item("UI91G86", "Blueberry mask", "cold", "beauty", 15, 3, 5, 5);
        Item item4 = new Item("OC17I77", "Kawaii cosmetic bag", "warm", "beauty", 70, 7, 3, 5);
        Item item5 = new Item("NK60V60", "Pisces Moleskine", "neutral", "zodiac", 300, 11, 4, 5);
        Item[] inventory = {item1, item2, item3, item4, item5};
        Item[] altsCucumber = m.findAlts(item1, false, inventory);
        Assert.assertEquals(altsCucumber.length, 3);
    }

    @Test
    public void testLinearSearch() {
        Marketplace m = new Marketplace();
        Item item1 = new Item("SQ36I87", "Cucumber mask", "cold", "beauty", 15, 4, 5, 5);
        Item item2 = new Item("AA11C19", "Pomegranate mask", "warm", "beauty", 15, 2, 5, 5);
        Item item3 = new Item("UI91G86", "Blueberry mask", "cold", "beauty", 15, 3, 5, 5);
        Item item4 = new Item("OC17I77", "Kawaii cosmetic bag", "warm", "beauty", 70, 7, 3, 5);
        Item item5 = new Item("NK60V60", "Pisces Moleskine", "neutral", "zodiac", 300, 11, 4, 5);
        Item[] inventory = {item1, item2, item3, item4, item5};
        Assert.assertEquals(m.linearSearch("UI91G86", inventory).getId(), "UI91G86");
    }
}