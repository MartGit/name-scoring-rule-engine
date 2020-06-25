package com.occ.namesscoringutil.score;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScoreTest {
@Mock
private Score.ScoreType scoreType;


    @Test
    void getScoreType() {
        List<String> namesList = new ArrayList<>();
        namesList.add("MARY");
        namesList.add("PATRICIA");
        namesList.add("LINDA");
        namesList.add("BARBARA");
        namesList.add("VINCENZO");
        Score score = new Score(scoreType, namesList);
                score.getScoreType();
    }

}