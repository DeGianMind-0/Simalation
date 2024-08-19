public class Mouth extends Organ {

    TypeOfFood type;
    int eatEnergy; //количество поедаемой энергии за такт

    public Mouth(TypeOfFood type, int damage, int eatEnergy) {
        super(OrganType.MOUTH, damage, 0, 0, 0);
        this.type = type;
        this.eatEnergy = eatEnergy;
    }
}
