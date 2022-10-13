package com.scyllasrock.discordlink.api.bukkitevents;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.scyllasrock.discordlink.DiscordLink;
import com.scyllasrock.discordlink.user.UserLink;

import net.dv8tion.jda.api.entities.User;

public class VoiceChannelLeft extends Event {
	private static final HandlerList HANDLERS = new HandlerList();
	DiscordLink plugin;
	User user;
	UserLink userLink;
	String voiceChannelID;
		public VoiceChannelLeft(DiscordLink plugin, String voiceChannelID, UserLink userLink) {
		this.plugin = plugin;
		this.userLink = userLink;
		this.voiceChannelID = voiceChannelID;
	}
			public String getVoiceChannelID() {
		return this.voiceChannelID;
	}
		public UserLink userLink() {
		return this.userLink;
	}
		public HandlerList getHandlers() {
		return HANDLERS;
	}
		public static HandlerList getHandlerList() {
		return HANDLERS;
	}
	}
