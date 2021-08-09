package nextstep.ladder.domain;

import nextstep.ladder.exception.StringLengthException;

import java.util.Objects;

public class LadderName {
    private static final int LETTER_LIMIT = 5;
    private String laddername;

    public LadderName(String ladderName) {
        this.laddername = ladderName;
    }

    public static LadderName of(String ladderName) {
        lengthValidation(ladderName);
        return new LadderName(ladderName);
    }

    private static void lengthValidation(String name) {
        if(name.length() > LETTER_LIMIT) {
            throw new StringLengthException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderName that = (LadderName) o;
        return Objects.equals(laddername, that.laddername);
    }

    @Override
    public int hashCode() {
        return Objects.hash(laddername);
    }

    @Override
    public String toString() {
        return laddername;
    }
}