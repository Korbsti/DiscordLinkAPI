package com.scyllasrock.discordlink.api.bukkitevents;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.scyllasrock.discordlink.DiscordLink;
import com.scyllasrock.discordlink.buttonmanager.ButtonLayout;
import com.scyllasrock.discordlink.buttonmanager.ButtonLink;
import com.scyllasrock.discordlink.channel.ChannelLink;
import com.scyllasrock.discordlink.user.UserLink;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.interactions.InteractionHook;
import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;
import net.dv8tion.jda.api.interactions.components.ItemComponent;

public class RecievedMessageEvent extends Event {
			private static final HandlerList HANDLERS = new HandlerList();
	DiscordLink plugin;
	User user;
	ChannelLink channelLink;
	UserLink userLink;
	String content;
	Message message;
	MessageReceivedEvent e;
	boolean replyAsEphemeral;
		public RecievedMessageEvent(DiscordLink plugin, ChannelLink channelLink, UserLink userLink, String content, Message message, boolean fromPrivateChannel, MessageReceivedEvent e) {
		this.plugin = plugin;
		this.channelLink = channelLink;
		this.userLink = userLink;
		this.content = content;
		this.e = e;
			}
		public ChannelLink getChannelLink() {
		return this.channelLink;
	}
		public UserLink getUserLink() {
		return this.userLink;
	}
		public String getContent() {
		return this.content;
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
		public MessageReceivedEvent getMessageRecievedEvent() {
		return this.e;
	}
		}
