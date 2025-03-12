import java.util.Stack;

class Move {
    int disk; // Disk number
    char from, to; // Source and destination poles

    // Constructor to create a new move object
    Move(int disk, char from, char to) {
        this.disk = disk; // Disk number
        this.from = from; // Source pole
        this.to = to; // Destination pole
    } 
}

public class TowerOfHanoiIterative { 
    public static void solveHanoiIterative(int n, char source, char auxiliary, char destination) { 
        Stack<Move> stack = new Stack<>(); // Stack to store moves
        stack.push(new Move(n, source, destination)); // Push initial move to stack

        while (!stack.isEmpty()) { // While stack is not empty
            Move move = stack.pop(); // Pop the top move from stack

            if (move.disk == 1) { // If only one disk, move it from source to destination
                System.out.println("Move disk 1 from " + move.from + " to " + move.to); // Move disk 1 from source to destination
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
