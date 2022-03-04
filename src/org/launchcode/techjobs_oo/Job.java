package org.launchcode.techjobs_oo;

import java.lang.reflect.Field;
import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;



    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }
    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }



    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    @Override
    public String toString() {
        String[] labels = {"ID: ", "Name: ", "Employer: ", "Location: ", "Position Type: ", "Core Competency: "};
        Field[] fields = Job.class.getDeclaredFields();
        String empty = "Data not available";
        String message = "\n";
        int i = 0;

        for(Field field : fields) {
            if (field.getName() == "nextId") {
        } else {
                try {
                    if (field.get(this) instanceof JobField) {
                        if (((JobField) field.get(this)).getValue() == "") {
                            message += labels[i] + empty + "\n";
                    } else {
                            message += labels[i] + field.get(this) + "\n";
                    }
                } else if (field.get(this) == null || field.get(this) == "") {
                    message += labels[i] + empty + "\n";
                } else {
                    message += labels[i] + field.get(this) + "\n";
                }
                    i++;
                } catch (Exception e) {
                    message += labels[i] + empty + "\n";
                    i++;
                }
            }
        }
        return message;
    }
}

