import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrganStorage {

    private static Map<OrganType, List<Organ>> storageOrgans = new HashMap<>();
    private static Map<TypeOfFood, List<Mouth>> storageMouths = new HashMap<>();

    static {
        storageOrgans.put(OrganType.CLAW, List.of(
                new Organ(OrganType.CLAW, 20, 0,0,0),
                new Organ(OrganType.CLAW, 30, 0,0,0),
                new Organ(OrganType.CLAW, 40, 0,0,0),
                new Organ(OrganType.CLAW, 50, 0,0,0),
                new Organ(OrganType.CLAW, 60, 0,0,0)
        ));

        storageOrgans.put(OrganType.VISION, List.of(
                new Organ(OrganType.VISION, 0, 0,100,0),
                new Organ(OrganType.VISION, 0, 0,120,0),
                new Organ(OrganType.VISION, 0, 0,150,0),
                new Organ(OrganType.VISION, 0, 0,80,0),
                new Organ(OrganType.VISION, 0, 0,60,0)
        ));

        storageOrgans.put(OrganType.DEFENSE, List.of(
                new Organ(OrganType.DEFENSE, 0, 5,0,0),
                new Organ(OrganType.DEFENSE, 0, 10,0,0),
                new Organ(OrganType.DEFENSE, 0, 15,0,0),
                new Organ(OrganType.DEFENSE, 0, 20,0,0),
                new Organ(OrganType.DEFENSE, 0, 25,0,0)
        ));

        storageOrgans.put(OrganType.LEG, List.of(
                new Organ(OrganType.LEG, 0, 0,0,6),
                new Organ(OrganType.LEG, 0, 0,0,7),
                new Organ(OrganType.LEG, 0, 0,0,9),
                new Organ(OrganType.LEG, 0, 0,0,10),
                new Organ(OrganType.LEG, 0, 0,0,13)
        ));

        storageMouths.put(TypeOfFood.CARNIVORE, List.of(
                new Mouth(TypeOfFood.CARNIVORE, 10, 30),
                new Mouth(TypeOfFood.CARNIVORE, 15, 40),
                new Mouth(TypeOfFood.CARNIVORE, 20, 50)
        ));
        storageMouths.put(TypeOfFood.HERBIVORE, List.of(
                new Mouth(TypeOfFood.HERBIVORE, 0, 50),
                new Mouth(TypeOfFood.HERBIVORE, 0, 60),
                new Mouth(TypeOfFood.HERBIVORE, 0, 70)
        ));
        storageMouths.put(TypeOfFood.OMNIVORE, List.of(
                new Mouth(TypeOfFood.OMNIVORE, 5, 40),
                new Mouth(TypeOfFood.OMNIVORE, 10, 50),
                new Mouth(TypeOfFood.OMNIVORE, 15, 60)
        ));
    }

    public static Map<OrganType, List<Organ>> getStorageOrgans() {
        return storageOrgans;
    }

    public static Map<TypeOfFood, List<Mouth>> getStorageMouths() {
        return storageMouths;
    }
}
