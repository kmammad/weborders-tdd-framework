package pages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    //POJO -> PLain Old Java Object

    private String name;
    private int age;
    private LocalDate dateOfBirth;


    public static void main(String[] args) {

        Student student = new Student("Bob", 34, LocalDate.now());
        Student student2 = new Student();

        System.out.println(student.toString());
    }

}
