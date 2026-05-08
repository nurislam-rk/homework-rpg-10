package com.narxoz.rpg.quest;
import java.util.*;

public class QuestLog {
    private final List<Quest> quests = new ArrayList<>();

    public void add(Quest quest) {
        if (quest != null) quests.add(quest);
    }

    public QuestIterator ordered() { return new OrderedQuestIterator(this); }
    public QuestIterator reverse() { return new ReverseQuestIterator(this); }
    public QuestIterator priorityAtLeast(QuestPriority threshold) { return new PriorityQuestIterator(this, threshold); }
    public QuestIterator rewardSorted() { return new RewardSortedQuestIterator(this); }

    List<Quest> snapshot() {
        return Collections.unmodifiableList(new ArrayList<>(quests));
    }
}