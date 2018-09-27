package pl.kucharski.testApp.enums;

public enum JobCategory {

    IT("IT"), FOOD_AND_DRINKS("Food & drinks"), OFFICE("Office"), COURIER("Courier"), SHOP_ASSISSTANT("Shop assistant");

    private String description;

    JobCategory(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
