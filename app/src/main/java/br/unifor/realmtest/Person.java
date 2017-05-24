package br.unifor.realmtest;

import io.realm.RealmObject;

/**
 * Created by rafaelpinheiro on 24/02/17.
 */

public class Person extends RealmObject {

    private long id;
    private String name;
    private int age;

    public Person(){}

    public Person(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(long id) {
        this.id = id;
    }
}
