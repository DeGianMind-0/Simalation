import java.awt.*;
import java.util.List;
import java.util.Random;

class Animal extends Entity {

    private TypeOfFood typeOfFood;
    private List<Organ> organs;
    private Mouth mouth;

    private int damage = 0;
    private int armor = 0;
    private int vision = 0;
    private int speed = 0;
    private int eatEnergy = 0;
    private int defaultEnergy;


    public Animal(int health, int energy, Color color, Mouth mouth, List<Organ> organs) {
        super(0, 0, health, energy, color);
        this.defaultEnergy = energy;
        this.mouth = mouth;
        this.organs = organs;
        updateParametersAnimal();
    }

    public Animal(int x, int y, int health, int energy, Color color, Mouth mouth, List<Organ> organs) {
        this(health, energy, color, mouth, organs);
        this.x = x;
        this.y = y;
    }

    public Animal setCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
        return this;
    }

    private void updateParametersAnimal() {
        typeOfFood = mouth.type;
        eatEnergy = mouth.eatEnergy;
        organs.add(mouth);
        for (Organ organ : organs) {
            this.damage += organ.getDamage();
            this.armor += organ.getArmor();
            this.vision += organ.getVision();
            this.speed += organ.getSpeed();
        }
    }

    @Override
    public void update(List<Entity> entities) {
        // Simplified movement logic
        Random rand = new Random();
        x += rand.nextInt(3) - 1; // move x by -1, 0 or 1
        y += rand.nextInt(3) - 1; // move y by -1, 0 or 1

        Entity target = findTarget(entities);
        move(target);
        eat(target);

        // Reproduce logic
        reproduce(entities);


    }

    private void eat(Entity target) {
        if (target != null && distanceTo(target) <= ENTITY_SIZE) {
            if (!target.isDead()) {
                target.attack(damage);
            } else {
                energy += target.eat(eatEnergy);
            }
        }
    }

    void move(Entity target) {
        if (target != null && distanceTo(target) <= vision) {
            moveTowards(target);
        } else {
            moveRandomly();
        }
    }

    private void moveTowards(Entity target) {
        int dx = target.x - this.x;
        int dy = target.y - this.y;
        double distance = Math.sqrt(dx * dx + dy * dy);

        if (distance > 0) {
            this.x += (int) (dx / distance * speed);
            this.y += (int) (dy / distance * speed);
        }

        // Убедимся, что животное не выходит за границы
        this.x = Math.max(0, Math.min(this.x, 800 - ENTITY_SIZE));
        this.y = Math.max(0, Math.min(this.y, 600 - ENTITY_SIZE));
    }

    private void moveRandomly() {
        Random rand = new Random();
        this.x += rand.nextInt(speed * 2 + 1) - speed;
        this.y += rand.nextInt(speed * 2 + 1) - speed;
        this.x = Math.max(0, Math.min(this.x, 800 - ENTITY_SIZE));
        this.y = Math.max(0, Math.min(this.y, 600 - ENTITY_SIZE));
    }

    @Override
    public String getTooltipText() {
        return String.format("Animal: Type = %s, Energy = %d, Health = %d", typeOfFood, energy, health);
    }

    private Entity findTarget(List<Entity> entities) {
        Entity target = null;
        double closestDistance = Double.MAX_VALUE;
        for (Entity entity : entities) {
            if (isValidTarget(entity)) {
                double distance = distanceTo(entity);
                if (distance < closestDistance && distance <= vision) {
                    closestDistance = distance;
                    target = entity;
                }
            }
        }
        return target;
    }

    private boolean isValidTarget(Entity entity) {
        if (entity == this) return false;
        switch (typeOfFood) {
            case CARNIVORE:
                return entity instanceof Animal;
            case HERBIVORE:
                return entity instanceof Plant;
            case OMNIVORE:
                return true;
            default:
                return false;
        }
    }

    private double distanceTo(Entity other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }

    private void reproduce(List<Entity> entities) {
        if (energy > defaultEnergy * 2) {
            energy -= defaultEnergy;
            entities.add(new Animal(x, y, health, defaultEnergy, color, mouth, organs));
        }
    }

    public TypeOfFood getTypeOfFood() {
        return typeOfFood;
    }
}