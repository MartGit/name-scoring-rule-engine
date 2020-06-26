package com.occ.namesscoringutil.rule;

import com.occ.namesscoringutil.score.Score;

import java.util.ArrayList;
import java.util.List;

public class RuleEngine {


        public RuleEngine() {
            rules = new ArrayList<>();
        }

        List<IRule<Score, Long>> rules;
        public Long rule(Score score) {
            Long result = 0L;
            for (int i = 0; i < rules.size(); i++) {
                if (rules.get(i).toString().toLowerCase().contains(score.getScoreType().toString().toLowerCase())) {
                    result = rules.get(i).processScore(score);
                } else {

                    new RuntimeException("No Matching rule found");
                }
            }
                return result;
        }


        public RuleEngine registerRule(IRule<Score, Long> rule) {
            rules.add(rule);
            return this;
        }

}
