package iceadobe.blockchain;

public class BlockchainApp {
	public static void main(String [] args) {
		Blockchain bitcoin = new Blockchain();

		Block a = new Block("0x200", new java.util.Date(), "<transactions>");
		Block b = new Block("0x200", new java.util.Date(), "<transactions>");
		Block c = new Block("0x200", new java.util.Date(), "<transactions>");

		bitcoin.addBlock(a);
		bitcoin.addBlock(b);
		bitcoin.addBlock(c);

		//tcpCoin.getLatestBlock().setPreviousHash("ABCDEFG");

		bitcoin.displayChain();

		bitcoin.isValid();
	}
}
