/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.service;

import domain.Gender;
import domain.Person;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import repositories.PeopleRepository;
import rest.services.PersonResource;

/**
 *
 * @author Falki
 */
public class PeopleService {

    private static List<Person> db = new ArrayList<Person>();
    private static int currentId = 1;
    PeopleRepository rep = new PeopleRepository();

    public List<Person> getData() {
        return rep.getData();
    }

    public Person get(int id) {
        for (Person p : db) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void addPerson(Person p) {
        p.setId(currentId++);
        rep.addPerson(p);
    }

    public void update(Person person) {
        rep.update(person);
    }

    public void delete(int id) {
        rep.delete(id);
    }

}
