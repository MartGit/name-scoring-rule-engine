package com.occ.namesscoringutil;

import com.occ.namesscoringutil.rule.RuleProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class NamesScoringUtilApplication implements CommandLineRunner {

    final static Logger LOGGER = LoggerFactory.getLogger(NamesScoringUtilApplication.class);

    public static void main(String[] args) {


        SpringApplication.run(NamesScoringUtilApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {


        String loadedData = loadData(args[0]);

        List<String> preparedData = prepareData(loadedData);

        RuleProxy proxy = new RuleProxy();

        proxy.registerAndProcessScoringRules("CURRENT", preparedData);

        proxy.registerAndProcessScoringRules("FUTURE", preparedData);

        proxy.registerAndProcessScoringRules("NEWDEPARTMENT", preparedData);

    }


    public  String loadData(String filePath) {
        String fileContent = null;
        try {
            Path path = FileSystems.getDefault().getPath(filePath);
            fileContent = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        }
        catch (IOException e) {
            //Handle a potential exception
        }
        LOGGER.info("Args here is " + filePath);

        return fileContent;
    }


    public List<String> prepareData(String loadedData) {


        Stream<String> words = Stream.of(loadedData);


        List<String> letterWord = words.map(w -> w.split(","))
                .flatMap(Arrays::stream)
                .sorted()
                .collect(Collectors.toList());

        List<String> listWithoutQuotes = removeQuotes(letterWord);

        return listWithoutQuotes;

    }

    public static List<String> removeQuotes(List<String> listWithQoutes) {

        return listWithQoutes.stream()
                .map(s -> s.replaceAll("\"", ""))
                .collect(Collectors.toList());
    }

}
