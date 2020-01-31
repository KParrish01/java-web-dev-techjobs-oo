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

    @Before
    public void init() {
        test_job1 = new Job();
        test_job2 = new Job();
        test_jobConstructor = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        test_jobConstructorDifferentId = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
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

//    @Test                    // <<<<<<delete before handing it in
//    public void testIdNotNull() {
//        assertNotNull(test_job1.getId());
//    }
//    @Test
//    public void testsSettingJobIdSequential() {
//        assertEquals(test_job2.getId(), (test_job1.getId() + 1), .001);
//    }
//    @Test
//    public void testSettingJobIdSequentialTrue(){
//        assertTrue(test_job1.getId() + 1 == test_job2.getId());
//    }

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
    public void testJobsForEquality() {
//        System.out.println("Test - equal except ID is not equal #" + numTestsRun);
//        System.out.println("ID of jobConstructor: " + test_jobConstructor.getId());
//        System.out.println("ID of jobConstructorDifferentId: " + test_jobConstructorDifferentId.getId());
        assertFalse(test_jobConstructor == test_jobConstructorDifferentId);
    }

    @Test
    public void testBlankLineBeforeAndAfter() {
//        assertEquals(test_jobConstructor.toString(), "");
        assertEquals(test_jobConstructor.toString(),
                "\nID: " + test_jobConstructor.getId() +
                "\nName: " + test_jobConstructor.getName() +
                "\nEmployer: " + test_jobConstructor.getEmployer()+
                "\nLocation: " + test_jobConstructor.getLocation() +
                "\nPosition Type: " + test_jobConstructor.getPositionType() +
                "\nCore Competency: " + test_jobConstructor.getCoreCompetency() +
                "\n");
//        if(!test_jobConstructor.getId() instanceof );
//        if(!test_jobConstructor.getName() instanceof String) {;
    }

//    @Test
//    public void inheritsSuperInFirstConstructor() {
//        assertEquals(0,0 /* (something only in Super), (check if it is in instance of extended class) */);
//    }

}
