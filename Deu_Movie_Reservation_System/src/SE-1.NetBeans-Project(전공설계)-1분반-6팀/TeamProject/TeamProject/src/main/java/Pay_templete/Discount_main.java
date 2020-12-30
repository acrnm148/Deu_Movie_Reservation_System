/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pay_templete;

import java.util.Scanner;

public class Discount_main {

    public static void work(int popcorn) {
        String price_movie = "9000";//데베값
        
        System.out.println("쿠폰을 입력하세요.");
        Scanner numscan = new Scanner(System.in);

        System.out.println();

        int scan_num = numscan.nextInt();

        if (scan_num % 2 == 1) {
            Pay couponnum1 = new Coupon10();
            couponnum1.coupon(scan_num, price_movie, popcorn);
        } else {
            Pay couponnum2 = new Coupon20();
            couponnum2.coupon(scan_num, price_movie, popcorn);
        }
        
    }
}
