package org.machinecoding.service;

import org.machinecoding.enums.StrategyType;
import org.machinecoding.exceptions.BidException;
import org.machinecoding.factory.BiddingStrategyFactory;
import org.machinecoding.strategy.WinningBidStrategy;
import org.machinecoding.domain.Auction;
import org.machinecoding.domain.Buyer;
import org.machinecoding.domain.Seller;

import java.util.HashMap;
import java.util.Map;

public class FlipBidderService {
    Map<String, Buyer> buyers;
    Map<String, Seller> sellers;
    Map<String, Auction> auctions;

    public FlipBidderService() {
        this.buyers = new HashMap<>();
        this.sellers = new HashMap<>();
        this.auctions = new HashMap<>();
    }

    public void addBuyer(String name) {
        buyers.put(name, new Buyer(name));
    }

    public void addSeller(String name) {
        sellers.put(name, new Seller(name));
    }

    public void createAuction(String id, int lowestBidLimit, int highestBidLimit, int participationCost, String sellerName, StrategyType strategyType) {
        Seller seller = sellers.get(sellerName);
        if (seller != null) {
            WinningBidStrategy strategy = new BiddingStrategyFactory().getStrategy(strategyType);
            auctions.put(id, new Auction(id, lowestBidLimit, highestBidLimit, participationCost, seller, new HashMap<>(), false, strategy));
        }
    }

    public void createBid(String buyerName, String auctionId, int amount) {
        Buyer buyer = buyers.get(buyerName);
        Auction auction = auctions.get(auctionId);
        if (buyer != null && auction != null) {
            try {
                auction.placeBid(buyer, amount);
            } catch (BidException e) {
                System.out.println(String.format("Error for buyer %s: %s ", buyerName, e.getMessage()));
            }
        } else {
            System.out.println(String.format("This buyer: %s or auction: %s doesn't exist", buyerName, auctionId));
        }
    }

    public void updateBid(String buyerName, String auctionId, int amount) {
        Buyer buyer = buyers.get(buyerName);
        Auction auction = auctions.get(auctionId);
        if (buyer != null && auction != null) {
            try {
                auction.updateBid(buyer, amount);
            } catch (BidException e) {
                System.out.println(String.format("Error for buyer %s: %s ", buyerName, e.getMessage()));
            }
        }
    }

    public void withdrawBid(String buyerName, String auctionId) {
        Buyer buyer = buyers.get(buyerName);
        Auction auction = auctions.get(auctionId);
        if (buyer != null && auction != null) {
            auction.withdrawBid(buyer);
        }
    }

    public void closeAuction(String auctionId) {
        Auction auction = auctions.get(auctionId);
        if (auction != null) {
            auction.closeAuction();
            System.out.println(auction.determineWinner());
        }
    }

}
