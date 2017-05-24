package studentRecordsBackup.bst;

import studentRecordsBackup.util.EvenFilterImpl;
import studentRecordsBackup.util.OddEvenFilterI;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MainNode extends Node implements SubjectI {

	private Set<BackupNode> ObserverList;

	/**
	 * Constructor
	 * @param BNumberIn = input number from file
     */
	MainNode(int BNumberIn) {
		BNumber = BNumberIn;
		left = right = null;
		isMax = false;
		ObserverList = new HashSet<>();
	}

	/**
	 * method to register observer and add to Set
	 * @param backupNodeIn = Node of backup tree to be registered
     */
	@Override
	public void registerObserver(BackupNode backupNodeIn, OddEvenFilterI filter) {
		if (filter instanceof EvenFilterImpl)
			backupNodeIn.setType(ObserverType.EVEN);
		else
			backupNodeIn.setType(ObserverType.ODD);
		ObserverList.add(backupNodeIn);
	}

	/**
	 * Method to notify all observers from Set
	 * @param updateValue = value from command line
	 * @param node
	 * @param isMax = true if node has maximum value
     */
	@Override
	public void notifyObservers(int updateValue, Node node, boolean isMax){

		for (Iterator<BackupNode> it = ObserverList.iterator(); it.hasNext(); ) {
			BackupNode backupNode = it.next();

			if (updateValue % 2 == 0) {
				if (backupNode.getType().equals(ObserverType.EVEN))
					backupNode.update(updateValue, isMax);
			}
			else
				if (backupNode.getType().equals((ObserverType.ODD)))
					backupNode.update(updateValue, isMax);
		}
	}
}
