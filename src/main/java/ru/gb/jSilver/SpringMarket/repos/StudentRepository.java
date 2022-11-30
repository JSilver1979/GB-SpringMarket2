package ru.gb.jSilver.SpringMarket.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.gb.jSilver.SpringMarket.data.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAllByScoreBetween(Integer min, Integer max);

    @Query("select s from Student s where s.score < 81")
    List<Student> findLowRatingStudents();

    Optional<Student> findStudentByName(String name);
}
