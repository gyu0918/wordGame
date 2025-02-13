
import  java.util.*;
import java.io.*;

//public class test {
//    public static void main(String[] args) {
//        Thread timerThread = new Thread(() -> {
//            try {
//                for (int i = 3; i > 0; i--) {
//                    System.out.print("\r" + i + " "); // 숫자 출력 후 공백 추가
//                    Thread.sleep(1000); // 1초 대기
//                }
//                System.out.print("\rGo!  \n"); // 마지막 메시지 출력 후 개행
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        timerThread.start();
//    }
//}
//public class test {
//    public static void main(String[] args) {
//        Thread progressThread = new Thread(() -> {
//            String gauge = "------"; // 초기 게이지
//            int length = gauge.length();
//
//            try {
//                for (int i = length; i >= 0; i--) {
//                    System.out.print("\r" + gauge.substring(0, i) + "  "); // 줄어든 게이지 출력
//                    Thread.sleep(1000); // 1초 대기
//                }
//                System.out.println("\rDone!  "); // 종료 메시지 출력
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        progressThread.start();
//    }
//}
//----------------override 사용--------------------------------------
//import java.util.Random;
//import java.util.Scanner;
//
///************
// * @info : Thread 게임 2 - 시간내에 구구단 문제 풀기
// * @name : Thread_Game2
// * @version : 1.0.0
// * @Description :
// ************/
//public class Thread_Game2 {
//
//    static int correct = 0; // 정답갯수
//    static int wrong = 0; // 틀린 갯수
//    static int proNum = 0; // 문제 갯수
//
//    public static void main(String[] args) {
//        GuguTimer timer = new GuguTimer();
//        timer.start();
//    }
//
//    private static class GuguTimer extends Thread {
//        @Override
//        public void run() {
//            GameGugu game = new GameGugu();
//
//            System.out.println("구구단 게임 시작! 제한시간 60초!");
//            game.start();
//            for(int i=60; i>0; i--) {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            System.out.println("게임 종료!");
//            System.out.println("총 문제 갯수: " + Thread_Game2.proNum);
//            System.out.println("맞춘 갯수: " + Thread_Game2.correct);
//            System.out.println("틀린 갯수: " + Thread_Game2.wrong);
//            System.exit(0); //THread 종료.
//
//            game.interrupt();
//        }
//    } //class - timer
//
//
//    private static class GameGugu extends Thread {
//        @Override
//        public void run() {
//            Scanner sc = new Scanner(System.in);
//
//            System.out.println("시작!");
//            while (true) {
//                Random random = new Random();
//                int fir = random.nextInt(100);
//                int sec = random.nextInt(10);
//                int result = fir * sec;
//
//                System.out.println((Thread_Game2.proNum+1)+ "번" + "--->" + fir + " X " + sec + " 정답은?");
//                int inRes = sc.nextInt();
//
//                if(inRes == result) {
//                    System.out.println("정답입니다!");
//                    Thread_Game2.correct ++; // 정답 갯수
//                }else {
//                    System.out.println("틀렸습니다! 정답은: " + result);
//                    Thread_Game2.wrong ++; // 틀린 갯수
//                }
//
//                Thread_Game2.proNum++; // 문제 갯수
//
//                if(isInterrupted()) {
//                    System.exit(0);
//                }
//            }//while
//        }
//    }// class - game
//
//}// class

public class test {
    static int score = 0; // 게임 점수

    public static void main(String[] args) {
        // 타이머 스레드와 게임 스레드를 동시에 실행
        Thread timerThread = new Thread(timerRunnable());
        Thread gameThread = new Thread(gameRunnable());

        // 스레드 시작
        timerThread.start();
        gameThread.start();
    }

    // 타이머를 처리하는 Runnable
    public static Runnable timerRunnable() {
        return new Runnable() {
            public void run() {
                startTimer();  // 타이머 시작
            }
        };
    }

    // 게임을 처리하는 Runnable
    public static Runnable gameRunnable() {
        return new Runnable() {
            public void run() {
                startGame();  // 게임 시작
            }
        };
    }

    // 타이머 시작 메서드
    public static void startTimer() {
        for (int i = 10; i > 0; i--) {
            try {
                Thread.sleep(1000);  // 1초 대기
                System.out.println("남은 시간: " + i + "초");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("타이머 종료!");
    }

    // 게임 시작 메서드
    public static void startGame() {
        // 간단한 게임 로직
        for (int i = 1; i <= 5; i++) {
            System.out.println("게임 " + i + " 시작!");
            score += 10;  // 점수 증가
            try {
                Thread.sleep(2000);  // 게임 진행 중 2초 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("게임 종료! 최종 점수: " + score);
    }
}

