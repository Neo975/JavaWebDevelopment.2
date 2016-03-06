package resources;

import java.io.Serializable;

/**
 * Created by Mike on 04.03.2016.
 */
public class TestResource implements Serializable{
    private String name;
    private int age;

    public TestResource(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public TestResource() {
        this.name = "";
        this.age = 0;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
