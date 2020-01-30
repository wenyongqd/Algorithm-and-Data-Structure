package hashtab;

import java.util.Scanner;

public class HashTabDemo {
    public static void main(String[] args) {

        //创建哈希表
        HashTab hashTab = new HashTab(7);

        //写一个简单的额菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("exit: 退出系统");

            key = scanner.next();

            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    //创建雇员
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);

                default:
                    break;

            }
        }

    }

}

class HashTab {
    private EmpLinkedList[] empLinkedListArray;
    private int size;  //表示共有多少条链表

    //构造器
    public HashTab(int size) {
        empLinkedListArray = new EmpLinkedList[size];
        //?留一个坑, 这时不要忘了分别初始化每条链表
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }

    }

    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list();
        }
    }

    //添加雇员
    public void add(Emp emp) {
        //根据员工的id，得到该员工应当添加到哪条链表
        int empLinkedListNO = hashFun(emp.id);
        //将emp添加到对应的链表中
        empLinkedListArray[empLinkedListNO].add(emp);
    }

    //编写散列函数，使用一个简单取模法
    public int hashFun(int id) {
        return id % size;
    }
}

class Emp {
    public int id;
    public String name;
    public Emp next; //next默认为null



    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}

//创建EmpLinkedList, 表示链表
class EmpLinkedList {
    //头指针，执行第一个Emp，因此我们这个链表head】，是直接指向第一个Emp
    private Emp head;  //默认null

    //添加雇员到列表
    //说明
    //1. 假定，当添加雇员时，id是自增长，即id的分配总是从小到大
    //  因此我们将该雇员直接加入到本链表的最后即可

    public void add(Emp emp) {
        //如果是添加第一个雇员
        if (head == null) {
            head = emp;
            return;
        }
        //如果不是第一个雇员，则使用一个辅助指针
        Emp curEmp = head;
        while (true) {
            if (curEmp.next == null) {  //说明到链表最后
                break;
            }
            curEmp = curEmp.next;
        }

        //退出时，直接将emp加入链表
        curEmp.next = emp;
    }

    //遍历链表的雇员信息
    public void list() {
        if (head == null) {
            System.out.println("当前链表为空");
            return;
        }
        System.out.println("当前链表的信息为");
        Emp curEmp = head; //辅助指针
        while (true) {
            System.out.printf("=> id=%d name=%s\t", curEmp.id, curEmp.name);
            if (curEmp.next == null) { //说明curEmp已经是到最后
                break;
            }
            curEmp = curEmp.next; //后移，遍历
        }
        System.out.println();
    }

}
