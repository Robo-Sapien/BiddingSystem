package org.machinecoding.exceptions;

public class InvalidBidAmountException extends BidException {
    public InvalidBidAmountException(int amount, int lowestBidLimit, int highestBidLimit) {
        super(String.format("Bid amount %d is not in allowed range: %d - %d", amount, lowestBidLimit, highestBidLimit));
    }
}
