package com.occ.namesscoringutil.rule;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CurrentScoringRuleTest {

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
        CurrentScoringRule currentScoringRule = new CurrentScoringRule("CURRENT", namesList);

        long result = currentScoringRule.processScore(namesList);

        assertEquals(3185, result);
    }
}