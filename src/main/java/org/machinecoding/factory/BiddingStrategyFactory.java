package org.machinecoding.factory;

import org.machinecoding.enums.StrategyType;
import org.machinecoding.strategy.HighestUniqueBidStrategyImpl;
import org.machinecoding.strategy.LowestUniqueBidStrategyImpl;
import org.machinecoding.strategy.WinningBidStrategy;

import java.util.HashMap;
import java.util.Map;

public class BiddingStrategyFactory {

    private final Map<StrategyType, WinningBidStrategy> strategyMap;

    public BiddingStrategyFactory() {
        strategyMap = new HashMap<>();

        WinningBidStrategy highestUniqueBiddingStrategy = new HighestUniqueBidStrategyImpl();
        WinningBidStrategy lowestUniqueBiddingStrategy = new LowestUniqueBidStrategyImpl();

        strategyMap.put(highestUniqueBiddingStrategy.getStrategyType(), highestUniqueBiddingStrategy);
        strategyMap.put(lowestUniqueBiddingStrategy.getStrategyType(), lowestUniqueBiddingStrategy);
    }

    public WinningBidStrategy getStrategy(StrategyType strategyType) {
        return strategyMap.get(strategyType);
    }

}
