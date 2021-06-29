package classTes;

class Parent {
    // 静态变量
    public static String p_StaticField = "父类--静态变量";
    protected int i = 1;
    protected int j = 8;
    // 变量
    public String p_Field = "父类--变量";

    // 静态初始化块
    static {
        System.out.println(p_StaticField);
        System.out.println("父类--静态初始化块");
    }

    // 初始化块
    {
        System.out.println(p_Field);
        System.out.println("父类--初始化块");
    }

    // 构造器
    public Parent() {
        System.out.println("父类--构造器");
        System.out.println("i=" + i + ", j=" + j);
        j = 9;
    }
    public static void Fly(){
        System.out.println("父类--Fly");
    }
    public void get(){

    }
}

