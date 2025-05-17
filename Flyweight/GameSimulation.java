package DesignPatterns.Flyweight;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Client class that uses bullets in a game simulation
public class GameSimulation {
    private List<Bullet> activeBullets = new ArrayList<>();
    private Random random = new Random();
    
    // Simulate firing a weapon
    public void fireWeapon(String weaponType, double x, double y, double z, double direction) {
        String bulletType;
        int bulletCount;
        double speed;
        double spread;
        
        // Configure weapon properties
        switch (weaponType) {
            case "pistol":
                bulletType = "9mm";
                bulletCount = 1;
                speed = 350;
                spread = 0.05;
                break;
            case "rifle":
                bulletType = "5.56mm";
                bulletCount = 1;
                speed = 850;
                spread = 0.02;
                break;
            case "sniper":
                bulletType = "7.62mm";
                bulletCount = 1;
                speed = 1200;
                spread = 0.005;
                break;
            case "shotgun":
                bulletType = "shotgun";
                bulletCount = 8;
                speed = 400;
                spread = 0.2;
                break;
            default:
                bulletType = "9mm";
                bulletCount = 1;
                speed = 300;
                spread = 0.1;
        }
        
        // Create bullets
        for (int i = 0; i < bulletCount; i++) {
            // Apply random spread to direction
            double actualDirection = direction + (random.nextDouble() - 0.5) * spread;
            
            // Create new bullet
            Bullet bullet = new Bullet(
                bulletType, 
                x, 
                y, 
                z, 
                actualDirection,
                speed
            );
            
            // Add to active bullets
            activeBullets.add(bullet);
        }
        
        System.out.println("Fired " + bulletCount + " " + bulletType + " bullets from " + weaponType);
    }
    
    // Update all bullets (called each frame)
    public void updateBullets(double deltaTime) {
        System.out.println("\nUpdating " + activeBullets.size() + " bullets...");
        
        // Create a copy of the list to avoid concurrent modification
        List<Bullet> bullets = new ArrayList<>(activeBullets);
        
        for (Bullet bullet : bullets) {
            bullet.update(deltaTime);
            
            // Remove inactive bullets
            if (!bullet.isActive() || isOutOfBounds(bullet)) {
                activeBullets.remove(bullet);
            }
        }
    }
    
    // Check if bullet is out of game boundaries
    private boolean isOutOfBounds(Bullet bullet) {
        // Simplified boundary check
        double maxDistance = 1000; // Max bullet travel distance
        return Math.abs(bullet.getPositionX()) > maxDistance || 
               Math.abs(bullet.getPositionY()) > maxDistance ||
               bullet.getPositionZ() < 0;
    }
    
    // Simulate hitting a target
    public void simulateTargetHit() {
        if (activeBullets.isEmpty()) return;
        
        // Randomly select a bullet
        int index = random.nextInt(activeBullets.size());
        Bullet bullet = activeBullets.get(index);
        
        // Create a target near the bullet's path
        double targetX = bullet.getPositionX() + (random.nextDouble() - 0.5) * 3;
        double targetY = bullet.getPositionY() + (random.nextDouble() - 0.5) * 3;
        double targetZ = bullet.getPositionZ();
        
        // Check collision with target
        bullet.checkCollision(targetX, targetY, targetZ, 1.0);
    }
    
    public int getActiveBulletCount() {
        return activeBullets.size();
    }
}