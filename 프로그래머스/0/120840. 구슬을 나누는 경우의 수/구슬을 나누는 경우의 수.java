import java.math.BigInteger;

class Solution {
    public BigInteger solution(int balls, int share) {
        return factorial(balls).divide(factorial(balls - share).multiply(factorial(share)));
    }

    public BigInteger factorial(int n) {
        BigInteger result = new BigInteger("1");
        BigInteger from = new BigInteger("1");
        BigInteger to = new BigInteger(String.valueOf(n));

        for (BigInteger i = from; i.compareTo(to) <= 0; i = i.add(BigInteger.ONE)) {
            result = result.multiply(i);
        }
        return result;
    }
}
