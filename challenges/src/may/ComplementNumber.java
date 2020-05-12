package may;

public class ComplementNumber {
    public int findComplement(int num) {
        int numberOfBits = (int)(Math.log(num)/Math.log(2)) + 1;

        return num^((1<<numberOfBits)-1);
    }
}
