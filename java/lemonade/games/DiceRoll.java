package lemonade.games;

import java.io.File;

import lemonade.runner.App;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class DiceRoll extends ListenerAdapter{

	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String message = event.getMessage().getContentRaw().toString().toUpperCase();
		
		if(message.startsWith(App.SERVER_PREFIX + "DICE")) {
			int num = 3;
			
			num = Integer.parseInt(Character.toString(Double.toString(Math.random()).charAt(16)));
			
			if(num==0) num = 2;
			if(num==7) num = 4;
			if(num==8) num = 6;
			if(num==9) num = 3;
			
			EmbedBuilder embed = new EmbedBuilder();
			embed.setDescription("You rolled a " + Integer.toString(num) + "!");
			event.getChannel().sendMessage(embed.build()).queue();
		}
	}
	
	
}