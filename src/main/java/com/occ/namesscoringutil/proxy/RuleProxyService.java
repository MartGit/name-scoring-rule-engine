package com.occ.namesscoringutil.proxy;

import java.util.List;

public interface RuleProxyService {

    long registerAndProcessScoringRules(String scoreType, List<String> names);
}
