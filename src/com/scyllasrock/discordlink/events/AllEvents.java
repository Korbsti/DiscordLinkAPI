package com.scyllasrock.discordlink.events;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.scyllasrock.discordlink.DiscordLink;
import com.scyllasrock.discordlink.api.bukkitevents.ButtonClickedEvent;
import com.scyllasrock.discordlink.api.bukkitevents.CommandTriggeredEvent;
import com.scyllasrock.discordlink.api.bukkitevents.ReactionAddedEvent;
import com.scyllasrock.discordlink.api.bukkitevents.RecievedMessageEvent;
import com.scyllasrock.discordlink.api.bukkitevents.RoleCreatedEvent;
import com.scyllasrock.discordlink.api.bukkitevents.RoleDeletedEvent;
import com.scyllasrock.discordlink.api.bukkitevents.UserAddedRole;
import com.scyllasrock.discordlink.api.bukkitevents.UserJoinedEvent;
import com.scyllasrock.discordlink.api.bukkitevents.UserLeftEvent;
import com.scyllasrock.discordlink.api.bukkitevents.UserRemovedRole;
import com.scyllasrock.discordlink.api.bukkitevents.VoiceChannelJoined;
import com.scyllasrock.discordlink.api.bukkitevents.VoiceChannelLeft;
import com.scyllasrock.discordlink.buttonmanager.ButtonLayout;
import com.scyllasrock.discordlink.buttonmanager.ButtonLink;
import com.scyllasrock.discordlink.buttonmanager.ButtonManager.ButtonPriority;
import com.scyllasrock.discordlink.buttonmanager.ButtonManager.ButtonType;
import com.scyllasrock.discordlink.user.UserLink;

import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.PrivateChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRoleAddEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRoleRemoveEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.api.events.interaction.command.CommandAutoCompleteInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.role.RoleCreateEvent;
import net.dv8tion.jda.api.events.role.RoleDeleteEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.ItemComponent;
import net.dv8tion.jda.api.interactions.components.LayoutComponent;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyCallbackAction;

public class AllEvents extends ListenerAdapter {
	DiscordLink plugin;
	
	public AllEvents(DiscordLink plugin) {
		this.plugin = plugin;
	}
	
	/** String id;. */
	@Override
	public void onButtonInteraction(ButtonInteractionEvent e) {
		e.reply("Loading contents..").queue();
		for (java.util.Map.Entry<String, ButtonLayout> entry : plugin.buttonManager.getSavedButtonLayouts()
		        .entrySet()) {
			for (ButtonLink buttonLink : entry.getValue().getButtonLayout()) {
				// Bukkit.getLogger().info("" + e.getComponentId() + " | " +
				// buttonLink.getButtonID());
				if (buttonLink.getButtonID().equals(e.getComponentId())) {
					Bukkit.getScheduler().runTask(plugin, new Runnable() {
						@Override
						public void run() {
							boolean fromPrivateChannel = e.getChannelType() == ChannelType.PRIVATE;
							ButtonClickedEvent buttonClicked = new ButtonClickedEvent(plugin, buttonLink,
							        plugin.getChannelsManager.getSpecificChannelLinkByID(e.getChannel().getId()),
							        plugin.userManager.getUserLinkByID(e.getUser().getId()), e.getMessage(),
							        fromPrivateChannel, e);
							Bukkit.getPluginManager().callEvent(buttonClicked);
							if (buttonClicked.getEphemeralBoolean()) {
								e.getMessage().editMessageComponents().setEmbeds();
							} else {
								e.getMessage().delete().queue();
							}
						}
					});
				}
			}
		}
		e.getHook().deleteOriginal().queue();
	}
	
