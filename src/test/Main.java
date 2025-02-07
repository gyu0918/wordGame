package test;


import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        String[][] str = {{"inheritance", "delimiter", "spring", "Framework", "application", "stack", "operator", "binaryNumber", "CentralProcessingUnit", "depth"},
                {"","","","","","","","","",""}};
        String[][] copy = {{"inheritance", "delimiter", "spring", "Framework", "application", "stack", "operator", "binaryNumber", "CentralProcessingUnit", "depth"},
                {"","","","","","","","","",""}};
        int[] score = {10,10,10,10,10,10,10,10,10,10};
        //색깔부분
        String[] strColor = new String[]{"","","","","","","","","",""}; //정답오답별 단어별색깔 저장배열//
        String red = "\033[31m";
        String green = "\033[32m";
        String white = "\u001B[37m";
        //처음 단어 출력
        for (int i = 0; i < 10; i++) {
            System.out.print(str[0][i] + " ");
        }
        System.out.println();

        int numCount = 0;
        int plag = 3;
        int endCount = 10;
        int comboCount = 0;
        int comboScore = 0;

        //랭킹 추가 부분
        int[] rankingScore = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};

        //id, password 초기 필요 부분 10개로 제한!!
        String[] id = {"","","","","","","","","",""};
        String[] password = {"","","","","","","","","",""};
        String name = null;
        int idNum = 0;

        //엔터 시작부분
        System.out.println("단어 게임을 시작할려면 엔터 치세요!");
        while(true)
            if ("".equals(sc.nextLine()))
                break ;

        //게임시작될때 부분
        int[] checkNum = new int[10];
        while (true) {
            //plag == 1 은 복습게임을 하는경우임 틀린단어만 모아서 다시 게임을 시작하는것!!
            if (plag == 1) {
                strColor = new String[]{"", "", "", "", "", "", "", "", "", ""};
                //초기화
                comboCount = 0;
                comboScore = 0;
                endCount = 0;
                for (int i = 0; i < 10; i++) {
                    if (score[i] != 10) {
                        score[i] = 10;
                        checkNum[i] = 0;
                        numCount = 0;
                        endCount++;
                        continue;
                    }
                    str[0][i] = "";
                    score[i] = 10;
                    checkNum[i] = 0;
                    numCount = 0;
                }
                System.out.println();
                plag = 0;
                // 다맞았을경우 초기화 해서 다시 게임을 기존에 저장해뒀던 단어들로 겜하는 경우임
            }else if (plag == 2) {
                strColor = new String[]{"","","","","","","","","",""};
                comboCount = 0;
                comboScore = 0;
                //점수 초기화 입력값들 저장된곳 초기화 + checkNum 초기화
                for (int i = 0; i < 10; i++) {
                    score[i] = 10;
                    checkNum[i] = 0;
                }
                //string배열은 깊은복사로 다음과 같이 해야됨 int 배열은 그냥 clone쓰면끝
                //깊은복사
                str = new String[copy.length][];
                for (int i = 0; i < copy.length; i++) {
                    str[i] = Arrays.copyOf(copy[i], copy[i].length);
                }
                endCount = 10;
                numCount = 0;
                plag  = 4;
            }else if (plag == 3) { // 맨처음에 plag ==3 이라서 아이디 적고 랭킹에 점수를 등록하는 부분이다.
                System.out.println("아이디를 입력하세요.");
                name = sc.nextLine();
                //아이디 찾아서 있으면 넘어가고 없으면 새로운 id배열에 넣는다.
                boolean plagId = true;
                int idCount = 0;
                for (int i = 0; i < 10; i++) {
                    if (id[i].equals(name)) {
                        plagId = false;
                        idCount = i;
                        break;
                    }
                }
                if (plagId) { //id 새로 입력하는 경우
                    if (idNum == 10) {
                        System.out.println("id가 꽉찼습니다 기존 아이디를 이용하세요");
                        System.out.println("기존 아이디 목록은 다음과 같습니다.");
                        for (int i = 0; i < id.length; i++)
                            System.out.print(id[i] + " ");
                        continue;
                    }
                    id[idNum] = name;
                    System.out.println("새로운 아이디군요 비밀번호를 등록하세요!");
                    String tempPassword = sc.nextLine();
                    System.out.println("비밀번호가 이문자로 저장되었습니다. => " + tempPassword);
                    System.out.println("게임을 시작하겠습니다. 단어를 입력해주세요!!");
                    password[idNum++] = tempPassword;
                } else { //id가 있는경우
                    System.out.println("패스워드를 입력하세요.");
                    int passwordCount = 4;
                    while (true) {
                        String tempPassword = sc.nextLine();
                        if (password[idCount].equals(tempPassword)) {
                            System.out.println("패스워드가 맞습니다 로그인합니다. 게임을 시작하겠습니다. 단어를 입력해주세요!!!");
                            break;
                        }
                        passwordCount--;
                        if (passwordCount == 0){
                            System.out.println("패스워드가 3번이상 틀렸습니다. 다른아이디로 로그인하세요");
                            break ;
                        }
                        System.out.println("패스워드  맞지 않습니다 다시 입력해주세요! " + passwordCount + " 회 남았습니다.");

                    }
                    if (passwordCount == 0)
                        continue ;
                }
                //초기화 new할때 새로운 아이디를 해야되니까 그리고 만약에 같은아이디를 다시 들어와서 할라고 해도 똑같이 해줘야한다.
                strColor = new String[]{"", "", "", "", "", "", "", "", "", ""};
                comboCount = 0;
                comboScore = 0;
                //점수 초기화 입력값들 저장된곳 초기화 + checkNum 초기화
                for (int i = 0; i < 10; i++) {
                    score[i] = 10;
                    checkNum[i] = 0;
//                    System.out.println("checkNum[i] = " + checkNum[i] + "str[0][i] = " + str[0][i]);
                }

                //깊은복사
                str = new String[copy.length][];
                for (int i = 0; i < copy.length; i++) {
                    str[i] = Arrays.copyOf(copy[i], copy[i].length);
                }
                endCount = 10;
                numCount = 0;
                plag = 4;
            }
            //랜덤단어 출력 + 단어입력후 저장
            int num = random.nextInt(10);
            if (checkNum[num] > 0 || "".equals(str[0][num]))
                continue ;

            //입력받는 부분
            checkNum[num]++;
            System.out.println(str[0][num]);
            String inputStr = sc.nextLine();

            //입력받은 문자에서 틀린부분 빨간색으로
            for (int i = 0; i < inputStr.length(); i++) {
                if (i < str[0][num].length()) {
                    if (inputStr.charAt(i) == str[0][num].charAt(i)) {
                        strColor[num] += green + inputStr.charAt(i); //맞는 글자는 초록색
                    }else if (inputStr.charAt(i) == ' ') {
                        strColor[num] += red + "♥";
                    }else {
                        strColor[num] += red + inputStr.charAt(i);   //틀린글자는 빨간색
                    }
                }else if (inputStr.charAt(i) == ' ') {
                    strColor[num] += red + "♥";
                }else {
                    strColor[num] += red + inputStr.charAt(i);  // 길이가 길면 빨간색으로 처리
                }
            }
            //입력된값이 몇개 틀렸는지 체크 하는 부분
            int wrongNum = 0;

            if (str[0][num].length() >= inputStr.length()) {
                for (int i = 0; i < str[0][num].length(); i++) {
                    //입력단어가 원래 단어보다 작게 입력했을때 처리
                    if (inputStr.length() == i) {
                        wrongNum += (str[0][num].length() - inputStr.length());
                        break ;

                    }
                    if (str[0][num].charAt(i) != inputStr.charAt(i))
                        wrongNum++;
                }
            }else {
                wrongNum = 123;
            }

            //점수 넣기!
            if (wrongNum == 1) {
                score[num] = 8;
            }else if (wrongNum == 2) {
                score[num] = 5;

            }else if (wrongNum > 2) {
                score[num] = 0;
            }

            //콤보 점수 넣기
            if (wrongNum == 0) {
                comboCount++;
                if (comboCount == 2)
                    comboScore += 1;
                if (comboCount > 2)
                    comboScore += 2;
            }
            else {
                comboCount = 0;
            }

            //종료조건
            numCount++;
            if (numCount == endCount) {
                int sum = 0;
                int endSum = 0;
                for (int i = 0; i < 10; i++) {
                    if (!"".equals(str[0][i])) {
                        System.out.println("단어 = " + str[0][i] + " 입력값 = " + strColor[i] + white + " 점수 = " + score[i]);
                        sum += score[i];
                        if (score[i] == 10)
                            endSum++;
                    }else {
                        endSum++;
                    }
                }

                sum += comboScore;
                System.out.println("콤보추가점수는 = " + comboScore + " 총점수는 = " + sum);

                //name에 해당하는 id 의 인덱스 찾는 부분
                int nameIndex = 0;
                for (int i = 0; i < 10; i++) {
                    if (id[i].equals(name))
                        nameIndex = i;
                }
                //점수 넣는 부분 새로운 기록을 세우면 해당 점수를 갈아치운다. 단 복습게임에서는 갱신되면 안된다.
                if (plag == 4) {
                    if (rankingScore[nameIndex] < sum) {
                        rankingScore[nameIndex] = sum;
                        System.out.println("새로운 기록을 세웠군요!! 축하드립니다.!");
                    }
                }

                //랭킹보드 출력하기 + 자기등수에 색깔칠하기!!
                System.out.println("랭킹보드는 다음과 같습니다.");
                int[] tempScore = new int[10];
                //점수 깊은복사 (int배열이나 double배열은 clone쓰면 깊은복사)
                tempScore = rankingScore.clone();
                //점수 오름차순으로 정렬
                Arrays.sort(tempScore);
//                System.out.println(tempScore[9] + " 8번째 = " + tempScore[8] + " 0번째는 = " + tempScore[0]);
                //순서별로 랭킹 출력  랭킹 5등까지
                int rank = 1;
                for(int i = 9; i >= 0; i--){
                    // 등수 5등까지만 출력
                    if (tempScore[i] == -1 || rank == 6)
                        break;
                    //
                    if (i < 9 && tempScore[i] == tempScore[i + 1]) {
                        continue;
                    }
                    // 점수 출력
                    System.out.print(rank + " 등 " + tempScore[i] + " 점 = ");
                    // 해당 점수의 사람들 출력
                    for (int j = 0; j < 10; j++) {
                        if (tempScore[i] == rankingScore[j]) {
                            //지금게임하고 있는아이디만 빨간색으로 표시하기위해서
                            if (j == nameIndex) {
                                System.out.print(red + id[j] + white + " ");
                            } else {
                                System.out.print(id[j] + " ");
                            }
                        }
                    }
                    System.out.println();
                    rank++;
                }
                System.out.println("틀린것을 복습하는 게임을 하시겠습니까? yes입력시 게임이 시작됩니다. 새로운아이디로 하실거면 new를 입력! 처음 단어로 랭킹 도전 re를 입력 끝낼려면 아무거나입력");
                String temp = sc.nextLine();
                if (temp.equals("yes")) {
                    plag = 1;
                    if (endSum == 10) {
                        System.out.println("틀린것이 없네요 처음 단어로 랭킹 도전 하시겠습니까? yes 입력 , 새로운 아이디로 하실거면 new");
                        temp = sc.nextLine();
                        if (temp.equals("yes")) {
                            plag = 2;
                        }else if (temp.equals("new")) {
                            plag = 3;
                        }else {
                            break;
                        }

                    }
                }else if (temp.equals("new")){
                    plag = 3;
                }else if (temp.equals("re")){
                    plag = 2;
                }
                else {
                    break;
                }

            }

        }
    }
}