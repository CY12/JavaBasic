package map;

public class Student {
    private int age;
    private String name;

    public Student() {
        System.out.println("Student 初始化");
    }
    public Student(String name) {
        System.out.println("Student 初始化 "+name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        System.out.println("name.hashCode()"+name.hashCode());
        int result = 17;
        result = 31 * result + (name == null ? 0 : name.hashCode());
        result = 31 * result + age;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;//地址相等
        }
        if (obj == null){
            return false;
        }

        if (obj instanceof Student){
            Student student = (Student)obj;
            if (student.age == this.age && student.name.equals(this.name)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
