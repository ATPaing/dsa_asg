package SaleInformationSystem;

public interface Product {
	public void insert(String itemName, String itemType, String Price, String stocks);
	public void update(String id);
	public void delete(String id);
	public String[] search(String id);
	public String[] searchByName(String name);
	public void viewAllProducts();
	public void userViewProducts();
	public void userBuyProduct();
	
}
