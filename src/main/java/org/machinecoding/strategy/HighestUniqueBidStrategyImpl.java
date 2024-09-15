package org.machinecoding.strategy;

import org.machinecoding.enums.StrategyType;
import org.machinecoding.domain.Buyer;

import java.util.Map;
import java.util.stream.Collectors;

public class HighestUniqueBidStrategyImpl implements WinningBidStrategy {
    @Override
    public String getWinner(Map<Buyer, Integer> bids) {
        return bids.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue)).entrySet().stream()
                    .filter(entry -> entry.getValue().size() == 1)
                    .max(Map.Entry.comparingByKey())
                    .map(entry -> String.format("Winner: %s with bid: %s", entry.getValue().getFirst().getKey(), entry.getKey()))
                    .orElse("No winner");
    }

    @Override
    public StrategyType getStrategyType() {
        return StrategyType.HIGHEST_UNIQUE;
    }
}
