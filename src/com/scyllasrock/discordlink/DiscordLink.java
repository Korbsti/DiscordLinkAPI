package com.scyllasrock.discordlink;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.LoginException;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.scyllasrock.discordlink.api.API;
import com.scyllasrock.discordlink.buttonmanager.ButtonLink;
import com.scyllasrock.discordlink.buttonmanager.ButtonManager;
import com.scyllasrock.discordlink.buttonmanager.ButtonManager.ButtonPriority;
import com.scyllasrock.discordlink.buttonmanager.ButtonManager.ButtonType;
import com.scyllasrock.discordlink.channel.ChannelLink;
import com.scyllasrock.discordlink.channel.ChannelsManager;
import com.scyllasrock.discordlink.channel.voicechannel.VoiceChannelManager;
import com.scyllasrock.discordlink.commandtriggers.CommandTriggerManager;
import com.scyllasrock.discordlink.configmanager.ConfigManager;
import com.scyllasrock.discordlink.events.AllEvents;
import com.scyllasrock.discordlink.reactions.ReactionManager;
import com.scyllasrock.discordlink.roles.RoleManager;
import com.scyllasrock.discordlink.user.UserManager;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

public class DiscordLink extends JavaPlugin {
	public JDA jda;
	public ConfigManager configManager = new ConfigManager(this);
	public ChannelsManager getChannelsManager = new ChannelsManager(this);
	public ButtonManager buttonManager = new ButtonManager(this);
	public RoleManager roleManager = new RoleManager(this);
	public UserManager userManager = new UserManager(this);
	public VoiceChannelManager voiceChannelManager = new VoiceChannelManager(this);
	public ReactionManager reactionManager = new ReactionManager(this);
	public CommandTriggerManager commandTriggerManager = new CommandTriggerManager(this);
	public String guildID;
	public Guild guild;
		public API api;
			@Override
	public void onEnable() {
		configManager.configCreator();

		try {
			jda = JDABuilder.createDefault(configManager.getYML().getString("token"))
			          .setChunkingFilter(ChunkingFilter.ALL) 
			          .setMemberCachePolicy(MemberCachePolicy.ALL) 
			          .enableIntents(GatewayIntent.GUILD_MEMBERS)
			          .enableIntents(GatewayIntent.GUILD_MESSAGE_REACTIONS)
			          .enableIntents(GatewayIntent.GUILD_VOICE_STATES)
			          .enableCache(CacheFlag.VOICE_STATE)
			          .addEventListeners(new AllEvents(this))
			          .build();
		} catch (LoginException e) {
			e.printStackTrace();
		}
				try {
			jda.awaitReady();
			guild = jda.getGuilds().get(0);
			this.guildID = guild.getId();
			this.api = new API(this);
						api.getChannelsManager().cacheAllChannels();
			api.getUserManager().cacheAllUsers();
						/*String args = "ADMINISTRATOR;STRING;deeznuts;type nuts;TRUE;TRUE=(CHOICE1,CHOICE2,CHOICE3)"
					+ "STRING;anothercmdname;type another command PLEASEE;TRUE;TRUE=(ANOTHERCHOICE,helpPLEASE)"
					+ "STRING;thisiscmdname;did you know im a DESCRIPTION;TRUE;FALSE=";
															api.getCommandTriggerManager().addNewCommandTrigger("cmdname", "description", args);*/
								} catch (InterruptedException e) {
			e.printStackTrace();
		}
			}
		@Override
	public void onDisable() {
		jda.shutdown();
			}
		}
