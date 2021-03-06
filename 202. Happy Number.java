/*
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
*/

// 用set记录出现过的数，有重复说明进loop了！
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> appearedNums = new HashSet<>();
        int squareSum = 0;
        while (appearedNums.add(squareSum)) {
            squareSum = 0;
            while (n > 0) {
                squareSum += (n % 10) * (n % 10);
                n /= 10;
            }
            if (squareSum == 1) {
                return true;
            }
            n = squareSum;
        }
        
        return false;
    }
}
