package hu.uszeged.inf.core.builder.plugin;

import hu.uszeged.inf.core.builder.Linear;

public class Sin extends Linear {
    public Sin() {
        super("s", "sin", 3);
    }

    @Override
    protected double operation(double param) {
        return Math.sin(param);
    }
}
