package Model;

public class Catalog implements CatalogInterface {
	private String[][] products;
	private final static String[][] demoCatalog = {
			{"759552413", "HORCHATA 10ML", "10" },
			{"857452894", "COLD BREW 15ML", "20"},
			{"089677354", "CHAMPURRADAS 6PACK", "15"},
			{"123520065", "QUESO SUIZO 2PACK", "30"},
			{"985867632", "OREO 24PACK", "40"},
			{"876567874", "CHICLE CLORETS", "3"},
			{"999743733", "SHAMPOO VALUE SIZE", "30"},
			{"777362837", "CD N*SYNC LIVE", "100"},
			{"544772525", "MATCHA TEA 300MG", "200"},
			{"276936947", "TOALLA ALGODON MEDIANA", "40"},
			{"343232211", "REVISTA PEOPLE MARZO", "30"},
			{"453943884", "COMIDA DE GATO WHISKAS", "55"}};

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
