package com.src.splitwise.splittype;

public class SplitTypeFactory {
    public ISplitType getSplitType(SplitType splitType) {
        return switch (splitType) {
            case EQUAL -> new EqualSplit();
            case PERCENTAGE -> new PercentageSplit();
            default -> null;
        };
    }
}
