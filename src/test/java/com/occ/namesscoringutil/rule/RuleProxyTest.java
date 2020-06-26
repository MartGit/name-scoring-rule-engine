package com.occ.namesscoringutil.rule;

import com.occ.namesscoringutil.proxy.RuleProxyServiceImpl;
import com.occ.namesscoringutil.score.Score;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class RuleProxyTest {

    @Test
    void registerAndProcessScoringRules() {

        RuleProxyServiceImpl ruleProxyServiceImpl = new RuleProxyServiceImpl();
        Score score = new Score();
        List<String> namesList = new ArrayList<>();
        namesList.add("MARY");
        namesList.add("PATRICIA");
        namesList.add("LINDA");
        namesList.add("BARBARA");
        namesList.add("VINCENZO");
        score.setNames(namesList);
        score.setScoreType(Score.ScoreType.CURRENT);

        ruleProxyServiceImpl.registerAndProcessScoringRules(score);
    }
}