package classTes;

public class ClassTest2 {
    public static void main(String[] args){
        animal a = new bird();

    }
}
class animal{
    public void eat(){
        System.out.println("animal can eat");
    };
}

class bird extends animal{
    @Override
    public void eat(){
        System.out.println("bird eat fish");
    }

    private void fly(){
        System.out.println("bird can fly");
    }
}