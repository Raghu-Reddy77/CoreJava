
interface Outer {
    void m1();
    interface inner{
        void m2();
    }
    abstract class A implements inner{
       public void m2(){
            System.out.println("inner");
        }
    }
    class B extends A{

    }
}

public class InterfaceInside {
    public static void main(String[] args) {
        Outer.A obj=new Outer.B();
        obj.m2();
    }
}
