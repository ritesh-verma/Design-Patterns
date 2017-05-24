package studentRecordsBackup.bst;

import studentRecordsBackup.util.OddEvenFilterI;

public class BackupNode extends Node implements ObserverI {

	private MainNode mainNode;
	private ObserverType type;

	BackupNode(int BNumberIn) {
		BNumber = BNumberIn;
		left = right = null;
		isMax = false;
	}

	public void setType(ObserverType type) {
		this.type = type;
	}

	public ObserverType getType() {
		return type;
	}

	@Override
	public void update(int updateValue, boolean isMaxIn) {
		this.isMax = isMaxIn;
		if (this.isMax())
			BNumber += (2 * updateValue);
		else
			BNumber += updateValue;
	}

}
