package tests;

import beans.Cat;
import beans.Dog;
import beans.Parrot;
import beans.Person;
import config.Config;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {Config.class})
public class ContextTest {

    @Autowired
    private ApplicationContext context;

    @Test
    @DisplayName("Verify that Cat component was successfully registered in Spring context")
    public void testCatComponentWasAdded() {
        Cat cat = context.getBean(Cat.class);

        assertEquals("Boris", cat.getName());
    }

    @Test
    @DisplayName("Verify that Dog component was successfully registered in Spring context")
    public void testDogComponentWasAdded() {
        Dog dog = context.getBean(Dog.class);

        assertEquals("Ginnes", dog.getName());
    }

    @Test
    @DisplayName("Verify that Parrot component with qualifier Koko was successfully registered in Spring context")
    public void testParrotComponentKokoWasAdded() {
        Parrot parrot = context.getBean("Koko", Parrot.class);

        assertEquals("Koko", parrot.getName());
    }

    @Test
    @DisplayName("Verify that Parrot component with qualifier Kale was successfully registered in Spring context")
    public void testParrotComponentKaleWasAdded() {
        Parrot parrot = context.getBean("Kale", Parrot.class);

        assertEquals("Kale", parrot.getName());
    }

    @Test
    @DisplayName("Verify that Person component was successfully registered in Spring context")
    public void testPersonComponentWasAdded() {
        Person person = context.getBean(Person.class);

        assertEquals("Boris", person.getCat().getName());
        assertEquals("Ginnes", person.getDog().getName());
        assertEquals("Koko", person.getParrotKoko().getName());
        assertEquals("Kale", person.getParrotKale().getName());
        assertEquals("Ilya", person.getName());
    }
}