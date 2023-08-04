package edu.center.edu_center.Repository;

import edu.center.edu_center.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import sun.management.jdp.JdpPacket;

public interface CourseRepo extends JpaRepository<Course, Integer> {
    boolean existsCourseByNameEqualsIgnoreCase(String name);
}
