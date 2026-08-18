import java.util.*;
//Gang of Four, Singleton Design Pattern
public class GameConfig{
    private static GameConfig instance;

    private String resolution;
    private int audioVolume;
    private String difficultyLevel;

    private GameConfig(){
        System.out.println("Loading config. from disk...");
        resolution = "1920x1080";
        audioVolume = 50;
        difficultyLevel = "hard";
    }

    public static GameConfig getInstance(){
        if(instance == null){
            instance = new GameConfig();
        }
        return instance;
    }

    public String getResolution(){
        return resolution;
    }
    public void setResolution(String res){
        resolution = res;
    }

    public int getVolume(){
        return audioVolume;
    }
    public void setVolume(int vol){
        audioVolume = vol;
    }

    public String getDifficultyLevel(){
        return difficultyLevel;
    }
    public void setDifficultyLevel(String level){
        difficultyLevel = level;
    }
}