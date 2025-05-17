package DesignPatterns.Flyweight;

// Bullet - Context class that uses flyweight
public class Bullet {
    // Reference to the flyweight
    private final BulletType bulletType;
    
    // Extrinsic state - unique for each bullet
    private double positionX;
    private double positionY;
    private double positionZ;
    private double direction; // in radians
    private double speed;     // in units per second
    private boolean active;
    
    public Bullet(String bulletTypeName, double x, double y, double z, double direction, double speed) {
        // Get flyweight from factory
        this.bulletType = BulletFactory.getBulletType(bulletTypeName);
        
        // Set extrinsic state
        this.positionX = x;
        this.positionY = y;
        this.positionZ = z;
        this.direction = direction;
        this.speed = speed;
        this.active = true;
    }
    
    public void update(double deltaTime) {
        if (!active) return;
        
        // Update position based on direction and speed
        positionX += Math.cos(direction) * speed * deltaTime;
        positionY += Math.sin(direction) * speed * deltaTime;
        
        // Simulate bullet drop due to gravity
        positionZ -= 0.5 * bulletType.getMass() * 9.8 * deltaTime * deltaTime;
        
        // Render the bullet at new position
        render();
    }
    
    public void render() {
        if (active) {
            bulletType.render(positionX, positionY, positionZ, direction, speed);
        }
    }
    
    public boolean checkCollision(double targetX, double targetY, double targetZ, double targetRadius) {
        if (!active) return false;
        
        // Simple distance-based collision check
        double distance = Math.sqrt(
            Math.pow(targetX - positionX, 2) +
            Math.pow(targetY - positionY, 2) +
            Math.pow(targetZ - positionZ, 2)
        );
        
        if (distance < targetRadius + bulletType.getSize()) {
            // Hit detected
            System.out.println("Hit detected! Damage dealt: " + bulletType.getDamage());
            active = false; // Deactivate bullet
            return true;
        }
        
        return false;
    }
    
    // Getters and setters for extrinsic state
    public double getPositionX() { return positionX; }
    public double getPositionY() { return positionY; }
    public double getPositionZ() { return positionZ; }
    public double getDirection() { return direction; }
    public double getSpeed() { return speed; }
    public boolean isActive() { return active; }
    
    public void deactivate() {
        active = false;
    }
}