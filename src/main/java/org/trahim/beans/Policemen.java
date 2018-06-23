package org.trahim.beans;

import org.trahim.beans.interfaces.Person;

import javax.enterprise.inject.Alternative;



@Alternative
public class Policemen implements Person {
    @Override
    public String getName() {
        return "Policemen";
    }
}
