package ru.gb.jSilver.SpringMarket.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.jSilver.SpringMarket.data.Student;
import ru.gb.jSilver.SpringMarket.services.StudentService;

import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
public class MainController {

    private final StudentService studentService;

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/students/find/{id}")
    public Student findStudent(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @GetMapping("students/between")
    public List<Student> getStudentsByScore(@RequestParam(defaultValue = "0") Integer min, @RequestParam(defaultValue = "100") Integer max) {
        return studentService.findByScore(min, max);
    }

    @GetMapping("students/low")
    public List<Student> getLow() {
        return studentService.findLow();
    }

    @GetMapping("students/name")
    public Optional<Student> getStudentByName(@RequestParam String name) {
        return studentService.findByName(name);
    }

    @GetMapping("students/score")
    public void changeScore(@RequestParam Long id, @RequestParam Integer score) {
        studentService.changeScore(id, score);
    }
//
//    @GetMapping("students/change_score")
//    public void changeScore(@RequestParam Integer studentId, @RequestParam Integer delta) {
//        studentService.changeScore(studentId, delta);
//    }
//
//    @GetMapping("/products")
//    public List<Product> getProducts() {
//        return productService.getAllProducts();
//    }
//
//    @GetMapping("/products/change_price")
//    public void changePrice(@RequestParam Integer productId,@RequestParam Double price) {
//        productService.changePrice(productId, price);
//    }
//
//    @GetMapping("/products/delete_product")
//    public void deleteProduct(@RequestParam Integer productId) {
//        productService.deleteProduct(productId);
//    }
}
