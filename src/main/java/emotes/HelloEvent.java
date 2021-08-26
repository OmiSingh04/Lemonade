package emotes;

import dev.os.damon.gilbert.App;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class HelloEvent extends ListenerAdapter {

	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String message = event.getMessage().getContentRaw().toString().toUpperCase();

		if (message.startsWith(App.SERVER_PREFIX + "HELLO") || message.startsWith(App.SERVER_PREFIX + "HI")) {

			String name = event.getMember().getNickname();
			if (name == null) {
				name = event.getAuthor().getName();
			}
			if(event.getAuthor().getIdLong() == 622669512877015053L)
				name = "my Sandyy";
			event.getChannel().sendMessage("Hi " + name + "!").queue();
		}
	}

}