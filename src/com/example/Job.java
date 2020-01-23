package com.example;

enum Job {

    SOFTWARE_ENGINEER("Software engineer"),
    QUALITY_ASSURANCE("Quality assurance"),
    SOFTWARE_ENGINEER_LEAD("Software engineer lead"),
    QUALITY_ASSURANCE_LEAD("Quality assurance lead"),
    PRODUCT_DESIGNER("Product designer"),
    PRODUCT_DESIGNER_LEAD("Product designer lead"),
    SUPPORT("Support");

    private String name;

    Job(String name) {
        this.name = name;
    }


    public static void showJobs() {
        int index = 1;
        for (Job job : Job.values()) {
            System.out.println(index + " - " + job);
            index++;
        }
    }

    public static Job getJob(int nr) {
        return values()[nr - 1];
    }

    public String toString() {
        return name;
    }

}