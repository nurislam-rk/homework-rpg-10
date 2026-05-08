package com.narxoz.rpg;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.council.*;
import com.narxoz.rpg.guild.*;
import com.narxoz.rpg.quest.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Homework 10: Full Demo with Bonus Part ===");
        QuestLog log = new QuestLog();
        log.add(new Quest("Dragon", QuestPriority.URGENT, 5000, true));
        log.add(new Quest("Herbs", QuestPriority.LOW, 50, false));
        log.add(new Quest("Bandits", QuestPriority.HIGH, 1000, false));
        log.add(new Quest("Guard", QuestPriority.NORMAL, 500, true));
        log.add(new Quest("Treasure", QuestPriority.HIGH, 2500, false));

        GuildHall hall = new GuildHall();
        new Captain("Kairat", hall);
        new Scout("Arman", hall);
        new Healer("Sara", hall);
        new Quartermaster("Berik", hall);
        new Loremaster("Alibi", hall);

        CouncilEngine engine = new CouncilEngine();
        CouncilRunResult res = engine.runCouncil(List.of(new Hero("Batyr", 100, 10, 5)), log, hall);
        System.out.println(res);
    }
}