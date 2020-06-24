package com.occ.namesscoringutil.rule;

import com.occ.namesscoringutil.score.Score;

import java.util.List;
import java.util.stream.Collectors;

public class AnotherDepartmentScoringRule implements IRule<Score, Score> {


    List<String> names;
    String scoreType;

    public AnotherDepartmentScoringRule(String scoreType, List<String> names) {
        this.names = names;
        this.scoreType = scoreType;
    }


    @Override
    public long processScore(List<String> allWords) {

        long result =  calculateeScoreForAllNames(allWords);

        return result;
    }


    private Integer calculateeScoreForAllNames(List<String> allWords){
        List<Integer> listOfScores = calculateScoreForAList(allWords);
        return listOfScores.stream()
                .reduce(0, Integer::sum);
    }

    private static List<Integer> calculateScoreForAList(List<String> allWords) {
        List<Integer> listOfScores = allWords.stream()
                .map(str -> calculateScoreForAWord(str)*(allWords.indexOf(str)+5))
                .collect(Collectors.toList());
        return listOfScores;
    }


    private static  Integer calculateScoreForAWord(String word){
        return word.chars()
                .map(i ->
                        {
                            if (i == 'A') {
                                i = 1;
                            } else if (i == 'B') {

                                i = 2;
                            } else if (i == 'C') {

                                i = 3;
                            } else if (i == 'D') {

                                i = 4;
                            } else if (i == 'E') {

                                i = 5;
                            } else if (i == 'F') {

                                i = 6;
                            } else if (i == 'G') {

                                i = 7;
                            } else if (i == 'H') {

                                i = 8;
                            } else if (i == 'I') {

                                i = 9;
                            } else if (i == 'J') {

                                i = 10;
                            } else if (i == 'K') {

                                i = 11;
                            } else if (i == 'L') {

                                i = 12;
                            } else if (i == 'M') {

                                i = 13;
                            } else if (i == 'N') {

                                i = 14;
                            } else if (i == 'O') {

                                i = 15;
                            } else if (i == 'P') {

                                i = 16;
                            } else if (i == 'Q') {

                                i = 17;
                            } else if (i == 'R') {

                                i = 18;
                            } else if (i == 'S') {

                                i = 19;
                            } else if (i == 'T') {

                                i = 20;
                            } else if (i == 'U') {

                                i = 21;
                            } else if (i == 'V') {

                                i = 21;
                            } else if (i == 'W') {

                                i = 23;
                            } else if (i == 'X') {

                                i = 24;
                            } else if (i == 'Y') {

                                i = 25;
                            } else if (i == 'Z') {

                                i = 26;
                            }
                            return i;
                        }
                )
                .sum();
    }

}
