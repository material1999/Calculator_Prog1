package hu.uszeged.inf.ui.plugin;

import hu.uszeged.inf.core.builder.Bivariate;

public class Exponentation extends Bivariate {
    public String id = "}[^]{";
    public String showingID = "^";
    public Exponentation () {
        super("^", "^", 3);
    }
    public double operation (double param_1, double param_2) {
        return param_1+param_2;
    }


}
