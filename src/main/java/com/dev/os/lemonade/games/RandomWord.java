package com.dev.os.lemonade.games;
import com.dev.os.lemonade.runner.App;
import com.github.dhiraj072.randomwordgenerator.RandomWordGenerator;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class RandomWord extends ListenerAdapter{

	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String message = event.getMessage().getContentRaw().toString().toUpperCase();
		if(message.startsWith(App.SERVER_PREFIX + "GUESS")) {
			String word = RandomWordGenerator.getRandomWord();
			event.getChannel().sendMessage(word).queue();
			
		}
	}
}
