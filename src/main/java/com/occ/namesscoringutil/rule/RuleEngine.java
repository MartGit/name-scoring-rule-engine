package com.occ.namesscoringutil.rule;

import com.occ.namesscoringutil.proxy.RuleProxyServiceImpl;
import com.occ.namesscoringutil.score.Score;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class RuleEngine {

    final static Logger LOGGER = LoggerFactory.getLogger(RuleEngine.class);


    public RuleEngine() {
            rules = new ArrayList<>();
        }

        List<IRule<Score, Long>> rules;
        Long result = 0L;
        public Long rule(Score score) {
            try {

                for (int i = 0; i < rules.size(); i++) {
                    if (rules.get(i).toString().toLowerCase().contains(score.getScoreType().toString().toLowerCase())) {
                        result = rules.get(i).processScore(score);
                    } else {

                        new RuntimeException("No Matching rule found");
                    }
                }
            }
            catch (Exception e) {
                LOGGER.info("There was a Problem in the Rule Engine " + e.getMessage());
            }
                return result;
        }


        public RuleEngine registerRule(IRule<Score, Long> rule) {
            rules.add(rule);
            return this;
        }

}
