

class Outer {
    
}

public class StaticInner01 {
    class SubInner extends Outer{
        void display(){
            System.out.println("hello");
        }
    }
    public static void main(String[] args) {
          StaticInner01.SubInner obj = new StaticInner01().new SubInner();
          obj.display();
    }
}
