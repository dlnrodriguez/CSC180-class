package WeekFour.Practice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by Dylon on 7/13/2016.
 */
public class Dog {
    private int age, legCount, weight;

    public Dog() {
        this.age = 0;
        this.legCount = 0;
        this.weight = 0;
    }

    public Dog(int age, int legCount, int weight) {
        this.age = age;
        this.legCount = legCount;
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getLegCount() {
        return legCount;
    }

    public void setLegCount(int legCount) {
        this.legCount = legCount;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dog dog = (Dog) o;

        if (age != dog.age) return false;
        if (legCount != dog.legCount) return false;
        return weight == dog.weight;

    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + legCount;
        result = 31 * result + weight;
        return result;
    }
}

class DogFile {
    private Dog dog;
    private RandomAccessFile dogFile;

    public DogFile(String fileName) {
        try {
            this.dogFile = new RandomAccessFile(fileName, "rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void putDog(Dog dog) {
        this.dog = dog;
    }

    public Dog getDog() {
        return this.dog;
    }

    public boolean close() {
        try {
            this.dogFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
