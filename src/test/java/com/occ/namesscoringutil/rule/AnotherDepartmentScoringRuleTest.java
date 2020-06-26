package com.occ.namesscoringutil.rule;

import com.occ.namesscoringutil.score.Score;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnotherDepartmentScoringRuleTest {

    @Test
    void processScore() {
        List<String> namesList = new ArrayList<>();
        Score score = new Score();
        namesList.add("BARBARA");
        namesList.add("HAI");
        namesList.add("JERE");
        namesList.add("LINDA");
        namesList.add("LYNWOOD");
        namesList.add("MARY");
        namesList.add("PATRICIA");
        namesList.add("SHON");
        namesList.add("VINCENZO");
        score.setNames(namesList);
        score.setScoreType(Score.ScoreType.ANOTHERDEPARTMENT);
        AnotherDepartmentScoringRule anotherDepartmentScoringRule = new AnotherDepartmentScoringRule(score);

        long result = anotherDepartmentScoringRule.processScore(score);

        assertEquals(5361, result);
    }
}