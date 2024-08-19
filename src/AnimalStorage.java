import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class AnimalStorage {
    private static Random random = new Random();
    private static HashSet<Color> colors = new HashSet();
    private static Map<TypeOfFood, List<Animal>> animals = new HashMap<>();

    static {
        animals.put(TypeOfFood.CARNIVORE, generateAnimals(TypeOfFood.CARNIVORE));
        animals.put(TypeOfFood.HERBIVORE, generateAnimals(TypeOfFood.HERBIVORE));
        animals.put(TypeOfFood.OMNIVORE, generateAnimals(TypeOfFood.OMNIVORE));
    }

    private static List<Animal> generateAnimals(TypeOfFood type) {
        List<Animal> result = new ArrayList<>();
        List<Organ> organsClaw = OrganStorage.getStorageOrgans().get(OrganType.CLAW);
        List<Organ> organsVision = OrganStorage.getStorageOrgans().get(OrganType.VISION);
        List<Organ> organsDefense = OrganStorage.getStorageOrgans().get(OrganType.DEFENSE);
        List<Organ> organsLeg = OrganStorage.getStorageOrgans().get(OrganType.LEG);
        List<Mouth> mouths = OrganStorage.getStorageMouths().get(type);
        for (int i = 0; i < 5; i++) {
//            Color newColor = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
//            while (colors.contains(newColor)) {
//                newColor = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
//            }
//            colors.add(newColor);
            Color newColor = type == TypeOfFood.CARNIVORE ? Color.RED : type == TypeOfFood.HERBIVORE ? Color.BLUE : Color.GRAY;
            List<Organ> organs = new ArrayList<>();
            organs.add(organsClaw.get(random.nextInt(organsClaw.size() - 1)));
            organs.add(organsVision.get(random.nextInt(organsVision.size() - 1)));
            organs.add(organsDefense.get(random.nextInt(organsDefense.size() - 1)));
            organs.add(organsLeg.get(random.nextInt(organsLeg.size() - 1)));
            Mouth mouth = mouths.get(random.nextInt(mouths.size() - 1));
            result.add(new Animal(100, 100, newColor, mouth, organs));
        }
        return result;
    }

    public static List<Animal> getAnimals(TypeOfFood type) {
        return animals.get(type);
    }

    public static Animal getRandomAnimal(TypeOfFood type) {
        List<Animal> animalList = animals.get(type);
        return animalList.get(random.nextInt(animalList.size() - 1));
    }
}
