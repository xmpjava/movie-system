
import java.util.Scanner;

public class LoginReg {    //用户登入注册类
    final int INIT = 1024;
    User[] user = new User[INIT];
    Scanner scanner = new Scanner(System.in);

    public void reg() {        //用户注册
        int flag = 0;
        System.out.println("\t 欢 迎 注 册 ");
        System.out.println("用户名");
        for (int i = 0; i < INIT; i++) {
            if (user[i] == null) {
                user[i] = new User();
                user[i].name = scanner.next();
                flag = i;
                break;
            }
        }
        System.out.println("密码");
        user[flag].password = scanner.next();
        System.out.println("\t恭喜你！ 注册成功");
    }

    public int login() {         //用户登录
        int flag = 0;
        System.out.println("\t欢 迎 登 陆");
        System.out.println("用户名");
        String n1 = scanner.next();
        System.out.println("密码");
        String n2 = scanner.next();
        for (int i = 0; i < INIT; i++) {
            if (user[i] != null) {
                if (user[i].name.equals(n1) && user[i].password.equals(n2)) {
                    flag = 1;
                    break;
                }
            }
        }
        switch (flag) {
            case 0:
                System.out.println("登陆失败");
                System.out.println("是否重新登录（Y/N）");
                String instr = scanner.next();
                if (instr.equalsIgnoreCase("Y")) {
                    login();
                }
                break;
            case 1:
                System.out.println("登陆成功");

                System.out.println("1.普通用户直接购买\t\t2.充值VIP购买");
                Scanner input = new Scanner(System.in);
                int logReg = input.nextInt();
                switch (logReg) {
                    case 1:
                        MovieUser movieUser=new MovieUser();
                        movieUser.getService();
                        break;
                    case 2:
                        MovieUservip movieUservip =new MovieUservip();
                        movieUservip.getService();
                        break;
                    default:
                        System.out.println("输入错误");
                        break;
                }
            default:
                System.out.println("输入错误");
                login();
                break;
        }
        return flag;
    }
}