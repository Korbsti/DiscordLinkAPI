package com.scyllasrock.discordlink.reactions;

import java.util.List;

import com.scyllasrock.discordlink.DiscordLink;
import com.scyllasrock.discordlink.channel.ChannelLink;
import com.scyllasrock.discordlink.user.UserLink;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.emoji.CustomEmoji;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.utils.data.DataObject;

public class ReactionManager {
		DiscordLink plugin;
		public ReactionManager(DiscordLink plugin) {
		this.plugin = plugin;
	}
		public void addReactionToMessageByDataObject(DataObject data, Message message) {
		message.addReaction(Emoji.fromData(data)).queue();
	}
		public void addReactionToMessageByFormatted(String formatted, Message message) {
		message.addReaction(Emoji.fromFormatted(formatted)).queue();
	}
		public void addReactionToMessageByFormattedLatestMessage(String formatted, ChannelLink channelLink) {
		channelLink.getLatestMessage().flatMap(message -> message.addReaction(Emoji.fromFormatted(formatted))).queue();
	}
		public void addReactionToMessageByUnicode(String unicode, Message message) {
		message.addReaction(Emoji.fromUnicode(unicode)).queue();
	}
		public void addReactionToMessageByCustomEmoji(CustomEmoji emoji, Message message) {
		message.addReaction(Emoji.fromCustom(emoji)).queue();
	}
		public void addReactionToMessageByCustomEmoji(String emojiName, long id, boolean isAnimated, Message message) {
		message.addReaction(Emoji.fromCustom(emojiName, id, isAnimated)).queue();
	}
		public void addReactionToMessageByEmoji(Emoji emoji, Message message) {
		message.addReaction(emoji).queue();
	}
		public void removeReaction(Emoji emoji, Message message) {
		message.removeReaction(emoji).queue();
	}
		public void removeReactionByUser(Emoji emoji, Message message, User user) {
		message.removeReaction(emoji, user).queue();
	}
		public List<MessageReaction> getAllReactionsFromMessage(Message message) {
		return message.getReactions();
	}
		public MessageReaction getCertainEmojiReaction(Message message, Emoji reaction) {
		return message.getReaction(reaction);
	}
				}
