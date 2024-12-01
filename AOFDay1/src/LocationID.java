import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class LocationID {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("file.txt");
		
		try (Scanner scanner = new Scanner(file)) {
			ArrayList<Integer> List1 = new ArrayList<Integer>();
			ArrayList<Integer> List2 = new ArrayList<Integer>();
			int total = 0;
			StringBuilder listBuild = new StringBuilder();
			
			while(scanner.hasNextLine()) {
				listBuild.append(scanner.nextLine()).append(System.lineSeparator());
			}
			String list = listBuild.toString();
			System.out.println(list);
			
			String[] arrayList = list.split("\\s+");
			int[] intList = new int[arrayList.length];
			
			for(int i = 0;i < arrayList.length;i++){
				intList[i] = Integer.parseInt(arrayList[i]);
			}
			
			for (int i = 0; i<intList.length; i=i+2) {
				List1.add(intList[i]);
			}
			
			for (int i = 1; i<intList.length; i=i+2) {
				List2.add(intList[i]);
			}
			
			List1.sort(null);
			List2.sort(null);
			
			for(int i = 0; i<List1.size(); i++) {
				if (List1.get(i) > List2.get(i)) {
					int diff = List1.get(i) - List2.get(i);
					total += diff;
				}else if(List2.get(i) > List1.get(i)) {
					int diff = List2.get(i) - List1.get(i);
					total += diff;
				}else {
					continue;
				}
			}
			
			System.out.println("The result is: " + total);
		
		} catch (NumberFormatException e) {
			System.out.println("IDIOT");
			e.printStackTrace();
		}
		
		
		
//		Sort arrays both from smallest to largest
//		compare List1[i] to List2[i] and save the difference to a new ArrayList (could possibly just go to next step...
//		Add up total the array 
	}
}
