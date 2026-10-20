package session_seven_encapsulation.class_problems;

public class Locker {
    private final int lockerNumber;
    private String code;

    public Locker(int lockerNumber, String code) {
        this.lockerNumber = lockerNumber;
        this.code = code;
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (!code.equals(currentCode)) {
            return false;
        }
        code = newCode;
        return true;
    }

    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");

        if (l.changeCode("1234", "5678")) {
            System.out.println("Change with correct code: success");
        }

        if (!l.changeCode("0000", "9999")) {
            System.out.println("Change with wrong code: rejected");
        }

        if (l.changeCode("5678", "1111")) {
            System.out.println("Code was still 5678, so this change worked");
        }
    }
}
