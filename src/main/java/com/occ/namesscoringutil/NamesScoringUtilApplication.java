package com.occ.namesscoringutil;

import com.occ.namesscoringutil.loaddata.LoadDataService;
import com.occ.namesscoringutil.loaddata.LoadDataServiceImpl;
import com.occ.namesscoringutil.preparedata.PrepareDataService;
import com.occ.namesscoringutil.preparedata.PrepareDataServiceImpl;
import com.occ.namesscoringutil.proxy.RuleProxyService;
import com.occ.namesscoringutil.proxy.RuleProxyServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;

@SpringBootApplication
public class NamesScoringUtilApplication implements CommandLineRunner {

    final static Logger LOGGER = LoggerFactory.getLogger(NamesScoringUtilApplication.class);

    public static void main(String[] args) {

        try {

            SpringApplication.run(NamesScoringUtilApplication.class, args);
        } catch (Exception e) {
            LOGGER.info("You Are Required to Enter the Name File Path " +  e.getMessage());
        }
    }

    @Bean
    public LoadDataService getHDataLoadService() {
        return new LoadDataServiceImpl();
    }

    @Bean
    public PrepareDataService getHDataPrepareService() {
        return new PrepareDataServiceImpl();
    }


   @Bean
   public  RuleProxyService getRuleProxyService() {
        return new RuleProxyServiceImpl();
   }


    @Override
    public void run(String... args) throws Exception {

        try {

            String loadedData = getHDataLoadService().loadData(args[0]);
            List<String> preparedData = getHDataPrepareService().prepareData(loadedData);
            long totalScore = getRuleProxyService().registerAndProcessScoringRules("CUREENT", preparedData);
            LOGGER.info("Sum of All Scores " + totalScore);

        }
        catch (Exception e){
            LOGGER.info("There was a problem from the API Processing Your Request " + e.getMessage());
        }


    }

}
