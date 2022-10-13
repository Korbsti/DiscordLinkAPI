package com.scyllasrock.discordlink.buttonmanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.scyllasrock.discordlink.DiscordLink;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

public class ButtonManager {
	DiscordLink plugin;
			private Map<String, ButtonLayout> savedButtonLayouts = new HashMap<>();
	private List<String> takenIDS = new ArrayList<>();
	public ButtonManager(DiscordLink plugin) {
		this.plugin = plugin;
	}
		public void addNewButtonToLayout(String layoutID, ButtonLink buttonLink) {
		savedButtonLayouts.get(layoutID).addButtonToLayout(buttonLink);
	}
		public Map<String, ButtonLayout> getSavedButtonLayouts(){
		return this.savedButtonLayouts;
	}
		public ButtonLayout getButtonLayoutByID(String layoutID) {
		return savedButtonLayouts.get(layoutID);
	}
		/**
	 * You really wont be using this as well.
	 * @return
	 */
	public List<String> getTakenIDS(){
		return this.takenIDS;
	}
	/**
	 * You really wont be using this trust.
	 * @param str
	 */
	public void addNewTakenID(String str) {
		this.takenIDS.add(str);
	}
		/**
	 * You also wont be using this.
	 * @param takenIDS
	 */
	public void setTakenIDS(List<String> takenIDS) {
		this.takenIDS = takenIDS;
	}
				/**
	 * Set the entirety of the saved button layouts with a hashmap of the layoutname
	 * and the buttonlayout.
	 */
	public void setAllButtonLayouts(Map<String, ButtonLayout> allButtonLayouts){
		this.savedButtonLayouts = allButtonLayouts;
	}
		/** Remove a button layout by its name. */
	public void removeSavedButtonLayout(String layoutID) {
		savedButtonLayouts.remove(layoutID);	
	}
		/**
	 * Create a new button layout
	 * 
	 * A button layout is consisted of multiple ButtonLinks
	 * 
	 * This layout will then be used to be attached onto a reply message of your choosing
	 * 
	 * Create a list<ButtonLink> and add the button links of your choosing using createNewButtonLink()
	 * 
	 * The layoutName is an identifier of your choosing, for example it can be the "Banana" layout
	 * or even "GodPleaseHelpMeTheseCommentsAreKillingMe" layout, see? Easy
	 */
	public String createNewButtonLayout(List<ButtonLink> buttonLayout) {
		ButtonLayout bLayout = new ButtonLayout(plugin, buttonLayout);
		savedButtonLayouts.put(bLayout.getLayoutID(), bLayout);
		return bLayout.getLayoutID();
	}
			/**
	 * Create a new button link
	 * A button link is going to be used as a component inside a button layout
	 * A button link requires, buttonID, button contents, button priority, and button type
	 * 
	 * name can be anything you want
	 * buttonID is just an identifier, it can also be anything you want
	 * buttonContents is what is shown on the button
	 * Button Priority, is either, PRIMARY, SECONDARY, LINK, or DANGER
	 * Button Type is either LABEL or EMOJI
	 * 
	 * if EMOJI is selected, buttonContent will require a FORMATTED button
	 * like so <emojiname:idnumber>
	 * 
	 * if LABEL is selected, then buttonContent will just be a regular string displayed
	 */
	public ButtonLink createNewButtonLink( String buttonContents, ButtonPriority buttonPriority, ButtonType buttonType) {
		return new ButtonLink(plugin, buttonContents, buttonPriority, buttonType);
	}
		public enum ButtonPriority{
		PRIMARY,
		SECONDARY,
		SUCCESS,
		LINK,
		DANGER
			}
		public enum ButtonType{
		LABEL,
		EMOJI
	}
					}
