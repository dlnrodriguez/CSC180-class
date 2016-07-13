package WeekFour.Practice;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * Created by Dylon on 7/13/2016.
 */
public class Dog {
    int age, legCount, weight;

    public Dog() {
        this.age = 0;
        this.legCount = 0;
        this.weight = 0;
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
}

class DogFile {
    private RandomAccessFile dogFile;

    public DogFile(String fileName) {
        try {
            this.dogFile = new RandomAccessFile(fileName, "rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
