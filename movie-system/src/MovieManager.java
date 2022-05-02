
import java.util.ArrayList;
import java.util.Scanner;

public class MovieManager{   //管理员类
    public MovieManager(){
        ArrayList<Movie> array=new ArrayList<>();
        Movie moviea=new Movie("S0","雷神3:诸神黄昏",
                "2017-11-03大陆上映",35);
        Movie movieb=new Movie("S1","全球风暴",
                "2017-10-27大陆上映",45);
        Movie moviec=new Movie("S2","我和我的祖国",
                "2020-11-03大陆上映",40);
        Movie movied=new Movie("S3","门锁",
                "2021-11-19大陆上映",45);
        Movie moviee=new Movie("S4","梅艳芳",
                "2021-11-12大陆上映",40);
        Movie movief=new Movie("S5","铁道英雄",
                "2021-11-19大陆上映",40);
        Movie movieg=new Movie("S6","扬名立万",
                "2021-11-11大陆上映",40);
        Movie movieh=new Movie("S7","你的世界没有我",
                "2021-12-3大陆上映",45);
        array.add(moviea);
        array.add(movieb);
        array.add(moviec);
        array.add(movied);
        array.add(moviee);
        array.add(movief);
        array.add(movieg);
        array.add(movieh);
        while (true){
            System.out.println("---欢迎来到管理员系统---");
            System.out.println("1.添加电影");
            System.out.println("2.删除电影");
            System.out.println("3.修改电影");
            System.out.println("4.查看电影");
            System.out.println("5.退出");
            System.out.println("请输入您的选择:");

            Scanner scanner=new Scanner(System.in);
            String s=scanner.nextLine();

            switch (s){
                case "1":
                    addStudent(array);
                    break;
                case "2":
                    deleteStudent(array);
                    break;
                case "3":
                    changeStudent(array);
                    break;
                case "4":
                    searchStudent(array);
                    break;
                case "5":
                    System.out.println("---退出---");
                    System.out.println("谢谢使用");
                    Main main=new Main();
                    main.interFace();
                    main.login();
                    main.booking();
                    System.exit(0);
                    break;
                case "#":
                    booking(array);
                    break;
            }
        }
    }

    public static void addStudent(ArrayList<Movie>array){
        Scanner sc=new Scanner(System.in);
        int index=-1;
        String number="";
        while (true) {
            System.out.println("请输入电影号：");
            String Number = sc.nextLine();
            for (int i = 0; i < array.size(); i++) {
                Movie movie1 = array.get(i);
                if (movie1.getNumber().equals(Number)) {
                    index = i;
                }
            }
            if (index != -1) {
                System.out.println("电影号已存在，请重新输");
                index = -1;
            } else {
                number = Number;
                break;
            }
        }
        System.out.println("请输入电影名称");
        String name= sc.nextLine();
        System.out.println("请输入电影上映时间");
        String time= sc.nextLine();
        System.out.println("请输入电影价格");
        int price= sc.nextInt();

        Movie movie1=new Movie();
        movie1.setNumber(number);
        movie1.setMovieName(name);
        movie1.setMovieTime(time);
        movie1.setMoviePrice(price);

        array.add(movie1);
        System.out.println("添加成功,请查看");
    }

    public static void deleteStudent(ArrayList<Movie>array){
        System.out.println("请输入想要删除的电影号：");
        Scanner scanner=new Scanner(System.in);
        String n=scanner.nextLine();
        int index=-1;
        for (int i=0;i< array.size();i++){
            Movie movie2=new Movie();
            movie2=array.get(i);
            if(movie2.getNumber().equals(n)){
                index=i;
                array.remove(i);
                System.out.println("删除成功");
                break;
            }
        }
        if(index!=-1){
            System.out.println("该电影不存在，请重新输入");
        }
    }

    public static void changeStudent(ArrayList<Movie>array){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入修改的电影号：");
        String  c=scanner.nextLine();
        int index=-1;
        for (int i=0;i< array.size();i++){
            Movie movie3=array.get(i);
            if(movie3.getNumber().equals(c)){
                index=i;
                System.out.println("请输入修改后的电影号");
                movie3.setNumber(scanner.nextLine());
                System.out.println("请输入修改后的电影名称");
                movie3.setMovieName(scanner.nextLine());
                System.out.println("请输入修改后的电影上映时间");
                movie3.setMovieTime(scanner.nextLine());
                System.out.println("请输入修改后的电影价格");
                movie3.setMoviePrice(scanner.nextInt());
                System.out.println("修改成功请查看！");
            }else{
                System.out.println("电影号存在");
            }
        }
        if(index==-1){
            System.out.println("该电影不存在");
        }
    }

    public static void searchStudent(ArrayList<Movie>array) {
        if (array.size() == 0) {
            System.out.println("请先添加电影信息");
            return;
        }
        System.out.print("电影号\t\t\t\t电影名称\t\t\t\t电影上映时间\t\t\t\t" + "电影价格" + "\n");

        for (int i = 0; i < array.size(); i++) {
            Movie movie4 = array.get(i);
            System.out.println(movie4.getNumber() + "\t\t\t\t" + movie4.getMovieName() + "\t\t\t\t" + movie4.getMovieTime() + "\t\t\t\t" +
                    movie4.getMoviePrice());
        }
    }

    public  static void booking(ArrayList<Movie>array){
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
