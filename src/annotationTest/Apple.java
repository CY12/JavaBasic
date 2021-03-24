package annotationTest;

public class Apple {
    @FruitName("苹果")
    private String fruitName;

    @FruitColor(fruitColor = FruitColor.Color.BLUE)
    private String fruitColor;

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public String getFruitColor() {
        return fruitColor;
    }

    public void setFruitColor(String fruitColor) {
        this.fruitColor = fruitColor;
    }
}
