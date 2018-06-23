package org.trahim.beans;

import org.trahim.beans.interfaces.Person;

public class OtherPolicemen implements Person {
    @Override
    public String getName() {
        return "Other";
    }
}
