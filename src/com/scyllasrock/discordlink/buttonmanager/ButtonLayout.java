package com.scyllasrock.discordlink.buttonmanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.scyllasrock.discordlink.DiscordLink;
import com.scyllasrock.discordlink.channel.ChannelLink;

import net.dv8tion.jda.api.EmbedBuilder;

public class ButtonLayout {
		DiscordLink plugin;
		private String layoutName;
	private List<ButtonLink> buttonLayout = new ArrayList<>();
		protected ButtonLayout(DiscordLink plugin, List<ButtonLink> buttonLayout) {
		this.plugin = plugin;
		this.buttonLayout = buttonLayout;
		Random random = new Random();
		do {
			this.layoutName = String.valueOf(random.nextInt(100000));
		} while (plugin.buttonManager.getTakenIDS().contains(this.layoutName));
			}
		public String getLayoutID() {
		return this.layoutName;
	}
		public void setButtonLayout(List<ButtonLink> buttonLayout) {
		this.buttonLayout = buttonLayout;
	}
		public List<ButtonLink> getButtonLayout() {
		return this.buttonLayout;
	}
		public void addButtonToLayout(ButtonLink buttonLink) {
		buttonLayout.add(buttonLink);
	}
		public void removeButtonFromLayout(int position) {
		buttonLayout.remove(position);
	}
													}
