import java.util.Scanner;

public class MovieUservip extends MovieUser{  //VIP用户类
    private double discount=0.75;
    void getService(){
        System.out.println("充值100送20，可免费观看3次");
        System.out.println("充值500送100，可免费观看5次");
        System.out.println("充值1000送300，可免费观看10次");
        Boolean con = true;
        Scanner scanner=new Scanner(System.in);
        System.out.println("是否需要充值办卡(Y/N)");
        String yesNo = scanner.next();
        if(yesNo.equalsIgnoreCase("Y")){
            System.out.println("请充值");
        }
        if(yesNo.equalsIgnoreCase("N")){
            con = false;
        }
    }
}
