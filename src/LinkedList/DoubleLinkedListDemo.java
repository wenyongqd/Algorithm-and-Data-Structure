package LinkedList;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {

    }
}

class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;

    class DoubleLinkedList {
        //初始化节点
        private HeroNode2 head = new HeroNode2(0,"","");
        //返回头节点
        public HeroNode2 getHead() {
            return head;
        }

        //遍历双向链表的方法
        public void list() {
            //判断链表是否为空
            if(head.next == null) {
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
    }


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
