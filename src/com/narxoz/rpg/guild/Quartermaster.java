package com.narxoz.rpg.guild;

public class Quartermaster extends GuildMember {
    public Quartermaster(String name, GuildMediator mediator) { super(name, mediator); }

    public void requestSupplies(String payload) {
        getMediator().dispatch("supplies", this, payload);
    }

    @Override
    public void receive(String topic, GuildMember from, String payload) {
        System.out.println("[QM " + getName() + "] Provisioning: " + payload);
    }
}