import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    Scanner scanner=new Scanner(System.in);
    ArrayList<Movie> array=new ArrayList<>();
    LoginReg loginReg =new LoginReg();

    public void interFace(){//订票界面
        System.out.println("\t\t\t**************************");
        System.out.println("\t\t\t\t\t影院订票系统");
        System.out.println("\t\t\t**************************");
        System.out.println("------------------------------------------------");
        System.out.println("电影编号\t\t电影名\t\t上映时间\t\t电影票价");
        for (int i = 0; i < array.size(); i++) {
            Movie movie5 = (Movie) array.get(i);
            System.out.println(movie5);
        }
        System.out.println("------------------------------------------------");
    }

    public void login(){//登录注册
        Movie movie1=new Movie();
        System.out.println("1.登陆\t\t2.注册\t\t3.管理员登录");
        Scanner input = new Scanner(System.in);
        int logReg = input.nextInt();
        switch (logReg) {
            case 1:
                if (loginReg.login() == 0)
                    login();
                break;
            case 2:
                loginReg.reg();
                login();
                break;
            case 3:
                MovieManager movieManager=new MovieManager();
                for(int i=0;i<array.size();i++){
                    Movie movie =(Movie) array.get(i);
                }
                break;
            default:
                System.out.println("输入错误");
                login();
        }
    }

    public  void booking(){// 订票
        Boolean con = true;
        int index = 0;
        int[] flag = {-1,-1,-1,-1,-1,-1,-1,-1};
        do {
            System.out.println("\t\t欢迎订票");
            System.out.println("请输入电影编号");
            String buy=scanner.nextLine();
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
            } else{
                System.out.println("\t\t订票成功");
                System.out.println("电影编号\t电影名\t\t上映时间\t\t电影票价");
                for(int i = 0; i < array.size(); i++) {
                    Movie movie7 = array.get(i);
                    System.out.println(movie7.getNumber() + "\t\t"+movie7.getMovieName() + "\t"+movie7.getMovieTime()+"\t\t" + "$" +movie7.getMoviePrice());
                    index++;
                }
            }
            System.out.println("是否需要继续订票(Y/N)");
            String yesNo = scanner.next();
            if (yesNo.equalsIgnoreCase("N"))
                con = false;
            if (yesNo.equalsIgnoreCase("N")) {
                System.out.println("已经没有可预订的票");
                con = false;
            }
        }
        while (con);
        int add = 0;
        int sign = 0;
        for (index = 0; index <5; index++) {
            Movie movie8 = array.get(index);
            if (flag[index] != -1) {
                add += movie8.getMoviePrice();
                sign++;
            }
        }
        System.out.println("你一共订了" + sign + "张票" + "一共￥" + add + "元");
    }
    public void init() {
        interFace();
// 界面
        login();
// 用户登陆、注册
        booking();
// 订票
    }
}
