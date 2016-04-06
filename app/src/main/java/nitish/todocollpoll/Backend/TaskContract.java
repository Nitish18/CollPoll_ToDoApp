package nitish.todocollpoll.Backend;

import android.provider.BaseColumns;

public class TaskContract {
	public static final String DB_NAME = "com.example.TodoList.db.tasks";
	public static final int DB_VERSION = 2;
	public static final String TABLE = "tasks";


// Declaring the No. of coloumns in the Sqllite database.
	public class Columns {
		public static final String TASK = "task";  //coloumn for storing task
		public static final String DATE = "date";  //coloumn for storing date , when the task is created.
		public static final String _ID = BaseColumns._ID;  // Id of each task.

	}
}
