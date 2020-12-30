/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import static Snack_deco.SelectPopcorn.popcornPrice;
import java.util.Scanner;
import startmenu_state.cancel;
import startmenu_state.search;

/**
 *
 * @author 강수나
 */
public class Main {

    private static String id = null;
    //public int popcornPrice;
    private static int state;
    private static int popcornPrice;

    public static void main(String[] args) {
        int popcornPrice;
        int reserveNum = 101;
        while (true) {
            state = startmenu_state.StateMain.work();

            if (state == 1) {
                
                //상영시간표 표시, 영화 선택
                id = movieList_strategy.Movietest.work();
                System.out.println();
                
                if (id != null) {
                    //좌석 선택, 간식 선택
                    System.out.println("------좌석선택------");
                    reserve_factory.movieClient.work(id, reserveNum);
                    reserveNum++;

                    //할인 및 결제
                    popcornPrice = Snack_deco.SelectPopcorn.getPopcornPrice();
                    System.out.println("--------결제--------");
                    Pay_templete.Discount_main.work(popcornPrice);
                    ReserveCtrl_observer.observerMain.work(101);
                } else {
                    System.out.println("처음 화면으로 돌아갑니다.");
                }
            } else if (state == 2) { //영화 조회
                movieList_strategy.Movietest.LoadName();
            } 
            else if (state == 3) { //예매 취소
                System.out.println("예매번호 입력 :");
                Scanner scan = new Scanner(System.in);
                state = scan.nextInt();
                ReserveCtrl_observer.observerMain.work(state);
            }
        }
    }
}
