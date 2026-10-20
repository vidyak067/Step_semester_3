package session_five_constructors.assignment_problems;

public class DuplicatePlayerPick {
    static String findDuplicatePick(String[] playerNames) {
        for (int i = 0; i < playerNames.length; i++) {
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        String[] first = {"Kohli", "Bumrah", "Kohli", "Rohit"};
        String[] second = {"Kohli", "Bumrah", "Rohit"};

        System.out.println(findDuplicatePick(first));
        System.out.println(findDuplicatePick(second));
    }
}
