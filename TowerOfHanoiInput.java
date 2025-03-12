import java.util.Stack;

/*
    We are not able to find the precise answer for Maximum number of disks that can be solved in 60 seconds
    for both recursive and iterative approach. Because its just taking wayy to long to print them. We are only
    able to give out practical results for the max inputs. Sorry. However, this algo below will print out the 
    precise results, but it will take a long time to print them.
 */


class TowerOfHanoiInput {
    // Recursive approach
    public static void solveHanoiRecursive(int n, char source, char auxiliary, char destination) {
        if (n == 1) return;
        solveHanoiRecursive(n - 1, source, destination, auxiliary);
        solveHanoiRecursive(n - 1, auxiliary, source, destination);
    }

    // Iterative approach
    public static void solveHanoiIterative(int n, char source, char auxiliary, char destination) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{n, source, auxiliary, destination});

        while (!stack.isEmpty()) {
            int[] move = stack.pop();
            int disk = move[0];
            if (disk == 1) continue;

            stack.push(new int[]{disk - 1, auxiliary, source, destination});
            stack.push(new int[]{disk - 1, source, destination, auxiliary});
        }
    }

    public static void main(String[] args) {
        int maxRecursive = 0, maxIterative = 0;

        // Benchmark recursive approach
        for (int n = 1; n <= 100; n++) {
            long startTime = System.nanoTime();
            try {
                solveHanoiRecursive(n, 'A', 'B', 'C');
                long endTime = System.nanoTime();
                if ((endTime - startTime) / 1e9 > 60) break; // Stop if execution > 60 sec
                maxRecursive = n;
            } catch (StackOverflowError e) {
                break;
            }
        }

        // Benchmark iterative approach
        for (int n = 1; n <= 100; n++) {
            long startTime = System.nanoTime();
            solveHanoiIterative(n, 'A', 'B', 'C');
            long endTime = System.nanoTime();
            if ((endTime - startTime) / 1e9 > 60) break; // Stop if execution > 60 sec
            maxIterative = n;
        }

        // Print results
        System.out.println("Max Recursive Disks: " + maxRecursive);
        System.out.println("Max Iterative Disks: " + maxIterative);
    }
}