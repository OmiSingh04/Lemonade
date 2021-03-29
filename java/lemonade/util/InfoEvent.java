package lemonade.util;

import lemonade.runner.App;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class InfoEvent extends ListenerAdapter{

	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String message = event.getMessage().getContentRaw().toUpperCase();
		
		if(message.startsWith(App.SERVER_PREFIX + "INFO")) {
			EmbedBuilder info = new EmbedBuilder();
			info.setTitle("😎 This is Lemonade!");
			info.setDescription("I am Sandwich Kun's fantasy brought to life");
			info.addField("ClearMessages","",true);
			info.addField("","",true);
			info.addField("","",true);
			info.addField("","",true);
			info.addField("","",true);
			info.addField("","",true);
			info.addField("","",true);
			info.addField("","",true);
			
			info.setFooter("To " + event.getAuthor().getName(), event.getMember().getUser().getAvatarUrl());
			event.getChannel().sendMessage(info.build()).queue();
			
		}
		else if(message.startsWith(App.SERVER_PREFIX + "SPAM"))
		{
			String name = event.getAuthor().getName().toString();
			int n = Integer.parseInt(message.split(" ")[1]);
			while(--n>=0)
			event.getChannel().sendMessage(name).queue();
		}
		
	}
}
