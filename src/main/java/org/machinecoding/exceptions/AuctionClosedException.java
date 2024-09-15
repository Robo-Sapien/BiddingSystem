package org.machinecoding.exceptions;

public class AuctionClosedException extends BidException {
    public AuctionClosedException() {
        super("Cannot place or update bid: Auction is closed");
    }
}
