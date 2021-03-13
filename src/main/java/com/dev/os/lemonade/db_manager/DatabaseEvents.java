package com.dev.os.lemonade.db_manager;

import java.util.Random;

import com.dev.os.lemonade.runner.App;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class DatabaseEvents extends ListenerAdapter {

	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

		String message = event.getMessage().getContentRaw().toString().toUpperCase();

		if (message.startsWith(App.SERVER_PREFIX + "REGISTER")) {
			boolean x = App.BOT_QUERIES.registerUser(event.getAuthor(), event.getGuild().getName());
			if (x)
				event.getChannel().sendMessage("Registered!\nYou have 500 lemons").queue();
			else
				event.getChannel().sendMessage("You are probably registered or ping Sandy").queue();
		}

		if (message.startsWith(App.SERVER_PREFIX + "LEMONS") || message.startsWith(App.SERVER_PREFIX + "BAL")) {
			long x = App.BOT_QUERIES.getLemons(event.getAuthor());
			System.out.println(x);
			if (x != -1)
				event.getChannel().sendMessage("You have " + x + " lemons").queue();
			else
				event.getChannel().sendMessage("E-error, b-baka Sandwich!").queue();
		}

		if (message.startsWith(App.SERVER_PREFIX + "SPIN")) {
			int random = new Random().nextInt(1000);
			boolean x = App.BOT_QUERIES.addLemons(event.getMessage().getAuthor(), random);
			if (x)
				event.getChannel().sendMessage("You won " + random + " lemons!").queue();
			if (!x)
				event.getChannel().sendMessage("Error Sandwich Kunnn TwT").queue();
		}

	}
}
