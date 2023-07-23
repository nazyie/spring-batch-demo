package nazyie.com.springbatchdemo.configuration.createflatfile;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.util.Iterator;
import java.util.List;

public class UserRecordReader implements ItemReader<User> {
    private final Iterator<User> userIterator;

    public UserRecordReader(List<User> userRecords) {
        this.userIterator = userRecords.iterator();
    }

    @Override
    public User read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        return userIterator.hasNext() ? userIterator.next() : null;
    }
}
