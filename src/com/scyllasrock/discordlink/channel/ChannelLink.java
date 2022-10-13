package com.scyllasrock.discordlink.channel;

import java.util.ArrayList;
import java.util.List;

import com.scyllasrock.discordlink.DiscordLink;
import com.scyllasrock.discordlink.buttonmanager.ButtonLayout;
import com.scyllasrock.discordlink.buttonmanager.ButtonLink;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Channel;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.ItemComponent;
import net.dv8tion.jda.api.requests.RestAction;
import net.dv8tion.jda.api.requests.restaction.MessageAction;

public class ChannelLink {
	DiscordLink plugin;
	private String channelID;
	private Channel channel;
	private String channelName;
		/**
	 * Create a new channel link inside the plugin, this requires the instance of
	 * DiscordLink, it requires a channel ID and a channel name
	 * 
	 * This class handles the discord channel and sending messages to a channel.
	 */
	public ChannelLink(DiscordLink plugin, String channelID) {
		this.plugin = plugin;
		this.channelID = channelID;
		this.channel = plugin.guild.getGuildChannelById(channelID);
		this.channelName = channel.getName();
	}
		public void setChannelID(String channelID) {
		this.channelID = channelID;
	}
		public String getChannelID() {
		return this.channelID;
	}
		public String getChannelName() {
		return this.channelName;
	}
		public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
		public Channel getChannel() {
		return this.channel;
	}
		public MessageChannel getAsMessageChannel() {
		return (MessageChannel) this.channel;
	}
		public RestAction<Message> getLatestMessage() {
		return getAsMessageChannel().retrieveMessageById(getAsMessageChannel().getLatestMessageId());
	}
		public String getLatestMessageID() {
		return getAsMessageChannel().getLatestMessageId();
	}
		public void setChannel(Channel channel) {
		this.channel = channel;
	}
		public void sendToChannelSimpleEmbeded(String title, String titleURL, java.awt.Color RGB, String description,
	        String footerMessage, String footerURL, String thumbnail) {
		EmbedBuilder eb = new EmbedBuilder();
		eb.setTitle(title, titleURL);
		eb.setColor(RGB);
		eb.setThumbnail(thumbnail);
		eb.setDescription(description);
		eb.setFooter(footerMessage, footerURL);
		getAsMessageChannel().sendMessageEmbeds(eb.build()).queue();
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
		getAsMessageChannel().sendMessageEmbeds(eb.build()).queue();
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
				getAsMessageChannel().sendMessageEmbeds(eb.build()).queue();
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
				getAsMessageChannel().sendMessageEmbeds(eb.build()).queue();
	}
		public void sendSimpleMessage(String message) {
		getAsMessageChannel().sendMessage(message).queue();
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
				getAsMessageChannel().sendMessageEmbeds(eb.build()).setActionRow(actionRow).queue();
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
				getAsMessageChannel().sendMessageEmbeds(eb.build()).setActionRow(actionRow).queue();
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
				getAsMessageChannel().sendMessageEmbeds(eb.build()).setActionRow(actionRow).queue();
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
		getAsMessageChannel().sendMessageEmbeds(eb.build()).setActionRow(actionRow).queue();
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
		getAsMessageChannel().sendMessageEmbeds(eb.build()).setActionRow(actionRow).queue();
	}
		public void sendToChannelSimpleEmbededWithReactions(String title, String titleURL, java.awt.Color RGB,
	        String description, String footerMessage, String footerURL, String thumbnail, List<String> formatEmojis) {
		EmbedBuilder eb = new EmbedBuilder();
		eb.setTitle(title, titleURL);
		eb.setColor(RGB);
		eb.setThumbnail(thumbnail);
		eb.setDescription(description);
		eb.setFooter(footerMessage, footerURL);
		Message msg = getAsMessageChannel().sendMessageEmbeds(eb.build()).complete();
		for (String str : formatEmojis) {
			plugin.reactionManager.addReactionToMessageByFormatted(str, msg);
		}
			}
		public void sendSimpleMessagWithReaction(String message, List<String> formatEmojis) {
		Message msg = getAsMessageChannel().sendMessage(message).complete();
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
		Message msg = getAsMessageChannel().sendMessageEmbeds(eb.build()).complete();
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
				Message msg = getAsMessageChannel().sendMessageEmbeds(eb.build()).complete();
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
		Message msg = getAsMessageChannel().sendMessageEmbeds(eb.build()).complete();
		for (String str : formatEmojis) {
			plugin.reactionManager.addReactionToMessageByFormatted(str, msg);
		}
					}
		public void sendSimpleMessageWithButtons(String message, ButtonLayout buttonLayout) {
		List<ItemComponent> actionRow = new ArrayList<>();
		for (ButtonLink buttonLink : buttonLayout.getButtonLayout()) {
			actionRow.add(buttonLink.getItemComponent());
		}
		getAsMessageChannel().sendMessage(message).setActionRow(actionRow).queue();
	}
	}
