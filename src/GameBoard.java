import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class GameBoard {

    private int plantGenerationRate;
    private ArrayList<Entity> entities = new ArrayList<>();
    private final Random random = new Random();
    private boolean isPaused = false;

    public void addAnimal(Animal animal) {
        entities.add(animal);
    }

    public void addPlant(Plant plant) {
        entities.add(plant);
    }

    public void update() {
        if (isPaused) return;

        changeEntities();
        for (Entity entity : entities) {
            entity.update(entities);
        }
    }

    private void changeEntities() {
        Iterator<Entity> iterator = entities.iterator();
        while (iterator.hasNext()) {
            Entity entity = iterator.next();
            if (entity.isDead()) {
                iterator.remove();
            }
        }
    }


    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void resetSimulation(int animalCarnivoreCount, int animalHerbivoreCount, int animalOmnivoreCount, int plantCount, int plantGenerationRate) {
        entities.clear();
        for (int i = 0; i < plantCount; i++) {
            addRandomPlant();
        }
        for (int i = 0; i < animalCarnivoreCount; i++) {
            addRandomAnimal(TypeOfFood.CARNIVORE);
        }
        for (int i = 0; i < animalHerbivoreCount; i++) {
            addRandomAnimal(TypeOfFood.HERBIVORE);
        }
        for (int i = 0; i < animalOmnivoreCount; i++) {
            addRandomAnimal(TypeOfFood.OMNIVORE);
        }
        this.plantGenerationRate = plantGenerationRate;
    }

    private void addRandomAnimal(TypeOfFood typeOfFood) {
        addAnimal(AnimalStorage.getRandomAnimal(typeOfFood).setCoordinate(random.nextInt(800), random.nextInt(600)));
    }

    private void addRandomPlant() {
        addPlant(new Plant(random.nextInt(800), random.nextInt(600), 50, 50, Color.GREEN));
    }


    public void togglePause() {
        isPaused = !isPaused;
    }

    public boolean isPaused() {
        return isPaused;
    }

}