package com.narxoz.rpg.guild;
import java.util.*;

public class GuildHall implements GuildMediator {
    private final Map<String, List<GuildMember>> topics = new HashMap<>();
    private int messageCount = 0;

    @Override
    public void register(GuildMember member) {
        if (member instanceof Captain) { subscribe("orders", member); subscribe("urgent", member); }
        if (member instanceof Scout) subscribe("scouting", member);
        if (member instanceof Healer) subscribe("healing", member);
        if (member instanceof Quartermaster) subscribe("supplies", member);
        if (member instanceof Loremaster) subscribe("history", member);
    }

    private void subscribe(String topic, GuildMember member) {
        topics.computeIfAbsent(topic, k -> new ArrayList<>()).add(member);
    }

    @Override
    public void dispatch(String topic, GuildMember from, String payload) {
        List<GuildMember> subs = topics.getOrDefault(topic, List.of());
        for (GuildMember sub : subs) {
            if (sub != from) {
                sub.receive(topic, from, payload);
                messageCount++;
            }
        }
    }

    public int getMessageCount() { return messageCount; }
}