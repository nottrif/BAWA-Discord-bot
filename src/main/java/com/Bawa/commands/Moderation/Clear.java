package com.Bawa.commands.Moderation;

import com.Bawa.BOT.Bot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Clear extends ListenerAdapter {
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        long time = 1;

        String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (args[0].equalsIgnoreCase(Bot.prefix + "clear")) {
            if (args.length < 2) // length starts counting from 1
            {
                EmbedBuilder use = new EmbedBuilder();
                use.setDescription("Please specify the number of messages you wish to delete.");
                use.setColor(0xff0000);
                event.getChannel().sendTyping().queue();
                event.getChannel().sendMessageEmbeds(use.build())
                        .queue(message ->
                        {
                            message.delete().queueAfter(10, TimeUnit.SECONDS);
                        });
            } else {

                try {
                    List<Message> todel = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
                    event.getTextChannel().deleteMessages(todel).queue();

                    EmbedBuilder success = new EmbedBuilder();
                    success.setDescription("Messages have been successfully deleted.");
                    success.setColor(0x00FF00);
                    event.getChannel().sendTyping().queue();
                    event.getChannel().sendMessageEmbeds(success.build())
                            .queue(message ->
                            {
                                message.delete().queueAfter(10, TimeUnit.SECONDS);
                            });

                } catch (IllegalArgumentException e) {
                    if (e.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval")) {
                        EmbedBuilder toomany = new EmbedBuilder();
                        toomany.setDescription("Maximum of 100 messages can be deleted at once.");
                        toomany.setColor(0xff0000);
                        event.getChannel().sendTyping().queue();
                        event.getChannel().sendMessageEmbeds(toomany.build())
                                .queue(message ->
                                {
                                    message.delete().queueAfter(10, TimeUnit.SECONDS);
                                });


                    } else {
                        EmbedBuilder tooold = new EmbedBuilder();
                        tooold.setDescription("Messages over 2 weeks old cannot be deleted.");
                        tooold.setColor(0xff0000);
                        event.getChannel().sendTyping().queue();
                        event.getChannel().sendMessageEmbeds(tooold.build())
                                .queue(message ->
                                {
                                    message.delete().queueAfter(10, TimeUnit.SECONDS);
                                });
                    }
                }
            }

        }
    }
}