package hu.uszeged.inf.core.builder.plugin;

import hu.uszeged.inf.core.builder.Linear;

public class Factorial extends Linear {
    public Factorial () {
        super("!", "!", 3);
    }

    @Override
    protected double operation(double param) {
        int i,fact=1;
        for(i=1;i<=param;i++){
            fact=fact*i;
        }
        return fact;
    }
}
