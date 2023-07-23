package nazyie.com.springbatchdemo.configuration.createflatfile;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author nazyie
 *
 * Job to create the flat file based on the data list
 */
@Configuration
public class CreateFlatFileConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job job() {
        return jobBuilderFactory.get("jobToCreateFlatFile")
                .start(stepToGenerateTheFlatFile())
                .build();
    }

    @Bean
    public Step stepToGenerateTheFlatFile() {
        return stepBuilderFactory.get("stepToGenerateTheFlatFile")
                .<User, User>chunk(1)
                .reader(new UserRecordReader(User.generateUserRecords()))
                .processor(new UserRecordProcessor())
                .writer(new UserRecordWriter().userFlatFileItemWriter())
                .build();
    }

}
