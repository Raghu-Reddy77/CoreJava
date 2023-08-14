class Outer{
    void display(){
        System.out.println("Outer classs");
    }
    class Inner{
        static int a=10;
        void display(){
            System.out.println("Innerclass");
            System.out.println(a);
        }
    }

    class ChildInner extends Inner{
        void geetings(){
            System.out.println("hello ChildInnerclass");
        }
    }
}
public class memberstatic {
    public static void main(String[] args) {
        Outer.Inner obj=new Outer().new Inner();
        obj.display();

        Outer.ChildInner obj1ChildInner = new Outer().new ChildInner();
        obj1ChildInner.geetings();
    }
}
