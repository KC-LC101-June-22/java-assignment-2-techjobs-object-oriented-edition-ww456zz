package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId() {
        Job one = new Job();
        Job two = new Job();

        assertNotEquals(one.getId(),two.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job test = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(test.getName() instanceof String);
        assertEquals("Product tester", test.getName());

        assertTrue(test.getEmployer() instanceof Employer);
        assertEquals("ACME", test.getEmployer().getValue());

        assertTrue(test.getLocation() instanceof Location);
        assertEquals("Desert", test.getLocation().getValue());

        assertTrue(test.getPositionType() instanceof PositionType);
        assertEquals("Quality control", test.getPositionType().getValue());

        assertTrue(test.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", test.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job test = new Job("chickenEater", new Employer("Ceva"), new Location("Lenxa"), new PositionType("Production"), new CoreCompetency("eating"));
        Job test1 = new Job("chickenEater", new Employer("Ceva"), new Location("Lenxa"), new PositionType("Production"), new CoreCompetency("eating"));
        assertFalse(test.equals(test1));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job test = new Job("chickenEater", new Employer("Ceva"), new Location("Lenxa"), new PositionType("Production"), new CoreCompetency("eating"));
        char[] arr = test.toString().toCharArray();
        assertEquals('\n', arr[0]);
        assertEquals('\n', arr[arr.length - 1]);

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job test = new Job("Supervisor", new Employer("Ceva"), new Location("Lenxa"), new PositionType("Production Management"), new CoreCompetency("Java"));
        String expected = "\nID: 4\nName: Supervisor\nEmployer: Ceva\nLocation: Lenxa\nPosition Type: Production Management\nCore Competency: Java\n";
        assertEquals(expected, test.toString());
        }

    @Test
    public void testToStringHandlesEmptyField() {
        Job test = new Job("", new Employer("ABC"), new Location(""), new PositionType("New"), new CoreCompetency("") );
        String expected = "\nID: 3\nName: Data not available\nEmployer: ABC\nLocation: Data not available\nPosition Type: New\nCore Competency: Data not available\n";
        assertEquals(expected, test.toString());
        }
    }

