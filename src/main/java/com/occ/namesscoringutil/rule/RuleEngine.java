package com.occ.namesscoringutil.rule;

import com.occ.namesscoringutil.score.Score;

import java.util.ArrayList;
import java.util.List;

public class RuleEngine {


        public RuleEngine() {
            rules = new ArrayList<>();
        }

        List<IRule<Score, Score>> rules;

        public long rule(Score score, List<String> allNames) {

            long result = 0;



            for (int i = 0; i < rules.size(); i++) {

                if (rules.get(i).toString().toLowerCase().contains(score.getScoreType().toString().toLowerCase())) {

                    result = rules.get(i).processScore(allNames);

                } else {

                    new RuntimeException("No Matching rule found");
                }
            }
                return result;
        }


        public RuleEngine registerRule(IRule<Score, Score> rule) {
            rules.add(rule);
            return this;
        }

}
