import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public List<Integer> readFile(String filePath) {
        List<Integer> numbers = new ArrayList<>();
        try {
            File file = new File(filePath);
            if(!file.exists()) {
                throw new FileNotFoundException();
            }
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
            br.close();
        } catch (Exception e) {
            System.err.println("File không tồn tại hoặc nội dung có lỗi");
        }
        return numbers;
    }

    public void writeFile(String filePath, int max) {
        try {
            FileWriter fw = new FileWriter(filePath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Giá trị lớn nhất là: " + max);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int findMax (List<Integer> numbers) {
        int max = numbers.get(0);
        for (int e : numbers) {
            if (max < e) {
                max = e;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ReadAndWriteFile f = new ReadAndWriteFile();
        List<Integer> numbers = f.readFile("numbers.txt");
        int maxValue = findMax(numbers);
        f.writeFile("result.txt", maxValue);
    }
}
