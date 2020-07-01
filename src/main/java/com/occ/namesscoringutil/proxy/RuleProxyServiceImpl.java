package com.occ.namesscoringutil.proxy;

import com.occ.namesscoringutil.rule.AnotherDepartmentScoringRule;
import com.occ.namesscoringutil.rule.CurrentScoringRule;
import com.occ.namesscoringutil.rule.FutureScoringRule;
import com.occ.namesscoringutil.rule.RuleEngine;
import com.occ.namesscoringutil.score.Score;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RuleProxyServiceImpl implements RuleProxyService {

    final static Logger LOGGER = LoggerFactory.getLogger(RuleProxyServiceImpl.class);

    public long registerAndProcessScoringRules(Score score) {

        RuleEngine ruleEngine = new RuleEngine();
        Long result = 0L;
        try {
            if (score.getScoreType().equals(Score.ScoreType.CURRENT)) {
                ruleEngine
                        .registerRule(new CurrentScoringRule(score));
                result = ruleEngine.rule(score);
            }
            if (score.getScoreType().equals(Score.ScoreType.FUTURE)) {
                ruleEngine
                        .registerRule(new FutureScoringRule(score));
                result = ruleEngine.rule(score);
            }
            if (score.getScoreType().equals(Score.ScoreType.ANOTHERDEPARTMENT)) {
                ruleEngine
                        .registerRule(new AnotherDepartmentScoringRule(score));
                result = ruleEngine.rule(score);
            }
        } catch (Exception e) {
            LOGGER.info("Error Processing your Request " + e.getMessage());
        }

        LOGGER.info(" Result Is " + result);

        return result;

    }
}
