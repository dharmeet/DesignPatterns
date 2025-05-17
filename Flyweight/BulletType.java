package DesignPatterns.Flyweight;

// Flyweight - stores intrinsic (shared) state
public class BulletType {
    private final String image;       // Bullet texture/model
    private final double damage;      // Damage per hit
    private final double mass;        // Physics property
    private final String soundEffect; // Sound when fired
    private final double size;        // Bullet size

    public BulletType(String image, double damage, double mass, String soundEffect, double size) {
        this.image = image;
        this.damage = damage;
        this.mass = mass;
        this.soundEffect = soundEffect;
        this.size = size;
        
        // Simulate heavy resource loading (textures, sound, etc.)
        System.out.println("Loading heavy resources for bullet type: " + image);
        try {
            Thread.sleep(200); // Simulate expensive resource loading
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getImage() {
        return image;
    }

    public double getDamage() {
        return damage;
    }

    public double getMass() {
        return mass;
    }

    public String getSoundEffect() {
        return soundEffect;
    }
    
    public double getSize() {
        return size;
    }
    
    // Render the bullet (shared rendering code)
    public void render(double x, double y, double z, double direction, double speed) {
        System.out.println("Rendering " + image + " bullet at position (" + 
                           x + ", " + y + ", " + z + "), direction: " + direction + 
                           ", speed: " + speed);
    }
}
