package com.occ.namesscoringutil.loaddata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class LoadDataServiceImpl implements LoadDataService {

    final static Logger LOGGER = LoggerFactory.getLogger(LoadDataServiceImpl.class);

    public String loadData(String filePath) {
        String fileContent = null;
        try {
            Path path = FileSystems.getDefault().getPath(filePath);
            fileContent = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        } catch (IOException e) {
            LOGGER.info("There was an Issue Loading the file... " + e.getMessage());
        }

        return fileContent;
    }
}
