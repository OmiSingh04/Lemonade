package com.dev.os.lemonade.util;

import com.dev.os.lemonade.runner.App;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class AvatarEvent extends ListenerAdapter{

	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String message = event.getMessage().getContentRaw().toString().toUpperCase();
		
		if(message.startsWith(App.SERVER_PREFIX + "AVATAR")) {
			message = message.substring(10);
			String avatar = event.getMessage().getMentionedMembers().get(0).getUser().getAvatarUrl();
			event.getChannel().sendMessage(avatar).queue();
		}
	}
}
