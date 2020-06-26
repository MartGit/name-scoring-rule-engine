package com.occ.namesscoringutil.rule;

import com.occ.namesscoringutil.score.Score;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

class RuleEngineTest {

    @Mock
    private Score scoree;

    @Mock
    private IRule irule;

    @Test
    void rule() {
        RuleEngine engine = new RuleEngine();
        Score score = new Score();
        List<String> namesList = new ArrayList<>();
        namesList.add("MARY");
        namesList.add("PATRICIA");
        namesList.add("LINDA");
        namesList.add("BARBARA");
        namesList.add("VINCENZO");
        score.setNames(namesList);
        score.setScoreType(Score.ScoreType.CURRENT);
        engine.rule(score);
    }

    @Test
    void registerRule() {
        RuleEngine engine = new RuleEngine();
        engine.registerRule(irule);

    }
}