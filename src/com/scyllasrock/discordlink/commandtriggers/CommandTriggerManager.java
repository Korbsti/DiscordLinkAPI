package com.scyllasrock.discordlink.commandtriggers;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;

import com.scyllasrock.discordlink.DiscordLink;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.interactions.commands.Command;
import net.dv8tion.jda.api.interactions.commands.Command.Subcommand;
import net.dv8tion.jda.api.interactions.commands.Command.SubcommandGroup;
import net.dv8tion.jda.api.interactions.commands.DefaultMemberPermissions;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandData;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandGroupData;
import net.dv8tion.jda.api.utils.data.DataObject;

public class CommandTriggerManager {
		DiscordLink plugin;
		private List<String> commands = new ArrayList<>();
		public CommandTriggerManager(DiscordLink plugin) {
		this.plugin = plugin;
	}
		/**
	 * Create a new command trigger by a command name and description of the command
	 * 
	 * This command trigger will fire a CommandTriggered event
	 * 
	 * 
	 * optionTypes should be this ";".
	 */
	public void addNewCommandTrigger(String commandName, String description, String args) {
		commands.add(commandName + "===" + args);
				// plugin.guild.updateCommands().addCommands(
		// Commands.slash(commandName,
		// description).addSubcommandGroups().addSubcommands().addOption(OptionType.valueOf(list[2]),
		// list[0], list[1])).queue();
				// plugin.jda.updateCommands().addCommands(Commands.slash(commandName,
		// description).addSubcommandGroups().addSubcommands().addOption(OptionType.valueOf(list[2]),
		// list[0], list[1])).queue();
				if (args != null) {
			args = args.replaceAll("\\(.*?\\)", "");
			String[] entireList = args.split("=");
			String[] list = args.replace("=", ";").split(";");
															int x = 1;
			switch (entireList.length) {
				case 1:
					plugin.guild.updateCommands().addCommands(Commands.slash(commandName, description)
					        .setDefaultPermissions(DefaultMemberPermissions.enabledFor(Permission.valueOf(list[0])))
					        .addSubcommandGroups().addSubcommands().addOption(OptionType.valueOf(list[x++]), list[x++],
					                list[x++], Boolean.valueOf(list[x++]), Boolean.valueOf(list[x++]))).queue();
					return;
				case 2:
					plugin.guild.updateCommands().addCommands(Commands.slash(commandName, description)
					        .setDefaultPermissions(DefaultMemberPermissions.enabledFor(Permission.valueOf(list[0])))
					        .addOption(OptionType.valueOf(list[x++]), list[x++], list[x++], true)
					        .addSubcommandGroups().addSubcommands().addOption(OptionType.valueOf(list[x++]), list[x++],
					                list[x++], Boolean.valueOf(list[x++]), Boolean.valueOf(list[x++]))).queue();
					return;
				case 3:
					plugin.guild.updateCommands().addCommands(Commands.slash(commandName, description)
					        .setDefaultPermissions(DefaultMemberPermissions.enabledFor(Permission.valueOf(list[0])))
					        .addOption(OptionType.valueOf(list[x++]), list[x++], list[x++], Boolean.valueOf(list[x++]),
					                Boolean.valueOf(list[x++]))
					        .addOption(OptionType.valueOf(list[x++]), list[x++], list[x++], Boolean.valueOf(list[x++]),
					                Boolean.valueOf(list[x++]))
					        .addSubcommandGroups().addSubcommands().addOption(OptionType.valueOf(list[x++]), list[x++],
					                list[x++], Boolean.valueOf(list[x++]), Boolean.valueOf(list[x++]))).queue();
					return;
				case 4:
					plugin.guild.updateCommands().addCommands(Commands.slash(commandName, description)
					        .setDefaultPermissions(DefaultMemberPermissions.enabledFor(Permission.valueOf(list[0])))
					        .addOption(OptionType.valueOf(list[x++]), list[x++], list[x++], Boolean.valueOf(list[x++]),
					                Boolean.valueOf(list[x++]))
					        .addOption(OptionType.valueOf(list[x++]), list[x++], list[x++], Boolean.valueOf(list[x++]),
					                Boolean.valueOf(list[x++]))
					        .addOption(OptionType.valueOf(list[x++]), list[x++], list[x++], Boolean.valueOf(list[x++]),
					                Boolean.valueOf(list[x++]))
					        .addSubcommandGroups().addSubcommands().addOption(OptionType.valueOf(list[x++]), list[x++],
					                list[x++], Boolean.valueOf(list[x++]), Boolean.valueOf(list[x++]))).queue();
					return;
				case 5:
					plugin.guild.updateCommands().addCommands(Commands.slash(commandName, description)
					        .setDefaultPermissions(DefaultMemberPermissions.enabledFor(Permission.valueOf(list[0])))
					        .addOption(OptionType.valueOf(list[x++]), list[x++], list[x++], Boolean.valueOf(list[x++]),
					                Boolean.valueOf(list[x++]))
					        .addOption(OptionType.valueOf(list[x++]), list[x++], list[x++], Boolean.valueOf(list[x++]),
					                Boolean.valueOf(list[x++]))
					        .addOption(OptionType.valueOf(list[x++]), list[x++], list[x++], Boolean.valueOf(list[x++]),
					                Boolean.valueOf(list[x++]))
					        .addOption(OptionType.valueOf(list[x++]), list[x++], list[x++], Boolean.valueOf(list[x++]),
					                Boolean.valueOf(list[x++]))
					        .addSubcommandGroups().addSubcommands().addOption(OptionType.valueOf(list[x++]), list[x++],
					                list[x++], Boolean.valueOf(list[x++]), Boolean.valueOf(list[x++]))).queue();
					return;
				case 6:
					plugin.guild.updateCommands().addCommands(Commands.slash(commandName, description)
					        .setDefaultPermissions(DefaultMemberPermissions.enabledFor(Permission.valueOf(list[0])))
					        .addOption(OptionType.valueOf(list[x++]), list[x++], list[x++], Boolean.valueOf(list[x++]),
					                Boolean.valueOf(list[x++]))
					        .addOption(OptionType.valueOf(list[x++]), list[x++], list[x++], Boolean.valueOf(list[x++]),
					                Boolean.valueOf(list[x++]))
					        .addOption(OptionType.valueOf(list[x++]), list[x++], list[x++], Boolean.valueOf(list[x++]),
					                Boolean.valueOf(list[x++]))
					        .addOption(OptionType.valueOf(list[x++]), list[x++], list[x++], Boolean.valueOf(list[x++]),
					                Boolean.valueOf(list[x++]))
					        .addOption(OptionType.valueOf(list[x++]), list[x++], list[x++], Boolean.valueOf(list[x++]),
					                Boolean.valueOf(list[x++]))
					        .addSubcommandGroups().addSubcommands().addOption(OptionType.valueOf(list[x++]), list[x++],
					                list[x++], Boolean.valueOf(list[x++]), Boolean.valueOf(list[x++]))).queue();
				case 7:
					plugin.guild.updateCommands().addCommands(Commands.slash(commandName, description)
					        .setDefaultPermissions(DefaultMemberPermissions.enabledFor(Permission.valueOf(list[0])))
					        .addOption(OptionType.valueOf(list[x++]), list[x++], list[x++], Boolean.valueOf(list[x++]),
					                Boolean.valueOf(list[x++]))
					        .addOption(OptionType.valueOf(list[x++]), list[x++], list[x++], Boolean.valueOf(list[x++]),
					                Boolean.valueOf(list[x++]))
					        .addOption(OptionType.valueOf(list[x++]), list[x++], list[x++], Boolean.valueOf(list[x++]),
					                Boolean.valueOf(list[x++]))
					        .addOption(OptionType.valueOf(list[x++]), list[x++], list[x++], Boolean.valueOf(list[x++]),
					                Boolean.valueOf(list[x++]))
					        .addOption(OptionType.valueOf(list[x++]), list[x++], list[x++], Boolean.valueOf(list[x++]),
					                Boolean.valueOf(list[x++]))
					        .addOption(OptionType.valueOf(list[x++]), list[x++], list[x++], Boolean.valueOf(list[x++]),
					                Boolean.valueOf(list[x++]))
					        .addSubcommandGroups().addSubcommands().addOption(OptionType.valueOf(list[x++]), list[x++],
					                list[x++], Boolean.valueOf(list[x++]), Boolean.valueOf(list[x++]))).queue();
				case 8:
					plugin.guild.updateCommands().addCommands(Commands.slash(commandName, description)
					        .setDefaultPermissions(DefaultMemberPermissions.enabledFor(Permission.valueOf(list[0])))
					        .addOption(OptionType.valueOf(list[x++]), list[x++], list[x++], Boolean.valueOf(list[x++]),
					                Boolean.valueOf(list[x++]))
					        .addOption(OptionType.valueOf(list[x++]), list[x++], list[x++], Boolean.valueOf(list[x++]),
					                Boolean.valueOf(list[x++]))
					        .addOption(OptionType.valueOf(list[x++]), list[x++], list[x++], Boolean.valueOf(list[x++]),
					                Boolean.valueOf(list[x++]))
					        .addOption(OptionType.valueOf(list[x++]), list[x++], list[x++], Boolean.valueOf(list[x++]),
					                Boolean.valueOf(list[x++]))
					        .addOption(OptionType.valueOf(list[x++]), list[x++], list[x++], Boolean.valueOf(list[x++]),
					                Boolean.valueOf(list[x++]))
					        .addOption(OptionType.valueOf(list[x++]), list[x++], list[x++], Boolean.valueOf(list[x++]),
					                Boolean.valueOf(list[x++]))
					        .addOption(OptionType.valueOf(list[x++]), list[x++], list[x++], Boolean.valueOf(list[x++]),
					                Boolean.valueOf(list[x++]))
					        .addSubcommandGroups().addSubcommands().addOption(OptionType.valueOf(list[x++]), list[x++],
					                list[x++], Boolean.valueOf(list[x++]), Boolean.valueOf(list[x++]))).queue();
				case 9:
					plugin.guild.updateCommands().addCommands(Commands.slash(commandName, description)
					        .setDefaultPermissions(DefaultMemberPermissions.enabledFor(Permission.valueOf(list[0])))
					        .addOption(OptionType.valueOf(list[x++]), list[x++], list[x++], Boolean.valueOf(list[x++]),
					                Boolean.valueOf(list[x++]))
					        .addOption(OptionType.valueOf(list[x++]), list[x++], list[x++], Boolean.valueOf(list[x++]),
					                Boolean.valueOf(list[x++]))
					        .addOption(OptionType.valueOf(list[x++]), list[x++], list[x++], Boolean.valueOf(list[x++]),
					                Boolean.valueOf(list[x++]))
					        .addOption(OptionType.valueOf(list[x++]), list[x++], list[x++], Boolean.valueOf(list[x++]),
					                Boolean.valueOf(list[x++]))
					        .addOption(OptionType.valueOf(list[x++]), list[x++], list[x++], Boolean.valueOf(list[x++]),
					                Boolean.valueOf(list[x++]))
					        .addOption(OptionType.valueOf(list[x++]), list[x++], list[x++], Boolean.valueOf(list[x++]),
					                Boolean.valueOf(list[x++]))
					        .addOption(OptionType.valueOf(list[x++]), list[x++], list[x++], Boolean.valueOf(list[x++]),
					                Boolean.valueOf(list[x++]))
					        .addOption(OptionType.valueOf(list[x++]), list[x++], list[x++], Boolean.valueOf(list[x++]),
					                Boolean.valueOf(list[x++]))
					        .addSubcommandGroups().addSubcommands().addOption(OptionType.valueOf(list[x++]), list[x++],
					                list[x++], Boolean.valueOf(list[x++]), Boolean.valueOf(list[x++]))).queue();
				case 10:
					plugin.guild.updateCommands().addCommands(Commands.slash(commandName, description)
					        .setDefaultPermissions(DefaultMemberPermissions.enabledFor(Permission.valueOf(list[0])))
					        .addOption(OptionType.valueOf(list[x++]), list[x++], list[x++], Boolean.valueOf(list[x++]),
					                Boolean.valueOf(list[x++]))
					        .addOption(OptionType.valueOf(list[x++]), list[x++], list[x++], Boolean.valueOf(list[x++]),
					                Boolean.valueOf(list[x++]))
					        .addOption(OptionType.valueOf(list[x++]), list[x++], list[x++], Boolean.valueOf(list[x++]),
					                Boolean.valueOf(list[x++]))
					        .addOption(OptionType.valueOf(list[x++]), list[x++], list[x++], Boolean.valueOf(list[x++]),
					                Boolean.valueOf(list[x++]))
					        .addOption(OptionType.valueOf(list[x++]), list[x++], list[x++], Boolean.valueOf(list[x++]),
					                Boolean.valueOf(list[x++]))
					        .addOption(OptionType.valueOf(list[x++]), list[x++], list[x++], Boolean.valueOf(list[x++]),
					                Boolean.valueOf(list[x++]))
					        .addOption(OptionType.valueOf(list[x++]), list[x++], list[x++], Boolean.valueOf(list[x++]),
					                Boolean.valueOf(list[x++]))
					        .addOption(OptionType.valueOf(list[x++]), list[x++], list[x++], Boolean.valueOf(list[x++]),
					                Boolean.valueOf(list[x++]))
					        .addOption(OptionType.valueOf(list[x++]), list[x++], list[x++], Boolean.valueOf(list[x++]),
					                Boolean.valueOf(list[x++]))
					        .addSubcommandGroups().addSubcommands().addOption(OptionType.valueOf(list[x++]), list[x++],
					                list[x++], Boolean.valueOf(list[x++]), Boolean.valueOf(list[x++]))).queue();
					return;
			}
						return;
		}
		plugin.jda.upsertCommand(commandName, description).queue();
			}
		public List<String> getAllCommandTriggers() {
		return this.commands;
	}
		public void setCommandTriggers(List<String> commandTriggers) {
		this.commands = commandTriggers;
	}
		/** Remove a command trigger by a command name. */
	public void removeCommandTrigger(String commandName) {
		int x = 0;
		for (String str : commands) {
			if (str.equals(commandName)) {
				commands.remove(x);
				break;
			}
			x++;
		}
				for (Command str : plugin.jda.retrieveCommands().complete()) {
			if (str.getName().equals(commandName)) {
				plugin.jda.deleteCommandById(str.getId()).queue();
			}
		}
		plugin.guild.updateCommands().queue();
			}
		public OptionType[] getOptionTypes() {
		return OptionType.values();
	}
	}
