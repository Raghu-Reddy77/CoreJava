public class MethodLocalInner {

    public void name() {
        System.out.println("hello world");
        class InnerMethodLocalInner {
            public void display() {
                System.out.println("display method");
            }
        }
        InnerMethodLocalInner obj = new InnerMethodLocalInner();
        obj.display();
    }

    public static void main(String[] args) {
         new MethodLocalInner().name();
    }
}
