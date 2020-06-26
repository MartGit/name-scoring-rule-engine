package com.occ.namesscoringutil.rule;

import com.occ.namesscoringutil.score.Score;

public interface IRule<I, O> {

    Long processScore(Score score);
}
