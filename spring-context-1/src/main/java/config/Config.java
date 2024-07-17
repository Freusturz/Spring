package config;

import beans.Cat;
import beans.Dog;
import beans.Parrot;
import beans.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Config {

    private final String LEO_PARROT_NAME = "Leo";

    private final String NYA_PARROT_NAME = "Nya";

    @Bean
    public Cat getCat() {

        return new Cat("Vasilis");

    }

    @Bean
    public Dog getDog() {

        return new Dog("Ginnes");

    }

    @Bean(name = LEO_PARROT_NAME)
    public Parrot getParrotLeo() {

        return new Parrot(LEO_PARROT_NAME);

    }

    @Bean(name = NYA_PARROT_NAME)
    public Parrot getParrotKale() {

        return new Parrot(NYA_PARROT_NAME);

    }

    @Bean
    public Person getPerson(Cat cat, Dog dog, @Qualifier(LEO_PARROT_NAME) Parrot Leo, @Qualifier(NYA_PARROT_NAME) Parrot Nya) {
        return new Person(cat, dog, Leo, Nya, "Ilya");
    }

}
