package com.Bawa.commands.Moderation;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import static com.Bawa.BOT.Bot.prefix;


public class Ping extends ListenerAdapter
{
    public void onMessageReceived(@NotNull MessageReceivedEvent event) //To find ping of the bot.
    {
        if (event.getAuthor().isBot())
        {
            return;
        }
        Message msg = event.getMessage();
        String []args= msg.getContentRaw().split("\\s+");
        if (args[0].equalsIgnoreCase(prefix + "ping"))
        {
            long time = System.currentTimeMillis();
            MessageChannel channel = event.getChannel();
            channel.sendTyping().queue();
            channel.sendMessage("pong!")
                    .queue(response ->
                    {
                        response.editMessageFormat("ping %d ms", System.currentTimeMillis() - time).queue();
                    });

        }

    }
}

