package kvx.jcandy;

public class CommonConstant {
    
    // Days
    public enum Days {

        SUNDAY(0),
        MONDAY(1),
        TUESDAY(2),
        WEDNESDAY(3),
        THURSDAY(4),
        FRIDAY(5),
        SATURDAY(6);

        private final int value;

        Days(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }

}
