package CollectDemo;

public class Dish {

    private String name;

    private Integer calories;

    private  boolean vegetarian;

    private final Type type;

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

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public Type getType() {
        return type;
    }

    Dish(String name, Integer calories, Boolean vegetarian, Type type){
        this.name = name;
        this.calories = calories;
        this.vegetarian = vegetarian;
        this.type = type;
    }

    @Override
    public String toString()
    {
        return name;
    }

    public enum Type { MEAT, FISH, OTHER }
}
