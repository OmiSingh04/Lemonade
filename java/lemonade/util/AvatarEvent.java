package lemonade.util;

import lemonade.runner.App;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class AvatarEvent extends ListenerAdapter {

	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String message = event.getMessage().getContentRaw().toString().toUpperCase();

		if (message.startsWith(App.SERVER_PREFIX + "AVATAR")) {
			try {
				String avatar = event.getMessage().getMentionedMembers(event.getGuild()).get(0).getUser()
						.getAvatarUrl();
				event.getChannel().sendMessage(avatar).queue();
			} catch (IndexOutOfBoundsException e) {
				String avatar = event.getAuthor().getAvatarUrl();
				event.getChannel().sendMessage(avatar).queue();
			}
		}
	}
}
