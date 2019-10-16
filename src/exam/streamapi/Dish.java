package exam.streamapi;

public class Dish {
  /** 메뉴 */
  private final String name;
  /** 채소 여부 */
  private final boolean vegetarian;
  /** 칼로리 */
  private final int calories;
  /** 메뉴 타입 */
  private final Type type;

  public Dish(String name, boolean vegetarian, int calories, Type type) {
    this.name = name;
    this.vegetarian = vegetarian;
    this.calories = calories;
    this.type = type;
  }

  public String getName() { return name; }

  public boolean isVegetarian() { return vegetarian; }

  public int getCalories() { return calories; }

  public Type getType() { return type; }

  @Override
  public String toString() {
    return "Dish [name=" + name + ", vegetarian=" + vegetarian + ", calories=" + calories + ", type=" + type + "]";
  }

  public enum Type {
    MEAT, FISH, OTHER
  }
}

