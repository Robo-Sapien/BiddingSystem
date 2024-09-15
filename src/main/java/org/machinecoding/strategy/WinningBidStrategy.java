package org.machinecoding.strategy;

import org.machinecoding.enums.StrategyType;
import org.machinecoding.domain.Buyer;

import java.util.Map;

public interface WinningBidStrategy {
    String getWinner(Map<Buyer, Integer> bids);
    StrategyType getStrategyType();
}
