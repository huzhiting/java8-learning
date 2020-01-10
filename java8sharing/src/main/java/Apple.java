import java.util.function.BiFunction;

public class Apple {

    private String color;

    private int no;

    private Integer weight;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    Apple(String n, Integer a) {
        color = n;
        weight = a;
    }

    @Override
    public String toString() {
        return String.format("{color=%s, weight=%d}", color, weight);
    }
}
