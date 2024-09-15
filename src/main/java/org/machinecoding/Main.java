package org.machinecoding;

import org.machinecoding.enums.StrategyType;
import org.machinecoding.service.FlipBidderService;

public class Main<T> {

    public static void main(String[] args) {
        FlipBidderService service = new FlipBidderService();

        System.out.println("Test Case 1");

        service.addBuyer("buyer1");
        service.addBuyer("buyer2");
        service.addBuyer("buyer3");
        service.addSeller("seller1");
        service.createAuction("A1", 10, 50, 1, "seller1", StrategyType.HIGHEST_UNIQUE);
        service.createBid("buyer1", "A1", 17);
        service.createBid("buyer2", "A1", 15);
        service.updateBid("buyer2", "A1", 19);
        service.createBid("buyer3", "A1", 19);
        service.closeAuction("A1");

        System.out.println("\nTest Case 2");

        service.addSeller("seller2");
        service.createAuction("A2", 5, 20, 2, "seller2", StrategyType.HIGHEST_UNIQUE);
        service.createBid("buyer3", "A2", 25);
        service.createBid("buyer2", "A2", 5);
        service.withdrawBid("buyer2", "A2");
        service.closeAuction("A2");

        System.out.println("\nTest Case 3");

        service.addBuyer("buyer4");
        service.addBuyer("buyer5");
        service.createAuction("A3", 5, 20, 2, "seller2", StrategyType.LOWEST_UNIQUE);
        service.createBid("buyer1", "A3", 10);
        service.createBid("buyer2", "A3", 5);
        service.createBid("buyer3", "A3", 10);
        service.createBid("buyer4", "A3", 13);
        service.createBid("buyer5", "A3", 15);
        service.withdrawBid("buyer2", "A3");
        service.closeAuction("A3");


        System.out.println("\nTest Case 4");

        service.createAuction("A4", 5, 20, 2, "seller2", StrategyType.LOWEST_UNIQUE);
        service.createBid("buyer1", "A4", 10);
        service.createBid("buyer2", "A4", 5);
        service.createBid("buyer3", "A4", 10);
        service.createBid("buyer4", "A4", 14);
        service.createBid("buyer5", "A4", 15);
        service.createBid("buyer6", "A4", 17);
        service.withdrawBid("buyer2", "A4");
        service.closeAuction("A4");

        System.out.println("\nTest Case 5");

        service.createAuction("A5", 5, 20, 2, "seller2", StrategyType.LOWEST_UNIQUE);
        service.createBid("buyer1", "A5", 10);
        service.createBid("buyer2", "A5", 5);
        service.createBid("buyer3", "A5", 10);
        service.createBid("buyer4", "A5", 14);
        service.createBid("buyer5", "A5", 15);
        service.withdrawBid("buyer2", "A5");
        service.closeAuction("A5");
        service.updateBid("buyer5", "A5", 19);
    }
}



