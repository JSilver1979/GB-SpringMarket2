package ru.gb.jSilver.SpringMarket.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.jSilver.SpringMarket.data.Student;
import ru.gb.jSilver.SpringMarket.repos.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

//    public Student getStudentByID (Long id) {
//        return repo.findById(id);
//    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student findById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public List<Student> findByScore(Integer min, Integer max) {
        return repo.findAllByScoreBetween(min,max);
    }

    public List<Student> findLow() {
        return repo.findLowRatingStudents();
    }

    public Optional<Student> findByName(String name) {
        return repo.findStudentByName(name);
    }

    @Transactional
    public void changeScore(Long id, Integer score) {
        Student student = repo.findById(id).orElseThrow();
        student.setScore(student.getScore() + score);
    }
}
