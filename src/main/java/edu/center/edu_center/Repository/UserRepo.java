package edu.center.edu_center.Repository;

import edu.center.edu_center.Entity.Course;
import edu.center.edu_center.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepo extends JpaRepository<User, UUID> {

    boolean existsUserByPhoneNumber(String phoneNumber);

}
