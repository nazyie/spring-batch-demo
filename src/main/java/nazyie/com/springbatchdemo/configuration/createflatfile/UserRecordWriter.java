package nazyie.com.springbatchdemo.configuration.createflatfile;

import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

public class UserRecordWriter {

    // using FlatFileItemWriter to write the flatfile
    public FlatFileItemWriter<User> userFlatFileItemWriter() {
        return new FlatFileItemWriterBuilder<User>()
                .name("flatFileItemWriter")
                .resource(new FileSystemResource("C:\\Users\\Engku Nazri\\Documents\\Workspace\\spring-batch-demo\\src\\main\\resources\\output\\user_record.txt"))
                .delimited()
                .delimiter(", ")
                .names("name", "email", "address")
                .build();
    }
}
