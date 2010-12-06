package mcwrapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.Scanner;

public class Options {

	
	
	public int port=25565;
	public int internalPort=25566;
	public int memory=1024;
	public int maxPlayers=16;
	
	public boolean autoSave=true;
	public int autoSaveMins=5;
	public boolean autoBackup=true;
	public int autoBackupMins=30;
	public int keepBackupHours=2;
	public boolean autoRestart=false;
	public int autoRestartMins=240;
	
	public int createWarpRank=1;
	public int useWarpRank=1;
	public int warpPlayerRank=3;
	public int teleportRank=3;
	
	public int homeCommandRank=0;
	public int giveRank=1;
	public int givePlayerRank=2;
	public int setRankRank=3;
	public int muteRank=2;
	
	
	public int defaultRank=0;	
	
	
	public boolean useWhitelist=false;
	public boolean onlineMode=true;
	public boolean debug=false;
	public boolean experimental=false;
	public String levelName="world";
	public String alternateJarFile="";
	Properties optionsLoader;
	Properties serverOptions;
	
	public Options() {
		optionsLoader=new Properties();
	}
	public void save() {
		save(false);
	}
	public void save(boolean createNew) {
		try {
			File file = new File("simpleserver.properties");
			if (!file.exists()) {
				file.createNewFile();
			}
			FileOutputStream w = new FileOutputStream(file);
			optionsLoader.setProperty("port", Integer.toString(port));
			optionsLoader.setProperty("memory", Integer.toString(memory));
			optionsLoader.setProperty("internalPort", Integer.toString(internalPort));
			optionsLoader.setProperty("homeCommandRank", Integer.toString(homeCommandRank));
			optionsLoader.setProperty("autoSaveMins", Integer.toString(autoSaveMins));
			optionsLoader.setProperty("autoBackupMins", Integer.toString(autoBackupMins));
			optionsLoader.setProperty("autoRestartMins", Integer.toString(autoRestartMins));
			optionsLoader.setProperty("keepBackupHours", Integer.toString(keepBackupHours));
			optionsLoader.setProperty("maxPlayers", Integer.toString(maxPlayers));
			optionsLoader.setProperty("giveRank", Integer.toString(giveRank));
			optionsLoader.setProperty("muteRank", Integer.toString(muteRank));
			
			optionsLoader.setProperty("teleportRank", Integer.toString(teleportRank));
			optionsLoader.setProperty("createWarpRank", Integer.toString(createWarpRank));
			optionsLoader.setProperty("useWarpRank", Integer.toString(useWarpRank));
			optionsLoader.setProperty("warpPlayerRank", Integer.toString(warpPlayerRank));
			
			optionsLoader.setProperty("givePlayerRank", Integer.toString(givePlayerRank));
			optionsLoader.setProperty("setRankRank", Integer.toString(setRankRank));
			optionsLoader.setProperty("defaultRank", Integer.toString(defaultRank));
			optionsLoader.setProperty("autoBackup", Boolean.toString(autoBackup));
			optionsLoader.setProperty("autoSave", Boolean.toString(autoSave));
			optionsLoader.setProperty("autoRestart", Boolean.toString(autoRestart));
			optionsLoader.setProperty("useWhitelist", Boolean.toString(useWhitelist));
			optionsLoader.setProperty("onlineMode", Boolean.toString(onlineMode));
			optionsLoader.setProperty("levelName", levelName);
			optionsLoader.setProperty("alternateJarFile", alternateJarFile);
			optionsLoader.store(w, "");
			if (createNew) { 
				System.out.println("Properties file not found! Created simpleserver.properties! Adjust values and then start the server again!");
				System.out.println("Press enter to continue...");
				Scanner in = new Scanner(System.in);
				in.nextLine();
				w.close();
				System.exit(0);
			}
			w.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Could not write the properties file!");
		}
		
	}
	
	public void saveMinecraftProperties() {
		try {
			File file = new File("server.properties");
			serverOptions = new Properties();
			if (!file.exists()) {
				file.createNewFile();
			}
			else {
				FileInputStream r = new FileInputStream(file);
				serverOptions.load(r);
				r.close();
			}
			FileOutputStream w = new FileOutputStream(file);
			serverOptions.setProperty("online-mode", Boolean.toString(onlineMode));
			serverOptions.setProperty("server-ip", "127.0.0.1");
			serverOptions.setProperty("server-port", Integer.toString(internalPort));
			serverOptions.setProperty("max-players", Integer.toString(maxPlayers));
			serverOptions.setProperty("level-name", levelName);
			serverOptions.store(w, "Generated by SimpleServer\r\nDO NOT EDIT THIS FILE!");
			w.close();
			
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Could not write Minecraft properties file!");
		}
	}
	
