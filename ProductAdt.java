package SaleInformationSystem;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class ProductAdt implements Product {
	
	public int IdCount = 000;
	
	Scanner s = new Scanner(System.in);
	
	HashMap<String, String[]> hashMap = new HashMap<>();
	
	public void insert(String itemName, String itemType, String Price, String stocks) {
		IdCount += 1;
		String currentId = String.format("%03d", IdCount);
		String[] productArr = {currentId, itemName, itemType, Price, stocks};
		hashMap.put(currentId, productArr);

	}

	public void update(String id) {
		int whileNum = 1;
		if(hashMap.containsKey(id)) {
			String[] value = hashMap.get(id);
			while(whileNum == 1) {
				System.out.println("Select the category you want to update: ");
				System.out.println(" 1) Name \n 2) Type \n 3) Price \n 4) Stocks \n 0) Exit");
				System.out.print("Choose the number: ");
				int ans = s.nextInt();
				s.nextLine();
				
				if(ans == 1) { // change name
					
					System.out.print("Enter new name: ");
					String newName = s.nextLine();
					System.out.println("Your name will change from \" " + value[1] + " \" to " + newName + ".");
					System.out.print("Do you wish to proceed? 1) Proceed 2) Cancel: ");
					int n = s.nextInt();
					s.nextLine();
					if(n == 1) {
						value[1] = newName; 
					} else {
						System.out.println("Operation aborted!");
					}
					
				} else if(ans == 2 ) { // change type
					
					System.out.print("Enter new type: ");
					String newType = s.nextLine();
					System.out.println("Your type will change from \" " + value[2] + " \" to " + newType + ".");
					System.out.print("Do you wish to proceed? 1) Proceed 2) Cancel: ");
					int n = s.nextInt();
					if(n == 1) {
						value[2] = newType; 
					} else {
						System.out.println("Operation aborted!");
					}
					
				} else if(ans == 3) { // change price
				
					System.out.print("Enter new price: ");
					String newPrice = s.nextLine();
					System.out.println("Your type will change from \" " + value[3] + " \" to " + newPrice + ".");
					System.out.print("Do you wish to proceed? 1) Proceed 2) Cancel: ");
					int n = s.nextInt();
					if (n == 1) {
						value[3] = newPrice; 
					} else {
						System.out.println("Operation aborted!");
					}
						
				} else if(ans == 4) { // change stock

					System.out.print("Enter new stocks: ");
					String newStock = s.nextLine();
					System.out.println("Your type will change from \" " + value[4] + " \" to " + newStock + ".");
					System.out.print("Do you wish to proceed? 1) Proceed 2) Cancel: ");
					int n = s.nextInt();
					if (n == 1) {
						value[4] = newStock; 
					} else {
						System.out.println("Operation aborted!");
					}
					
				} else if(ans == 0) {
					whileNum = 2;
				}
					
			}
			
		} else {
			System.out.println("Item does not exist");
		}
	
	}

	public void viewAllProducts() {
		System.out.println("=============================================");
		System.out.println("");
		UtilityFunctions.printTable(hashMap);	
		
	}

	public void delete(String id) {
		hashMap.remove(id);

	}


	public String[] search(String id) {
		
		if(hashMap.containsKey(id)) {
			String[] result = hashMap.get(id);
			return result;	
		} else {
			String[] emptyArr = null;
			return emptyArr;
		}
	
	}
	
	@Override
	public String[] searchByName(String name) {
		
		   // Extract the desired elements and store them in a new array
        String[][] newArr = new String[hashMap.size()][2];
        int index = 0;
        for (String[] value : hashMap.values()) {
            newArr[index][0] = value[1]; // Name
            newArr[index][1] = value[0]; // ID
            index++;
        }

        // Sort the new array using merge sort
        UtilityFunctions.mergeSort(newArr);


        // Perform binary search
        String targetName = name;
        int resultIndex = UtilityFunctions.binarySearch(newArr, targetName);

        // Print the search result
        if (resultIndex != -1) {
        	System.out.println("Item found !!");
            return  new String[]{newArr[resultIndex][0], newArr[resultIndex][1]};
        } else {
            System.out.println("Name '" + targetName + "' not found.");
            return null;
        }
	}

	@Override
	public void userViewProducts() {
		// TODO Auto-generated method stub
		UtilityFunctions.printTableForUserView(hashMap);	
		
	}

	@Override
	public void userBuyProduct() {
	
		try {
			UtilityFunctions.printTableForUserView(hashMap);
			System.out.println("Choose the item you want to buy by entering its number !");
			System.out.print("Enter the number you want to buy: ");
			int num = s.nextInt();
			s.nextLine();
			String id = "00" + num ;
			String[] value = hashMap.get(id);
			
			int currentStock = Integer.parseInt(value[4]);
			int newStock = currentStock - 1;
			
			value[4] = Integer.toString(newStock);
			
			System.out.println("Buy out completed");
		} catch(Exception e) {
			if(e.getMessage().equals("Cannot load from object array because \"value\" is null")) {
				System.out.println("You cannot choose the number that does not exist.");
			} else {
				System.out.println(e.getMessage());
			}
		}

	}



}
