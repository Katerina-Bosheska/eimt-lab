package mk.finki.labs.eimtlab.authorization;

import mk.finki.labs.eimtlab.authorization.domain.model.User;
import mk.finki.labs.eimtlab.authorization.domain.model.UserId;
import mk.finki.labs.eimtlab.authorization.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataGenerator {

    private final UserRepository userRepository;

    DataGenerator(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostConstruct
    @Transactional
    public void generateData() {
        List<User> users = new ArrayList<>();
        users.add(new User(new UserId("kate1"),"Kate1", "hehe@mail.com", "Macedonia"));
        users.add(new User(new UserId("kate2"), "Kate2", "hehe2@mail.com", "Macedonia"));
        users.add(new User(new UserId("kate3"),"Kate3", "hehe3@mail.com", "Macedonia"));
        userRepository.saveAll(users);
    }

}
