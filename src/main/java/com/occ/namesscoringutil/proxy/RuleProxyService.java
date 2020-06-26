package com.occ.namesscoringutil.proxy;

import com.occ.namesscoringutil.score.Score;

public interface RuleProxyService {

    long registerAndProcessScoringRules(Score score);
}
