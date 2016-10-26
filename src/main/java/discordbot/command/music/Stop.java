package discordbot.command.music;

import discordbot.command.CommandVisibility;
import discordbot.core.AbstractCommand;
import discordbot.handler.MusicPlayerHandler;
import discordbot.handler.Template;
import discordbot.main.DiscordBot;
import net.dv8tion.jda.entities.Guild;
import net.dv8tion.jda.entities.MessageChannel;
import net.dv8tion.jda.entities.TextChannel;
import net.dv8tion.jda.entities.User;

/**
 * !stop
 * make the bot stop playing music
 */
public class Stop extends AbstractCommand {
	public Stop() {
		super();
	}

	@Override
	public String getDescription() {
		return "stops playing music";
	}

	@Override
	public String getCommand() {
		return "stop";
	}

	@Override
	public String[] getUsage() {
		return new String[]{};
	}

	@Override
	public CommandVisibility getVisibility() {
		return CommandVisibility.PUBLIC;
	}

	@Override
	public String[] getAliases() {
		return new String[0];
	}

	@Override
	public String execute(DiscordBot bot, String[] args, MessageChannel channel, User author) {
		Guild guild = ((TextChannel) channel).getGuild();
		MusicPlayerHandler.getFor(guild, bot).stopMusic();
		bot.leaveVoice(guild);
		return Template.get("command_stop_success");
	}
}