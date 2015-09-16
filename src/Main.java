import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("y")));
		BufferedReader br2 = new BufferedReader(new FileReader(new File("pig_header")));
		BufferedReader coefReader = new BufferedReader(new FileReader(new File("Amazon_Keyword.csv")));
		String features = br.readLine();
		String schemaLine = br2.readLine();
		
		String[] values = features.split("\\t");
		String[] splits = schemaLine.split("\\t");
		
		System.out.println(values.length);
		
		int i = 0;
		for(String value : values) {
			//if(value.equals("")) {
				System.out.println(value + "-->" + splits[i]);
			//}
			i++;
		}

		
		br2.close();
		br.close();
	}

}
