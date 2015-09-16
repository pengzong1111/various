import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class Step2ModelFilter {

    /**
     * set 0 to the value of the rest of fields to the given channelName 
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        String channelName = "Subsidiaries";
        int bin = 5;
        File modelFile = new File("models-latest/subsidiaries" + bin + ".csv");
        
        File cleanModelFile = new File("models-latest/step2/subsidiaries" + bin + ".csv");
        filter(modelFile, channelName, cleanModelFile);
    }

    private static void filter(File modelFile, String channelName, File cleanModelFile) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(modelFile)));
        
        String headerLine = br.readLine();
        String valueLine = br.readLine();
        br.close();
        
        String[] headers = headerLine.split(",");
        String[] values = valueLine.split(",");
        
        if(headers.length == values.length) {
            int i = 0;
            for(String header : headers) {
                if(!header.contains(channelName)) {
                    values[i] = String.valueOf(0);
                }
                i++;
            }
        }
        
        PrintWriter pw = new PrintWriter(cleanModelFile);
        
        int x = 0;
        StringBuilder valueLineBuilder = new StringBuilder(); 
        for(String value: values) {
            if(x == 0) {
                valueLineBuilder.append(value);
            } else {
                valueLineBuilder.append(',').append(value);
            }
            x++;
        }
        
        pw.println(headerLine);
        pw.println(valueLineBuilder.toString());
        pw.flush();
        pw.close();
    }

}
