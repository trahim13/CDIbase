package org.trahim.beans;

import org.trahim.annototions.WorkerPerson;
import org.trahim.beans.interfaces.Person;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
@WorkerPerson
public class Worker implements Person {
    private String name;

    @Override
    public String getName() {
        return "worker";
    }
}
