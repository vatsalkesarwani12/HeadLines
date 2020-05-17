/*
package e.vatsal.kesarwani.headlines.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import e.vatsal.kesarwani.headlines.Activity.DeepNews;
import e.vatsal.kesarwani.headlines.Model.DataItem;

public class DataSource {
    private Context mContext;
    private SQLiteDatabase mDatabase;
    SQLiteOpenHelper mDbHelper;

    public DataSource(Context context) {
        this.mContext = context;
        mDbHelper = new SQLiteDatabaseHelper(mContext);
        mDatabase = mDbHelper.getWritableDatabase();
    }

    public void open() {
        mDatabase = mDbHelper.getWritableDatabase();
    }

    public void close() {
        mDbHelper.close();
    }

    public void createItem() {
        ContentValues values = DeepNews.toValues();
        mDatabase.insert(DatabaseItems.TABLE_ITEMS, null, values);
    }


    public long getDataItemsCount() {
        return DatabaseUtils.queryNumEntries(mDatabase, DatabaseItems.TABLE_ITEMS);
    }

    public List<DataItem> getAllItems() {
        List<DataItem> dataItems = new ArrayList<>();

        Cursor cursor = mDatabase.query(DatabaseItems.TABLE_ITEMS, DatabaseItems.ALL_COLUMNS,
                null, null, null, null, null);

        while (cursor.moveToNext()) {
            DataItem item = new DataItem();
            item.setName(cursor.getString(
                    cursor.getColumnIndex(DatabaseItems.COLUMN_NAME)));
            item.setDescription(cursor.getString(
                    cursor.getColumnIndex(DatabaseItems.COLUMN_DESCRIPTION)));
            item.setTitle(cursor.getString(
                    cursor.getColumnIndex(DatabaseItems.COLUMN_TITLE)));
            item.setContent(cursor.getString(
                    cursor.getColumnIndex(DatabaseItems.COLUMN_CONTENT)));
            item.setUrl(cursor.getString(
                    cursor.getColumnIndex(DatabaseItems.COLUMN_URL)));
            item.setImageUrl(cursor.getString(
                    cursor.getColumnIndex(DatabaseItems.COLUMN_URL_TO_IMAGE)));
            item.setPublishedAt(cursor.getString(
                    cursor.getColumnIndex(DatabaseItems.COLUMN_PUBLISHED_AT)));
            dataItems.add(item);
        }

        return dataItems;
    }

}
*/
