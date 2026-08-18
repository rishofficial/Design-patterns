// 1. The Prototype Interface
// We extend Java's built-in Cloneable interface so the system knows it's allowed to copy it.
public interface GameUnit extends Cloneable {
    GameUnit cloneUnit();
    void showInfo();
}

// 2. The Concrete Prototype
public class SpaceMarine implements GameUnit {
    
    // Expensive assets
    private String meshFile;
    private String textureMap;
    private String aiBehavior;
    
    // Unique stats per unit
    private int health;

    // The EXPENSIVE constructor
    public SpaceMarine() {
        System.out.println("Disk Action: Loading heavy 3D mesh, textures, and AI... (Takes 5 seconds)");
        this.meshFile = "SpaceMarine_Mesh_v1.obj";
        this.textureMap = "Marine_Tex_HighRes.png";
        this.aiBehavior = "Aggressive_Swarm_AI";
        this.health = 100;
    }

    // The MAGIC happens here. 
    // This bypasses the constructor entirely and instantly copies the object in memory.
    @Override
    public GameUnit cloneUnit() {
        try {
            return (SpaceMarine) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning failed!");
            return null;
        }
    }

    // A setter so we can change individual clone stats later
    public void setHealth(int health) { 
        this.health = health; 
    }

    @Override
    public void showInfo() {
        System.out.println("Space Marine Ready! Health: " + health + " | Assets: " + meshFile);
    }
}
public class GameRunner {
    public static void main(String[] args) {
        
        System.out.println("--- Level Loading ---");
        
        // Step 1: Create the base prototype (The slow part)
        SpaceMarine baseMarine = new SpaceMarine();
        
        System.out.println("\n--- Level Started! Player requests 3 units ---");
        
        // Step 2: Instantly clone the base marine instead of using 'new'
        SpaceMarine marine1 = (SpaceMarine) baseMarine.cloneUnit();
        SpaceMarine marine2 = (SpaceMarine) baseMarine.cloneUnit();
        SpaceMarine marine3 = (SpaceMarine) baseMarine.cloneUnit();
        
        // Step 3: We can modify the clones independently!
        // Marine 1 takes damage, but the others stay at 100 health.
        marine1.setHealth(45);
        
        marine1.showInfo();
        marine2.showInfo();
        marine3.showInfo();
    }
}
