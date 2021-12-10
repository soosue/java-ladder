package ladder.domain;

import ladder.strategy.MakeRungStrategy;
import ladder.util.function.MathFunction;

public class LadderPartFactory {

    private static boolean isPreviousRungSet = false;

    private LadderPartFactory() {}

    public static LadderPart ladderPart(int idx, MakeRungStrategy strategy) {
        if (MathFunction.EVEN_NUMBER.test(idx)) {
            return Rail.instance();
        }

        if (isPreviousRungSet) {
            changeIsPreviousRungSet(false);
            return Rung.from(isPreviousRungSet);
        }

        changeIsPreviousRungSet(strategy.test());
        return Rung.from(isPreviousRungSet);
    }

    public static void initIsPreviousRungSet() {
        changeIsPreviousRungSet(false);
    }

    public static void changeIsPreviousRungSet(boolean value) {
        isPreviousRungSet = value;
    }

}
