package com.scyllasrock.discordlink.user;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

import com.scyllasrock.discordlink.DiscordLink;
import com.scyllasrock.discordlink.buttonmanager.ButtonLayout;
import com.scyllasrock.discordlink.buttonmanager.ButtonLink;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.PrivateChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.interactions.components.ItemComponent;

public class UserLink {
	private String userID;
	private User user;
	private DiscordLink plugin;
	private Player p;
	private boolean insideVoiceChannel;
	private Instant joinedVoiceChannelAt;
	
	public UserLink(DiscordLink plugin, User user) {
		this.plugin = plugin;
		this.user = user;
		this.userID = user.getId();
	}
	
	public String getUserID() {
		return this.userID;
	}
	
	public User getUser() {
		return this.user;
	}
	
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	/** Set the JDA user of the User within this instance. */
	public void setUser(User user) {
		this.user = user;
	}
	
	/** Set the players instance inside UserLink. */
	public void setPlayer(Player p) {
		this.p = p;
	}
	
	public Player getPlayer() {
		return this.p;
	}
	
	public boolean getInsideVoiceChannel() {
		return this.insideVoiceChannel;
	}
	
	public Instant getVoiceChannelJoinedAt() {
		return this.joinedVoiceChannelAt;
	}
	
	public void setInsideVoiceChannel(boolean insideVoiceChannel) {
		this.insideVoiceChannel = insideVoiceChannel;
	}
	
	public void setVoiceChannelJoinedAt(Instant instant) {
		joinedVoiceChannelAt = instant;
	}
	
	public PrivateChannel getPrivateChannel() {
		return user.openPrivateChannel().complete();
	}
	
	public void sendToChannelSimpleEmbeded(String title, String titleURL, java.awt.Color RGB, String description,
	        String footerMessage, String footerURL, String thumbnail) {
		EmbedBuilder eb = new EmbedBuilder();
		eb.setTitle(title, titleURL);
		eb.setColor(RGB);
		eb.setThumbnail(thumbnail);
		eb.setDescription(description);
		eb.setFooter(footerMessage, footerURL);
		getPrivateChannel().sendMessageEmbeds(eb.build()).queue();
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
		getPrivateChannel().sendMessageEmbeds(eb.build()).queue();
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
		getPrivateChannel().sendMessageEmbeds(eb.build()).queue();
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
		getPrivateChannel().sendMessageEmbeds(eb.build()).queue();
	}
	
	public void sendSimpleMessage(String message) {
		getPrivateChannel().sendMessage(message).queue();
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
		getPrivateChannel().sendMessageEmbeds(eb.build()).setActionRow(actionRow).queue();
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
		getPrivateChannel().sendMessageEmbeds(eb.build()).setActionRow(actionRow).queue();
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
		getPrivateChannel().sendMessageEmbeds(eb.build()).setActionRow(actionRow).queue();
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
		getPrivateChannel().sendMessageEmbeds(eb.build()).setActionRow(actionRow).queue();
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
		getPrivateChannel().sendMessageEmbeds(eb.build()).setActionRow(actionRow).queue();
	}
	
	public void sendToChannelSimpleEmbededWithReactions(String title, String titleURL, java.awt.Color RGB,
	        String description, String footerMessage, String footerURL, String thumbnail, List<String> formatEmojis) {
		EmbedBuilder eb = new EmbedBuilder();
		eb.setTitle(title, titleURL);
		eb.setColor(RGB);
		eb.setThumbnail(thumbnail);
		eb.setDescription(description);
		eb.setFooter(footerMessage, footerURL);
		Message msg = getPrivateChannel().sendMessageEmbeds(eb.build()).complete();
		for (String str : formatEmojis) {
			plugin.reactionManager.addReactionToMessageByFormatted(str, msg);
		}
	}
	
	public void sendSimpleMessagWithReaction(String message, List<String> formatEmojis) {
		Message msg = getPrivateChannel().sendMessage(message).complete();
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
		Message msg = getPrivateChannel().sendMessageEmbeds(eb.build()).complete();
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
		Message msg = getPrivateChannel().sendMessageEmbeds(eb.build()).complete();
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
		Message msg = getPrivateChannel().sendMessageEmbeds(eb.build()).complete();
		for (String str : formatEmojis) {
			plugin.reactionManager.addReactionToMessageByFormatted(str, msg);
		}
	}
	
	public void sendSimpleMessageWithButtons(String message, ButtonLayout buttonLayout) {
		List<ItemComponent> actionRow = new ArrayList<>();
		for (ButtonLink buttonLink : buttonLayout.getButtonLayout()) {
			actionRow.add(buttonLink.getItemComponent());
		}
		getPrivateChannel().sendMessage(message).setActionRow(actionRow).queue();
	}
}
