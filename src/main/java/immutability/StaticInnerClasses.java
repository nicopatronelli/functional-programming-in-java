package immutability;

// https://stackoverflow.com/questions/16147405/whats-the-advantage-of-making-an-inner-class-as-static-with-java#:~:text=If%20the%20nested%20class%20does,to%20use%20the%20nested%20class.
public class StaticInnerClasses {
    private int state;
    public static void main(String[] args) {

    }

    class Pokemon {
        private int number;
        private String name;

        public void m() {
            state = state * 2;
        }
    }
}
