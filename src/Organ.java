class Organ {
    private OrganType type;
    private int damage, armor, vision, speed;

    public Organ(OrganType type, int damage, int armor, int vision, int speed) {
        this.type = type;
        this.damage = damage;
        this.armor = armor;
        this.vision = vision;
        this.speed = speed;
    }

    public int getDamage() {
        return damage;
    }

    public int getArmor() {
        return armor;
    }

    public int getVision() {
        return vision;
    }

    public int getSpeed() {
        return speed;
    }
}
