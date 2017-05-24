package studentRecordsBackup.bst;

public class Node{
	protected int BNumber;
	protected boolean isMax;
	protected Node left;
	protected Node right;

	public enum ObserverType {
		EVEN,
		ODD
	}

	public int getBNumber() {
		return BNumber;
	}

	public void setBNumber(int BNumber) {
		this.BNumber = BNumber;
	}

	public boolean isMax() {
		return isMax;
	}

	public void setMax(boolean max) {
		isMax = max;
	}
}
