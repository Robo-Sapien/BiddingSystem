package org.machinecoding.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.machinecoding.exceptions.AuctionClosedException;
import org.machinecoding.exceptions.BidException;
import org.machinecoding.exceptions.BidNotFoundException;
import org.machinecoding.exceptions.InvalidBidAmountException;
import org.machinecoding.strategy.WinningBidStrategy;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Auction {
    String id;
    int lowestBidLimit;
    int highestBidLimit;
    int participationCost;
    Seller seller;
    Map<Buyer, Integer> bids;
    boolean isClosed;
    WinningBidStrategy strategy;

    public void placeBid(Buyer buyer, int amount) throws BidException {
        if (isClosed) {
            throw new AuctionClosedException();
        }
        if (amount < lowestBidLimit || amount > highestBidLimit) {
            throw new InvalidBidAmountException(amount, lowestBidLimit, highestBidLimit);
        }
        buyer.incrementAuctionCount();
        bids.put(buyer, amount);
    }

    public void updateBid(Buyer buyer, int amount) throws BidException {
        if (isClosed) {
            throw new AuctionClosedException();
        }
        if (!bids.containsKey(buyer)) {
            throw new BidNotFoundException();
        }
        if (amount < lowestBidLimit || amount > highestBidLimit) {
            throw new InvalidBidAmountException(amount, lowestBidLimit, highestBidLimit);
        }
        bids.put(buyer, amount);
    }

    public void withdrawBid(Buyer buyer) {
        if (!isClosed) {
            bids.remove(buyer);
        }
    }

    public void closeAuction() {
        isClosed = true;
    }

    public String determineWinner() {
        if (!isClosed || bids.isEmpty()) {
            return "No winner";
        }

        return strategy.getWinner(bids);
    }
}
