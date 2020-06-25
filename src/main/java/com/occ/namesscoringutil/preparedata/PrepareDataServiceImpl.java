package com.occ.namesscoringutil.preparedata;

import com.occ.namesscoringutil.utils.DataUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrepareDataServiceImpl implements PrepareDataService {
    final static Logger LOGGER = LoggerFactory.getLogger(PrepareDataServiceImpl.class);

    public List<String> prepareData(String loadedData) {
        List<String> listWithoutQuotes = new ArrayList<>();
        try {
            Stream<String> names = Stream.of(loadedData);
            List<String> letterWord = names.map(w -> w.split(","))
                    .flatMap(Arrays::stream)
                    .sorted()
                    .collect(Collectors.toList());
            listWithoutQuotes = DataUtility.removeQuotes(letterWord);
        } catch (Exception e) {
            LOGGER.info("Error Occurred while preparing data " + e.getMessage());
        }

        return listWithoutQuotes;

    }

}
