package com.dev.os.lemonade.db_manager;

import com.dev.os.lemonade.runner.App;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class DatabaseEvents extends ListenerAdapter{
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		String message = event.getMessage().getContentRaw().toString().toUpperCase();
		
		if(message.startsWith(App.SERVER_PREFIX + "REGISTER")) {
			boolean x = App.BOT_QUERIES.registerUser(event.getAuthor(), event.getGuild().getName());
			if(x)
				event.getChannel().sendMessage("Registered!\nYou have 500 lemons").queue();
			else
				event.getChannel().sendMessage("E-error, b-baka Sandwich!");
		}
		
		if(message.startsWith(App.SERVER_PREFIX + "LEMONS")) {
			long x = App.BOT_QUERIES.getLemons(event.getAuthor());
			if(x != -1)
				event.getChannel().sendMessage("You have " + x + " lemons");
			else
				event.getChannel().sendMessage("E-error, b-baka Sandwich!");
		}
	}
}
