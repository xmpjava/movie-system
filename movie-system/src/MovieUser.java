import java.util.ArrayList;
import java.util.Scanner;

public class MovieUser extends BookTicket{   //普通用户类

    void getService(){
        System.out.println("您可免费享用一杯可乐");
    }

    public  static void booking(ArrayList<Movie> array){
        Scanner scanner=new Scanner(System.in);
        Boolean con = true;
        int index = 0;
        int[] flag = {-1,-1,-1,-1,-1,-1,-1,-1};
        do {

            System.out.println("\t\t欢迎订票");
            System.out.println("请输入电影编号");
            String  buy=scanner.nextLine();

            for (int i = 0; i < array.size(); i++) {
                Movie movie6=array.get(i);
                if (movie6.getNumber().equals(buy))
                {
                    flag[index] = i;
                    break;
                }
            }
            if (flag[index] == -1) {
                System.out.println("\t\t编号输入错误(找不到您要的电影)");
            } else {
                System.out.println("\t\t订票成功");
                System.out.println("电影编号\t电影名\t\t上映时间\t\t电影票价");
                for (int i = 0; i < array.size(); i++) {
                    Movie movie7 = array.get(i);
                    System.out.println(movie7.getNumber() + "\t\t"+movie7.getMovieName() + "\t"+movie7.getMovieTime()+"\t\t" + "$" +movie7.getMoviePrice());
                    index++;
                }
            }
            System.out.println("是否需要继续订票(Y/N)");

            String yesNo = scanner.next();
            if (yesNo.equalsIgnoreCase("N"))
                con = false;
            if (index >= array.size()) {
                System.out.println("已经没有可预订的票");
                con = false;
            }
        }
        while (con);
        int add = 0;
        int sign = 0;
        for (index = 0; index < 5; index++) {
            Movie movie8 = array.get(index);
            if (flag[index] != -1) {
                add += movie8.getMoviePrice();
                sign++;
            }
        }
        System.out.println("你一共订了" + sign + "张票" + "一共￥" + add + "元");
    }
}
