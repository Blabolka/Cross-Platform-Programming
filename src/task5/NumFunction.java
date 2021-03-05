package task5;

public class NumFunction implements Evaluatable{
    @Override
    public double evalf(double x) {
        return Math.sin(x)/x;
    }
}
