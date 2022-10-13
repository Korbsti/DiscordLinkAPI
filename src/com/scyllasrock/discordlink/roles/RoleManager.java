package com.scyllasrock.discordlink.roles;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.scyllasrock.discordlink.DiscordLink;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.requests.restaction.RoleAction;

public class RoleManager {
		DiscordLink plugin;
		public RoleManager(DiscordLink plugin) {
		this.plugin = plugin;
	}
			/**
	 * Create a new role, by role name, color, and icon of the role, with permissions.
	 */
	public void createRole(String roleName, java.awt.Color color, String icon, Collection<Permission> permissions) {
		RoleAction role = plugin.guild.createRole();
		role.setName(roleName);
		role.setColor(color);
		role.setIcon(icon);
		role.setPermissions(permissions);
		role.queue();
	}
		/** Create a new role, by role name, color, with permissions. */
	public void createRole(String roleName, java.awt.Color color, Collection<Permission> permissions) {
		RoleAction role = plugin.guild.createRole();
		role.setName(roleName);
		role.setColor(color);
		role.setPermissions(permissions);
		role.queue();
	}
		/** Create a new role, by role name, color. */
	public void createRole(String roleName, java.awt.Color color) {
		RoleAction role = plugin.guild.createRole();
		role.setName(roleName);
		role.setColor(color);
		role.queue();
	}
		/** Delete a role by ID. */
	public void deleteRoleByID(String roleID) {
		plugin.guild.getRoleById(roleID).delete().queue();
	}
		/** Get a role by ID. */
	public Role getRoleByID(String roleID) {
		return plugin.guild.getRoleById(roleID);
	}
		/** Set a roles ID to a certain colour. */
	public void setRoleColor(String roleID, java.awt.Color color) {
		((RoleAction) plugin.guild.getRoleById(roleID)).setColor(color).queue();
	}
			/** Set a certain roles ID permissions. */
	public void setRolePermissions(String roleID, Collection<Permission> permissions) {
		((RoleAction) plugin.guild.getRoleById(roleID)).setPermissions(permissions).queue();
	}
		/** Return a list of strings, with all role IDs. */
	public List<String> returnAllRolesID(){
		List<String> returningID = new ArrayList<>();
				for(Role role : plugin.guild.getRoles()) {
			returningID.add(role.getId());
		}
		return returningID;
	}
		/** Return a list of strings, with all role names. */
	public List<String> returnAllRolesName(){
		List<String> returning = new ArrayList<>();
				for(Role role : plugin.guild.getRoles()) {
			returning.add(role.getName());
		}
		return returning;
	}
		/**
	 * Return a hashmap, with the key as the role name
	 * and the value as the role ID.
	 */
	public HashMap<String, String> returnAllRolesNameWithID(){
		 HashMap<String, String> returning = new  HashMap<>();
				for(Role role : plugin.guild.getRoles()) {
			returning.put(role.getName(), role.getId());
		}
		return returning;
	}
						}
