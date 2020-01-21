package LinkedList;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        System.out.println("双向链表的测试");

        //创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(3, "卢俊义", "王麒麟");
        HeroNode2 hero3 = new HeroNode2(4, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(7, "林冲", "豹子头");
        HeroNode2 hero5 = new HeroNode2(9, "何文勇", "勇哥");

        //创建链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();


        //加入按照编号顺序
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero4);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero5);

        doubleLinkedList.list();

        //删除
        doubleLinkedList.del(3);
        System.out.println("删除后的链表情况");
        doubleLinkedList.list();

    }
}

class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}' + "\n";
    }

}

class DoubleLinkedList {
    //初始化节点
    private HeroNode2 head = new HeroNode2(0, "", "");

    //返回头节点
    public HeroNode2 getHead() {
        return head;
    }

    //遍历双向链表的方法
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，因此我们需要一个辅助变量来遍历
        HeroNode2 temp = head.next;
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将temp后移
            temp = temp.next;

        }

    }

    public void add(HeroNode2 heroNode) {
        //因为head节点不能动，因此我们需要一个辅助遍历temp
        HeroNode2 temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                break;
            }

            temp = temp.next;
        }


        //当退出while循环时，temp就指向了链表的最后
        //形成一个双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }


    //双向链表节点的修改和单向链表几乎一样
    public void update(HeroNode2 newHeroNode) {
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表不能为空～");
            return;
        }

        //找到需要修稿的节点，根据no编号
        //定义一个辅助变量
        HeroNode2 temp = head.next;
        boolean flag = false; //表示是否找到该节点
        while (true) {
            if (temp == null) {
                System.out.println("链表为空～");
                break;//已经遍历完链表
            }

            if (temp.no == newHeroNode.no) {
                //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到要修改的节点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else { //没有找到
            System.out.printf("没有找到编号%d的节点，不能修改\n", newHeroNode.no);
        }
    }

    //从双向链表种删除一个节点
    //说明
    //1. 对于双向链表，我们可以直接找到要删除的这个节点
    //2. 找到以后，自我删除即可
    public void del(int no) {
        //判断当前链表是否为空
        if (head.next == null) {
            System.out.println("链表为空，无法删除");
            return;
        }

        HeroNode2 temp = head.next; //辅助指针
        boolean flag = false; //标记是否找到待删除的接待你
        while (true) {
            if (temp == null) { //已经到链表的最后
                flag = true;
                break;
            }
            temp = temp.next; //temp后移，遍历
            if (temp.no == no) {
                //找到待删除节点的前一个节点temp
                flag = true;
                break;
            }
        }
        if (flag) { //找到
            //可以删除
            //这里的代码有问题？
            //如果是最后一个节点，就不需要执行下面这句话，否则就出现空指针异常

            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("您要删除的%d数据不存在\n", no);
        }
    }
}
