package cn.itcast.authEnum;

/**
 * Created by gaoyu on 2017/6/7.
 * Wish you a good day~
 */
public enum Color {
    RED("red"), BLUE("blue"), BLACK("black"), WHITE("white"), ORANGE("orange"), YELLOW("yellow"), GREEN("green"), PURPLE("purple");
    String color;

    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
