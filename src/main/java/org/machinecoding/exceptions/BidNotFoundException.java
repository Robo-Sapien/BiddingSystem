package org.machinecoding.exceptions;

public class BidNotFoundException extends BidException {
    public BidNotFoundException() {
        super("Cannot update bid: No existing bid found for this buyer");
    }
}
