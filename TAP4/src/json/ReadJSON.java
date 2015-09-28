package json;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

/**
 * Created by pedro on 26/09/15.
 */
public class ReadJSON {

    public static void main(String[] args) throws Exception{

        JSONParser parser = new JSONParser();
        FileReader f = new FileReader("sample.json");
        Object obj = parser.parse(f);
        JSONObject json = (JSONObject)obj;
        System.out.println(json.get("firstName"));
        JSONObject json2 = (JSONObject)json.get("address");
        System.out.println(json2);




    }
}