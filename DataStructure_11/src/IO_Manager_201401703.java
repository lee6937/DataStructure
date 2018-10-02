import java.io.*;
import java.nio.file.Paths;

public class IO_Manager_201401703 {
    BufferedReader br;

    String filename = Paths.get("C:\\Users\\dkfma\\Desktop\\Random", "1000000.txt").toString();//파일 읽어오기
    StringBuffer sb;


    String readData() {
        try {
            br = new BufferedReader(new FileReader(filename));
            sb = new StringBuffer();
            int i;
            while ((i = br.read()) != -1) {
                sb.append((char)i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}




