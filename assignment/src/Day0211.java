
import java.util.*;
import java.io.*;


public class Day0211 {
    public static void main(String[] args) throws IOException {


//        //1번문제----------------------------------------------------------
//        int[][] a = new int[4][5];
//        int num=16;
//        //배열순회 값 입력
//        for(int i=0; i<a.length; i++) {
//           if (i % 2 == 0) {
//               for (int j = 0; j < a[0].length; j++) {
//                   a[i][j] = num;
//                   num++;
//               }
//               num-= 6;
//           }else {
//               for (int j = 0; j < a[0].length; j++) {
//                   a[i][j] = num;
//                   num--;
//               }
//               num -=4;
//           }
//
//        }
//
//
//        //배열 순회 값 출력
//        for(int i=0; i<a.length; i++) {
//            for(int j=0; j<a[0].length; j++) {
//                System.out.print(a[i][j]+" ");
//            }
//            System.out.println();
//        }
//
//        //2번 문제----------------------------------------------------------
//        String[][] a = new String[2][2];
//        Random rand = new Random();
//
//        String[] word = {"apple","book","java","oracle","computer","html","dbms","server"};
//        //배열순회 값 입력
//        for(int i=0; i<a.length; i++) {
//            for (int j=0; j<a[i].length; j++) {
//                a[i][j] = word[rand.nextInt(word.length)];
//            }
//        }
//
//
//        //배열 순회 값 출력
//        for(int i=0; i<a.length; i++) {
//            for(int j=0; j<a[0].length; j++) {
//                System.out.print(a[i][j]+" ");
//            }
//            System.out.println();
//        }
//
//        //3번문제----------------------------------------------------------
//        String[][] a = new String[2][2];
//        Random rand = new Random();
//        Scanner sc = new Scanner(System.in);
//
//        String[] word = {"apple","book","java","oracle","computer","html","dbms","server"};
//        //배열순회 값 입력
//        for(int i=0; i<a.length; i++) {
//            for (int j=0; j<a[i].length; j++) {
//                a[i][j] = word[rand.nextInt(word.length)];
//                System.out.println(a[i][j] + " ");
//                String str = sc.nextLine();
//                if (str.equals(a[i][j])) {
//                    a[i][j] = "";
//                }
//            }
//        }
//        //배열 순회 값 출력
//        for(int i=0; i<a.length; i++) {
//            for(int j=0; j<a[0].length; j++) {
//                System.out.print(a[i][j]+" ");
//            }
//            System.out.println();
//        }
//
//        //4번문제----------------------------------------------------------
//        int[][] a = new int[][]{{1, 1, 0, 2}, {3, 2, 1, 2}, {0, 0, 3, 2}, {4, 4, 4, 4}, {2, 4, 3, 1}, {2, 4, 1, 3}};
//        int cnt = 0;
//        int temp = -1;
//        //배열순회
//        for(int i=0; i<a.length; i++) {
//            cnt = 0;
//            for (int j=0; j<a[i].length; j++) {
//                if (temp == a[i][j]) {
//                    cnt++;
//                } else{
//                    temp = a[i][j];
//                    cnt = 0;
//                }
//                if (cnt >= 2) {
//                    System.out.println("연속된 숫자 3이상인 행은 좌표는 = " + i + " " + j + "  이다");
//                    break;
//                }
//
//            }
//        }

//        //5번문제----------------------------------------------------------
//        int[][] tempArr =  {{1,1,0},{0,1,0},{0,1,1}};
//
//        //회전 회오리!!!!!!!!
//        for(int i=0; i<tempArr.length; i++) {
//            for (int j=0; j<tempArr[i].length; j++) {
//               if (i == 1 && j == 1) {
//                   continue;
//               }
//               if (tempArr[i][j] == 1) {
//                   tempArr[i][j] = 0;
//               }else if(tempArr[i][j] == 0){
//                   tempArr[i][j] = 1;
//               }
//
//            }
//        }
//        //배열 순회 값 출력
//        for(int i=0; i<tempArr.length; i++) {
//            for(int j=0; j<tempArr[0].length; j++) {
//                System.out.print(tempArr[i][j]+" ");
//            }
//            System.out.println();
//        }

//        //6번문제----------------------------------------------------------
//        int[][] tempArr =  {{0,0,1},{1,1,1},{1,0,0}};
//
//        //회전 회오리!!!!!!!!
//        for(int i=0; i<tempArr.length; i++) {
//            for (int j=0; j<tempArr[i].length; j++) {
//                if (i == 1 && j == 1) {
//                    continue;
//                }
//                if (tempArr[i][j] == 1) {
//                    tempArr[i][j] = 0;
//                }else if(tempArr[i][j] == 0){
//                    tempArr[i][j] = 1;
//                }
//
//            }
//        }
//        //배열 순회 값 출력
//        for(int i=0; i<tempArr.length; i++) {
//            for(int j=0; j<tempArr[0].length; j++) {
//                System.out.print(tempArr[i][j]+" ");
//            }
//            System.out.println();
//        }

//        //7번문제----------------------------------------------------------
//        int[][] tempArr =  new int[4][5];
//        int num = 1;
//        int cnt = 1;
//        int finalCnt = 4;
//        //대각선 ++ 법칙!!!
//        for(int i=0; i<tempArr.length; i++) {
//            if (i == 0){
//                for (int j=0; j<tempArr[0].length; j++) {
//                    tempArr[i][j] = num;
//                    num += cnt;
//                    cnt++;
//                }
//            }else{
//                for (int j=0; j<tempArr[0].length; j++) {
//                    //i = 1 j = 0;
//                    if (j == tempArr[0].length-1){
//                        tempArr[i][j] = tempArr[i - 1][j] + finalCnt;
//                        finalCnt--;
//                        continue;
//                    }
//                    tempArr[i][j] = tempArr[i-1][j + 1] + 1;
//                }
//            }
//        }
//        //배열 순회 값 출력
//        for(int i=0; i<tempArr.length; i++) {
//            for(int j=0; j<tempArr[0].length; j++) {
//                System.out.print(tempArr[i][j]+" ");
//            }
//            System.out.println();
//        }
//
//        //8번문제----------------------------------------------------------
//        int[][] a = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
//
//        int plag = 1;
//        int i = -1;
//        int j = -1;
//        int cnt = 0;
//        int beforeNum = 0;
//        int temp = 0;
//        int endCnt = 0;
//
//        //회전 안에 회전 안에 회전 ....회오리!!!!
//        for(;true;) {
//
//            if (plag == 1) {
//                if (cnt % 4 == 0) {
//                    i += 1;
//                    j += 1;
//                    beforeNum = a[i + 1][j];
//                    endCnt++;
//
//                    //종료조건 (크기에 따라 바꾸는 것도 생각해보기)
//                    if (endCnt == 3)
//                        break;
//                }
//                for(; j < a[0].length; j++) {
//                    if (a[i][j] < 0 ) {
//                        break ;
//                    }
//                    temp = a[i][j] * -1;
//                    a[i][j] = beforeNum;
//                    beforeNum = temp;
//                }
//                plag = 2;
//                cnt++;
//
//            }
//            else if (plag == 2) {
//                j--;
//                i++;
//                for(; i < a.length; i++) {
//                    if (a[i][j] < 0 ) {
//                        break ;
//                    }
//                    temp = a[i][j] * -1;
//                    a[i][j] = beforeNum;
//                    beforeNum = temp;
//                }
//                plag = 3;
//                cnt++;
//
//            }
//            else if (plag == 3) {
//                i--;
//                j--;
//                for ( ; j >= 0; j--) {
//                    if (a[i][j] < 0 ) {
//                        break ;
//                    }
//                    temp = a[i][j] * -1;
//                    a[i][j] = beforeNum;
//                    beforeNum = temp;
//                }
//                plag = 4;
//                cnt++;
//
//            }else if (plag == 4) {
//                j++;
//                i--;
//                for (; i >= 0; i--) {
//                    if (a[i][j] < 0 ) {
//                        break ;
//                    }
//                    temp = a[i][j] * -1;
//                    a[i][j] = beforeNum;
//                    beforeNum = temp;
//                }
//
//                plag = 1;
//                cnt++;
//                i++;
//            }
//        }
//
//        //- 없애기 작업
//        for (int k = 0; k < a.length; k++) {
//            for (int l = 0; l < a[0].length; l++) {
//                if (a[k][l] < 0)
//                    a[k][l] *= -1;
//            }
//        }
//
//
//        //배열 순회 값 출력
//        for(int k=0; k<a.length; k++) {
//            for(int l=0; l<a[0].length; l++) {
//                System.out.print(a[k][l]+" ");
//            }
//            System.out.println();
//        }

        //넥슨입사 문제---------------------------------------------------------------------------------
        //1번 제너레이터 문제!!!!
        // 1, 3, 5, 7, 9, 20, 31
        //4999 -> 4 + 9+ 9+ 9+ 4999   5030까지
//        int[] num = new int[6000];
//        //1 부터 차례대로 숫자 입력
//        for (int i = 1; i < num.length; i++){
//            num[i] = i;
//        }
//
//        //제너레이터 판별 1제외 시작 +  제너레이터 해당되는 인덱스 0으로 바꾼다음에 다 더하는 식으로
//        int temp;
//        int cal;
//        int index = 0;
//        num[2] = 0;
//        //전체 반복문 i를 숫자로 num배열은 판변 배열로
//        for (int i = 2; i < 5031; i++){
//            // 각자리 숫자 더하고 그수 더한값 만들기
//            cal = i;
//            temp = 0;
//            index = i;
//            for (int j = 0; j < 4; j++){
//
//                temp = i /10;
//                if (temp == 0){
//                    cal += i % 10;
//                    break ;
//                }
//                cal += i % 10;
//                i = i / 10;
//            }
//            // 만든 값으로 num 인덱스에 해당하는 값을 0으로 만들기
//            num[cal] = 0;
//            i = index;
//
//        }
//        // num에 0 이 아닌 숫자들은 모두 셀프 넘버이니까 5000까지 다 더하기
//        int result = 0;
//        for (int i = 0; i < 5000; i++){
//            result += num[i];
//        }
//        System.out.println("정답 = " + result);

        //애니팡-------------------------------------------------------------

        int[][] map = new int[5][5];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] checkMap = new int[5][5];

