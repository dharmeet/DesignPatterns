package DesignPatterns.Flyweight;

import java.util.HashMap;
import java.util.Map;

// Flyweight Factory
public class BulletFactory {
    private static final Map<String, BulletType> bulletTypes = new HashMap<>();
    
    // Get or create a bullet type
    public static BulletType getBulletType(String bulletTypeName) {
        BulletType bulletType = bulletTypes.get(bulletTypeName);
        
        if (bulletType == null) {
            // Create new bullet type based on name
            switch (bulletTypeName) {
                case "9mm":
                    bulletType = new BulletType("9mm_texture.png", 15, 0.008, "9mm_fire.wav", 0.009);
                    break;
                case "5.56mm":
                    bulletType = new BulletType("556mm_texture.png", 25, 0.012, "556mm_fire.wav", 0.0117);
                    break;
                case "7.62mm":
                    bulletType = new BulletType("762mm_texture.png", 40, 0.033, "762mm_fire.wav", 0.0155);
                    break;
                case "shotgun":
                    bulletType = new BulletType("shotgun_texture.png", 80, 0.24, "shotgun_fire.wav", 0.18);
                    break;
                default:
                    bulletType = new BulletType("default_texture.png", 10, 0.01, "default_fire.wav", 0.01);
            }
            bulletTypes.put(bulletTypeName, bulletType);
        }
        
        return bulletType;
    }
    
    public static int getTotalBulletTypes() {
        return bulletTypes.size();
    }
}