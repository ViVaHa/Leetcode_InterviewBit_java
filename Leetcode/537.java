class Solution {
    public String complexNumberMultiply(String a, String b) {
        String x[] = a.split("\\+|i");
        String y[] = b.split("\\+|i");
        int x_real = Integer.parseInt(x[0]);
        int x_imag = Integer.parseInt(x[1]);
        int y_real = Integer.parseInt(y[0]);
        int y_imag = Integer.parseInt(y[1]);
        StringBuilder builder = new StringBuilder("");
        builder.append(String.valueOf((x_real*y_real) - (x_imag*y_imag)));
        builder.append("+");
        builder.append(String.valueOf((x_real*y_imag) + (y_real*x_imag)));
        builder.append("i");
        return builder.toString();
    }
}
