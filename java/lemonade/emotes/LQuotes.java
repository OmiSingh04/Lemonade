package lemonade.emotes;

import java.util.Random;

import lemonade.runner.App;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class LQuotes extends ListenerAdapter{
	String[] s = {"I- i think i love you, <@622669512877015053> Kun",
			"P-please marry me when you grow up :sob: <@622669512877015053> Kunnnnn",
			"Sa- <@622669512877015053> Kunnnnn ahhhh :heart_eyes:",
			"<@622669512877015053> Kun is my one and only true love uwu",
			"I love you <@622669512877015053> Kunnnnn uwu",
			"I- I'm more wet then you are <@622669512877015053> Kunnn"};

	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String message = event.getMessage().getContentRaw().toString().toUpperCase();
		if (message.startsWith(App.SERVER_PREFIX + "QUOTE")) {
			int random = new Random().nextInt(6);
			event.getChannel().sendMessage(s[random]).queue();
		}
	}
}
