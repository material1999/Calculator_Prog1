package hu.uszeged.inf.core.builder.plugin;

import hu.uszeged.inf.core.builder.Bivariate;

public class Exponentation extends Bivariate {
    public Exponentation () {
        super("^", "^", 3);
    }
    public double operation (double param_1, double param_2) {
        return Math.pow(param_2, param_1);
    }


}
