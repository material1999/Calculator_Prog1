package hu.uszeged.inf.core.builder.plugin;

import hu.uszeged.inf.core.builder.Linear;

public class Log extends Linear {
    public Log() {
        super("l", "l", 3);
    }

    @Override
    protected double operation(double param) {
        return Math.log10(param);
    }
}
