package classTes;

/**
 * 当产生继承关系以后,在子类里面会有一个父类对象,在子类的构造器当中如果什么都不写的话,会默认有一个super()去调用父类的默认构造函数,
 * 在初始化子类的时候,一定要使父类已经存在了(所以要初始化先初始化父类对象).不然没办法调用父类的构造函数.父类必须在子类初始化之前就已经准备好.
 */
public class SubClass extends Parent {

    // 静态变量
    public static String s_StaticField = "子类--静态变量";

    // 变量
    public String s_Field = "子类--变量";

    // 静态初始化块
    static {
        System.out.println(s_StaticField);
        System.out.println("子类--静态初始化块");
    }
    // 初始化块
    {
        System.out.println(s_Field);
        System.out.println("子类--初始化块");
    }

    public static void Fly(){
        System.out.println("父类--Fly");
    }
    // 构造器
    public SubClass() {
        System.out.println("子类--构造器");
        System.out.println("i=" + i + ",j=" + j);
    }

    // 程序入口
    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        Parent p = new SubClass();

        subClass.get();
        Fly();
        Parent.Fly();
    }
}