/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReserveCtrl_observer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author 강수나
 */
public class observerMain {

    /**
     * @param args the command line arguments
     */
    public static void work(int reserveNum) {
        boolean state;
        Subject_Reserve sub = new ReserveManager();
        Observer clt = new Client();

        
        state = sub.check_reservation(reserveNum);
        
        if (state == true) {
            sub.add(clt);
            
            //출력
            System.out.println("--------------------------------");
            System.out.println("원하시는 서비스를 선택해주세요.");
            System.out.println("1. 확인");
            System.out.println("2. 영화표 출력");
            System.out.println("3. 예매 취소");
            System.out.print("입력:");
            
            //사용자 선택
            String answer = getAnswer();

            if (answer.equals("1")) {
                sub.notifyObserver("즐거운 관람 되십시오!");
            } else if (answer.equals("2")) {
                sub.notifyObserver("영화표가 출력됩니다! 즐거운 관람 되십시오!");
            } else if (answer.equals("3")) {
                sub.delete(clt, reserveNum);
            } 
        }
        else System.out.println("예매 번호를 확인해주세요.");
    }

    public static String getAnswer() {
        boolean answerstate = true;
        String answer = null;
        while (answerstate) {

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            try {
                answer = in.readLine();
            } catch (IOException ioe) {
                System.err.print(ioe);
            }
            if (answer == null) {
                answer = "1";
            }
            if (answer.equals("1")) {
                answerstate = false;
            } else if (answer.equals("2")) {
                answerstate = false;
            } else if (answer.equals("3")) {
                answerstate = false;
            }
        }
        return answer;

    }

}
