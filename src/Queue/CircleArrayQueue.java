import java.net.PortUnreachableException;
import java.security.PublicKey;
import java.util.Scanner;

public class CircleArrayQueue {

    public static void main(String[] args) {
        System.out.println("测试数组模拟环形队列的案例～～");
        //创建一个队列
        CircleArray circleArray = new CircleArray(5);
        char key = ' '; //接受用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头部");
            key = scanner.next().charAt(0); //接收一个字符

            switch (key) {
                case 's':
                    circleArray.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    circleArray.addQueue(value);
                    break;
                case 'g': //取出数据
                    try {
                        int res = circleArray.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = circleArray.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }

        }

        System.out.println("程序退出");

    }
}

class CircleArray {
    private int maxSize;
    private int front; //front指向队列的第一个元素，front的初始值=0
    private int rear; //指向队列的最后一个元素的后一个位置，rear的初始值=0
    private int[] arr; //该数据用于存放数据，模拟队列

    public CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    //判断是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;

    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满，不能加入数据～");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize; //如果直接（rear+1）的话数组可能越界
    }

    //取出数据,出队列
    public int getQueue() {
        //判断是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取出数据～");
        }
        //1.先将front对应的值保存到一个临时变量
        //2.将front后移,考虑取模
        //3.将临时保存的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //显示队列数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空的，没有数据～");
            return;
        }
        //思路：从front开始遍历，遍历多少个元素
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }

    }

    //显示头元素
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据～");
        }
        return arr[front];
    }


    //求出当前队列有效数据的个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

}