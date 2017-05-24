package studentRecordsBackup.bst;

import studentRecordsBackup.util.OddEvenFilterI;

public interface SubjectI {
	void registerObserver(BackupNode backupNodeIn, OddEvenFilterI filter);
	void notifyObservers(int updateValue, Node node, boolean isMax);
}
