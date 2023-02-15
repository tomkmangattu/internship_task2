package zohointership;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2 {
	static List<Browser> browserList = new ArrayList<Browser>();
	

	
	static void showLine() {
		System.out.println("*********************");
	}
	
	static boolean checkIsListEmpty() {
		if(browserList.isEmpty()) {
			System.out.println("Browser's list is empty");
			return true;
		}
		return false;
	}
	
	static void showMainMenu() {
		
		  
		showLine();
		System.out.println("Main Menu");
		System.out.println("1. Show all Browsers");
		System.out.println("2. Add new Browser");
		System.out.println("3. Remove a Browser");
		System.out.println("4. Browser History");
		System.out.println("5. Exit");
		showLine();
		System.out.println("\nEnter your choice");
		
		
	}
	
	static void showAllBrowsers() {
		showLine();
		if(!checkIsListEmpty()) {
			System.out.println("\nDisplaying browsers");
			for (int idx = 0; idx < browserList.size(); idx ++) {
				System.out.println("\n" + (idx + 1) + ". ");
				browserList.get(idx).show();
			}
		}	
	}
	
	static void addBrowsers(Scanner scanner) {
		showLine();
		System.out.println("How many number of browsers do you want to add :");
		int input = scanner.nextInt();
		scanner.nextLine();
		
		for (int idx = 0; idx < input; idx++) {
			System.out.println("Enter Browser " + (idx + 1) + " name : ");
			String name = scanner.nextLine();
			
			System.out.println("Enter browser version : ");
			String version = scanner.nextLine();
			
			System.out.println("How many history urls do you want to add : ");
			int histNo = scanner.nextInt();
			scanner.nextLine();
			
			Browser newBrowser = new Browser(name, version);
			
			if(histNo > 0) {
			
				for(int urlIdx = 0; urlIdx < histNo; urlIdx ++) {
					System.out.println("Enter url " + (urlIdx + 1) + " : ");
					String url = scanner.nextLine();
					newBrowser.addUrl(url);
				}
			}
			
			browserList.add(newBrowser);
			
			
		}
		
	}
	
	static void showAllBrowsers(String request) {
		showLine();
		
		for(int idx = 0; idx < browserList.size(); idx++) {
			String name = browserList.get(idx).getName();
			System.out.println((idx+1) + ". " + name);
		}
		System.out.println(request);
		
	}
	
	static void removeBrowser(Scanner scanner) {
		if(!checkIsListEmpty()) {
			showAllBrowsers("Select a browser to remove");
			int input = scanner.nextInt();
			scanner.nextLine();
			int idx = input -1;
			
			browserList.remove(idx);
		}
		
	}
	
	static void addBrowserHistory(Scanner scanner, int index) {
		System.out.println("How many urls do you want to add :");
		int input = scanner.nextInt();
		scanner.nextLine();
		
		for(int idx = 0; idx < input; idx ++) {
			System.out.println("Enter url " + (idx + 1));
			String url = scanner.nextLine();
			browserList.get(index).addUrl(url);
		}
	}
	
	static void removeHistory(Scanner scanner, int index) {
		System.out.println("Select a url to delete :");
		browserList.get(index).showHistory();
		int input = scanner.nextInt();
		scanner.nextLine();
		
		browserList.get(index).deleteUrl(input - 1);
	}
	
	static void resetHistory(int index) {
		browserList.get(index).resetHistory();
	}
	
	static void browserHistory(Scanner scanner) {
		showLine();
		if(!checkIsListEmpty()) {
			showAllBrowsers("Select a browser");
			int input = scanner.nextInt();
			scanner.nextLine();
			
			int idx = input - 1;
			
			
			showLine();
			
			System.out.println("1.Add new history entry");
			System.out.println("2.Remove a history Entry");
			System.out.println("3.Reset history");
			
			input = scanner.nextInt();
			scanner.nextLine();
			
			switch(input) {
			case 1 : addBrowserHistory(scanner, idx);
				break;
			case 2: removeHistory(scanner, idx);
				break;
			case 3: resetHistory(idx);
					break;
			default : System.out.println("Your choice should be between 1 and 3");
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int input = 0;
		while(input != 5) {
			showMainMenu();
			input = scanner.nextInt();
			
			switch(input) {
			case 1 : showAllBrowsers();
				break;
			case 2 : addBrowsers(scanner);
				break;
			case 3: removeBrowser(scanner);
				break;
			case 4: browserHistory(scanner);
				break;
				
			default : System.out.println("Your Choice should be between 1 and 5");
			}
		}
		scanner.close();
	}
}


