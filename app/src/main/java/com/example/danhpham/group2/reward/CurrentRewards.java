package com.example.danhpham.group2.reward;

import java.util.ArrayList;

public class CurrentRewards {
    private int maxRewards = 3;
    private ArrayList<Reward> rewardList = null;

    public boolean isAvailableReward() {
        if (rewardList.size() != 3)
            return true;
        return false;
    }

    public boolean isNoAwards() {
        if (rewardList.isEmpty())
            return true;
        return false;
    }

    public void addReward(Reward reward) {
        if (this.isAvailableReward()) {
            rewardList.add(reward);
        }
    }

    public void removeReward(Reward reward) {
        if (!this.isNoAwards()) {
            rewardList.remove(reward);
        }
    }
}
