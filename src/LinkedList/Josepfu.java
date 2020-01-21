package LinkedList;

public class Josepfu {
    public static void main(String[] args) {
        //测试遍历
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5); //加入5个小孩节点
        circleSingleLinkedList.showBoy();

    }
}

class CircleSingleLinkedList {
    //创建一个first节点
    private Boy first = null;
    //添加小孩节点，构建一个环形链表
    public void addBoy(int nums) {
        //nums做一个数据校验
        if (nums < 1) {
            System.out.println("nums的值不正确");
            return;
        }
        //辅助指针，帮助构建环形链表
        Boy curBoy = null;
        //使用for循环来创建我们的环形链表
        for(int i = 1; i <= nums; i ++) {
             //根据编号创建小孩节点
            Boy boy = new Boy(i);
            //如果是第一个节点
            if (i == 1) {
                first = boy;
                first.setNext(first); //构建环
                curBoy = first; //让curBoy指向第一个小孩
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    //遍历当前环形链表
    public void showBoy() {
        //判断链表是否为空
        if (first == null){
            System.out.println("没有任何小孩～");
            return;
        }
        //因为first不能动，因此我们仍然使用一个辅助指针完成遍历
        Boy curBoy = first;
        while (true) {
            System.out.printf("小的的编号%d \n", curBoy.getNo());
            if(curBoy.getNext() == first) {
                //说明已经遍历完毕
                break;
            }
            curBoy = curBoy.getNext(); //curBoy后移
        }
    }
}


class Boy {
    private int no;
    private Boy next;
    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}