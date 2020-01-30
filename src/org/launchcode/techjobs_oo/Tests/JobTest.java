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
        System.out.println(numTestsRun);
          System.out.println("ID of job: " + test_job2.getId());
          System.out.println("ID of job: " + test_job1.getId());
          System.out.println("ID of jobConstructor: " + test_jobConstructor.getId());
          System.out.println("ID of jobConstructorDifferentId: " + test_jobConstructorDifferentId.getId());
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
    public void emptyTestToImportJunits() {
          System.out.println("1 - emptyTest #" + numTestsRun);
        assertTrue(1==1);
        assertFalse(1==2);
        assertEquals(1, 1, .001);
    }

    @Test
    public void testNotNull() {
        System.out.println("2 - not Null #" + numTestsRun);
//        int test_id1 = new Job().getId();
//        assertNotNull(test_id1);
        assertNotNull(test_job1.getId());
    }

    @Test
    public void testSettingJobId(){
          System.out.println("3 - testSettingJobId #" + numTestsRun);
//        int test_id1 = new Job().getId();
//        System.out.println(test_id1);
//        int test_id2 = new Job().getId();
//        System.out.println(test_id2);
//        System.out.println(test_id1);
//        assertFalse(test_id1 == test_id2);
        assertFalse(test_job1.getId() == test_job2.getId());

    }

    @Test
    public void testsSettingJobIdSequential() {
          System.out.println("4 - IdSequential #" + numTestsRun);
//        int test_id1 = new Job().getId();
//        int test_id2 = new Job().getId();
//        System.out.println(test_id2);
//        System.out.println(test_id1);
//        assertEquals(test_id2, (test_id1 + 1), .001);
        assertEquals(test_job2.getId(), (test_job1.getId() + 1), .001);
    }

    @Test
    public void testSettingJobIdSequentialTrue(){
          System.out.println("5 - IdSequentialTrue #" + numTestsRun);
//        int test_id1 = new Job().getId();
//        int test_id2 = new Job().getId();
//        System.out.println(test_id2);
//        System.out.println(test_id1);
//        assertTrue(test_id1 + 1 == test_id2);
        assertTrue(test_job1.getId() + 1 == test_job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFieldsClasses() {
        assertTrue(test_jobConstructor instanceof Job);
        assertTrue(test_jobConstructor.getName() instanceof String);
        assertTrue(test_jobConstructor.getEmployer() instanceof Employer);
        assertTrue(test_jobConstructor.getLocation() instanceof Location);
        assertTrue(test_jobConstructor.getPositionType() instanceof PositionType);
        assertTrue(test_jobConstructor.getCoreCompetency() instanceof CoreCompetency);
          System.out.println("6 - instanceOfJob #" + numTestsRun);
    }

    @Test
    public void testJobConstructorSetsAllFieldsValues() {
        assertNotNull(test_jobConstructor.getId());
        assertEquals("Product tester", test_jobConstructor.getName());
        assertEquals("ACME", test_jobConstructor.getEmployer().getValue());
        assertEquals("Desert", test_jobConstructor.getLocation().getValue());
        assertEquals("Quality control", test_jobConstructor.getPositionType().getValue());
        assertEquals("Persistence", test_jobConstructor.getCoreCompetency().getValue());
          System.out.println("7 - setsFieldValues #" + numTestsRun);
//        System.out.println(test_jobConstructor.getEmployer());
//        System.out.println(test_jobConstructor.getEmployer().getValue());
//        System.out.println("ACME");
//        assertEquals("ACME", test_jobConstructor.getEmployer()); // this did not work...
    }

    @Test
    public void testJobsForEquality(){
        System.out.println("8 - equal except ID is not equal #" + numTestsRun);
        System.out.println("ID of jobConstructor: " + test_jobConstructor.getId());
        System.out.println("ID of jobConstructorDifferentId: " + test_jobConstructorDifferentId.getId());
        assertFalse(test_jobConstructor == test_jobConstructorDifferentId);
    }

}
