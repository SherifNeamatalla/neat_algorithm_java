package neat.algorithm.activationfunctions;

public class SigmoidActivationFunction implements ActivationFunction{
    @Override
    public double activate(double input) {
        return (1/( 1 + Math.pow(Math.E,(-1*input))));
    }
}
