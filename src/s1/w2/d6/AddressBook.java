package s1.w2.d6;

import java.util.*;

public class AddressBook {
    static Map <String, Map.Entry<String,String>> map = new HashMap<>() ;
    //这个不会定义Map.Entry,这个就跟c++的pair差不多
    //要把它写成静态的，就是归属于这个类，所有对象公用一份
    //没用static的话后面的对象每次要用都要自己new一份给自己用
    public static void printMenu(){
                System.out.println("========== 简易通讯录 ==========\n" +
                        "1. 添加联系人\n" +
                        "2. 按姓名查找\n" +
                        "3. 按姓名删除\n" +
                        "4. 显示全部（按姓名升序）\n" +
                        "5. 退出\n" +
                        "================================\n" +
                        "请选择（1-5）：");
    }

    public static void addContact(Scanner sc) {
        System.out.println("请按该格式输入信息:姓名,电话,邮箱");
        String str = sc.nextLine();
        String name , number , email ;
        String[] parts = str.split(",") ;
        if (parts.length != 3) {
            System.out.println("格式不对！请按 姓名,电话,邮箱 输入");
            return;
        }
        //加个格式校验
        name = parts[0] ;
        number = parts[1] ;
        email = parts[2] ;
        //这个也是查的，只要分离要用split，但是不知道要先用一个字符串数组分来，然后在一个个保存
        if(map.get(name) != null ){
            System.out.println("该联系人已存在，是否覆盖？(y/n)");
            String c = sc.next();
            if(c.equals("y")) {
                //不可以用== ，string里面==比的是地址
                map.put(name,Map.entry(number,email)) ;
                System.out.println("覆盖成功");
            }
            //存入entry得用Map.entry(number,email)
        }
        else {
            map.put(name,Map.entry(number,email)) ;
            System.out.println("添加成功");
        }
    }

    public static void findContact(Scanner sc) {
        System.out.println("请输入姓名：");
        String name = sc.next() ;
        if(map.get(name) != null) System.out.println("姓名："+name+"电话："+map.get(name).getKey()+"邮箱："+map.get(name).getValue());
        else System.out.println("未找到");
    }

    public static void deleteContact(Scanner sc) {
        System.out.println("请输入姓名：");
        String name = sc.next() ;
        if(map.get(name) != null) {
            System.out.println("确定删除" + name + "吗？(y/n)");
            String op = sc.next() ;
            if(op.equals("y")){
                map.remove(name) ;
                System.out.println("删除成功");
            }
            //忘记删除方法了

        }
        else System.out.println("未找到");
    }

    public static void showAll() {
        Map <String,Map.Entry<String,String>> mp = new TreeMap<>(map) ;

//        Map <String,Map.Entry<String,String>> mp = new TreeMap<>((a,b) -> a.compareTo(b)) ;
        for(var v : mp.entrySet()){
            System.out.println("姓名：" + v.getKey()
                    + "  电话：" + v.getValue().getKey()
                    + "  邮箱：" + v.getValue().getValue());
        }
        //输出学习一下
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in) ;
        while(true){
            printMenu() ;
            int choice = sc.nextInt() ;
            sc.nextLine() ; // 吃掉换行
            switch (choice){
                case 1: addContact(sc); break;
                case 2: findContact(sc); break;
                case 3: deleteContact(sc); break;
                case 4: showAll(); break;
                case 5: System.out.println("再见"); return;
                default: System.out.println("无效选项");
            }
        }
    }
}
