import java.io.*;
import java.util.*;

public class crazyBBuyooBBuyoo {
    static Scanner in = new Scanner(System.in);

    static Random rand = new Random();
//    static File file = new File("d:\\example\\writeFile.txt");
    static File file = new File("/Users/junggkim/Desktop/myfile.txt");


    static int[][] a = new int[7][7];
    static int[][] second = new int[a.length][a[0].length];
    static int[][] third = new int[a.length][a[0].length];
    //회원 아이디별 필요 배열들
    static String[] id = new String[10];
    static String[] password = new String[10];
    static int[] coin = new int[10];
    static int[][] itemInfo = new int[10][4];

    static boolean stop = false;
    static int flag = 0;
    static int index = 0;  //로그인시 필요한 정보 인덱스 접근을 위해 선언

    public static void main(String[] args) throws IOException {

        while (!stop) {
            login();
            //startMenu();
            gameStart();
            // a -> second
//            copyArray(1);
////            item();
//            checkDuplicate();
//            downZero();
//            prtTool();
//            copyArray(2);
//            if (endGame() == 1)
//                break ;
        }
    }

    //txt파일에서 회원 아이디 찾는 메서드
    public static boolean searchIdOrPassword(String id,String pwd,boolean flag) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(file));
        //아이디만 찾을경우 flag = true  비번을 찾을경우 flag = false

        String str;
        while ((str = br.readLine()) != null) {
            String[] part = str.split(",");
            if (part[0].equals(id)) {
                if (!flag){
                    if (part[1].equals(pwd)){
                        br.close();
                        return true;
                    }
                }
                br.close();
                return false;
            }

        }
        br.close();
        return true;
    }
    public static void login() throws IOException {
        //파일 존재 여부 체크 및 생성
        if (!file.exists()){
            file.createNewFile();
         }
        BufferedReader br = new BufferedReader(new FileReader(file));
        BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));  //append모드
        //로그인 부터
        System.out.println("아이디를 입력하세요.");
        String name = in.nextLine();

        //텍스트 파일에 아이디,비밀번호,점수,코인개수,폭탄아이템개수,십자가아이템개수,선택숫자삭제아이템개수
        //id 검색 + 회원가입부분
        if (searchIdOrPassword(name,null,true)) {
            System.out.println("아이디가 없네요 해당 아이디로 회원가입을 시작하겠습니다. 비번을 입력하세요.");
            String password = in.nextLine();
            bw.write(name + "," + password + "," + ",0,0,0,0,0\n");
            System.out.println("id = " + name + " password = " + password);
            bw.close();
        }else{ //로그인 부분
            while(true){
                System.out.println("비번을 입력하세요.");
                String password = in.nextLine();
                if(searchIdOrPassword(name,password,false)){
                    break ;
                }else{
                    System.out.println("비번이 틀렸습니다 다시 입력해주세요.");
                }
            }
        }
    }
    public static void gameStart() {
        int rr = rand.nextInt(7) + 1;
        System.out.println("그다음 숫자는 : " + rr);

        System.out.println("    1  2  3  4  5  6  7");
        System.out.println("   ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ-");
        for (int i = 0; i < a.length; i++) {
            System.out.print(i+1 + " | ");
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("들어갈 번호를고르시오");
        int chose = in.nextInt();
        for (int i = a[0].length - 1; i >= 0; i--) {
            if (a[i][chose - 1] == 0) {
                a[i][chose - 1] = rr;
                break;
            }
        }
    }
    public static void item(int choiceItem){
        // 회원별 아이템이 얼마나 남아있는지 에 따라서 밑에 아이템 기능들이 작동하도록 해야한다.

        // 폭탄 : 해당범위 숫자 0으로 제거 (랜덤범위로)
        if (choiceItem == 1){
            int col = rand.nextInt(7);
            int row = rand.nextInt(7);
            int mark = 100;
            for (int i = 0; i < second.length; i++) {
                for (int j = 0; j < second[i].length; j++) {
                    if ((j > col - 2 && j < col + 2) && (i > row  - 2 && i < row + 2)) {
                        // 색깔 표시를 위해서
                        second[i][j] = mark++;
                    }
                }
            }
            // 지맘대로 십자가 : 가로 세로 한줄 전체를 랜덤한 위치에 모두 0으로 만들어준다.
        }else if (choiceItem == 2){
            int col = rand.nextInt(7);
            int row = rand.nextInt(7);
            for (int i = 0; i < second.length; i++) {
                for (int j = 0; j < second[i].length; j++) {
                    if (j == col || i == row) {
                        second[i][j] = 0;
                    }
                }
            }
            // 일심동체 :선택한 숫자만 모두 없애는 기능
        }else if (choiceItem == 3){
            System.out.println("삭제하고 싶은 숫자를 한개만 고르세요.");
            int deleteNum = in.nextInt();
            if (deleteNum < 8 && deleteNum > 0){
                for (int i = 0; i  <  second.length; i++) {
                    for (int j = 0; j < second[i].length; j++) {
                        if(second[i][j] == deleteNum){
                            second[i][j] = 0;
                        }
                    }
                }
            }
        }
    }

    //------------------------------------------------------------------------------------------
    public static void checkDuplicate() {
        boolean flag = true;
        while (flag) {
            int j = 0;
            for (int i = 0; i < a.length; ) {
                int len = 1;

                while (j < a[i].length - 1 && a[i][j] == a[i][j + 1]) {
                    len++;
                    j++;
                }
                if (len >= 3) {
                    for (int k = 0; k < len; k++) {
                        second[i][j - len + k + 1] = 0;
                    }
                } else {
                    j++;
                }
                if (j == a[0].length) {
                    i++;
                    j = 0;
                }

            }
            flag = false;
        }

        boolean haha = true;

        while (haha) {
            int i = 0;
            for (int j = 0; j < a[0].length; ) {
                int len = 1;
                while (i < a.length - 1 && a[i][j] == a[i + 1][j]) {
                    len++;
                    i++;
                }
                if (len >= 3) {
                    for (int k = 0; k < len; k++) {
                        second[i - len + k + 1][j] = 0;
                    }
                } else {
                    i++;
                }
                if (i == a.length) {
                    j++;
                    i = 0;
                }
            }
            haha = false;
        }
    }

    public static void downZero() {
        for (int i = second.length - 1; i >= 1; i--) {
            for (int j = 0; j < second[0].length; j++) {
                if (second[i][j] == 0) {
                    int ii = i;
                    for (int k = i - 1; k >= 0; k--) {
                        if (second[k][j] != 0) {
                            second[ii][j] = second[k][j];
                            second[k][j] = 0;
                            ii--;
                        }
                    }

                }
            }
        }
    }

    public static void prtTool() {
        System.out.println("----------결과----------");
        for (int k = 0; k < second.length; k++) {
            for (int j = 0; j < second[k].length; j++) {
                System.out.print(second[k][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void copyArray(int x) {
        if (x == 1){
            for (int i = 0; i < second.length; i++) {
                for (int j = 0; j < second[0].length; j++) {
                    second[i][j] = a[i][j];
                }
            }
        }else{
            for (int i = 0; i < second[0].length; i++) {                 //배열 복사
                for (int j = 0; j < second[0].length; j++) {
                    third[i][j] = second[i][j];
                }
            }


            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[0].length; j++) {
                    a[i][j] = third[i][j];
                }
            }
        }
    }

    public static int endGame() {
        System.out.println("종료(0) / 계속(1)");
        int choice = in.nextInt();
        int cnt = 0;
        for (int i = 0; i < second.length; i++) {          //게임 탈락여부
            for (int j = 0; j < second[0].length; j++) {
                if (second[i][j] == 0) {
                    cnt++;
                }
            }
        }
        if (cnt == 0) {                        //게임탈락
            System.out.println("게임종료");
            stop = true;
        }
        if (choice == 0) {               //게임수동 종료
            stop = true;
        } else if (choice == 1) {
            return 0;
        }
        return 1;
    }
}

















