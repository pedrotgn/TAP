package json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("measurements.json")) {
            Gson gson = new Gson();
            Type listType = new TypeToken<List<Measurement>>() {}.getType();
            List<Measurement> measurements = gson.fromJson(reader, listType);

            measurements.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
