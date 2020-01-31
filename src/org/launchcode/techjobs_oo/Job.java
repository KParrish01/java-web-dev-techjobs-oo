package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // DONE: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize the 'id' field.

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
    // DONE TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getId() == job.getId();
//        if (o == null || getClass() != o.getClass()) return false;
//        Job job = (Job) o;
//        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
//        return Objects.hash(id);
    }

    // DONE: Add toString method to allow for nice print of jobs:

    @Override
    public String toString() {
        if ((this.name == ""  || this.name == null) &&
                (this.employer.getValue() == ""  || this.employer.getValue() == null) &&
                (this.location.getValue() == ""  || this.location.getValue() == null) &&
                (this.positionType.getValue() == "" || this.positionType.getValue() == null) &&
                (this.coreCompetency.getValue() == "" || this.coreCompetency.getValue() == null)) {
            return "\nID: " + this.id +
                    "\nOOPS! This job does not seem to exist.";
        }

        else if (this.name == ""  || this.name == null) {
            this.name = "Data not available";
        }
        if (this.employer.getValue() == ""  || this.employer.getValue() == null) {
            this.employer.setValue("Data not available");    //This worked also: this.employer = new Employer("Data not available");
        }
        if (this.location.getValue() == ""  || this.location.getValue() == null) {
            this.location.setValue("Data not available");
        }
        if (this.positionType.getValue() == "" || this.positionType.getValue() == null) {
            this.positionType.setValue("Data not available");
        }
        if (this.coreCompetency.getValue() == "" || this.coreCompetency.getValue() == null) {
            this.coreCompetency.setValue("Data not available");
        }
        return "\nID: " +  this.id +
                "\nName: " + this.name +
                "\nEmployer: " + this.employer +
                "\nLocation: " + this.location +
                "\nPosition Type: " + this.positionType +
                "\nCore Competency: " + this.coreCompetency +
                "\n";
    }


    // DONE: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID and id.

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
}

