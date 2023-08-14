class Test {
    int x = 10;

    public void methodOne() {
        int y = 20; // y is effectively final
        class Inner {
            public void methodTwo() {
                System.out.println(x); // 10
                System.out.println(y); // 20
            }
        }
        Inner i = new Inner();
        i.methodTwo();
    }

    public static void main(String[] args) {
        new Test().methodOne();
    }
}