import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    private static List<Country> readFile() {
        List<Country> list = new ArrayList<>();
        try {
            FileReader fr = new FileReader("countries.csv");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String txt[] = line.split(",");
                int id = Integer.parseInt(txt[0]);
                String code = txt[1];
                String name = txt[2];
                list.add(new Country(id, code, name));
            }
        } catch (Exception e) {
            System.err.println("Không tìm được file hoặc nội dung có lỗi");
        }
        return list;
    }
    public static void main(String[] args) {
        ReadFile rf = new ReadFile();
        List<Country> list = rf.readFile();
        for (Country c : list) {
            System.out.println(c);
        }
    }
}
