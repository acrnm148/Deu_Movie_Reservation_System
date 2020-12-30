/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Snack_deco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.exit;
import java.util.Scanner;

public class SelectPopcorn {

    protected static Popcorn product = null;
    private static final int ORIGINAL = 1;
    private static final int CHOCOPOPCORN = 2;
    private static final int CHEESEPOPCORN = 3;
    private static final int CARAMELPOPCORN = 4;

    private static final int STEAK = 1;
    private static final int CHOCO = 2;
    private static final int CHEESE = 3;
    private static final int CARAMEL = 4;
    private static final int EXIT = 5;
    public static int popcornPrice = 0;

    public static void work() throws IOException {
        
        print_menu();
        select_popcorn();

    }

    private static void print_menu() {
        //string builer 사용해서 변경요망
        System.out.println("----------------메뉴판----------------");
        System.out.println("    메뉴(팝콘)     |      가격");
        System.out.println("--------------------------------------");
        System.out.println("    1)Original     |      5,000");
        System.out.println("    2)Choco        |      7,000");
        System.out.println("    3)Cheese       |      7,000");
        System.out.println("    4)Caramel      |      7,000");
        System.out.println("    5)exit         |      ");
        System.out.print("팝콘을 선택하세요 : ");
    }

    private static void select_popcorn() throws IOException {
        boolean state = true;
        Scanner sc = new Scanner(System.in);
        int popchoice = sc.nextInt();
        switch (popchoice) {
            case ORIGINAL:
                product = new Originalpopcorn();
                break;
            case CHOCOPOPCORN:
                product = new Chocopopcorn();
                break;
            case CHEESEPOPCORN:
                product = new Cheesepopcorn();
                break;
            case CARAMELPOPCORN:
                product = new Caramelpopcorn();
                break;
            default:
                break;

        }
        System.out.println();
        System.out.print("시즈닝을 추가 주문하시겠습니까? [Y/N] : ");
        BufferedReader Seasoning = new BufferedReader(new InputStreamReader(System.in));
        String popcornS = Seasoning.readLine();
        System.out.println();
        
        if (popcornS.toLowerCase().startsWith("y")) {
            System.out.println("----------------메뉴판----------------");
            System.out.println("    메뉴(시즈닝)   |      가격");
            System.out.println("--------------------------------------");
            System.out.println("    1)Steak       |     +3,500");
            System.out.println("    2)Choco       |     +3,000");
            System.out.println("    3)Cheese      |     +2,500");
            System.out.println("    4)Caramel     |     +2,000");
            System.out.println("    5)exit        |     ");
            System.out.println();

            while (state) {
                System.out.println("뿌릴 시즈닝을 선택해주세요.");
                System.out.println();
                Scanner sa = new Scanner(System.in);
                int choiceS = sa.nextInt();

                switch (choiceS) {
                    case STEAK:
                        product = new SteakSeasoning(product);
                        System.out.println(product.getDescription());
                        System.out.println("current cost : " + product.cost());
                        break;
                    case CHOCO:
                        product = new ChocoSeasoning(product);
                        System.out.println(product.getDescription());
                        System.out.println("current cost : " + product.cost());
                        break;
                    case CHEESE:
                        product = new CheeseSeasoning(product);
                        System.out.println(product.getDescription());
                        System.out.println("current cost : " + product.cost());
                        break;
                    case CARAMEL:
                        product = new CaramelSeasoning(product);
                        System.out.println(product.getDescription());
                        System.out.println("current cost : " + product.cost());
                        break;
                    case EXIT:

                        System.out.println("Thank you, here is your bil");
                        System.out.println("---------------------------");
                        System.out.println("\n\n");
                        counting_seasoning(product);
                        System.out.println("Enjoy it.");
                        System.out.println("\n\n");

                        System.out.println("---------------------------");

                        state = false;
                        //exit(0);
                        break;
                    default:
                        break;
                }
            }
        }else{
            System.out.print(product.getDescription());
            System.out.println(product.cost());
        }
        //return counting_seasoning(product);
    }

    private static void counting_seasoning(Popcorn product) {

        String counting = product.getDescription();
        System.out.println(counting);
        int steak_c = 0;
        int choco_c = 0;
        int cheese_c = 0;
        int caramel_c = 0;
        int whole_c = 0;
        int from_index = 0;
        String whole_s = "Seasoning";
        String steak_s = "SteakSeasoning";
        String choco_s = "ChocoSeasoning";
        String cheese_s = "CheeseSeasoning";
        String caramel_s = "CaramelSeasoning";
        String selected_popcorn = "";

        if (counting.contains("OriginalPopcorn")) {
            selected_popcorn = "OriginalPopcorn";
        } else if (counting.contains("ChocoPopcorn")) {
            selected_popcorn = "ChocoPopcorn";
        } else if (counting.contains("CheesePopcorn")) {
            selected_popcorn = "CheesePopcorn";
        } else if (counting.contains("CaramelPopcorn")) {
            selected_popcorn = "CaramelPopcorn";
        }

        while ((from_index = counting.indexOf(steak_s, from_index)) != -1) {

            steak_c++;
            from_index++;

        }
        from_index = 0;
        while ((from_index = counting.indexOf(choco_s, from_index)) != -1) {

            choco_c++;
            from_index++;

        }

        from_index = 0;
        while ((from_index = counting.indexOf(cheese_s, from_index)) != -1) {

            cheese_c++;
            from_index++;

        }
        from_index = 0;
        while ((from_index = counting.indexOf(caramel_s, from_index)) != -1) {

            caramel_c++;
            from_index++;

        }
        from_index = 0;
        while ((from_index = counting.indexOf(whole_s, from_index)) != -1) {

            whole_c++;
            from_index++;

        }
        System.out.println("선택한 팝콘 : " + selected_popcorn);
        System.out.println("결제 금액   : " + product.cost());
        System.out.println("추가한 시즈닝 개수 :" + whole_c);
        System.out.println("Steak      : " + steak_c);
        System.out.println("Choco      : " + choco_c);
        System.out.println("Cheese     : " + cheese_c);
        System.out.println("Caramel    : " + caramel_c);
        
        
        //return product.cost();
    }
    
    public static int getPopcornPrice(){
        popcornPrice = product.cost();
        return popcornPrice;
    }
}
