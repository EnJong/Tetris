package config;

public class ConfigFactory {

	public static GameConfig<Object> GAME_CONFIG = null;

	static {
		try {
			GAME_CONFIG = new GameConfig<Object>();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static GameConfig<Object> getGameConfig() {
		return GAME_CONFIG;
	}
	
}
