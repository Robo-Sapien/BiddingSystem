package org.machinecoding.domain;

public class Buyer extends User {
    int auctionCount;
    public Buyer(String name) {
        super(name);
        this.auctionCount = 0;
    }

    public boolean isPreferredBuyer() {
        return auctionCount > 2;
    }

    public void incrementAuctionCount() {
        auctionCount++;
    }
}
