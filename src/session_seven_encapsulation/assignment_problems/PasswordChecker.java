package session_seven_encapsulation.assignment_problems;

public class PasswordChecker {
    private final String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        if (password.length() < 6) {
            return "Weak";
        } else if (password.length() < 10) {
            return "Medium";
        }
        return "Strong";
    }

    public static void main(String[] args) {
        PasswordChecker pc = new PasswordChecker("abcd");
        System.out.println(pc.getStrength());

        PasswordChecker pc2 = new PasswordChecker("abcdefgh");
        System.out.println(pc2.getStrength());

        PasswordChecker pc3 = new PasswordChecker("abcdefghij");
        System.out.println(pc3.getStrength());
    }
}
