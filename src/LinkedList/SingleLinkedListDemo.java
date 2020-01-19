package LinkedList;

public class SingleLinkedListDemo {

    public static void main(String[] args) {

        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(3, "卢俊义", "王麒麟");
        HeroNode hero3 = new HeroNode(4, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(7, "林冲", "豹子头");
        HeroNode hero5 = new HeroNode(9, "何文勇", "勇哥");

        //创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();


        //加入按照编号顺序
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero5);




//        //加入
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero4);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero5);

        singleLinkedList.list();

        //测试修改节点的代码
        HeroNode newHeroNode = new HeroNode(3,"小卢","玉麒麟");
        singleLinkedList.update(newHeroNode);

        //删除一个节点
        singleLinkedList.del(9);

        //显示
        singleLinkedList.list();
        //测试一下，求单链表中有效节点的个数
        System.out.println(getLength(singleLinkedList.getHead()));

        //测试一下看看是否得到了倒数第K个元素
        System.out.println(findLastIndexNode(singleLinkedList.getHead(), 4));

    }


    //定义HeroNode，每个HeroNode对象就是一个节点
    //求单链表中有效节点的个数(如果是带头节点的链表，需要不统计头节点)
    public static int getLength(HeroNode head) {
        if(head.next == null) { //空链表
            return 0;
        }
        int length = 0;
        //定义一个辅助的变量
        HeroNode cur = head.next;
        while(cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    //查找单链表中的倒数第k个节点
    //1.编写一个方法，接收head节点，同时接收index
    //2.index表示是倒数第index个节点
    //3.先把链表从头到尾遍历，得到链表的总长度getLength()
    //4.得到size后，我们从链表的第一个开始遍历(size - index)个，就可以得到
    //5.如果得到了返回该节点，否则返回空
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        if(head.next == null){
            return null;
        }


        HeroNode cur = head.next;
        int length = getLength(head);
        if(index > length || index < 0) {

            return null;
        }
        for(int i = 0; i < length - index; i++ ) {
            cur = cur.next;
        }

        return cur;
    }


}

class SingleLinkedList {
    //先初始化一个头节点，头节点不要动，不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }
    //添加节点到单向链表
    //思路：当不考虑编号顺序时
    //1。找到当前链表的最后节点
    //2。将最后这个节点的next指向新的节点

    public void add(HeroNode heroNode) {
        //因为head节点不能动，因此我们需要一个辅助遍历temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                break;
            }

            temp = temp.next;
        }


        //当退出while循环时，temp就指向了链表的最后
        //将最后这个节点的next指向新的节点
        temp.next = heroNode;
    }


    //根据newHeroNode的no来修改节点
    public void update(HeroNode newHeroNode) {
        //判断是否为空
        if(head.next == null) {
            System.out.println("链表不能为空～");
            return;
        }

        //找到需要修稿的节点，根据no编号
        //定义一个辅助变量
        HeroNode temp = head.next;
        boolean flag = false; //表示是否找到该节点
        while(true) {
            if(temp == null) {
                System.out.println("链表为空～");
                break;//已经遍历完链表
            }

            if(temp.no == newHeroNode.no) {
                //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到要修改的节点
        if(flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else { //没有找到
            System.out.printf("没有找到编号%d的节点，不能修改\n", newHeroNode.no);
        }
    }

    //删除节点
    //思路
    //1. head不能动，因此我们需要一个temp辅助节点找到待删除节点的前一个节点
    //2. 说明我们在比较时，是temp.next.no和需要删除节点的no比较
    public void del(int no) {
        HeroNode temp = head;
        Boolean flag = false; //标记是否找到待删除的接待你
        while (true) {
            if(temp.next == null) { //已经到链表的最后
                break;
            }
            if(temp.next.no == no) {
                //找到待删除节点的前一个节点temp
                flag = true;
                break;

            }
            temp = temp.next; //temp后移，遍历
        }
        if(flag) { //找到
            //可以删除
            temp.next = temp.next.next;
        } else {
            System.out.printf("您要删除的%d数据不存在\n", no);
        }
    }



    //显示链表[遍历]
    public void list() {
        //判断链表是否为空
        if(head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
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


    //第二种方式在添加英雄时，根据排名将英雄加入到指定位置
    //将最后这个节点的next指向新的节点
    public void addByOrder(HeroNode heroNode) {
        //因为节点不能动，因此我们仍然通过一个辅助指针（变量）来帮助找到添加的位置
        //因为单链表，因此我们找的temp是位于添加位置的前一个节点，否则添加不了
        HeroNode temp = head;
        boolean flag = false;//flad标志添加的编号是否存在，默认为false
        while (true) {
            if (temp.next == null) {//说明temp已经在链表的最后
                break;
            }
            if(temp.next.no > heroNode.no) {//位置找到，就在temp的后面插入
                break;
            }
            else if (temp.next.no == heroNode.no) {//说明希望添加的heroNode的编号已然存在
                flag = true;//说明编号存在
                break;
            }
            temp = temp.next;

        }
        if(flag) {
            System.out.printf("准备插入的英雄编号%d 已经存在了，不能加入\n", heroNode.no);
        }else {
            //插入到链表中，temp的后面
            heroNode.next= temp.next;
            temp.next = heroNode;
        }
    }
}

class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next; //指向下一个节点

    //构造器

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    //为了显示方便，我们重新toString

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}' + "\n";
    }
}
