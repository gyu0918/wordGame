//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
import java.util.*;
import java.io.*;
public class Main {
    static String[] englishWord = new String[5];
    static Scanner sc = new Scanner(System.in);
    static String[] wordMeaning = new String[5];
    public static void main(String[] args) {
        int firstStart = 0;
        while(true) {
              System.out.println("하고 싶은 기능을 숫자로 입력해주세요.");

              System.out.println("1 : 단어 저장기능, 2: 단어 전체보기, 3: 단어 검색하기, 4:단어 삭제기능, 5:단어 수정 기능" +
                      " 6: 단어포함 모든 단어 찾기 기능 7: 단어 뜻을 저장하는 기능  8: 영어단어뜻까지 보는기능 9 : 단어 검색인데 뜻까지 보는 기능"
                        + " 10 : 단어시험 기능 + 종료하고싶으면 1004 입력하세요.");
              int plag = sc.nextInt();
              if(plag == 1) {
                  saveEnglish(firstStart++);
              }else if (plag == 2) {
                  prtAllEng(false);
              }else if (plag == 3) {
                  searchEng(false);
              }else if (plag == 4) {
                  deleteEng();
              }else if (plag == 5) {
                  updateEng();
              }else if (plag == 6) {
                  searchEng(true);
              }else if (plag == 7) {
                    saveEnglish(-1);
              }else if (plag == 8) {
                    prtAllEng(true);
              }else if (plag == 9) {
                  upSearchEng();
              }else if (plag == 10) {
                  gameEng();
              }else if (plag == 1004) {
                  break ;
              }
          }
    }
    //중복 체크 메서드 + 중복이면 true 반환
    public static boolean checkDouble(String word){
        for (int j = 0; j < englishWord.length; j++) {
            if (englishWord[j] == null)
                continue;
            if (englishWord[j].equals(word)) {
                return true ;
            }
        }
        return false;
    }
    //영어 단어 저장 기능 +  영어단어와 뜻도 보여주는 기능 추가
    public static void saveEnglish(int upgradeOn) {
        if (upgradeOn == -1){
            sc.nextLine();
            while(true) {
                System.out.println("단어와 뜻을 입력해주세요.");
                String str = sc.nextLine();
                //중복 체크
                if(!checkDouble(str)) {
                    System.out.println("입력한 단어가 없습니다.");
                    continue;
                }
                //단어 뜻 저장
                String meaning = sc.nextLine();
                for (int i = 0; i < englishWord.length; i++) {
                    if (englishWord[i].equals(str)) {
                        wordMeaning[i] = meaning;
                        break ;
                    }
                }
                System.out.println("단어 뜻  " + meaning + "  입력되었습니다. ");
                break ;
            }

        }else if (upgradeOn > 0) {
            sc.nextLine();
            //단어 삭제되어서 다시 입력하는 부분
            int nullCnt = 0;
            for(int i = 0; i < englishWord.length; i++) {
                if (englishWord[i] == null)
                    nullCnt++;
            }
            if (nullCnt == 0){
                System.out.println("단어가 모두 있습니다. ");
                return ;
            }

            for (int i = 0; i < englishWord.length; i++) {
                if ( englishWord[i] != null)
                    continue;
                System.out.println("단어를 입력해주세요.");
                String word = sc.nextLine();
                //중복 체크
                if (checkDouble(word)) {
                    i--;
                    System.out.println("단어가 중복되었습니다.");
                    continue;
                }
                englishWord[i] = word;
            }
            System.out.println("단어를  모두 입력하셨습니다.");
        }else if (upgradeOn == 0){
            sc.nextLine();
            //맨처음 시작 부분
            for (int i = 0; i < englishWord.length; i++) {
                System.out.println("단어를 입력해주세요.");
                String word = sc.nextLine();
                //중복 체크
                if (checkDouble(word)) {
                    i--;
                    System.out.println("단어가 중복입니다.");
                    continue;
                }
                englishWord[i] = word;
            }
            System.out.println("단어를  모두 입력하셨습니다.");
        }
    }
    //전체보기 기능
    public static void prtAllEng(boolean upgradeOn) {
        if(upgradeOn){
            for (int i = 0; i < englishWord.length; i++) {
                System.out.println(englishWord[i]);
                System.out.println(wordMeaning[i]);
            }
        }else{
            for (int i = 0; i < englishWord.length; i++) {
                System.out.println(englishWord[i]);
            }
        }
    }
    //검색하기 기능  + 단어가 포함된 던어면 모두 찾아준다.
    public static void searchEng(boolean upgradeOn) {
        sc.nextLine();
        System.out.println("검색할려는 단어를 입력하세요.");
        String str = sc.nextLine();
        boolean noSearch = true;
        for (int i = 0; i < englishWord.length; i++) {
            if (upgradeOn) {
                //해당 단어가 포함되어있는 단어 모드 검색기능 are re
                boolean finalPlag = false;
                for(int j = 0; j < englishWord[i].length(); j++) {
                    boolean noExistence = false;
                    int temp = j;
                    for (int k = 0; k < str.length(); k++) {
                        if (englishWord[i].charAt(temp) != str.charAt(k)) {
                            noExistence = true;
                            break;
                        }
                        temp++;
                    }
                    if (!noExistence) {
                        finalPlag = true;
                        break ;
                    }
                }
                if (finalPlag) {
                    System.out.println("단어 = " + englishWord[i]);
                    noSearch = false;
                }
            }
            else{
                if (str.equals(englishWord[i])) {
                    System.out.println(englishWord[i]);
                    return ;
                }
            }
        }
        if (noSearch) {
            System.out.println("찾으시는 단어가 없습니다.");

        }
    }
    //단어 삭제 기능
    public static void deleteEng() {
        sc.nextLine();
        System.out.println("삭제 하고 싶은 단어를 입력하세요. ");
        String str = sc.nextLine();
        for (int i = 0; i < englishWord.length; i++) {
            if (str.equals(englishWord[i])) {
                System.out.println(englishWord[i] + " 단어를 삭제합니다.");
                englishWord[i] = null;
                return ;
            }
        }
        System.out.println("해당 단어가 존재하지 않습니다.");
    }
    //단어 수정 기능
    public static void updateEng() {
        sc.nextLine();
        System.out.println("수정 하고 싶은 단어를 입력하세요. ");
        String str = sc.nextLine();
        for (int i = 0; i < englishWord.length; i++) {
            if (str.equals(englishWord[i])) {
                System.out.println("수정할 내용을 입력하세요.");
                str = sc.nextLine();
                //중복체크
                if (checkDouble(str)) {
                    i--;
                    System.out.println("단어가 중복되엇습니다.");
                    continue;
                }
                englishWord[i] = str;
                System.out.println(englishWord[i] + " 이단어로 수정되었습니다.");
                return ;
            }
        }
        System.out.println("해당 단어가 존재하지 않습니다.");
    }
    //검색 업그레이드 버전 + 영어단어와 뜻도 검색해서 보여주는  없으면 예외 처리
    public static void upSearchEng() {
        sc.nextLine();
        System.out.println("검색하고 싶은 단어를 입력하세요 ");
        String str = sc.nextLine();
        for (int i = 0; i < englishWord.length; i++) {
            if (str.equals(englishWord[i])) {
                System.out.println("단어는 = " + englishWord[i]);
                System.out.println("단어 뜻은 = " + wordMeaning[i]);
                return ;
            }
        }
        System.out.println("해당 단어가 없습니다.");
    }

    //단어 시험 기능
    public static void gameEng() {
        sc.nextLine();
        System.out.println("단어 시험을 시작하겠습니다. 랜덤한 단어를 제시하겠습니다. 뜻을 맞추세요");
        // 단어 뜻이 3개가 없다면 뜻적으라고 해야함
        int  nullCnt = 0;
        for (int i = 0; i < wordMeaning.length; i++) {
            if (wordMeaning[i] == null) {
                nullCnt++;
            }
        }
        if (nullCnt >= 3) {
            System.out.println("뜻이 있는 단어가 3개가 안됩니다 뜻을 저장해주세요.");
            return ;
        }

        Random random = new Random();
        int[] checkNum = new int[5];
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            int num = random.nextInt(5);
            if (checkNum[num] != 0 || wordMeaning[num] == null) {
                i--;
                continue ;
            }
            checkNum[num]++;
            System.out.println(wordMeaning[num]);
            String str = sc.nextLine();
            if (str.equals(englishWord[num])) {
                cnt++;
            }

        }
        System.out.println("맞춘 개수는 = " + cnt);

    }
}