	@Override
	public void onSlashCommandInteraction(SlashCommandInteractionEvent e) {
		e.reply("*Recieved Command*").queue();
		for (String str : plugin.api.getCommandTriggerManager().getAllCommandTriggers()) {
			if (str.split("===")[0].equalsIgnoreCase(e.getName())) {
				Bukkit.getScheduler().runTask(plugin, new Runnable() {
					@Override
					public void run() {
						boolean fromPrivateChannel = e.getChannelType() == ChannelType.PRIVATE;
						CommandTriggeredEvent commandTriggered = new CommandTriggeredEvent(plugin,
						        plugin.getChannelsManager
						                .getSpecificChannelLinkByID(e.getChannel().getId()), plugin.userManager
						                        .getUserLinkByID(
						                                e.getUser().getId()), e.getCommandString(), null,
						        fromPrivateChannel, e);
						Bukkit.getPluginManager().callEvent(commandTriggered);
						/*
						 * List<String> but = new ArrayList<String>();
						 * 
						 * arrs.add("<:MC_emilianya:875879713938239549>");
						 * 
						 * 
						 * commandTriggered.getChannelLink().sendSimpleMessagWithReaction("Testing",
						 * arrs);
						 */
						/*
						 * List<ButtonLink> myButtons = new ArrayList<ButtonLink>(); myButtons.add(new
						 * ButtonLink(plugin, "confirm", ButtonPriority.SUCCESS, ButtonType.LABEL));
						 * myButtons.add(new ButtonLink(plugin, "cancel", ButtonPriority.DANGER,
						 * ButtonType.LABEL)); myButtons.add(new ButtonLink(plugin, "boop",
						 * ButtonPriority.SECONDARY, ButtonType.LABEL));
						 * 
						 * String id = plugin.buttonManager.createNewButtonLayout(myButtons);
						 * commandTriggered.sendToChannelSimpleEmbededWithButtons("embed with buttons",
						 * Color.PINK, "Testing buttons!",
						 * plugin.api.getButtonManager().getButtonLayoutByID(id));
						 */
					}
				});
			}
		}
		e.getHook().deleteOriginal().queue();
	}
	
	@Override
	public void onMessageReceived(MessageReceivedEvent e) {
		Bukkit.getScheduler().runTask(plugin, new Runnable() {
			@Override
			public void run() {
				boolean fromPrivateChannel = e.getChannelType() == ChannelType.PRIVATE;
				// Bukkit.getLogger().info(e.getMessage().getContentDisplay());
				RecievedMessageEvent recievedMessageEvent = new RecievedMessageEvent(plugin, plugin.getChannelsManager
				        .getSpecificChannelLinkByID(e.getChannel().getId()), plugin.userManager.getUserLinkByID(
				                e.getAuthor().getId()), e.getMessage().getContentDisplay(), e.getMessage(),
				        fromPrivateChannel, e);
				Bukkit.getPluginManager().callEvent(recievedMessageEvent);
			}
		});
	}
	
	@Override
	public void onMessageReactionAdd(MessageReactionAddEvent e) {
		Bukkit.getScheduler().runTask(plugin, new Runnable() {
			@Override
			public void run() {
				MessageChannel msgChannel = e.getChannel();
				Message message = msgChannel.retrieveMessageById(e.getMessageId()).complete();
				if (message.getAuthor().isBot() && !e.getUser().isBot()) {
					boolean fromPrivateChannel = e.getChannelType() == ChannelType.PRIVATE;
					ReactionAddedEvent reactionAddedEvent = new ReactionAddedEvent(plugin, plugin.getChannelsManager
					        .getSpecificChannelLinkByID(e.getChannel().getId()), plugin.userManager.getUserLinkByID(e
					                .getUserId()), null, e.getEmoji().getFormatted(), message.getContentDisplay(),
					        fromPrivateChannel);
					Bukkit.getPluginManager().callEvent(reactionAddedEvent);
				}
			}
		});
	}
	
	@Override
	public void onGuildVoiceJoin(GuildVoiceJoinEvent e) {
		Bukkit.getScheduler().runTask(plugin, new Runnable() {
			@Override
			public void run() {
				UserLink userLink = plugin.userManager.getUserLinkByID(e.getMember().getUser().getId());
				VoiceChannelJoined guildJoinedVoice = new VoiceChannelJoined(plugin, e.getChannelJoined().getId(),
				        userLink);
				Bukkit.getPluginManager().callEvent(guildJoinedVoice);
				plugin.voiceChannelManager.addVoiceChannelUser(userLink);
			}
		});
	}
	
	@Override
	public void onGuildVoiceLeave(GuildVoiceLeaveEvent e) {
		Bukkit.getScheduler().runTask(plugin, new Runnable() {
			@Override
			public void run() {
				UserLink userLink = plugin.userManager.getUserLinkByID(e.getMember().getUser().getId());
				VoiceChannelLeft guildLeftVoice = new VoiceChannelLeft(plugin, e.getChannelLeft().getId(), userLink);
				Bukkit.getPluginManager().callEvent(guildLeftVoice);
				plugin.voiceChannelManager.removeVoiceChannelUser(userLink);
			}
		});
	}
	
