package Model;

public class Catalog implements CatalogInterface {
	private String[][] products;
	private final static String[][] demoCatalog = {
			{"7593026552413", "HORCHATA 10ML", "10" },
			{"8574522637894", "COLD BREW 15ML", "20"},
			{"0896740367354", "CHAMPURRADAS 6PACK", "15"},
			{"1235427520065", "QUESO SUIZO 2PACK", "30"},
			{"9858734667632", "OREO 24PACK", "40"},
			{"8765334567874", "CHICLE CLORETS", "3"},
			{"9928429743733", "SHAMPOO VALUE SIZE", "30"},
			{"7747567362837", "CD N*SYNC LIVE", "100"},
			{"5447746662525", "MATCHA TEA 300MG", "200"},
			{"2769278436947", "TOALLA ALGODON MEDIANA", "40"},
			{"3432543532211", "REVISTA PEOPLE MARZO", "30"},
			{"4539876543884", "COMIDA DE GATO WHISKAS", "55"}};

	/**
	 * @param products
	 */
	public Catalog() {
		super();
		this.products = demoCatalog;
	}

	/* (non-Javadoc)
	 * @see Model.CatalogInterface#getProducts()
	 */
	@Override
	public String[][] getProducts() {
		return products;
	}

	/* (non-Javadoc)
	 * @see Model.CatalogInterface#setProducts(java.lang.String[][])
	 */
	@Override
	public void setProducts(String[][] products) {
		this.products = products;
	}
	

}
