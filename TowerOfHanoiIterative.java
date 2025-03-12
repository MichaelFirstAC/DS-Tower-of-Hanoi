import java.util.Stack;

class Move {
    int disk;
    char from, to;

    Move(int disk, char from, char to) {
        this.disk = disk;
        this.from = from;
        this.to = to;
    }
}

public class TowerOfHanoiIterative {
    public static void solveHanoiIterative(int n, char source, char auxiliary, char destination) {
        Stack<Move> stack = new Stack<>();
        stack.push(new Move(n, source, destination));

        while (!stack.isEmpty()) {
            Move move = stack.pop();

            if (move.disk == 1) {
                System.out.println("Move disk 1 from " + move.from + " to " + move.to);
            } else {
                // Step 3: Move (n-1) disks from auxiliary to destination
                stack.push(new Move(move.disk - 1, auxiliary, move.to));

                // Step 2: Move nth disk from source to destination
                System.out.println("Move disk " + move.disk + " from " + move.from + " to " + move.to);

                // Step 1: Move (n-1) disks from source to auxiliary
                stack.push(new Move(move.disk - 1, move.from, auxiliary));
            }
        }
    }

    public static void main(String[] args) {
        int n = 3; // Number of disks
        solveHanoiIterative(n, 'A', 'B', 'C'); // A = Source, B = Auxiliary, C = Destination
    }
}
