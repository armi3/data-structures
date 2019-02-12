package Model;

public class Catalog implements CatalogInterface {
	private String[][] products;

	/**
	 * @param products
	 */
	public Catalog() {
		super();
		this.products = new String [0][3];
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
