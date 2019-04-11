package edu.uph.ii.platformy.config;

import edu.uph.ii.platformy.models.*;
import edu.uph.ii.platformy.repositories.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
public class RepositoriesInitializer {

    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    InitializingBean init() {

        return () -> {

            if(candidateRepository.findAll().isEmpty()) {//przyjmijmy, że jeśli repozytorium typów jest puste, to trzeba zainicjalizować bazę danych




                Candidate v1 = new Candidate();
                v1.setImie("Piotr");
                v1.setNazwisko("Żyła");
                v1.setMiasto("Kraków");
                v1.setPartia("C++");
                candidateRepository.save(v1);

                Candidate v2 = new Candidate();
                v2.setImie("Kamil");
                v2.setNazwisko("Stoch");
                v2.setMiasto("Warszawa");
                v2.setPartia("C++");
                candidateRepository.save(v2);

                Candidate v3 = new Candidate();
                v3.setImie("Adam");
                v3.setNazwisko("Małysz");
                v3.setMiasto("Kraków");
                v3.setPartia("Java");
                candidateRepository.save(v3);

                Candidate v4 = new Candidate();
                v4.setImie("Adam");
                v4.setNazwisko("Małysz");
                v4.setMiasto("Kraków");
                v4.setPartia("Java");
                candidateRepository.save(v4);

            }


            if(roleRepository.findAll().isEmpty() == true){
                try {
                    Role roleUser = roleRepository.save(new Role(Role.Types.ROLE_USER));
                    Role roleAdmin = roleRepository.save(new Role(Role.Types.ROLE_ADMIN));

                    User user = new User("user", true);
                    user.setRoles(new HashSet<>(Arrays.asList(roleUser)));
                    user.setPassword(passwordEncoder.encode("user"));

                    User admin = new User("admin", true);
                    admin.setRoles(new HashSet<>(Arrays.asList(roleAdmin)));
                    admin.setPassword(passwordEncoder.encode("admin"));

                    User test = new User("test", true);
                    test.setRoles(new HashSet<>(Arrays.asList(roleAdmin, roleUser)));
                    test.setPassword(passwordEncoder.encode("test"));

                    userRepository.save(user);
                    userRepository.save(admin);
                    userRepository.save(test);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }

        };
    }

}
