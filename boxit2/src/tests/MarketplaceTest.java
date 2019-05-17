package tests;

import app.Marketplace;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MarketplaceTest {

    @Test
    public void testBuildMold() {
        Marketplace m = new Marketplace();
        String[] emfSeed = {"MM51F94", "WD22R83", "IV45Y29", "XI41S33", "OE67K77"};
        Assert.assertEquals(m.buildMold(emfSeed, true).getItems()[0].getId(), "MM51F94");
    }

    @Test
    public void testFindAlts() {
        Marketplace m = new Marketplace();
    }

    @Test
    public void testLinearSearch() {
        Marketplace m = new Marketplace();
    }
}