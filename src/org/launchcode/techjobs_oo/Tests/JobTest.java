package org.launchcode.techjobs_oo.Tests;

import jdk.jfr.StackTrace;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    private static int numTestsRun = 0;
    Job test_job1;
    Job test_job2;
    Job test_jobConstructor;
    Job test_jobConstructorDifferentId;
    Job test_jobConstructorEmptyFields;
    Job test_jobConstructorEmptyFields2DifferentFields;
    Job test_jobConstructorAllFieldsEmptyStringOrNull;

    @Before
    public void init() {
        test_job1 = new Job();
        test_job2 = new Job();
        test_jobConstructor = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        test_jobConstructorDifferentId = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        test_jobConstructorEmptyFields = new Job("Sleeper", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        test_jobConstructorEmptyFields2DifferentFields = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency("Patience"));
        test_jobConstructorAllFieldsEmptyStringOrNull = new Job("", new Employer(""), new Location(), new PositionType(""), new CoreCompetency(""));
    }

    @After
    public void countTests(){
          System.out.println("This was test #" + ++numTestsRun);
    }

    @AfterClass
    public static void lastStatement(){
          System.out.println("Finished running " + numTestsRun + " tests!");
    }


    @Test
    public void testSettingJobId(){
        assertNotNull(test_job1.getId());
        assertFalse(test_job1.getId() == test_job2.getId());
        assertTrue(test_job1.getId() + 1 == test_job2.getId());
        assertEquals(test_job2.getId(), (test_job1.getId() + 1), .001); // different way of testing same as isTrue above
    }

    //May do: might combine the following two into "testConstructorSetsAllFields":
    @Test
    public void testJobConstructorSetsAllFieldsClasses() {
        assertTrue(test_jobConstructor instanceof Job);
        assertTrue(test_jobConstructor.getName() instanceof String);
        assertTrue(test_jobConstructor.getEmployer() instanceof Employer);
        assertTrue(test_jobConstructor.getLocation() instanceof Location);
        assertTrue(test_jobConstructor.getPositionType() instanceof PositionType);
        assertTrue(test_jobConstructor.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobConstructorSetsAllFieldsValues() {
        assertNotNull(test_jobConstructor.getId());
        assertEquals("Product tester", test_jobConstructor.getName());
        assertEquals("ACME", test_jobConstructor.getEmployer().getValue());
        assertEquals("Desert", test_jobConstructor.getLocation().getValue());
        assertEquals("Quality control", test_jobConstructor.getPositionType().getValue());
        assertEquals("Persistence", test_jobConstructor.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEqualityIfAllButIdEqual() {
//        System.out.println("Test - equal except ID is not equal #" + numTestsRun);
//        System.out.println("ID of jobConstructor: " + test_jobConstructor.getId());
//        System.out.println("ID of jobConstructorDifferentId: " + test_jobConstructorDifferentId.getId());
        assertFalse(test_jobConstructor == test_jobConstructorDifferentId);
    }

    @Test
    public void testToStringBlankLineBeforeAndAfter() {
        String toString = test_jobConstructor.toString();
        assertTrue(toString.startsWith("\n"));
        assertTrue(toString.endsWith("\n"));
    }

     @Test
     public void testToStringLabelFollowedByDataInField() {
        String toString = test_jobConstructor.toString();
        assertTrue(toString.contains("\nID: " + test_jobConstructor.getId()));
        assertTrue(toString.contains("\nName: " + test_jobConstructor.getName()));
        assertTrue(toString.contains("\nEmployer: " + test_jobConstructor.getEmployer()));
        assertTrue(toString.contains("\nLocation: " + test_jobConstructor.getLocation()));
        assertTrue(toString.contains("\nPosition Type: " + test_jobConstructor.getPositionType()));
        assertTrue(toString.contains("\nCore Competency: " + test_jobConstructor.getCoreCompetency()));
    }

    @Test
    public void testToStringPrintsCorrectOutputOrder() {
        assertEquals(test_jobConstructor.toString(),
                "\nID: " + test_jobConstructor.getId() +
                "\nName: " + test_jobConstructor.getName() +
                "\nEmployer: " + test_jobConstructor.getEmployer()+
                "\nLocation: " + test_jobConstructor.getLocation() +
                "\nPosition Type: " + test_jobConstructor.getPositionType() +
                "\nCore Competency: " + test_jobConstructor.getCoreCompetency() +
                "\n");
    }

    @Test
    public void testToStringIfNoDataInField() {
        String toString1 = test_jobConstructorEmptyFields.toString();
        assertTrue(toString1.contains("\nID: " + test_jobConstructorEmptyFields.getId()));
        assertTrue(toString1.contains("\nName: " + test_jobConstructorEmptyFields.getName()));
        assertTrue(toString1.contains("\nEmployer: " + "Data not available"));
        assertTrue(toString1.contains("\nLocation: " + "Data not available"));
        assertTrue(toString1.contains("\nPosition Type: " + "Data not available"));
        assertTrue(toString1.contains("\nCore Competency: " + "Data not available"));
        String toString2 = test_jobConstructorEmptyFields2DifferentFields.toString();
        assertTrue(toString2.contains("\nID: " + test_jobConstructorEmptyFields2DifferentFields.getId()));
        assertTrue(toString2.contains("\nName: " + "Data not available"));
        assertTrue(toString2.contains("\nEmployer: " + "Data not available"));
        assertTrue(toString2.contains("\nLocation: " + "Data not available"));
        assertTrue(toString2.contains("\nPosition Type: " + "Data not available"));
        assertTrue(toString2.contains("\nCore Competency: " + test_jobConstructorEmptyFields2DifferentFields.getCoreCompetency()));
    }

    @Test
    public void testToStringReplaceWithDataNotAvailableIfNoValueCorrectOrder() {
        assertEquals("\nID: " + test_jobConstructorEmptyFields.getId() +
                        "\nName: " + test_jobConstructorEmptyFields.getName() +
                        "\nEmployer: " + "Data not available"+
                        "\nLocation: " + "Data not available"+
                        "\nPosition Type: " + "Data not available"+
                        "\nCore Competency: " + "Data not available"+
                        "\n",
                    test_jobConstructorEmptyFields.toString());
        assertEquals("\nID: " + test_jobConstructorEmptyFields2DifferentFields.getId() +
                        "\nName: " + "Data not available" +
                        "\nEmployer: " + "Data not available"+
                        "\nLocation: " + "Data not available"+
                        "\nPosition Type: " + "Data not available"+
                        "\nCore Competency: " + test_jobConstructorEmptyFields2DifferentFields.getCoreCompetency() +
                        "\n",
                    test_jobConstructorEmptyFields2DifferentFields.toString());
    }

    @Test
    public void testToStringOopsIfAllFieldsEmpty() {
        assertEquals("\nID: " + test_jobConstructorAllFieldsEmptyStringOrNull.getId() +
                "\nOOPS! This job does not seem to exist.",
                test_jobConstructorAllFieldsEmptyStringOrNull.toString());
    }

//    @Test
//    public void inheritsSuperInFirstConstructor() {
//        assertEquals(0,0 /* (something only in Super), (check if it is in instance of extended class) */);
//    }

}
