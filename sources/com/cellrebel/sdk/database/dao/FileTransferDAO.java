package com.cellrebel.sdk.database.dao;

import com.cellrebel.sdk.database.FileTransferServer;
import java.util.List;

public interface FileTransferDAO {
    void a(FileTransferServer fileTransferServer);

    List<FileTransferServer> getAll();
}
