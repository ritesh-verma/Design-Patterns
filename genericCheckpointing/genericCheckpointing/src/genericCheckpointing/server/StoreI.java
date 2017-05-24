package genericCheckpointing.server;

import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;

public interface StoreI extends StoreRestoreI {
    public void writeObj(MyAllTypesFirst aRecord, String wireFormat, FileProcessor fileProcessor);
    public void writeObj(MyAllTypesSecond aRecord, String wireFormat, FileProcessor fileProcessor);
}