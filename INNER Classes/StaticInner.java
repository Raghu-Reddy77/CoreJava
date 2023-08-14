class Outer{
    class Inner{
        static void hello(){
            System.out.println("hello from inner class");
        }
    }
}



public class StaticInner {
    public static void main(String[] args) {
        Outer.Inner.hello(); // static we can access directly 
    }
}
