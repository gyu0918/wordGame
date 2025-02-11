import java.util.Random;

public class ArraryEX2 {
    public static void main(String[] args) {
//        int[][] a = new int[4][5];
//        int num=10;
//        //배열순회 값 입력
//        for(int i=0; i<a.length; i++) {
//            for(int j=0; j<a[0].length; j++) {
//                a[i][j]=num;
//                num++;
//            }
//            //System.out.println();
//        }
//        //배열 순회 값 출력
//        for(int i=0; i<a.length; i++) {
//            for(int j=0; j<a[0].length; j++) {
//                System.out.print(a[i][j]+" ");
//            }
//            System.out.println();
//        }

//        //문제 1
//        int[][] a = new int[4][5];
//        int num=10;
//        //배열순회 값 입력
//        for(int i=0; i<a.length; i++) {
//            for(int j=a[0].length; j > 0; j--) {
//                a[i][j - 1]=num;
//                num++;
//            }
//
//            //System.out.println();
//        }
//        //배열 순회 값 출력
//        for(int i=0; i<a.length; i++) {
//            for(int j=0; j<a[0].length; j++) {
//                System.out.print(a[i][j]+" ");
//            }
//            System.out.println();
//        }
//        //문제 2
//        int[][] a = new int[4][5];
//        int num=10;
//        //배열순회 값 입력
//        for(int i=0; i<a.length; i++) {
//            for(int j=0; j < a[0].length; j++) {
//                a[i][j]=num;
//                num += 4;
//            }
//            num -= 19;
//
//        }
//        //배열 순회 값 출력
//        for(int i=0; i<a.length; i++) {
//            for(int j=0; j<a[0].length; j++) {
//                System.out.print(a[i][j]+" ");
//            }
//            System.out.println();
//        }

//        //문제 3
//        int[][] a = new int[4][5];
//        int num=29;
//        //배열순회 값 입력
//        for(int i=0; i<a.length; i++) {
//            for(int j=0; j < a[0].length; j++) {
//                a[i][j]=num;
//                num -= 4;
//            }
//            num += 19;
//
//        }
//        //배열 순회 값 출력
//        for(int i=0; i<a.length; i++) {
//            for(int j=0; j<a[0].length; j++) {
//                System.out.print(a[i][j]+" ");
//            }
//            System.out.println();
//        }

//        //문제 4
//        int[][] a = new int[4][5];
//        int num=10;
//        int cnt = 0;
//        //배열순회 값 입력
//        for(int i=0; i<a.length; i++) {
//            for(int j=0; j < a[0].length; j++) {
//                if (num%2==0)
//                    cnt++;
//                a[i][j]=num;
//                num++;
//            }
//            num += 5;
//
//        }
//        //배열 순회 값 출력
//        for(int i=0; i<a.length; i++) {
//            for(int j=0; j<a[0].length; j++) {
//                System.out.print(a[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println("짝수는 개수는  = " +cnt);
//        //문제 5
//        int[][] a = new int[4][5];
//        int num=10;
//        int temp = 0;
//        //배열순회 값 입력
//        for(int i=0; i<a.length; i++) {
//            for(int j=0; j < a[0].length; j++) {
//                if (num <= 30 || num >= 40) {
//                    a[i][j] = temp;
//                    num++;
//                }
//                else {
//                    a[i][j] = num;
//                    num++;
//                }
//            }
//            num += 5;
//
//        }
//        //배열 순회 값 출력
//        for(int i=0; i<a.length; i++) {
//            for(int j=0; j<a[0].length; j++) {
//                System.out.print(a[i][j]+" ");
//            }
//            System.out.println();
//        }
//        //문제 6
//        int[][] a = new int[4][5];
//        int num=10;
//        Random rand = new Random();
//        //배열순회 값 입력
//        for(int i=0; i<a.length; i++) {
//            for(int j=0; j < a[0].length; j++) {
//                int randomNum = rand.nextInt(5) + 1;
//                    a[i][j] = randomNum;
//                }
//        }
//        //배열 순회 값 출력
//        for(int i=0; i<a.length; i++) {
//            for(int j=0; j<a[0].length; j++) {
//                System.out.print(a[i][j]+" ");
//            }
//            System.out.println();
//        }

        //문제 7
        int first=4;
        int second=5;
        int[][] a = new int[first][second];
        int num=1;
        int plag = 1;
        boolean[][] visited = new boolean[first][second];
        int i = 0;
        int j = -1;
        int cnt = 0;
        //배열순회 값 입력
        for(;true;) {
            if (num == (first * second) + 1)
                break ;
            if (plag == 1) {
                if (cnt % 4 == 0) {
                    j +=1;
                }
                for(; j < a[0].length; j++) {
                    if (visited[i][j]) {
                        break;
                    }
                    a[i][j] = num;
                    num++;
                    visited[i][j] = true;
                }
                plag = 2;
                cnt++;

            }
            else if (plag == 2) {
                j--;
                i++;
                for(; i < a.length; i++) {
                    if (visited[i][j]) {
                        break;
                    }
                    a[i][j] = num;
                    num++;
                    visited[i][j] = true;
                }
                plag = 3;
                cnt++;

            }
            else if (plag == 3) {
                i--;
                j--;
                for ( ; j >= 0; j--) {
                    if (visited[i][j]) {
                        break;
                    }
                    a[i][j] = num;
                    num++;
                    visited[i][j] = true;
                }
                plag = 4;
                cnt++;

            }else if (plag == 4) {
                j++;
                i--;
                for (; i >= 0; i--) {
                    if (visited[i][j]) {
                        break;
                    }
                    a[i][j] = num;
                    num++;
                    visited[i][j] = true;
                }
                if (cnt > 4)
                    return ;
                plag = 1;
                cnt++;
                i++;
            }
        }


        //배열 순회 값 출력
        for(int k=0; k<a.length; k++) {
            for(int l=0; l<a[0].length; l++) {
                System.out.print(a[k][l]+" ");
            }
            System.out.println();
        }

    }
}
