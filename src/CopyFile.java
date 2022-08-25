import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CopyFile {
    private List<Integer> readFile(String fileOut) {
        List<Integer> numbers = new ArrayList<>();
        try {
            File file = new File(fileOut);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
            br.close();
        } catch (Exception e) {
            System.err.println("File vào không tồn tại hoặc nội dung có lỗi");
        }
        return numbers;
    }

    private static void writeFile(String fileOut, String fileIn) {
        try {
            FileWriter fw = new FileWriter(fileOut, true);
            BufferedWriter bw = new BufferedWriter(fw);
            String line = "";
            FileReader fr = new FileReader(fileIn);
            BufferedReader reader = new BufferedReader(fr);
            while ((line = reader.readLine())!=null){
                bw.write("\n");
                bw.write(line);
            }
            bw.close();
        } catch (IOException e) {
            System.err.println("File ra tồn tại");
        }
    }

    public static void main(String[] args) {
        writeFile("result.txt", "numbers.txt");
    }
}
