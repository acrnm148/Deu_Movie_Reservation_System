package Pay_templete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Pay {

    private int per;

    private int dbcoupon;

    final void coupon(int num, String price_movice, int price_popcorn) {
        if (checkcoupon(num) == true) {

            per = discount();
            pay_discount(per, price_movice, price_popcorn);
        } else {
            print_pay(price_movice, price_popcorn);
        }
    }

    public abstract int discount();

    public boolean checkcoupon(int num) {

        Connection con;
        con = null;
        PreparedStatement pstmt = null; // "Statement pstmt = null;"에 비해 미리처리하기 때문에 속도가 더 빠름
        ResultSet rs = null;

        try {  //DB URL 수정해서 쓰세용
            con = DriverManager.getConnection("jdbc:mysql://localhost:3305/movieinfo?serverTimezone=UTC", "root", "0000");//데베 다시 재 검토
        } catch (SQLException ex) {
            Logger.getLogger(Pay.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sql = "SELECT coupon FROM checkcoupon WHERE coupon = '" + num + "'";

        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                dbcoupon = rs.getInt("coupon"); // coupon 필드값을 가져옴
            }

            rs.close();
            pstmt.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("[ERROR]" + e.getMessage());
            e.printStackTrace();
        }
        if (dbcoupon == num) {
            return true;
        } else {
            System.out.println("유효하지않은 쿠폰입니다.");

            return false;
        }
    }

    //할인율을 계산하고 금액을 표시하는 메소드
    public void pay_discount(int per, String price_movie, int price_popcorn) {
        int Iprice_movie = Integer.parseInt(price_movie);
        int Iprice_popcorn = price_popcorn;
        int sum = Iprice_movie + Iprice_popcorn;
        int discountedPrice = sum * per / 100;
        int lastprice = sum - discountedPrice;
        System.out.println("쿠폰할인) 결제하실 금액은 " + lastprice + "원 입니다.");
    }

    public void print_pay(String price_movie, int price_popcorn) {
        int Iprice_movie = Integer.parseInt(price_movie);
        int Iprice_popcorn = price_popcorn;

        int sum = Iprice_movie + Iprice_popcorn;
        System.out.println("결제하실 금액은 " + sum + "원 입니다.");
    }
}
