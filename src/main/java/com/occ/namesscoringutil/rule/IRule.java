package com.occ.namesscoringutil.rule;

import java.util.List;

public interface IRule<I, O> {

    Long processScore(List<String> allNames);
}
