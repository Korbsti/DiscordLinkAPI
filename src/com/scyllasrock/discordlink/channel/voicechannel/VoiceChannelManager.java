package com.scyllasrock.discordlink.channel.voicechannel;

import java.util.ArrayList;
import java.util.List;

import com.scyllasrock.discordlink.DiscordLink;
import com.scyllasrock.discordlink.user.UserLink;

import net.dv8tion.jda.api.entities.Category;
import net.dv8tion.jda.api.entities.VoiceChannel;

public class VoiceChannelManager {
	DiscordLink plugin;
		private List<UserLink> voiceChannelUsers = new ArrayList<>();
		public VoiceChannelManager(DiscordLink plugin) {
		this.plugin = plugin;
	}
		public List<UserLink> returnVoiceChannelUsers() {
		return this.voiceChannelUsers;
	}
		public void setVoiceChannelUsers(List<UserLink> voiceChannelUsers) {
		this.voiceChannelUsers = voiceChannelUsers;
	}
		public void addVoiceChannelUser(UserLink userLink) {
		voiceChannelUsers.add(userLink);
		userLink.setInsideVoiceChannel(true);
	}
		public void removeVoiceChannelUser(UserLink userLink) {
		int x = 0;
		for (UserLink loopedUserLinks : voiceChannelUsers) {
			if (userLink.getUserID().equals(loopedUserLinks.getUserID())) {
				voiceChannelUsers.remove(x);
				userLink.setInsideVoiceChannel(false);
				break;
			}
			x++;
		}
	}
		public void createVoiceChannelInCategory(String channelName, Category category) {
		plugin.jda.getGuildById(plugin.guildID).createVoiceChannel(channelName, category).queue();
	}
		/** Create a voice channel with a channel name. */
	public void createVoiceChannel(String channelName) {
		plugin.jda.getGuildById(plugin.guildID).createVoiceChannel(channelName).queue();
	}
		/** Delete a voice channel with an ID. */
	public void deleteVoiceChannel(String voiceChannelID) {
		plugin.jda.getGuildById(plugin.guildID).getVoiceChannelById(voiceChannelID).delete().queue();
	}
		/**
	 * Get a VoiceChannel list by a name first argument being the voice channel
	 * name, and later being ignoreCase.
	 */
	public List<VoiceChannel> getVoiceChannelsByName(String voiceChannelName, boolean ignoreCase) {
		return plugin.guild.getVoiceChannelsByName(voiceChannelName, ignoreCase);
	}
		/**
	 * Get a voice channel id by name first argument being the voice channel name,
	 * and later being ignore caps or not.
	 */
	public String getVoiceChannelIDByName(String voiceChannelName, boolean ignoreCase) {
		return plugin.guild.getVoiceChannelsByName(voiceChannelName, true).get(0).getId();
			}
	}
