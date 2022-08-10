package com.Bawa.commands.Moderation;

import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class GuildMemberJoin extends ListenerAdapter {
    public GuildMemberJoin() {
        super();
    }

    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {
        event.getGuild().addRoleToMember(event.getMember().getUser() , event.getGuild().getRolesByName("Member", true).get(0)).queue();
    }
}

