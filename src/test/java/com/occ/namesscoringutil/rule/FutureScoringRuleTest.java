package com.occ.namesscoringutil.rule;

import com.occ.namesscoringutil.score.Score;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FutureScoringRuleTest {
    @Test
    void processScore() {
        List<String> namesList = new ArrayList<>();
        namesList.add("BARBARA");
        namesList.add("HAI");
        namesList.add("JERE");
        namesList.add("LINDA");
        namesList.add("LYNWOOD");
        namesList.add("MARY");
        namesList.add("PATRICIA");
        namesList.add("SHON");
        namesList.add("VINCENZO");
        FutureScoringRule futureScoringRule = new FutureScoringRule("FUTURE", namesList);

        long result = futureScoringRule.processScore(namesList);

       assertEquals(2641, result);
    }
}