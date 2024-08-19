import java.awt.Color;
import java.util.List;

class Plant extends Entity {
    int energyUpdate = 1;

    public Plant(int x, int y, int health, int energy, Color color) {
        super(x, y, health, energy, color);
    }

    @Override
    public void update(List<Entity> entities) {
        energy += energyUpdate; // Растение растут каждый тик
    }

    @Override
    public String getTooltipText() {
        return String.format("Plant: Energy = %d, Health = %d", energy, health);
    }
}
