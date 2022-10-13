package com.scyllasrock.discordlink.api.bukkitevents;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.scyllasrock.discordlink.DiscordLink;
import com.scyllasrock.discordlink.buttonmanager.ButtonLink;
import com.scyllasrock.discordlink.channel.ChannelLink;
import com.scyllasrock.discordlink.reactions.ReactionLink;
import com.scyllasrock.discordlink.user.UserLink;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;

public class ReactionAddedEvent extends Event {
				private static final HandlerList HANDLERS = new HandlerList();
	DiscordLink plugin;
	User user;
	ReactionLink reactionLink;
	ChannelLink channelLink;
	UserLink userLink;
	Message message;
	String formatted;
	String display;
		public ReactionAddedEvent(DiscordLink plugin, ChannelLink channelLink, UserLink userLink, Message message, String formatted, String display, boolean fromPrivateChannel) {
		this.plugin = plugin;
		this.reactionLink = reactionLink;
		this.channelLink = channelLink;
		this.userLink = userLink;
		this.message = message;
		this.display = display;
	}
		public ReactionLink getReactionLink() {
		return this.reactionLink;
	}
		public ChannelLink getChannelLink() {
		return this.channelLink;
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
		public Message getMessage() {
		return this.message;
	}
		public String getFormatted() {
		return this.formatted;
	}
		}
