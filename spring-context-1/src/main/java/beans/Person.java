package beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Person {

    private Cat cat;

    private Dog dog;

    private Parrot parrotLeo;

    private Parrot parrotNya;

    private String name;

}
