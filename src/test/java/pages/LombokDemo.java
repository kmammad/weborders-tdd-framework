package pages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LombokDemo {

    //POJO -> PLain Old Java Object

    private String name;
    private int age;
    private LocalDate dateOfBirth;


    public static void main(String[] args) {

        LombokDemo student = new LombokDemo("Bob", 34, LocalDate.now());
        LombokDemo student2 = new LombokDemo();

        System.out.println(student.toString());
    }

}
