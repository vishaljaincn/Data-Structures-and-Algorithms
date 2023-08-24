package day1_Introduction_to_problem_solving;

class Day1Example {
    int count = 0;

    int countFactors(int n) {
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (i == n / i) {
                    count++;
                    System.out.println(i);
                } else {
                    count = count + 2;
                    System.out.println(i + " " + n / i);
                }
            }
        }
        return count;
    }

    boolean checkPrime(int n) {
        int a = countFactors(n);
        if (a == 2) {
            return true;
        }
        return false;
    }

    int squareRootOfAPerfectSquare(int n) {
        for (int i = 1; i * i <= n; i++) {
            if (i * i == n) {
                return i;
            }
        }
        return -1;
    }

    int squareRootOfANonPerfectSquare(int n) {
        int ans = 0;
        for (int i = 1; i * i <= n; i++) {
            ans = i;
        }
        return ans;
    }

    int countNoOfTimesWeNeedToDivideGivenNoByTwoTillWeGet1AsQuotient(int n) {
        int count = 0;
        while (n > 1) {
            count++;
            n = n/2;
        }
        return count;
    }

    public static void main(String[] args) {
        Day1Example day1Example = new Day1Example();
        day1Example.countFactors(100);
        System.out.println(day1Example.checkPrime(9));
        System.out.println(day1Example.squareRootOfAPerfectSquare(64));
        System.out.println(day1Example.squareRootOfANonPerfectSquare(50));
        System.out.println(day1Example.countNoOfTimesWeNeedToDivideGivenNoByTwoTillWeGet1AsQuotient(9));
        System.out.println(day1Example.countNoOfTimesWeNeedToDivideGivenNoByTwoTillWeGet1AsQuotient(27));

    }
}