package DesignPatterns.Flyweight;

public class BulletGameDemo {
    public static void main(String[] args) {
        // Create game simulation
        GameSimulation game = new GameSimulation();
        
        System.out.println("=== PUBG-Style Bullet Simulation with Flyweight Pattern ===\n");
        
        // Simulate firing different weapons
        game.fireWeapon("pistol", 0, 0, 1.8, 0.1);
        game.fireWeapon("rifle", 5, 10, 1.7, 0.2);
        game.fireWeapon("shotgun", -5, -8, 1.6, -0.3);
        game.fireWeapon("sniper", 20, -15, 3.0, 0.5);
        
        System.out.println("\nTotal bullet type objects created: " + BulletFactory.getTotalBulletTypes());
        System.out.println("Total active bullets: " + game.getActiveBulletCount());
        
        // Simulate a few game frames
        for (int frame = 1; frame <= 3; frame++) {
            System.out.println("\n--- Frame " + frame + " ---");
            
            // Update all bullets
            game.updateBullets(0.016); // ~60 FPS
            
            // Simulate some hits
            if (frame > 1) {
                game.simulateTargetHit();
                game.simulateTargetHit();
            }
            
            System.out.println("Active bullets remaining: " + game.getActiveBulletCount());
        }
        
        // Fire more bullets of existing types (reusing flyweights)
        System.out.println("\n--- Firing more bullets (should reuse existing bullet types) ---");
        game.fireWeapon("rifle", 8, 12, 1.7, 0.15);
        game.fireWeapon("shotgun", -10, 5, 1.6, -0.1);
        
        System.out.println("\nFinal bullet type count: " + BulletFactory.getTotalBulletTypes());
        System.out.println("Final active bullet count: " + game.getActiveBulletCount());
        
        // Show memory benefit
        System.out.println("\n=== Memory Usage Analysis ===");
        System.out.println("Without Flyweight: Would need to store texture, sound, damage, etc. for each bullet");
        System.out.println("With Flyweight: Storing only " + BulletFactory.getTotalBulletTypes() + 
                           " shared resources for " + game.getActiveBulletCount() + " bullets");
    }
}