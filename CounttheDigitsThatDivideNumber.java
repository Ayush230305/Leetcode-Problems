public class CounttheDigitsThatDivideNumber{
        public int countDigits(int num) {
        int remainingNumber = num;
        int divisibleDigitCount = 0;
        while (remainingNumber > 0) {
            int currentDigit = remainingNumber % 10;
            if (num % currentDigit == 0)
                divisibleDigitCount++;
            remainingNumber /= 10;
        }
        return divisibleDigitCount;
    }
}
