package sxk.demo.spring.demo2.pojo;

/**
 * Created by sunxikai on 19/8/8.
 */
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        System.out.println("Person被创建了 name:" + name + ", age:" + age);
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}