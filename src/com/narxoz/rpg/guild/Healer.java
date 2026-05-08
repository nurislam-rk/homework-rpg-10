package com.narxoz.rpg.guild;

public class Healer extends GuildMember {
    public Healer(String name, GuildMediator mediator) { super(name, mediator); }

    public void prepareAid(String payload) {
        getMediator().dispatch("healing", this, payload);
    }

    @Override
    public void receive(String topic, GuildMember from, String payload) {
        System.out.println("[Healer " + getName() + "] Preparing: " + payload);
    }
}