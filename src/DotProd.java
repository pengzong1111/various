import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class DotProd {

    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("y")));
        BufferedReader br2 = new BufferedReader(new FileReader(new File("pig_header")));
        BufferedReader coefReader = new BufferedReader(new FileReader(new File("Amazon_Keyword.csv")));
        String features = br.readLine();
        String schemaLine = br2.readLine();
        
        String[] values = features.split("\\t");
        String[] splits = schemaLine.split("\\t");
        
        System.out.println(values.length);
        
        String variableLine = coefReader.readLine();
        String[] variables = variableLine.split(",");
        String variabeValueLine = coefReader.readLine();
        String[] variableValues = variabeValueLine.split(",");
        Map<String, Double> mapCoef = new HashMap<String, Double>();
        Map<String, String> mapFeature = new HashMap<String, String>();
        for(int i=0; i<variables.length; i++) {
            mapCoef.put(variables[i], Double.valueOf(variableValues[i]));
        }
        
        for(int i = 0; i<splits.length; i++) {
           // System.out.println(splits[i] + values[i]);
            if(!values[i].equals("")) {
            mapFeature.put(splits[i], values[i]);
            }
        }
        
        double result = mapCoef.get("INTERCEPT");
        for(int i=0; i<variables.length; i++) {
            String variable = variables[i];
            System.out.println(variable);
            if(variable.equals("INTERCEPT") || variable.equals("_TARGET_")) {
                continue;
            } else {
                result += mapCoef.get(variable) * Double.valueOf(mapFeature.get(variable));
            }
        }
        System.out.println("result: " + result);
        br2.close();
        br.close();
    
    }

}
