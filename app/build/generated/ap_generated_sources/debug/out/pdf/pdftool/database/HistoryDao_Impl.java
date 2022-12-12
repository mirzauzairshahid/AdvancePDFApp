package pdf.pdftool.database;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public final class HistoryDao_Impl implements HistoryDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfHistory;

  private final SharedSQLiteStatement __preparedStmtOfDeleteHistory;

  public HistoryDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfHistory = new EntityInsertionAdapter<History>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `History`(`mId`,`file_path`,`date`,`operation_type`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, History value) {
        stmt.bindLong(1, value.getId());
        if (value.getFilePath() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getFilePath());
        }
        if (value.getDate() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDate());
        }
        if (value.getOperationType() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getOperationType());
        }
      }
    };
    this.__preparedStmtOfDeleteHistory = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Delete from History";
        return _query;
      }
    };
  }

  @Override
  public void insertAll(History... histories) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfHistory.insert(histories);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteHistory() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteHistory.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteHistory.release(_stmt);
    }
  }

  @Override
  public List<History> getAllHistory() {
    final String _sql = "SELECT * FROM History order by mId desc";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfMId = _cursor.getColumnIndexOrThrow("mId");
      final int _cursorIndexOfMFilePath = _cursor.getColumnIndexOrThrow("file_path");
      final int _cursorIndexOfMDate = _cursor.getColumnIndexOrThrow("date");
      final int _cursorIndexOfMOperationType = _cursor.getColumnIndexOrThrow("operation_type");
      final List<History> _result = new ArrayList<History>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final History _item;
        final String _tmpMFilePath;
        _tmpMFilePath = _cursor.getString(_cursorIndexOfMFilePath);
        final String _tmpMDate;
        _tmpMDate = _cursor.getString(_cursorIndexOfMDate);
        final String _tmpMOperationType;
        _tmpMOperationType = _cursor.getString(_cursorIndexOfMOperationType);
        _item = new History(_tmpMFilePath,_tmpMDate,_tmpMOperationType);
        final int _tmpMId;
        _tmpMId = _cursor.getInt(_cursorIndexOfMId);
        _item.setId(_tmpMId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<History> getHistoryByOperationType(String[] types) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("select * from history where operation_type IN(");
    final int _inputSize = types.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") order by mId desc");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (String _item : types) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindString(_argIndex, _item);
      }
      _argIndex ++;
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfMId = _cursor.getColumnIndexOrThrow("mId");
      final int _cursorIndexOfMFilePath = _cursor.getColumnIndexOrThrow("file_path");
      final int _cursorIndexOfMDate = _cursor.getColumnIndexOrThrow("date");
      final int _cursorIndexOfMOperationType = _cursor.getColumnIndexOrThrow("operation_type");
      final List<History> _result = new ArrayList<History>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final History _item_1;
        final String _tmpMFilePath;
        _tmpMFilePath = _cursor.getString(_cursorIndexOfMFilePath);
        final String _tmpMDate;
        _tmpMDate = _cursor.getString(_cursorIndexOfMDate);
        final String _tmpMOperationType;
        _tmpMOperationType = _cursor.getString(_cursorIndexOfMOperationType);
        _item_1 = new History(_tmpMFilePath,_tmpMDate,_tmpMOperationType);
        final int _tmpMId;
        _tmpMId = _cursor.getInt(_cursorIndexOfMId);
        _item_1.setId(_tmpMId);
        _result.add(_item_1);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