	public void load() {
		try {
			File file = new File("simpleserver.properties");
			if (!file.exists()) {
				file.createNewFile();
				save(true);
				return;
			}
			FileInputStream r = new FileInputStream(file);
			if (r==null || r.available()==0) {
				file.createNewFile();
				save(true);
				return;
			}
			optionsLoader.load(r);
			if (optionsLoader.getProperty("port")!=null)
				port = Integer.valueOf(optionsLoader.getProperty("port"));
			if (optionsLoader.getProperty("memory")!=null)
				memory = Integer.valueOf(optionsLoader.getProperty("memory"));
			if (optionsLoader.getProperty("internalPort")!=null)
				internalPort = Integer.valueOf(optionsLoader.getProperty("internalPort"));
			if (optionsLoader.getProperty("autoSaveMins")!=null)
				autoSaveMins = Integer.valueOf(optionsLoader.getProperty("autoSaveMins"));
			if (optionsLoader.getProperty("autoBackupMins")!=null)
				autoBackupMins = Integer.valueOf(optionsLoader.getProperty("autoBackupMins"));
			if (optionsLoader.getProperty("autoRestartMins")!=null)
				autoRestartMins = Integer.valueOf(optionsLoader.getProperty("autoRestartMins"));
			if (optionsLoader.getProperty("keepBackupHours")!=null)
				keepBackupHours = Integer.valueOf(optionsLoader.getProperty("keepBackupHours"));
			if (optionsLoader.getProperty("maxPlayers")!=null)
				maxPlayers = Integer.valueOf(optionsLoader.getProperty("maxPlayers"));
			if (optionsLoader.getProperty("muteRank")!=null)
				muteRank = Integer.valueOf(optionsLoader.getProperty("muteRank"));
			if (optionsLoader.getProperty("useWarpRank")!=null)
				useWarpRank = Integer.valueOf(optionsLoader.getProperty("useWarpRank"));
			if (optionsLoader.getProperty("createWarpRank")!=null)
				createWarpRank = Integer.valueOf(optionsLoader.getProperty("createWarpRank"));
			if (optionsLoader.getProperty("warpPlayerRank")!=null)
				warpPlayerRank = Integer.valueOf(optionsLoader.getProperty("warpPlayerRank"));
			if (optionsLoader.getProperty("teleportRank")!=null)
				teleportRank = Integer.valueOf(optionsLoader.getProperty("teleportRank"));
			if (optionsLoader.getProperty("giveRank")!=null)
				giveRank = Integer.valueOf(optionsLoader.getProperty("giveRank"));
			if (optionsLoader.getProperty("homeCommandRank")!=null)
				homeCommandRank = Integer.valueOf(optionsLoader.getProperty("homeCommandRank"));
			if (optionsLoader.getProperty("givePlayerRank")!=null)
				givePlayerRank = Integer.valueOf(optionsLoader.getProperty("givePlayerRank"));
			if (optionsLoader.getProperty("setRankRank")!=null)
				setRankRank = Integer.valueOf(optionsLoader.getProperty("setRankRank"));
			if (optionsLoader.getProperty("defaultRank")!=null)
				defaultRank = Integer.valueOf(optionsLoader.getProperty("defaultRank"));
			if (optionsLoader.getProperty("autoBackup")!=null)
				autoBackup = Boolean.valueOf(optionsLoader.getProperty("autoBackup"));
			if (optionsLoader.getProperty("autoSave")!=null)
				autoSave = Boolean.valueOf(optionsLoader.getProperty("autoSave"));
			if (optionsLoader.getProperty("autoRestart")!=null)
				autoRestart = Boolean.valueOf(optionsLoader.getProperty("autoRestart"));
			if (optionsLoader.getProperty("useWhitelist")!=null)
				useWhitelist = Boolean.valueOf(optionsLoader.getProperty("useWhitelist"));
			if (optionsLoader.getProperty("onlineMode")!=null)
				onlineMode = Boolean.valueOf(optionsLoader.getProperty("onlineMode"));
			if (optionsLoader.getProperty("debug")!=null)
				debug = Boolean.valueOf(optionsLoader.getProperty("debug"));
			if (optionsLoader.getProperty("experimental")!=null)
				experimental = Boolean.valueOf(optionsLoader.getProperty("experimental"));
			if (optionsLoader.getProperty("levelName")!=null)
				levelName = optionsLoader.getProperty("levelName");
			if (optionsLoader.getProperty("alternateJarFile")!=null)
				alternateJarFile = optionsLoader.getProperty("alternateJarFile");
			if (autoRestartMins<5) {
				//autoRestartMins=5;
			}
			if (internalPort == port) {
				System.out.println("OH NO! Your 'internalPort' and 'port' properties are the same! Edit simpleserver.properties and change them to different values. 'port' is recommended to be 25565, the default port of minecraft, and will be the port you actually connect to.");
				System.out.println("Press enter to continue...");
				Scanner in = new Scanner(System.in);
				in.nextLine();
				r.close();
				System.exit(0);
			}
			r.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Could not read the properties file!");
		}
	}

}