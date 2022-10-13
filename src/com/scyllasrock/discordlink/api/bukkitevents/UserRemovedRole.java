package com.scyllasrock.discordlink.api.bukkitevents;

import java.util.List;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.scyllasrock.discordlink.DiscordLink;
import com.scyllasrock.discordlink.user.UserLink;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;

public class UserRemovedRole extends Event {
	DiscordLink plugin;
			private static final HandlerList HANDLERS = new HandlerList();

	UserLink userLink;
	List<Role> roles;
			public UserRemovedRole(DiscordLink plugin, UserLink userLink, List<Role> roles) {
		this.plugin = plugin;
		this.userLink = userLink;
		this.roles = roles;
	}
			public List<Role> getRoles() {
		return this.roles;
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
