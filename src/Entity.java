import java.awt.Color;
import java.util.List;

abstract class Entity {

    public static final int ENTITY_SIZE = 10;

    protected int x, y;
    protected int health;
    protected int energy;
    protected Color color;

    public Entity(int x, int y, int health, int energy, Color color) {
        this.x = x;
        this.y = y;
        this.health = health;
        this.energy = energy;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }

    public abstract void update(List<Entity> entities);

    public void attack(int damage) {
        this.health -= damage;
    }

    public int eat(int eatEnargy) {
        if (!isDead()) {
            System.out.println("entity dont dead!");
        }
        int result = Math.min(eatEnargy, energy);
        energy -= result;
        return result;
    }


    public boolean isDead() {
        return health <= 0;
    }

    public boolean isDelete() {
        return energy <= 0;
    }

    public abstract String getTooltipText();
}