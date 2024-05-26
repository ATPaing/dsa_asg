package SaleInformationSystem;

import java.util.Scanner;


public class Main {
	
	static Scanner s = new Scanner(System.in);
	static int res = 200;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
			
			Product pdt = new ProductAdt();
			
			// insert demo data
			pdt.insert("mango", "Fruit", "350", "99");
			pdt.insert("apple", "Fruit", "150", "60");
			pdt.insert("carrot", "Vegetables", "200", "70");
			pdt.insert("cabbage", "Vegetables", "700", "39");
			pdt.insert("noodle", "food", "1000", "45");
			
			int role = UtilityFunctions.ChooseRole();
			while(res == 200) {
			if(role == 1) {
				
				
					
					int userInputNum = UtilityFunctions.ChooseAdminProcess();
					
					if(userInputNum == 0) {
//						terminateTheProcess(userInputNum);
						role = UtilityFunctions.ChooseRole();
					}
					
					while(userInputNum < 0 || userInputNum > 5) {
						System.out.println("==========================================");
						System.out.println("Please choose the number between 0 and 5");
						userInputNum = UtilityFunctions.ChooseAdminProcess();
						
						if(userInputNum == 0) {
//							terminateTheProcess(userInputNum);
							role = UtilityFunctions.ChooseRole();
						}
						
					}
					
					if(userInputNum == 1) {
						
						String name, type, price, stocks;
						
						System.out.println("=============================================");
						System.out.print("Please enter the product name: ");
						name = s.nextLine();
						System.out.println("");
						
						System.out.print("Please enter the type name: ");
						type = s.nextLine();
						System.out.println("");
						
						System.out.print("Please enter the price : ");
						price = s.nextLine();
						System.out.println("");
						
						System.out.print("Please enter the stocks: ");
						stocks = s.nextLine();
						System.out.println("");
						
						pdt.insert(name, type, price, stocks);
						
						System.out.println("Product successfully inserted!");
						System.out.println("");

					} else if(userInputNum == 2) {

						System.out.print("Add id of an item you want to search: ");
						String id = s.nextLine();
						
						String[] result = pdt.search(id);
						
						if(result != null) {
							System.out.println("Item id: " + result[0]);
							System.out.println("Item name: " + result[1]);
							System.out.println("Item type: " + result[2]);
							System.out.println("Item price: " + result[3]);
							System.out.println("Item stocks: " + result[4]);
						} else {
							System.out.println("Id does not exist");
						}
						
						System.out.print("Type any key to exist: ");
						s.nextLine();

						
					} else if(userInputNum == 3) {

						pdt.viewAllProducts();
						System.out.println("");
						
					} else if(userInputNum == 4) {
						
						System.out.print("Enter the item Id you want to update: ");
						String id = s.nextLine();
						
						pdt.update(id);
						
					} else if(userInputNum == 5) {
						
						System.out.print("Enter the item Id you want to delete: ");
						String id = s.nextLine();
						
						System.out.print("Are you sure you want to delete the item: \" " + id + " \"? (y/n): ");
						String confirmation = s.nextLine();
						
						if(confirmation.equalsIgnoreCase("y")) {
							pdt.delete(id);
							System.out.println("Successfully deleted");
						} else {
							System.out.println("Operation aborted !");
						}
										
					}
				

			} else if (role == 2) {
				
//				while(res == 200) {
					int userInputNum = UtilityFunctions.ChooseUserProcess();
					
					if(userInputNum == 0) {
//						terminateTheProcess(userInputNum);
						role = UtilityFunctions.ChooseRole();
					}
					
					while(userInputNum < 0 || userInputNum > 3) {
						System.out.println("==========================================");
						System.out.println("Please choose the number between 0 and 3");
						userInputNum = UtilityFunctions.ChooseUserProcess();
						
						if(userInputNum == 0) {
//							terminateTheProcess(userInputNum);
							role = UtilityFunctions.ChooseRole();
						}
						
					}
					
					if(userInputNum == 1) {
						
						pdt.userViewProducts();
						
					} else if(userInputNum == 2) {
						
						pdt.userBuyProduct();
						
					} else if(userInputNum == 3) {
						System.out.print("Please enter the item you want to search: ");
						String name = s.nextLine();
						System.out.println("");
						String[] res = pdt.searchByName(name);
						if(res == null) {
							System.out.println("Sorry, the item does not exist.");
						} else {
							String[] result = pdt.search(res[1]);
							if(result != null) {
								System.out.println("Item name: " + result[1]);
								System.out.println("Item type: " + result[2]);
								System.out.println("Item price: " + result[3]);
							} else {
								System.out.println("Id does not exist");
							}
						}
					}
//				}
				
			}
		}
			
		} catch(Exception e) {
			System.out.println("Unexpected error occur. Program terminated. Bye Bye !");
			
		}
		


		
	}
	
	public static void terminateTheProcess(int num) {
		if(num == 0) {
			System.out.println("======================================");
			System.out.println("System terminated. Have a nice day !");
			System.exit(0);
		}
	}

}
