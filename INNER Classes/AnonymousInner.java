class PopCorn {
    class VrMall {
        void taste() {
            System.out.println("Salty");
        }
    }
}

public class AnonymousInner {

    public static void main(String[] args) {
        PopCorn.VrMall obj = new PopCorn().new VrMall() {
            void taste() {
                System.out.println("Spicy");
            }
        };
        obj.taste();

        PopCorn.VrMall obj1 = new PopCorn().new VrMall();
        obj1.taste();
    }
}
