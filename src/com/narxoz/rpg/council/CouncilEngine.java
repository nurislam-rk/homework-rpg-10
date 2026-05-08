package com.narxoz.rpg.council;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.guild.*;
import com.narxoz.rpg.quest.*;
import java.util.List;

public class CouncilEngine {
    public CouncilRunResult runCouncil(List<Hero> party, QuestLog questLog, GuildHall hall) {
        int qCount = 0;
        QuestIterator it = questLog.rewardSorted();
        while (it.hasNext()) {
            Quest q = it.next();
            hall.dispatch("orders", null, "Plan: " + q.getTitle());
            qCount++;
        }
        return new CouncilRunResult(qCount, hall.getMessageCount(), 5);
    }
}