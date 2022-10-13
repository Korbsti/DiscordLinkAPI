package com.scyllasrock.discordlink.buttonmanager;

import java.util.Random;

import com.scyllasrock.discordlink.DiscordLink;
import com.scyllasrock.discordlink.buttonmanager.ButtonManager.ButtonPriority;
import com.scyllasrock.discordlink.buttonmanager.ButtonManager.ButtonType;

import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.interactions.components.ItemComponent;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

public class ButtonLink {
	DiscordLink plugin;
		private String buttonID;
	private String buttonContents;
	private ButtonPriority buttonPriority;
	private ButtonType buttonType;
	private ItemComponent itemComponent;
			public ButtonLink(DiscordLink plugin, String buttonContents, ButtonPriority buttonPriority, ButtonType buttonType) {
		this.plugin = plugin;
		this.buttonPriority = buttonPriority;
		this.buttonType = buttonType;
		this.buttonContents = buttonContents;
				Random random = new Random();
		do {
			this.buttonID = String.valueOf(random.nextInt(100000));
		} while (plugin.buttonManager.getTakenIDS().contains(this.buttonID));
								if(buttonContents.contains(";")) {
			String[] list = buttonContents.split(";");
						buttonID = list[0];
			buttonContents = list[1];
					}
				plugin.buttonManager.addNewTakenID(this.buttonID);

				itemComponent = returnAsItemComponent();
	}
		public String getButtonID() {
		return this.buttonID;
	}
		public String getButtonContents() {
		return this.buttonContents;
	}
		public void setButtonContents(String buttonContents) {
		this.buttonContents = buttonContents;
	}
		public ButtonPriority getButtonPriority() {
		return this.buttonPriority;
	}
		public ButtonType getButtonType() {
		return this.buttonType;
	}
		public void setButtonPriority(ButtonPriority buttonPriority){
		this.buttonPriority = buttonPriority;
	}
		public void setButtonType(ButtonType buttonType) {
		this.buttonType = buttonType;
	}
		public ItemComponent getItemComponent() {
		return this.itemComponent;
	}
		public void setItemComponent(ItemComponent itemComponent) {
		this.itemComponent = itemComponent;
	}
		public ItemComponent returnAsItemComponent() {
		ButtonType type = getButtonType();
		Button button = null;
		switch(getButtonPriority()) {
			case PRIMARY:
				switch(type) {
					case EMOJI:
												button = Button.primary(buttonID, Emoji.fromFormatted(buttonContents));
												return button;
					case LABEL:
						button = Button.primary(buttonID, buttonContents);
						return button;
				}
				break;
			case SECONDARY:
				switch(type) {
					case EMOJI:
						button =Button.secondary(buttonID, Emoji.fromFormatted(buttonContents));
						return button;
					case LABEL:
						button =Button.secondary(buttonID, buttonContents); 
						return button;
				}
			case SUCCESS:
				switch(type) {
					case EMOJI:
						button =  Button.success(buttonID, Emoji.fromFormatted(buttonContents));
						return button;
					case LABEL:
						button =Button.success(buttonID, buttonContents);
						return button;
				}
			case LINK:
				switch(type) {
					case EMOJI:
						button =Button.link(buttonID, Emoji.fromFormatted(buttonContents));
						return button;
					case LABEL:
						button =Button.link(buttonID, buttonContents); 
						return button;
				}
			case DANGER:
				switch(type) {
					case EMOJI:
						button = Button.danger(buttonID, Emoji.fromFormatted(buttonContents));
						return button;
					case LABEL:
						button =Button.danger(buttonID, buttonContents); 
						return button;
				}
			default:
				break;

		}
		return null;
			}
							}
