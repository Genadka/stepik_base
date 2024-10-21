package bloc_one;

public class AsciiCharSequence implements java.lang.CharSequence {

    private byte[] num;

    public AsciiCharSequence(byte[] num) {
        this.num = num;
    }

    @Override
    public int length() {
        return num.length;
    }

    @Override
    public char charAt(int index) {
        return (char) num[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return new AsciiCharSequence(java.util.Arrays.copyOfRange(num, start, end));
    }

    @Override
    public String toString() {
        return new String(num);
    }
}
