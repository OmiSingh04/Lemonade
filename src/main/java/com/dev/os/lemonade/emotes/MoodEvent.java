package com.dev.os.lemonade.emotes;
import java.awt.Color;

import com.dev.os.lemonade.runner.App;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;



public class MoodEvent extends ListenerAdapter{
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		try {
		String message = event.getMessage().getContentRaw().toString().toUpperCase();
		
		String memberName = event.getAuthor().getName();
		
		if(message.substring(0,8).equalsIgnoreCase(App.SERVER_PREFIX + "MOOD "))
		{
			EmbedBuilder embed = new EmbedBuilder();
			if(message.substring(8).startsWith("HAPPY"))
			{
				embed.setColor(Color.blue);
				embed.setTitle(memberName + " is Happy!");
				event.getChannel().sendMessage(embed.build()).queue();
				event.getChannel().sendMessage(" https://tenor.com/87Ak.gif ").queue();
			}
			else if(message.substring(8).startsWith("SAD"))
			{
				embed.setColor(Color.green);
				embed.setTitle(memberName + " is Sad!");
				event.getChannel().sendMessage(embed.build()).queue();
				event.getChannel().sendMessage("https://tenor.com/W7s2.gif ").queue();
			}
			else if(message.substring(8).startsWith("LAUGH"))
			{
				embed.setColor(Color.yellow);
				embed.setTitle(memberName + " is Laughing!");
				event.getChannel().sendMessage(embed.build()).queue();
				event.getChannel().sendMessage("https://tenor.com/09rQ.gif").queue();
			}
			else if(message.substring(8).startsWith("CRY"))
			{
				embed.setColor(Color.red);
				embed.setTitle(memberName + " is Crying!");
				event.getChannel().sendMessage(embed.build()).queue();
				event.getChannel().sendMessage("https://tenor.com/ZjFC.gif ").queue();
			}
			else if(message.substring(8).startsWith("BORED"))
			{
				embed.setColor(Color.CYAN);
				embed.setTitle(memberName + " is Bored!");
				event.getChannel().sendMessage(embed.build()).queue();
				event.getChannel().sendMessage("https://tenor.com/6oLN.gif ").queue();
			}
		}
		}
		catch(Exception e) {
			return;
		}
		
		
	}

}