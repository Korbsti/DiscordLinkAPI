package com.scyllasrock.discordlink.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.scyllasrock.discordlink.DiscordLink;

import net.dv8tion.jda.api.entities.Member;

public class UserManager {
		DiscordLink plugin;
		public Map<String, UserLink> users = new HashMap<>();
			public UserManager(DiscordLink plugin) {
		this.plugin = plugin;
	}
			public Map<String, UserLink> getAllUsers(){
		return this.users;
	}
		public List<UserLink> getAllUserLinks(){
		return (List<UserLink>) users.values();
	}

		public UserLink getUserLinkByID(String id) {
		return users.get(id);
	}
		/**
	 * Create a new UserLink for the plugin, mainly meant for managing discord users
	 * The userID is the userID.
	 */
	public void addUserLink(String userID, UserLink userLink) {
		users.put(userID, userLink);
	}
		public void removeUserLink(String userID) {
		users.remove(userID);
	}
		public void setAllUsers(HashMap<String, UserLink> users) {
		this.users = users;
	}
		/**
	 * This will automatically cache all the users within the guild inside the "users"
	 * hashmap, the key will be the users personal ID
	 * But I recommend not using this UNLESS you really need to, the plugin
	 * already caches users upon joining the guild and upon this plugins startup.
	 */
	public void cacheAllUsers() {
		for(Member member : plugin.guild.getMembers()) {
			users.put(member.getId(), new UserLink(plugin, member.getUser()));
					}
			}
						}
