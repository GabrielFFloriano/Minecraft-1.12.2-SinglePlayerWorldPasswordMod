package com.shiringu.singleplayerpasswordmod;

import com.shiringu.singleplayerpasswordmod.gui.PasswordScreen;
import com.shiringu.singleplayerpasswordmod.util.Reference;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=Reference.MOD_ID)
public class ClientModInitializer {

	public ClientModInitializer() {
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	@SubscribeEvent
	public void onPlayerLoggedIn() {
		// Show password screen
		Minecraft.getMinecraft().displayGuiScreen(new PasswordScreen());
	}
}
