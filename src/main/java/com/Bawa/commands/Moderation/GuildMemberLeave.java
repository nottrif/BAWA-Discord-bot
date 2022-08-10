package com.Bawa.commands.Moderation;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Random;

public class GuildMemberLeave extends ListenerAdapter {
    String[] messages = {
            "[member] left, the party's over.",
            "[member] left, sad to see you leave"
    };

    @Override
    public void onGuildMemberRemove(GuildMemberRemoveEvent event) {
        Random rand = new Random();
        int number = rand.nextInt(messages.length);

        EmbedBuilder join = new EmbedBuilder();
        join.setColor(0xf48342);
        join.setDescription(messages[number].replace("[member]", event.getMember().getAsMention()));

        event.getGuild().getDefaultChannel().sendMessageEmbeds(join.build()).queue();
    }
}

