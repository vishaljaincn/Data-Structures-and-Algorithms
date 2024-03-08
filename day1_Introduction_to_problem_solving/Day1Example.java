package day1_Introduction_to_problem_solving;

class Day1Example {
    // Member variable to count factors
    int count = 0;

    /**
     * Method to count factors of a number and print them.
     * Time complexity: O(sqrt(n))
     *
     * @param n The number to count factors for.
     * @return The count of factors.
     */
    int countFactors(int n) {
        for (int i = 1; i * i <= n; i++) {
            // Check if i is a factor of n
            if (n % i == 0) {
                // If i is the only factor, increment count and print i
                if (i == n / i) {
                    count++;
                    System.out.println(i);
                } else {
                    // If i and n/i are factors, increment count by 2 and print both
                    count = count + 2;
                    System.out.println(i + " " + n / i);
                }
            }
        }
        return count;
    }

    /**
     * Method to check if a number is prime.
     * Time complexity: O(sqrt(n))
     *
     * @param n The number to check for primality.
     * @return True if the number is prime, false otherwise.
     */
    boolean checkPrime(int n) {
        // Call countFactors to get the count of factors
        int a = countFactors(n);
        // If the count is 2, the number is prime
        if (a == 2) {
            return true;
        }
        return false;
    }

    /**
     * Method to find the square root of a perfect square.
     * Time complexity: O(sqrt(n))
     *
     * @param n The perfect square for which to find the square root.
     * @return The square root of the perfect square, or -1 if n is not a perfect square.
     */
    int squareRootOfAPerfectSquare(int n) {
        for (int i = 1; i * i <= n; i++) {
            // Check if i is the square root of n
            if (i * i == n) {
                return i;
            }
        }
        // Return -1 if n is not a perfect square
        return -1;
    }

    /**
     * Method to find the square root of a non-perfect square.
     * Time complexity: O(sqrt(n))
     *
     * @param n The non-perfect square for which to find the square root.
     * @return The floor value of the square root of the non-perfect square.
     */
    int squareRootOfANonPerfectSquare(int n) {
        int ans = 0;
        for (int i = 1; i * i <= n; i++) {
            // Update ans to the latest value of i
            ans = i;
        }
        return ans;
    }

    /**
     * Method to count the number of times a number needs to be divided by 2 until the quotient is 1.
     * Time complexity: O(log(n))
     *
     * @param n The number for which to count the divisions.
     * @return The count of divisions needed.
     */
    int countNoOfTimesWeNeedToDivideGivenNoByTwoTillWeGet1AsQuotient(int n) {
        int count = 0;
        while (n > 1) {
            // Increment count and divide n by 2
            count++;
            n = n / 2;
        }
        return count;
    }

    public static void main(String[] args) {
        // Creating an instance of the Day1Example class
        Day1Example day1Example = new Day1Example();

        // Calling the countFactors method and printing the result
        day1Example.countFactors(100);

        // Calling the checkPrime method and printing the result
        System.out.println(day1Example.checkPrime(9));

        // Calling the squareRootOfAPerfectSquare method and printing the result
        System.out.println(day1Example.squareRootOfAPerfectSquare(64));

        // Calling the squareRootOfANonPerfectSquare method and printing the result
        System.out.println(day1Example.squareRootOfANonPerfectSquare(50));

        // Calling the countNoOfTimesWeNeedToDivideGivenNoByTwoTillWeGet1AsQuotient method and printing the result
        System.out.println(day1Example.countNoOfTimesWeNeedToDivideGivenNoByTwoTillWeGet1AsQuotient(9));
        System.out.println(day1Example.countNoOfTimesWeNeedToDivideGivenNoByTwoTillWeGet1AsQuotient(27));
    }
}
