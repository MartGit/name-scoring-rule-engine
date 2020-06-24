package com.occ.namesscoringutil.score;

import java.util.List;

public class Score {

    private ScoreType scoreType;
    private List<String> names;

    public Score(ScoreType scoreType, List<String> names )
    {
        this.scoreType = scoreType;
        this.names = names;
    }


    public ScoreType getScoreType() {
        return scoreType;
    }

    public void setScoreType(ScoreType scoreType) {
        this.scoreType = scoreType;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public enum ScoreType {
        CURRENT, FUTURE, ANOTHERDEPARTMENT
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Score{");
        sb.append("scoreType='").append(scoreType).append('\'');
        sb.append(", names=").append(names);
        sb.append('}');
        return sb.toString();
    }
}
