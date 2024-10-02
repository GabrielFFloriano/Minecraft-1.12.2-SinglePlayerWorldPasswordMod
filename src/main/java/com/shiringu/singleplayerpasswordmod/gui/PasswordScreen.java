package com.shiringu.singleplayerpasswordmod.gui;

import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.text.TextComponentString;

public class PasswordScreen extends GuiScreen{
	private GuiButton confirmBtn;
	private GuiButton cancelBtn;
	private String password = "";
	
	
	@Override
	public void initGui() {
		// Button position
		int centerX = this.width/2;
		int centerY = this.height/2;
		
		this.confirmBtn = new GuiButton(0, centerX-50, centerY, 100, 20, "Confirm");
		this.buttonList.add(confirmBtn);
	
		this.cancelBtn = new GuiButton(1, centerX-50, centerY+30, 100, 20, "Cancel");
		this.buttonList.add(cancelBtn);
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException{
		// Buttons actions
		if (button == confirmBtn) {
			Minecraft.getMinecraft().player.sendMessage(new TextComponentString("Password Confirmed: " + this.password));
			this.mc.displayGuiScreen(null);
		} else if (button == cancelBtn) {
			this.mc.displayGuiScreen(null);
		}
	}
	
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException{
		// defining the password
		if (Character.isLetterOrDigit(typedChar)) {
			this.password += typedChar;
		}else if (keyCode == 14 && this.password.length()>0) {
			// Backspace
			this.password = this.password.substring(0,this.password.length()-1);
		} // TODO Delete key
		super.keyTyped(typedChar, keyCode);
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		this.drawCenteredString(this.fontRenderer, "Enter Password", this.width/2, this.height/2-40, 0xFFFFFF);
		this.drawCenteredString(this.fontRenderer, this.password, this.width/2, this.height/2-20, 0xFFAA00);
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return true;
	}
}
