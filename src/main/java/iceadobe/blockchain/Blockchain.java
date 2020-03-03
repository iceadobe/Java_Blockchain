package iceadobe.blockchain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Blockchain {
    private List<Block> chain;

    public Blockchain() {
        chain = new ArrayList<>();
        chain.add(generateGenesis());
    }

    private Block generateGenesis() {
        Block genesis = new Block("0x200", new Date(), "<transactions>");
        genesis.setPreviousHash(null);
        genesis.computeHash();
        return genesis;
    }

    public void addBlock(Block block) {
        Block newBlock = block;
        newBlock.setPreviousHash(chain.get(chain.size() - 1).getHash());
        newBlock.computeHash();
        this.chain.add(newBlock);
    }

    public void displayChain() {
        for(int i=0; i<chain.size(); i++) {
            System.out.println("Block: " + i
                    + "\nVersion: " + chain.get(i).getVersion()
                    + "\nTimestamp: " + chain.get(i).getTimestamp()
                    + "\nPrevious Hash: " + chain.get(i).getPreviousHash()
                    + "\nHash: " + chain.get(i).getHash()
            );
            System.out.println();
        }
    }

    public Block getLatestBlock() {
        return this.chain.get(chain.size()-1);
    }

    public void isValid() {
        for(int i=chain.size()-1; i>0; i--) {
            if(   !(chain.get(i).getHash().equals(chain.get(i).computeHash()))   ) {
                System.out.println("Chain is not valid");
                return;
            }

            if(  !(chain.get(i).getPreviousHash().equals(chain.get(i-1).computeHash()))  ) {
                System.out.println("Chain is not valid");
                return;
            }
        }
        System.out.println("Chain is valid.");
    }
}


