        // 입력부
        for (int i = 0; i < 5; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                checkMap[i][j] = map[i][j];
            }
        }



        int temp;
        int checkcheck = 0;

        while (true){
            // 가로 + 세로 한번씩 중복되는 숫자 찾아서 새로운 맵에  체크해준다.
            int rowCnt = 1;
            int colCnt = 1;
            int endCnt = 0;
            //가로 시작
            System.out.println("가로 시작-----------------------------------------");
            for (int i = 0; i < 5; i++){
                temp = map[i][0];
                for (int j = 1; j < 5; j++){
                    if (map[i][j] == temp){
                        rowCnt++;
                    }else{
                        //3이상이 끝나는 좌표
                        if (rowCnt >2){
                            for (int row = j - 1; rowCnt > 0; rowCnt--){
                                if (checkMap[i][row] != 0)
                                    endCnt++;
                                checkMap[i][row--] = 0;
                            }
                        }
                        rowCnt = 1;
                    }
                    temp = map[i][j];
                }
                //뒤에서 같은경우 check 해야함
                if (rowCnt >2){
                    for (int row = 4; rowCnt > 0; rowCnt--){
                        if (checkMap[i][row] != 0)
                            endCnt++;
                        checkMap[i][row--] = 0;
                    }
                }
                rowCnt = 1;

            }
            System.out.println("세로 시작!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            // 세로 시작
            for (int j = 0; j < 5; j++){
                temp = map[0][j];
                for (int i = 1; i < 5; i++){
                    if (map[i][j] == temp){
                        colCnt++;
                    }else{
                        //3이상이 끝나는 좌표
                        if (colCnt >2){
                            for (int col = i - 1; colCnt > 0; colCnt--){
                                if (checkMap[col][j] != 0)
                                    endCnt++;
                                checkMap[col--][j] = 0;
                            }
                        }
                        colCnt = 1;
                    }
                    temp = map[i][j];
                }
                //뒤에서 같은경우 check
                if (colCnt >2){
                    for (int col = 4; colCnt > 0; colCnt--){
                        if (checkMap[col][j] != 0)
                            endCnt++;
                        checkMap[col--][j] = 0;
                    }
                }
                colCnt = 1;
            }

            //체크해준 맵을 기준으로 0위에 있는 숫자는 내려준다.
            int[][] newMap = new int[5][5];
            for (int j = 0; j < 5; j++){
                int stop = 4;
                for (int i = 4; i >= 0; i--){
                    System.out.println("checkMap == "+checkMap[i][j] + " --------------------");
                    if (checkMap[i][j] != 0) {
                        System.out.println("chekmap[stop][j] = " + checkMap[i][j] + " ");
                        newMap[stop--][j] = checkMap[i][j];
                    }
                }
            }
            map = newMap;
            //map복사 checkMap 으로
            for (int i = 0; i < 5; i++) {
                System.arraycopy(map[i], 0, checkMap[i], 0, 5);
            }
            if (endCnt == 0)
                break ;
            endCnt = 0;
        }

        //배열을 출력한다.
        System.out.println("출력!!!!!!!!!!!!!!!!!!!!!!!!");
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
