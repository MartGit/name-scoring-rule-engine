package com.occ.namesscoringutil.rule;

import com.occ.namesscoringutil.score.Score;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class RuleProxy {

    final static Logger LOGGER = LoggerFactory.getLogger(RuleProxy.class);



    public long registerAndProcessScoringRules(String scoreType, List<String> names) {

        RuleEngine ruleEngine = new RuleEngine();
        ruleEngine
                .registerRule(new CurrentScoringRule(scoreType, names))
                .registerRule(new FutureScoringRule(scoreType, names))
                .registerRule(new AnotherDepartmentScoringRule(scoreType, names));

        Score currentScore = new Score(Score.ScoreType.CURRENT, names);
        Score futureScore = new Score(Score.ScoreType.FUTURE, names);
        Score anotherDeptScore = new Score(Score.ScoreType.ANOTHERDEPARTMENT, names);

        long currentResult = ruleEngine.rule(currentScore, names);

        long futureResult = ruleEngine.rule(futureScore, names);

        long anotherDeptResult = ruleEngine.rule(anotherDeptScore, names);

        LOGGER.info("Current Result Is " + currentResult);

        LOGGER.info("Future Result Is " + futureResult);

        LOGGER.info("AnotherDept Result Is " + anotherDeptResult);

        return anotherDeptResult;

    }
}
