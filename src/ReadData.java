import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadData {
    public List<List<String>> render(String filePath) {
        try {
            List<List<String>> data = new ArrayList<>();
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8));

            String line = br.readLine();
            while (line != null) {
                List<String> lineData = Arrays.asList(line.split("\t"));
                data.add(lineData);
                line = br.readLine();
            }
            return data;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
