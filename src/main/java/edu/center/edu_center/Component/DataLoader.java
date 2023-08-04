package edu.center.edu_center.Component;

import edu.center.edu_center.Entity.DoOrNot;
import edu.center.edu_center.Entity.Enums.DoOrNotName;
import edu.center.edu_center.Entity.Enums.RoleName;
import edu.center.edu_center.Entity.Role;
import edu.center.edu_center.Entity.User;
import edu.center.edu_center.Repository.AuthRepository;
import edu.center.edu_center.Repository.DoOrNotRepo;
import edu.center.edu_center.Repository.RoleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Configuration
@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final RoleRepo roleRepo;

    private final DoOrNotRepo doOrNotRepo;

    private final AuthRepository authRepository;

    private final PasswordEncoder passwordEncoder;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String init;

    @Override
    public void run(String... args) throws Exception {
        if (init.equals("create-drop") || init.equals("create")) {
            for (RoleName value : RoleName.values()) {
                roleRepo.save(new Role(value));
            }
            for (DoOrNotName value : DoOrNotName.values()) {
                doOrNotRepo.save(new DoOrNot(value));
            }
            authRepository.save(
                    new User(
                            "shahrisod gaday",
                            "qozi",
                            "tvar",
                            "980009792",
                            passwordEncoder.encode("admin123"),
                            Collections.singletonList(roleRepo.findById(3).orElseThrow(() -> new ResourceNotFoundException("getRole")))
                    )
            );
        }
    }
}
