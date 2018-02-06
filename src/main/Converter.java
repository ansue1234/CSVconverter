package main;
import java.util.*;
import java.io.*;
import java.io.FileReader;

public class Converter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//This is where the path of the csv file should be, on my PC, for some reason, I can't read anything in my C: drive
		String fileName = "resources\\TestTrajectory_left.csv";
		//File f = new File("resources\\TestTrajectory_left.csv");
		List<List<String>> list = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line = br.readLine();
			String[] headers = line.split(";");
			for(String header: headers) {
				List<String> subList = new ArrayList<String>();
				subList.add(header);
				list.add(subList);
			}
			while((line = br.readLine()) != null) {
				String[] elems = line.split(";");
				for(int i = 0; i < elems.length; i++) {
					list.get(i).add(elems[i]);
				}
			}
			br.close();
		}catch(FileNotFoundException a){
			System.out.println("File not found");
		}catch (IOException a){
			System.out.println("don't know why it did not work");
		}

		int rows = list.size();
		int cols = list.get(0).size();
		String[][] array2D = new String[rows][cols];
		for(int row = 0; row < rows; row++) {
		    for(int col = 0; col < cols; col++) {
		        array2D[row][col] = list.get(row).get(col);
		    }
		}

		for(int i = 0; i<array2D.length; i++)
		{
		    for(int j = 0; j<array2D[0].length; j++)
		    {
		        System.out.println(array2D[i][j]);
		    }
		    System.out.println();
		}

	}
//		File f = new File("resources\\TestTrajectory_left.csv");
//		System.out.println(f.getAbsolutePath());
//	}
}
