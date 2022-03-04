package org.launchcode.techjobs_oo.tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class JobTests {

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();

        assertFalse(job1.equals(job2));
        assertTrue((job2.getId() - 1) == (job1.getId()));

    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(testJob instanceof Job);
        assertTrue(testJob.getName() == "Product tester");

        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getEmployer().getValue() == "ACME");

        assertTrue(testJob.getLocation() instanceof Location);
        assertTrue(testJob.getLocation().getValue() == "Desert");

        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertTrue(testJob.getPositionType().getValue() == "Quality control");

        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(testJob.getCoreCompetency().getValue() == "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringBlankLines() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        int last = (job.toString().length() - 1);
        assertTrue(job.toString().charAt(0) == '\n');
        assertTrue(job.toString().charAt(last) == '\n');

    }

    @Test
    public void testToStringLabelsandValues() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String[] lines = job.toString().trim().split("\n");
        System.out.println(lines);

        assertTrue(lines[0].startsWith("ID:"));
        assertTrue(lines[1].startsWith("Name:"));
        assertTrue(lines[2].startsWith("Employer:"));
        assertTrue(lines[3].startsWith("Location:"));
        assertTrue(lines[4].startsWith("Position Type:"));
        assertTrue(lines[5].startsWith("Core Competency:"));

        assertTrue(lines[0].endsWith(Integer.toString(job.getId())));
        assertTrue(lines[1].endsWith(job.getName()));
        assertTrue(lines[2].endsWith(job.getEmployer().toString()));
        assertTrue(lines[3].endsWith(job.getLocation().toString()));
        assertTrue(lines[4].endsWith(job.getPositionType().toString()));
        assertTrue(lines[5].endsWith(job.getCoreCompetency().toString()));


    }

    @Test
    public void testToStringEmpty() {
        Job job = new Job();
        String[] strings = job.toString().trim().split("\n");

        List<String> list = new ArrayList<>(Arrays.asList(strings));
        System.out.println(list);

        list.remove(0);
        strings = list.toArray(new String[list.size()]);
        System.out.println(list);
        String empty = "Data not available";
        for (String string : strings) {
            assertTrue(string.endsWith(empty));
        }

    }
}
