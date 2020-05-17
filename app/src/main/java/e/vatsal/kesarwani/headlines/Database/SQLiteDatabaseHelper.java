//package e.vatsal.kesarwani.headlines.Database;
//
//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//import androidx.annotation.Nullable;
//
//public class SQLiteDatabaseHelper extends SQLiteOpenHelper {
//
//    public static final String DB_FILE_NAME = "headlines.db";
//    public static final int DB_VERSION = 1;
//
//    public SQLiteDatabaseHelper(Context context) {
//        super(context, DB_FILE_NAME, null, DB_VERSION);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        db.execSQL(DatabaseItems.SQL_CREATE);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL(DatabaseItems.SQL_DELETE);
//        onCreate(db);
//    }
//}