	@Override
	public void onGuildMemberJoin(GuildMemberJoinEvent e) {
		String id = e.getUser().getId();
		if (plugin.api.getUserManager().getUserLinkByID(id) == null) {
			plugin.api.getUserManager().addUserLink(id, new UserLink(plugin, e.getUser()));
		}
		Bukkit.getScheduler().runTask(plugin, new Runnable() {
			@Override
			public void run() {
				UserLink userLink = plugin.userManager.getUserLinkByID(e.getMember().getUser().getId());
				UserJoinedEvent userJoinedEvent = new UserJoinedEvent(plugin, userLink);
				Bukkit.getPluginManager().callEvent(userJoinedEvent);
			}
		});
	}
	
	@Override
	public void onGuildMemberRemove(GuildMemberRemoveEvent e) {
		Bukkit.getScheduler().runTask(plugin, new Runnable() {
			@Override
			public void run() {
				UserLink userLink = plugin.userManager.getUserLinkByID(e.getMember().getUser().getId());
				UserLeftEvent userLeftEvent = new UserLeftEvent(plugin, userLink);
				Bukkit.getPluginManager().callEvent(userLeftEvent);
			}
		});
	}
	
	@Override
	public void onRoleCreate(RoleCreateEvent e) {
		Bukkit.getScheduler().runTask(plugin, new Runnable() {
			@Override
			public void run() {
				RoleCreatedEvent roleCreatedEvent = new RoleCreatedEvent(plugin, e.getRole().getId(), e.getRole());
				Bukkit.getPluginManager().callEvent(roleCreatedEvent);
			}
		});
	}
	
	@Override
	public void onRoleDelete(RoleDeleteEvent e) {
		Bukkit.getScheduler().runTask(plugin, new Runnable() {
			@Override
			public void run() {
				RoleDeletedEvent roleDeletedEvent = new RoleDeletedEvent(plugin, e.getRole().getId(), e.getRole());
				Bukkit.getPluginManager().callEvent(roleDeletedEvent);
			}
		});
	}
	
	@Override
	public void onGuildMemberRoleAdd(GuildMemberRoleAddEvent e) {
		Bukkit.getScheduler().runTask(plugin, new Runnable() {
			@Override
			public void run() {
				UserAddedRole userAddedRole = new UserAddedRole(plugin, plugin.userManager.getUserLinkByID(e.getMember()
				        .getUser().getId()), e.getRoles());
				Bukkit.getPluginManager().callEvent(userAddedRole);
			}
		});
	}
	
	@Override
	public void onGuildMemberRoleRemove(GuildMemberRoleRemoveEvent e) {
		Bukkit.getScheduler().runTask(plugin, new Runnable() {
			@Override
			public void run() {
				UserRemovedRole userRemovedRole = new UserRemovedRole(plugin, plugin.userManager.getUserLinkByID(e
				        .getMember().getUser().getId()), e.getRoles());
				Bukkit.getPluginManager().callEvent(userRemovedRole);
			}
		});
	}
	
	@Override
	public void onCommandAutoCompleteInteraction(CommandAutoCompleteInteractionEvent event) {
		for (String str : plugin.api.getCommandTriggerManager().getAllCommandTriggers()) {
			String placeholder = str.split("===")[1];
			String args = placeholder.replaceAll("\\(.*?\\)", "");
			String[] entireList = args.split("=");
			String[] secondEntireList = placeholder.split("=");
			int position = 5;
			int otherPos = 1;
			for (String inner : entireList) {
				String[] innerList = inner.split(";");
				if ("TRUE".equals(innerList[position]) && event.getName().equals(str.split("===")[0]) && event
				        .getFocusedOption().getName().equals(innerList[position - 3])) {
					String[] words = new String[100];
					int x = 0;
					for (String choices : secondEntireList[otherPos].substring(secondEntireList[otherPos].indexOf('(')+ 1, secondEntireList[otherPos].indexOf(')')).split(",")) {
						if (choices != null) {
							words[x] = choices;
							x++;
						}
					}
					if (words.length == 0) {
						break;
					}
					List<Command.Choice> options = new ArrayList<>();
					for (String word : words) {
						if (word != null && word.startsWith(event.getFocusedOption().getValue())) {
							options.add(new Command.Choice(word, word));
						}
					}
					if (!options.isEmpty()) {
						event.replyChoices(options).queue();
					}
				}
				position = 4;
				otherPos++;
			}
		}
	}
	/*
	 * public void replyToCommand(ButtonLayout buttonLayout, ButtonLink buttonLink,
	 * SlashCommandInteractionEvent e) {
	 * 
	 * switch (buttonLink.getButtonPriority()) { case PRIMARY: buttonLayout.send
	 * break; case SECONDARY:
	 * 
	 * break; case SUCCESS:
	 * 
	 * break; default: break; } }
	 */
}
