package com.occ.namesscoringutil.rule;

import java.util.List;

public interface IRule<I, O> {

    long processScore(List<String> allNames);
}
