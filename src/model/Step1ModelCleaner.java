package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step1ModelCleaner {

	public static void main(String[] args) throws IOException {

		File cleanModel = new File("cleanModel.csv");
		File oldModel = new File("models/paid_social_bin_models/paid_social1.csv");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(oldModel)));

		String headerLine = br.readLine();
		String valueLine = br.readLine();
		br.close();

		String[] headers = headerLine.split(",");
		String[] values = valueLine.split(",");

		System.out.println(headers.length == values.length);
		System.out.println(headers.length);
		System.out.println(values.length);
		StringBuilder headerBuilder = new StringBuilder();
		headerBuilder.append("_TARGET_,INTERCEPT");
		
		for(String header : headers) {
			String s = header.replace("\"", "").replace("factor(", "").replace(")", "");
			if(s.contains(" ")) {
				s = s.split(" ")[0];
			} else if(s.equals("cust_purchase_segment_code1")) {
				s = "cust_purchase_segment_codeI";
			} else if(s.equals("cust_purchase_segment_code2")) {
				s = "cust_purchase_segment_codeO";
			} else if(s.equals("cust_purchase_segment_code3")) {
				s = "cust_purchase_segment_codeA";
			} else if(s.equals("cust_purchase_segment_code4")) {
				s = "cust_purchase_segment_codeH";
			} 
			
			if(!s.equals("")) {
				headerBuilder.append(',').append(s);
			}
		}
		System.out.println(headerBuilder.toString());
	}

}
