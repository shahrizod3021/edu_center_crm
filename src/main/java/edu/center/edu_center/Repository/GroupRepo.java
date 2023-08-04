package edu.center.edu_center.Repository;

import edu.center.edu_center.Entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepo extends JpaRepository<Group, Integer> {
    boolean existsGroupByNameEqualsIgnoreCase(String name);
}
