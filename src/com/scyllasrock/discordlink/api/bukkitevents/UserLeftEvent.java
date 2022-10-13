package com.scyllasrock.discordlink.api.bukkitevents;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.scyllasrock.discordlink.DiscordLink;
import com.scyllasrock.discordlink.channel.ChannelLink;
import com.scyllasrock.discordlink.user.UserLink;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;

public class UserLeftEvent extends Event {
		private static final HandlerList HANDLERS = new HandlerList();
	DiscordLink plugin;
	User user;
	UserLink userLink;
		public UserLeftEvent(DiscordLink plugin, UserLink userLink) {
		this.plugin = plugin;
		this.userLink = userLink;
	}
		public UserLink getUserLink() {
		return this.userLink;
	}
			public HandlerList getHandlers() {
		return HANDLERS;
	}
		public static HandlerList getHandlerList() {
		return HANDLERS;
	}
		}
