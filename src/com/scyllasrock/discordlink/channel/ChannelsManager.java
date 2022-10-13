package com.scyllasrock.discordlink.channel;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;

import com.scyllasrock.discordlink.DiscordLink;

import net.dv8tion.jda.api.entities.Channel;
import net.dv8tion.jda.api.entities.Message;

public class ChannelsManager {
	DiscordLink plugin;
	private List<ChannelLink> channels = new ArrayList<>();
		public ChannelsManager(DiscordLink plugin) {
		this.plugin = plugin;
	}
			/** Return all known channel links by a list. */
	public List<ChannelLink> getAllChannels() {
		return this.channels;
	}
		/** Set the channels internal cache to a list filled with ChannelLink. */
	public void setChannels(List<ChannelLink> channels) {
		this.channels = channels;
	}
		/** Return a channel link by a channel ID. */
	public ChannelLink getSpecificChannelLinkByID(String channelID) {
		for (ChannelLink channelLink : channels) {
			if (channelID.equals(channelLink.getChannelID())) {
				return channelLink;
			}
		}
		return null;
	}
		/** Add a channel link into the channels list. */
	public void addChannelLink(ChannelLink channelLink) {
		channels.add(channelLink);
	}
		/** Get a channel link by message class (which you probably wont use). */
	public ChannelLink getChannelLinkByMessage(Message message) {
		return getSpecificChannelLinkByID(message.getChannel().getId());
	}
	/**
	 * Cache all channels into the ChannelsManager, each channel having a ChannelLink
	 * This is automatically executed upon startup, however does not add a channel upon
	 * a channel being created.
	 */
	public void cacheAllChannels() {
		channels.clear();
		for(Channel channel : plugin.guild.getChannels()) {
			channels.add(new ChannelLink(plugin, channel.getId()));
		}
							}
			/** 
	 * Get channel link by specific position from the config, whatever is first is 0
	 * second being 1, 
	 * third being 2 etc.
	 * 
	 * @param x
	 * @return
	 */
	public ChannelLink getChannelLinkByConfig(int x) {
		Bukkit.getLogger().info(String.valueOf(plugin.configManager.getConfChannels()));
		return getSpecificChannelLinkByID(plugin.configManager.getConfChannels().get(x));
	}
				}
