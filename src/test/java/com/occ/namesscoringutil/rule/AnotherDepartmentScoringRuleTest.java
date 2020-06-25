package com.occ.namesscoringutil.rule;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnotherDepartmentScoringRuleTest {

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
        AnotherDepartmentScoringRule anotherDepartmentScoringRule = new AnotherDepartmentScoringRule("ANOTHERDEPARTMENT", namesList);

        long result = anotherDepartmentScoringRule.processScore(namesList);

        assertEquals(5361, result);
    }
}