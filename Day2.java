import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day2 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("file2.txt");
		Scanner scanner = new Scanner(file);
		StringBuilder str = new StringBuilder();
		ArrayList<int[]> List = new ArrayList<int[]>();
		
		while(scanner.hasNextLine()) {
			str.append(scanner.nextLine()).append(System.lineSeparator()).append(System.lineSeparator());
		}
		
		String strReports = str.toString();
		strReports = strReports.replaceAll(System.lineSeparator(), ",").replaceAll(" ", "-");

		String[] reportArray = strReports.split(",,");
		int[][] reports = new int[reportArray.length][];
		
		
		
		for (int i = 0; i < reports.length; i++) {
			String[] tempArray = reportArray[i].split("-");
			reports[i] = new int[tempArray.length];
			
			for(int j = 0; j < tempArray.length; j++) {
				
				System.out.println("Reports I J: " + reports[i][j]);
				System.out.println("Temp J: " + tempArray[j]);
				
				reports[i][j] = Integer.parseInt(tempArray[j]);
			}
		}
		
		System.out.println(reports[1][1]);
		
		String[] reportStr = new String[reports.length];
		
//		
//		for(int i = 0; i<reports.length; i++) {
//			int tempLine = reports[i];
//			reportStr[i] = String.valueOf(tempLine);
//			String[] reportFinal = reportStr[i].split("");
//			int[] reportFinalInt = new int[reportFinal.length];
//				
//				for(int y = 0;y < reportFinal.length;y++){
//					reportFinalInt[y] = Integer.parseInt(reportFinal[y]);
//				}
//				List.add(reportFinalInt);
//		}
//		
		int total = 0;
		
		for(int i =0; i<List.size() - 1; i++) {
			for(int j=0; j<List.get(i).length - 1; j++){
				int diff = List.get(i)[j] - List.get(i)[j+1];
				if(List.get(i)[j] > List.get(i)[j+1] && diff >=1 && diff <=3) {
					total += 1;
					continue;
				} else if(List.get(i)[j] < List.get(i)[j+1]  && diff >=1 && diff <=3) {
					total += 1;
					continue;
				} else {
					System.out.println("List " + Arrays.toString(List.get(i)) + " is wrong");
					total -= 1;
				}
			}
		}
		System.out.println(total);
	}
}

//		Loop through
//		turn array to a string
//		split back into its own array
