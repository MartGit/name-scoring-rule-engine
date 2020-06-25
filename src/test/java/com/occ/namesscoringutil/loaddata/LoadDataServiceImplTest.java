package com.occ.namesscoringutil.loaddata;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoadDataServiceImplTest {


    @BeforeEach
    void setUp() {



    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void loadData() {

        LoadDataServiceImpl loadDataService = new LoadDataServiceImpl();
        String filePath = "/Users/apple/namescoringapplication/src/main/resources/fewNames.txt";
        String fileContent = "\"MARY\",\"PATRICIA\",\"LINDA\",\"BARBARA\",\"VINCENZO\",\"SHON\",\"LYNWOOD\",\"JERE\",\"HAI\"";
        System.out.println("loadservice is " + loadDataService);
        String result = loadDataService.loadData(filePath);

        assertEquals(fileContent, result);
    }
}