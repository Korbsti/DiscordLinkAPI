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
import net.dv8tion.jda.api.interactions.InteractionHook;
import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;
import net.dv8tion.jda.api.interactions.components.ItemComponent;

public class CommandTriggeredEvent extends Event {
			private static final HandlerList HANDLERS = new HandlerList();
	DiscordLink plugin;
	User user;
	ChannelLink channelLink;
	UserLink userLink;
	String content;
	Message message;
	SlashCommandInteraction e;
	boolean replyAsEphemeral;
		public CommandTriggeredEvent(DiscordLink plugin, ChannelLink channelLink, UserLink userLink, String content, Message message, boolean fromPrivateChannel, SlashCommandInteraction e) {
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
		public void setAsEphemeral(boolean b) {
		this.replyAsEphemeral = b;
	}
			public boolean getEphemeralBoolean() {
		return this.replyAsEphemeral;
	}
					public void sendToChannelSimpleEmbeded(String title, String titleURL, java.awt.Color RGB, String description,
	        String footerMessage, String footerURL, String thumbnail) {
		EmbedBuilder eb = new EmbedBuilder();
		eb.setTitle(title, titleURL);
		eb.setColor(RGB);
		eb.setThumbnail(thumbnail);
		eb.setDescription(description);
		eb.setFooter(footerMessage, footerURL);
				e.replyEmbeds(eb.build()).setEphemeral(replyAsEphemeral).queue();
	}
		public void sendToChannelSimpleEmbeded(String title, String titleURL, java.awt.Color RGB, String description,
	        String footerMessage, String footerURL) {
		EmbedBuilder eb = new EmbedBuilder();
		eb.setTitle(title, titleURL);
		eb.setColor(RGB);
		if (!"".equals(plugin.configManager.getThumbnail())) {
			eb.setThumbnail(plugin.configManager.getThumbnail());
		}
		eb.setDescription(description);
		eb.setFooter(footerMessage, footerURL);
		e.getHook().sendMessageEmbeds(eb.build()).setEphemeral(replyAsEphemeral).queue();
	}
		public void sendToChannelSimpleEmbeded(String title, String titleURL, java.awt.Color RGB, String description) {
		EmbedBuilder eb = new EmbedBuilder();
		eb.setTitle(title, titleURL);
		eb.setColor(RGB);
		if (!"".equals(plugin.configManager.getThumbnail())) {
			eb.setThumbnail(plugin.configManager.getThumbnail());
		}
		eb.setDescription(description);
				if (!"".equals(plugin.configManager.getFooter())) {
					eb.setFooter(null, plugin.configManager.getFooter());
				}
				e.getHook().sendMessageEmbeds(eb.build()).setEphemeral(replyAsEphemeral).queue();
	}
		public void sendToChannelSimpleEmbeded(String title, java.awt.Color RGB, String description) {
		EmbedBuilder eb = new EmbedBuilder();
		if (!"".equals(plugin.configManager.getIconURL())) {
			eb.setTitle(title, null);
		} else {
			eb.setTitle(title, plugin.configManager.getIconURL());
		}
				eb.setColor(RGB);
		if (!"".equals(plugin.configManager.getThumbnail())) {
			eb.setThumbnail(plugin.configManager.getThumbnail());
		}
		eb.setDescription(description);
				if (!"".equals(plugin.configManager.getFooter())) {
					eb.setFooter(null, plugin.configManager.getFooter());
				}
				e.getHook().sendMessageEmbeds(eb.build()).setEphemeral(replyAsEphemeral).queue();
	}
		public void sendSimpleMessage(String message) {
		e.getHook().sendMessage(message).setEphemeral(replyAsEphemeral).queue();
			}
		public void sendToChannelSimpleEmbededWithButtons(String title, String titleURL, java.awt.Color RGB,
	        String description, String footerMessage, String footerURL, String thumbnail, ButtonLayout buttonLayout) {
		EmbedBuilder eb = new EmbedBuilder();
		eb.setTitle(title, titleURL);
		eb.setColor(RGB);
		eb.setThumbnail(thumbnail);
		eb.setDescription(description);
		eb.setFooter(footerMessage, footerURL);
				List<ItemComponent> actionRow = new ArrayList<>();
		for (ButtonLink buttonLink : buttonLayout.getButtonLayout()) {
			actionRow.add(buttonLink.getItemComponent());
		}
				e.getHook().sendMessageEmbeds(eb.build()).setEphemeral(replyAsEphemeral).addActionRow(actionRow).queue();
	}
		public void sendToChannelSimpleEmbededWithButtons(String title, String titleURL, java.awt.Color RGB,
	        String description, String footerMessage, String footerURL, ButtonLayout buttonLayout) {
		EmbedBuilder eb = new EmbedBuilder();
		eb.setTitle(title, titleURL);
		eb.setColor(RGB);
		if (!"".equals(plugin.configManager.getThumbnail())) {
			eb.setThumbnail(plugin.configManager.getThumbnail());
		}
		eb.setDescription(description);
		eb.setFooter(footerMessage, footerURL);
				List<ItemComponent> actionRow = new ArrayList<>();
		for (ButtonLink buttonLink : buttonLayout.getButtonLayout()) {
			actionRow.add(buttonLink.getItemComponent());
		}
				e.getHook().sendMessageEmbeds(eb.build()).setEphemeral(replyAsEphemeral).addActionRow(actionRow).queue();
	}
		public void sendToChannelSimpleEmbededWithButtons(String title, String titleURL, java.awt.Color RGB,
	        String description, ButtonLayout buttonLayout) {
		EmbedBuilder eb = new EmbedBuilder();
		eb.setTitle(title, titleURL);
		eb.setColor(RGB);
		if (!"".equals(plugin.configManager.getThumbnail())) {
			eb.setThumbnail(plugin.configManager.getThumbnail());
		}
		eb.setDescription(description);
				if (!"".equals(plugin.configManager.getFooter())) {
					eb.setFooter(null, plugin.configManager.getFooter());
				}
				List<ItemComponent> actionRow = new ArrayList<>();
		for (ButtonLink buttonLink : buttonLayout.getButtonLayout()) {
			actionRow.add(buttonLink.getItemComponent());
		}
				e.getHook().sendMessageEmbeds(eb.build()).setEphemeral(replyAsEphemeral).addActionRow(actionRow).queue();
	}
		public void sendToChannelSimpleEmbededWithButtons(String title, java.awt.Color RGB, String description,
	        ButtonLayout buttonLayout) {
		EmbedBuilder eb = new EmbedBuilder();
		if (!"".equals(plugin.configManager.getIconURL())) {
			eb.setTitle(title, plugin.configManager.getIconURL());
		} else {
			eb.setTitle(title, null);
		}
				eb.setColor(RGB);
				if (!"".equals(plugin.configManager.getThumbnail())) {
					eb.setThumbnail(plugin.configManager.getThumbnail());
				}
		eb.setDescription(description);
		if (!"".equals(plugin.configManager.getFooter())) {
			eb.setFooter(null, plugin.configManager.getFooter());
		}
				List<ItemComponent> actionRow = new ArrayList<>();
		for (ButtonLink buttonLink : buttonLayout.getButtonLayout()) {
			actionRow.add(buttonLink.getItemComponent());
		}
		e.getHook().sendMessageEmbeds(eb.build()).setEphemeral(replyAsEphemeral).addActionRow(actionRow).queue();
	}
		public void sendToChannelSimpleEmbededWithButtonsNoURL(String title, java.awt.Color RGB, String description,
	        ButtonLayout buttonLayout) {
		EmbedBuilder eb = new EmbedBuilder();
		eb.setColor(RGB);
		eb.setDescription(description);
		List<ItemComponent> actionRow = new ArrayList<>();
		for (ButtonLink buttonLink : buttonLayout.getButtonLayout()) {
			actionRow.add(buttonLink.getItemComponent());
		}
		e.getHook().sendMessageEmbeds(eb.build()).setEphemeral(replyAsEphemeral).addActionRow(actionRow).queue();
	}
		public void sendToChannelSimpleEmbededWithReactions(String title, String titleURL, java.awt.Color RGB,
	        String description, String footerMessage, String footerURL, String thumbnail, List<String> formatEmojis) {
		EmbedBuilder eb = new EmbedBuilder();
		eb.setTitle(title, titleURL);
		eb.setColor(RGB);
		eb.setThumbnail(thumbnail);
		eb.setDescription(description);
		eb.setFooter(footerMessage, footerURL);
		Message msg = e.getHook().sendMessageEmbeds(eb.build()).setEphemeral(replyAsEphemeral).complete();
		for (String str : formatEmojis) {
			plugin.reactionManager.addReactionToMessageByFormatted(str, msg);
		}
			}
		public void sendSimpleMessagWithReaction(String message, List<String> formatEmojis) {
		Message msg = e.getHook().sendMessage(message).setEphemeral(replyAsEphemeral).complete();
		for (String str : formatEmojis) {
			plugin.reactionManager.addReactionToMessageByFormatted(str, msg);
		}
	}
		public void sendToChannelSimpleEmbededWithReactions(String title, String titleURL, java.awt.Color RGB,
	        String description, String footerMessage, String footerURL, List<String> formatEmojis) {
		EmbedBuilder eb = new EmbedBuilder();
		eb.setTitle(title, titleURL);
		eb.setColor(RGB);
				if (!"".equals(plugin.configManager.getThumbnail())) {
					eb.setThumbnail(plugin.configManager.getThumbnail());
				}
		eb.setDescription(description);
		eb.setFooter(footerMessage, footerURL);
		Message msg = e.getHook().sendMessageEmbeds(eb.build()).setEphemeral(replyAsEphemeral).complete();
		for (String str : formatEmojis) {
			plugin.reactionManager.addReactionToMessageByFormatted(str, msg);
		}
	}
		public void sendToChannelSimpleEmbededWithReactions(String title, String titleURL, java.awt.Color RGB,
	        String description, List<String> formatEmojis) {
		EmbedBuilder eb = new EmbedBuilder();
		eb.setTitle(title, titleURL);
		eb.setColor(RGB);
				if (!"".equals(plugin.configManager.getThumbnail())) {
					eb.setThumbnail(plugin.configManager.getThumbnail());
				}
				eb.setDescription(description);
		if (!"".equals(plugin.configManager.getFooter())) {
			eb.setFooter(null, plugin.configManager.getFooter());
		}
				Message msg = e.getHook().sendMessageEmbeds(eb.build()).setEphemeral(replyAsEphemeral).complete();
		for (String str : formatEmojis) {
			plugin.reactionManager.addReactionToMessageByFormatted(str, msg);
		}
			}
		public void sendToChannelSimpleEmbededWithReactions(String title, java.awt.Color RGB, String description,
	        List<String> formatEmojis) {
		EmbedBuilder eb = new EmbedBuilder();
		if (!"".equals(plugin.configManager.getIconURL())) {
			eb.setTitle(title, plugin.configManager.getIconURL());
		} else {
			eb.setTitle(title, null);
		}
		eb.setColor(RGB);
		if (!"".equals(plugin.configManager.getThumbnail())) {
			eb.setThumbnail(plugin.configManager.getThumbnail());
		}
		eb.setDescription(description);
				if (!"".equals(plugin.configManager.getFooter())) {
					eb.setFooter(null, plugin.configManager.getFooter());
				}
		Message msg = e.getHook().sendMessageEmbeds(eb.build()).setEphemeral(replyAsEphemeral).complete();
		for (String str : formatEmojis) {
			plugin.reactionManager.addReactionToMessageByFormatted(str, msg);
		}
					}
		public void sendSimpleMessageWithButtons(String message, ButtonLayout buttonLayout) {
		List<ItemComponent> actionRow = new ArrayList<>();
		for (ButtonLink buttonLink : buttonLayout.getButtonLayout()) {
			actionRow.add(buttonLink.getItemComponent());
		}
		e.getHook().sendMessage(message).addActionRow(actionRow).setEphemeral(replyAsEphemeral).queue();
	}
		}
