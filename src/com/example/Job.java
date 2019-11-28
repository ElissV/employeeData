package com.example;

import java.util.EnumSet;

enum Job {
    SOFTWARE_ENGINEER,
    QUALITY_ASSURANCE,
    SOFTWARE_ENGINEER_LEAD,
    QUALITY_ASSURANCE_LEAD,
    PRODUCT_DESIGNER,
    PRODUCT_DESIGNER_LEAD,
    SUPPORT,;

    private static EnumSet<Job> jobs = EnumSet.allOf(Job.class);

    public static void showJobs() {
        int index = 1;
        for (Job job : jobs) {
            System.out.println(index + " - " + job);
            index++;
        }
    }

    public static Job getJob(int nr) {
        return values()[nr - 1];
    }

    public String toString() {
        String jobName = name().toLowerCase().replaceAll("_", " ");
        jobName = jobName.substring(0, 1).toUpperCase() + jobName.substring(1);
        return jobName;
    }

}