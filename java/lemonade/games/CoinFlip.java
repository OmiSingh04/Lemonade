package lemonade.games;


import lemonade.runner.App;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CoinFlip extends ListenerAdapter{
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String message = event.getMessage().getContentRaw().toString().toUpperCase();
		
		if(message.startsWith(App.SERVER_PREFIX + "FLIP")) {
			EmbedBuilder embed = new EmbedBuilder();
			int n = Integer.parseInt(Character.toString(Double.toString(Math.random()).charAt(17)));
			if(n < 5)	embed.setDescription("Heads!");
			else	embed.setDescription("Tails!");
			event.getChannel().sendMessage(embed.build()).queue();
			
		}
	}

}