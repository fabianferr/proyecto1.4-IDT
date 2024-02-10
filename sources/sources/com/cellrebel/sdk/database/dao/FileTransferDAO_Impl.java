package com.cellrebel.sdk.database.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.cellrebel.sdk.database.FileTransferServer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class FileTransferDAO_Impl implements FileTransferDAO {
    private final RoomDatabase a;
    private final EntityInsertionAdapter<FileTransferServer> b;
    private final SharedSQLiteStatement c;

    class a extends EntityInsertionAdapter<FileTransferServer> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, FileTransferServer fileTransferServer) {
            supportSQLiteStatement.bindLong(1, fileTransferServer.a);
            String str = fileTransferServer.b;
            if (str == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, str);
            }
        }

        public String createQuery() {
            return "INSERT OR REPLACE INTO `FileTransferServer` (`id`,`url`) VALUES (nullif(?, 0),?)";
        }
    }

    class b extends SharedSQLiteStatement {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String createQuery() {
            return "DELETE FROM filetransferserver";
        }
    }

    public FileTransferDAO_Impl(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
    }

    public static List<Class<?>> a() {
        return Collections.emptyList();
    }

    public void a(FileTransferServer fileTransferServer) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert(fileTransferServer);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    public List<FileTransferServer> getAll() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * from filetransferserver", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "url");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                FileTransferServer fileTransferServer = new FileTransferServer();
                fileTransferServer.a = query.getLong(columnIndexOrThrow);
                if (query.isNull(columnIndexOrThrow2)) {
                    fileTransferServer.b = null;
                } else {
                    fileTransferServer.b = query.getString(columnIndexOrThrow2);
                }
                arrayList.add(fileTransferServer);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
