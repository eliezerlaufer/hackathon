package neogrid.distribution.enums;

public enum ProductType {
	FOOD("Alimento"), 
	ELECTRONICS("Eletronico"), 
	REFRIGERATED("Refrigerado");
	
	private String productType;
	
	private ProductType(String productType) {
		this.productType = productType;
	}
	
	public static ProductType valueOfProductType(String productType) {
		for (ProductType prodType : values()) {
            if (prodType.productType.equals(productType)) {
                return prodType;
            }
        }
        return null;
	}
	
	@Override
    public String toString() {
        return this.productType;
    }
}
