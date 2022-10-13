package com.scyllasrock.discordlink.api;

import com.scyllasrock.discordlink.DiscordLink;
import com.scyllasrock.discordlink.buttonmanager.ButtonManager;
import com.scyllasrock.discordlink.channel.ChannelsManager;
import com.scyllasrock.discordlink.channel.voicechannel.VoiceChannelManager;
import com.scyllasrock.discordlink.commandtriggers.CommandTriggerManager;
import com.scyllasrock.discordlink.reactions.ReactionManager;
import com.scyllasrock.discordlink.roles.RoleManager;
import com.scyllasrock.discordlink.user.UserManager;

public class API {
		DiscordLink plugin;
		public API(DiscordLink plugin) {
		this.plugin = plugin;
	}
			public ButtonManager getButtonManager() {
		return plugin.buttonManager;
	}
		public ChannelsManager getChannelsManager() {
		return plugin.getChannelsManager;
	}
		public RoleManager getRoleManager() {
		return plugin.roleManager;
	}
		public UserManager getUserManager() {
		return plugin.userManager;
	}
		public VoiceChannelManager getVoiceChannelManager() {
		return plugin.voiceChannelManager;
	}
		public ReactionManager getReactionManager() {
		return plugin.reactionManager;
	}
		public CommandTriggerManager getCommandTriggerManager() {
		return plugin.commandTriggerManager;
	}
			}
