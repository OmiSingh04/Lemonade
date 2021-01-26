package com.dev.os.lemonade.emotes;

import com.dev.os.lemonade.runner.App;

import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class HelloEvent extends ListenerAdapter{
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String message = event.getMessage().getContentRaw().toString().toUpperCase();
		
		if(message.startsWith(App.SERVER_PREFIX + "HELLO")||message.startsWith(App.SERVER_PREFIX + "HI")) {
			
			String name = event.getMember().getNickname();
			if(name == null) {
				name = event.getAuthor().getName();
			}
			event.getChannel().sendMessage("Hi " + name + "!").queue();
		}
		
		
		
		
	}
	
	public void onGuildMemberJoin(GuildMemberJoinEvent e) {
		e.getMember();
		
	}

}