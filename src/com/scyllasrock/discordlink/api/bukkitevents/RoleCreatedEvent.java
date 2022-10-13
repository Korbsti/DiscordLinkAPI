package com.scyllasrock.discordlink.api.bukkitevents;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.scyllasrock.discordlink.DiscordLink;
import com.scyllasrock.discordlink.channel.ChannelLink;
import com.scyllasrock.discordlink.user.UserLink;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;

public class RoleCreatedEvent extends Event {
		private static final HandlerList HANDLERS = new HandlerList();
	DiscordLink plugin;
	User user;
	String roleID;
	Role role;
		public RoleCreatedEvent(DiscordLink plugin, String channelID, Role role) {
		this.plugin = plugin;
		this.roleID = channelID;
			}
		public String getRoleID() {
		return this.roleID;
	}
		public Role getRole() {
		return this.role;
	}
		public HandlerList getHandlers() {
		return HANDLERS;
	}
		public static HandlerList getHandlerList() {
		return HANDLERS;
	}
	}
