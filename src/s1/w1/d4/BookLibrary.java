package s1.w1.d4;

import java.util.ArrayList;

class Book {
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle() { return title; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return "《" + title + "》 " + author + " ￥" + price;
    }
}

public class BookLibrary {
    private ArrayList<Book> books = new ArrayList<>();

    // 增
    public void add(Book b) {
        books.add(b);
    }

    // 查：按书名找，找到返回下标，找不到返回 -1
    public int findByTitle(String title) {
        // TODO-1：普通 for + equals 比较书名（比内容用 equals！）
        for(int i = 0 ; i < books.size() ; i ++ ){
            if(books.get(i).getTitle().equals(title)){
                return i ;
            }
        }
        return -1;
    }

    // 删：按书名删，删成功返回 true
    public boolean removeByTitle(String title) {
        // TODO-2：先 findByTitle 拿下标，下标合法就 books.remove(下标) 返回 true
        //         （体会：数组版要自己写挪位循环，ArrayList 一行搞定）
        int i = findByTitle(title);  //不可以写books.findByTitle(),因为books是ArrayList，没有这个方法
        //也不是BookLibrary.findByTitle(...)，这是调静态方法的语法
        //正确写发就是在当前这个对象上找方法。
        if(i >= 0){
            books.remove(i) ;
            return true;
        }else return false;
    }

    // 显示全部
    public void listAll() {
        if (books.isEmpty()) {
            System.out.println("（书架是空的）");
            return;
        }
        // TODO-3：增强 for 打印每本书（println 一个 Book 会自动调它的 toString）
        for(var v : books){
            System.out.println(v);
        }
    }

    public static void main(String[] args) {
        BookLibrary lib = new BookLibrary(); //lib是图书馆名，是不可以被便利的。
        //他里面有books数组才可以被便利
        lib.add(new Book("Java 核心技术", "Cay", 149.0));
        lib.add(new Book("算法图解", "Aditya", 49.0));

        System.out.println("--- 全部 ---");  lib.listAll();
        System.out.println("《算法图解》的下标 = " + lib.findByTitle("算法图解"));   // 1

        lib.removeByTitle("Java 核心技术");
        System.out.println("--- 删后 ---");  lib.listAll();

        // TODO-4：调用 listAll 前把剩下的也删掉，验证空书架的输出
        lib.removeByTitle("算法图解");
//        for(var v : lib){
//            lib.removeByTitle(v.getTitle());
//        } lib是图书馆名，是不可以被便利的。
//        他里面有books数组才可以被遍历
//        增强 for 底层悄悄用了一个 Iterator。这个迭代器有个安保机制：每走一步都会检查"列表在我开始遍历后有没有被偷偷改过"。你这一删，列表结构变了 → 它立刻抛 ConcurrentModificationException（并发修改异常）。
//
//        所以"遍历一个列表的同时从它里面删元素"，是 Java 里一个经典雷区，普通 for-each 做不到。
        System.out.println("--- 清空后 ---");
        lib.listAll();
    }
}
