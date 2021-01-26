package com.dev.os.lemonade.emotes;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ImageSend extends ListenerAdapter{

	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String message = event.getMessage().toString().toUpperCase();
		if(message.startsWith("LM.SEND")) {
			EmbedBuilder builder = new EmbedBuilder();
			builder.setTitle("Image");
			builder.setDescription("https://http.cat/500");
			event.getChannel().sendMessage(builder.build()).queue();
		}
	}
	
}
