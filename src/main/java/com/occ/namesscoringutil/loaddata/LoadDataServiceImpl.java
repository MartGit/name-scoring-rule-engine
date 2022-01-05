package com.occ.namesscoringutil.loaddata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class LoadDataServiceImpl implements LoadDataService {

    final static Logger LOGGER = LoggerFactory.getLogger(LoadDataServiceImpl.class);

    public String loadData(String filePath) {
        String fileContent = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(filePath);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line + System.lineSeparator());
            }
            fileContent = stringBuilder.toString();

        } catch (IOException e) {
            LOGGER.info("There was an Issue Loading the file... " + e.getMessage());
        }

        return fileContent;
    }
}
