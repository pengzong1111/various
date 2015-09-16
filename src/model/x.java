package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class x {

	public static void main(String[] args) throws IOException {
		File[] step1Models = new File("models/dra_bin_models").listFiles();
		
		String splits[] = readValues(new File("models/dra_bin_models/DRA1.csv")).split(",");;
		for(File step1Model : step1Models) {
			if(step1Model.isFile()) {
				String[] headers = readValues(step1Model).split(",");
				for(int i=0; i<headers.length; i++) {
					System.out.print( headers[i].equals(splits[i]) + "\t");
				}
				System.out.println();
			}
		}

	}

	private static String readHeader(File step1Model) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(step1Model)));

		String headerLine = br.readLine();
		br.close();
		return headerLine;
	}

	private static String readValues(File step1Model) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(step1Model)));
		br.readLine();
		String headerLine = br.readLine();
		br.close();
		return headerLine;
	}
}
