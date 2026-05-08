package com.narxoz.rpg.guild;

public class Scout extends GuildMember {
    public Scout(String name, GuildMediator mediator) { super(name, mediator); }

    public void reportRoute(String payload) {
        getMediator().dispatch("scouting", this, payload);
    }

    @Override
    public void receive(String topic, GuildMember from, String payload) {
        System.out.println("[Scout " + getName() + "] Info: " + payload);
    }
}