package com.example.danhpham.group2.reward;

public class DiscountReward extends Reward implements IRewardable {
    public DiscountReward(){
        super("Discount");
    }

    @Override
    public void applyReward(){
        // TODO implement discount
        double discount = .25;
    }
}
