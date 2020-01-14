package StreamDemo;

public class Dish {

    private String name;

    private Integer calories;

    private String unit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    Dish(String name, Integer calories, String unit){
        this.name = name;
        this.calories = calories;
        this.unit = unit;
    }
}
