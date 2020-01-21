package LinkedList;

public class Josepfu {
    public static void main(String[] args) {
        //测试遍历
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5); //加入5个小孩节点
        circleSingleLinkedList.showBoy();


        //测试小孩出圈
        circleSingleLinkedList.countBoy(1,2,5); //2->4->1->5->3


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

    //根据用户的输入，计算出小孩出圈的顺序

    /**
     *
     * @param startNo 表示从第几个小孩开始数数
     * @param countNo 表示数几下
     * @param nums 表示最初有多少个小孩在圈中
     */
    public void countBoy(int startNo, int countNo, int nums) {
        //先对数据进行校验
        if (first == null  || startNo < 1 || startNo > nums ) {
            System.out.println("参数输入有误，请重新输入");
            return;
        }
        //创建辅助指针，帮助小孩出圈
        Boy helper = first;
        //需求创建一个辅助指针（变量）helper，事先应该指向环形量表的最后这个节点
        while (true) {
            if (helper.getNext() == first) {  //说明helper指向最后小孩节点
                break;
            }
            helper = helper.getNext();
        }
        //小孩报数前，先让first和helper移动k - 1次
        for (int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //当小孩报数时，让first和helper指针同时移动m-1次，然后出圈
        //这里是一个循环操作，直到圈中只有一个节点
        while (true) {
            if (helper == first) { //说明圈中只有一个节点
                break;
            }
            //让first个helper指针同时移动countNum-1次
            for (int j =0; j < countNo - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //这时first指向的节点，就是要出圈的小孩节点
            System.out.printf("小孩%d出圈\n", first.getNo());
            //这时将first指向的小孩节点出圈
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号是%d \n", first.getNo());

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