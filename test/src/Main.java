//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("d:\\example\\writeFile.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        BufferedReader br = new BufferedReader(new FileReader(file));
        bw.write("안녕하세요");
        bw.write("\nsssssss");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        bw.close();
        String str;
        System.out.println("11111111111111");
        while ((str = br.readLine()) != null) {
//            System.out.println(str);
            System.out.println("sdfsdfdsfdsfd");
            if (str.equals(name)) {
                System.out.println(name);
            }
        }
        System.out.println("22222222222222");
        bw.close();
        String string = br.readLine();
//        System.out.println(string + " 길이 " + string.length());
    }
}