package Pay_templete;

public class Coupon20 extends Pay {

    public int discount() { //할인율 리턴
        int per = 20;
        System.out.println("할인율은 " + per + "%입니다.");
        System.out.println();
        return per;
    }
}
