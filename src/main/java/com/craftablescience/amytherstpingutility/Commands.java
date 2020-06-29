package com.craftablescience.amytherstpingutility;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.SubscribeEvent;

public class Commands {

    private final ConfigReader configReader;

    public Commands() {
        this.configReader = new ConfigReader();
    }

    @SubscribeEvent
    public void onMessage(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        String msg = event.getMessage().getContentDisplay();
        if (msg.startsWith(this.configReader.getPrefix())) {
            String output = this.runCommand(msg);
            MessageChannel channel = event.getChannel();
            if (output != null) {
                channel.sendMessage(output).queue();
            } else {
                channel.sendMessage(String.format("Unrecognizable command. Type \"%s%s\" to get help.", this.configReader.getPrefix(), this.configReader.getHelpCommand())).queue();
            }
        }
    }

    private String runCommand(String msg) {
        if (msg.length() > this.configReader.getPrefix().length()) {
            if (msg.startsWith(this.configReader.getPingCommand(), this.configReader.getPrefix().length())) {
                return this.getPingOutput();
            } else if (msg.startsWith(this.configReader.getHelpCommand(), this.configReader.getPrefix().length())) {
                return this.getHelpOutput();
            }
        }
        return null;
    }

    private String getPingOutput() {
        return "PONG";
    }
    private String getHelpOutput() {
        return "Help is for the weak";
    }
}