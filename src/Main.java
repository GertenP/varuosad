import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<String>> data = new ReadData().render("C:\\Users\\50708122221\\IdeaProjects\\varuosad\\src\\data\\LE.txt");
        System.out.println(data);
        List<List<String>> cleanedData = new ArrayList<>();
        for (List<String> row : data) {
            List<String> cleanedRow = new ArrayList<>();
            for (String value : row) {
                cleanedRow.add(value.replace("\"", ""));
            }
            cleanedData.add(cleanedRow);
        }

        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter("C:\\Users\\50708122221\\IdeaProjects\\varuosad\\src\\output.json", StandardCharsets.UTF_8)) {
            gson.toJson(cleanedData, writer);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
