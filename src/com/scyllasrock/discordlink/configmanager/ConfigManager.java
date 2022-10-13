package com.scyllasrock.discordlink.configmanager;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import com.scyllasrock.discordlink.DiscordLink;

public class ConfigManager {
	DiscordLink plugin;
	private File configFile;
	private YamlConfiguration configYml;
	private String directoryPathFile = System.getProperty("user.dir") + File.separator + "plugins" + File.separator + "DiscordLink";
		private String iconURL;
	private String header;
	private String footer;
	private String thumbnail;
	private String prefix;
	private Map<Integer, String> channel = new HashMap<>();
		public ConfigManager(DiscordLink instance) {
		this.plugin = instance;
	}
		public void configCreator() {
		if (new File(directoryPathFile).mkdirs()) {
			Bukkit.getLogger().info("Generated DiscordLink configuration folder");
		}
		configFile = new File(plugin.getDataFolder(), "config.yml");
		if (!configFile.exists()) {
			plugin.saveDefaultConfig();
		}
		configYml = YamlConfiguration.loadConfiguration(configFile);
				iconURL = configYml.getString("iconURL");  
		header = configYml.getString("header");
		footer = configYml.getString("footer");
		thumbnail = configYml.getString("thumbnail");
		prefix = configYml.getString("prefix");
				int x = 0;
		for (String str : configYml.getKeys(true)) {
			String[] list = str.split("\\.");
			if (list.length == 2 && str.startsWith("channels")) {
				channel.put(x, configYml.getString("channels." + list[1] + ".channelID"));
				x++;
			}
		}
			}
		public Map<Integer, String> getConfChannels(){
		return this.channel;
	}
			public File getConfigFile() {
		return this.configFile;
	}
		public YamlConfiguration getYML() {
		return this.configYml;
	}
		public String getPrefix() {
		return this.prefix;
	}
		public String getIconURL() {
		return this.iconURL;
	}
		public String getHeader() {
		return this.header;
	}
		public String getFooter() {
		return this.footer;
	}
		public String getThumbnail() {
		return this.thumbnail;
	}
		public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
		public void setIconURL(String iconURL) {
		this.iconURL = iconURL;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public void setFooter(String footer) {
		this.footer = footer;
	}
				}
