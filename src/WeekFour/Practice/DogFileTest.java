package WeekFour.Practice;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Dylon on 7/13/2016.
 */
public class DogFileTest {
    @Test
    public void test() {
        DogFile file = new DogFile("dog.bin");
        Dog dog = new Dog(75, 6, 42);
        file.putDog(dog);
        Dog newDog = file.getDog();
        assertEquals(dog, newDog);
    }
}