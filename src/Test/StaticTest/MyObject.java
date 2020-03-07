package Test.StaticTest;

class MyObject {
    private static String str1 = "staticProperty";
    private String str2 = "property";

    public MyObject() {

    }

 

    /* 对于非静态成员方法，它访问静态成员方法/变量显然是毫无限制的*/

    public void print1() {
        System.out.println(str1);
        System.out.println(str2);
        print2();
    }
    // static是程序刚启动的时候 就加加载static进内存
    /* 静态方法中不能访问非静态成员方法和非静态成员变量*/
    //什么时候使用静态？
    // 1. 公共调用.
    // 2. 静态方法调用.
    // java变量或方法都是后期绑定机制的，static是为了实现前期绑定。
    // 当你一个成员变量在全局中多次使用，而且该变量的值是固定的，这个时候就要用到static来声明变量了。
    // 至于为什么呢，因为你在做项目时，内存的合理使用是很重要的，一个变量声明了static 之后，无乱多少个方法调用它，它在内存中只占用了一个内存，而没有声明，一个方法调用一次，它就占用一次内存。
    public static void print2() {
        System.out.println(str1);
        // System.out.println(str2);
        // print1();
    }

    /* main方法中，先创建对象，有对象来调用方法*/
    public static void main(String[] args) {
        MyObject.print2();
        System.out.println("=========");
        MyObject myPro = new MyObject();
        myPro.print1();
    }
}
// 类、对象、方法之间的关系，打个比方，我有个汽车的图纸相当于类，说明汽车要有车身、轮子、方向盘（非静态属性），有个驾驶的功能（非静态方法），你想驾驶汽车。就要根据图纸生产（构建，new）1辆实物汽车（对象\实例），这样你才能实现这个汽车的驾驶功能（调用这个实物汽车的方法），如果给这个汽车的图纸起个品牌名字，和那些实例汽车没什么关系，品牌就是静态的，要有个方法来描述这个品牌，这个方法就要声明为静态的，如果在这个图纸里还有个生产摩托车的方法，和车身、轮子、方向盘没什么关系，那这个方法也可以声明为静态的。

// 1、当一个方法只需要访问这个类的静态属性时
// 2、当一个方法不需要访问这个类的实例对象的属性时