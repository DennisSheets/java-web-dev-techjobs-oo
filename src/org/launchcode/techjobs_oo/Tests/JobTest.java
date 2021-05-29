package org.launchcode.techjobs_oo.Tests;

import org.junit.Test;
import org.junit.Before;
import org.launchcode.techjobs_oo.*;
import org.launchcode.techjobs_oo.Employer;

import static org.junit.Assert.*;

public class JobTest {

    Job jobA;
    Job jobB;
    Job jobC;
    Job jobD;
    Job jobE;
    Job jobF;

    @Before
    public void setup() {

        jobA = new Job();
        jobB = new Job();
        jobC = new Job();
        jobD = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        jobE = new Job();
        jobF = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
    }

    @Test
    public void TestSettingJobId() {
        assertEquals(2,jobC.getId() - jobA.getId(),.001);
    }

    @Test
    public void TestJobConstructorSetsAllFields(){
        assertEquals("Product tester",jobD.getName());
        assertTrue(jobD.getEmployer() instanceof Employer);
        assertTrue(jobD.getLocation() instanceof Location);
        assertTrue(jobD.getPositionType() instanceof PositionType);
        assertTrue(jobD.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("ACME",jobD.getEmployer().getValue());
        assertEquals("Desert",jobD.getLocation().getValue());
        assertEquals("Quality Control",jobD.getPositionType().getValue());
        assertEquals("Persistence",jobD.getCoreCompetency().getValue());
    }

    @Test
    public void TestJobsForEquality() {
        assertFalse(jobA.equals(jobB));
    }

    @Test
    public void TestToStringLeadTrailingBlankLines() {
        char[] chars = jobD.toString().toCharArray();
        assertTrue("Leading Char is an empty line  \n",chars[0] == '\n');
        assertTrue("Trailing Char is an empty line \n",chars[chars.length -1] == '\n');
    }

    @Test
    public void TestToStringToCreateToString() {
        String string = "\n" +
                "ID: 4\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality Control\n" +
                "Core Competency: Persistence\n";
        assertTrue(jobD.toString().equals(string));
    }

    @Test  // bonus
    public void TestToStringBlankA() {
        assertTrue(jobF.toString().equals("OOPS! This job does not seem to exist."));
    }

    @Test  // bonus
    public void TestToStringBlankB() {
        assertTrue(jobF.toString().contains("OOPS! This job does not seem to exist."));
    }
}
