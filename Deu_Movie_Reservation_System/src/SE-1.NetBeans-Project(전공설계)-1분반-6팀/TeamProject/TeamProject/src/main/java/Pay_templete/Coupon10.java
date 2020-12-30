package Pay_templete;

public class Coupon10 extends Pay {

    public int discount() { //할인율 리턴
        int per = 10;
        System.out.println("할인율은 " + per + "%입니다.");
        System.out.println();
        return per;
    }

}
