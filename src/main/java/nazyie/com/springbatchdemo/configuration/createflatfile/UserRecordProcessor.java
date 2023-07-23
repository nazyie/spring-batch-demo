package nazyie.com.springbatchdemo.configuration.createflatfile;

import org.springframework.batch.item.ItemProcessor;

public class UserRecordProcessor implements ItemProcessor<User, User> {

    @Override
    public User process(User user) throws Exception {
        // nothing to process over here
        return user;
    }
}
