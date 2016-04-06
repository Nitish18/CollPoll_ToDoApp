package nitish.todocollpoll.Backend;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class TaskDBHelper extends SQLiteOpenHelper {

	public TaskDBHelper(Context context) {
		super(context, TaskContract.DB_NAME, null, TaskContract.DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase sqlDB) {

	/*	String sqlQuery =
				String.format("CREATE TABLE %s (" +
						"_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
						"%s TEXT,  " + "%s TEXT)", TaskContract.TABLE,
								    TaskContract.Columns.TASK,TaskContract.Columns.DATE);*/



		// executing a sql query for creating a table and required coloumns in the database.
		String makeTable = "CREATE TABLE " + TaskContract.TABLE + "("
				+ TaskContract.Columns._ID + " TEXT," + TaskContract.Columns.TASK + " TEXT,"
				+ TaskContract.Columns.DATE + " TEXT" + ")";
		sqlDB.execSQL(makeTable);

	}

	@Override
	public void onUpgrade(SQLiteDatabase sqlDB, int i, int i2) {
		sqlDB.execSQL("DROP TABLE IF EXISTS "+TaskContract.TABLE);
		onCreate(sqlDB);
	}
}
