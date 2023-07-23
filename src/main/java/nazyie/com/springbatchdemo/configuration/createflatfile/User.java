package nazyie.com.springbatchdemo.configuration.createflatfile;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private String email;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static List<User> generateUserRecords() {
        List<User> users = new ArrayList<>();

        int RECORD_COUNT = 5;

        for(int i = 0; i < RECORD_COUNT; i++) {
            User user = new User();
            user.setName(String.format("USER0%d", i + 1));
            user.setAddress("PT 0" + i);
            user.setEmail(String.format("USER0%d@nazyie.com.my", i + 1));

            users.add(user);
        }

        return users;
    }
}
