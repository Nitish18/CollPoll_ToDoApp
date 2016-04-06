package nitish.todocollpoll;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import nitish.todocollpoll.Backend.TaskContract;
import nitish.todocollpoll.Backend.TaskDBHelper;

/**
 * Created by nitish on 4/6/2016.
 */
public class Searchresult extends Activity {

    TextView TV1;
    ListView LV;
    private TaskDBHelper helper2;
    private ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchresult);
        TV1 = (TextView) findViewById(R.id.hi);
        LV = (ListView) findViewById(R.id.search_list);
        Bundle extras = getIntent().getExtras();
        String value = extras.getString("KEY_DATE");

        Toast.makeText(Searchresult.this,value, Toast.LENGTH_LONG).show();


        helper2 = new TaskDBHelper(Searchresult.this);
        SQLiteDatabase sqlDB = helper2.getReadableDatabase();

        //quering the sqllite database , checking if the item matches with the required entered date by the user.
        //Iterating the Cursor object till the end.
      Cursor cursor = sqlDB.query(TaskContract.TABLE,new String[]{TaskContract.Columns._ID,TaskContract.Columns.TASK, TaskContract.Columns.DATE},TaskContract.Columns.DATE+" = '"+value+"'", null, null, null, null);


        //Filling the listview with the data from the Cursor object.
        listAdapter = new SimpleCursorAdapter(
                this,
                R.layout.single_item2,
                cursor,
                new String[]{TaskContract.Columns.TASK},
                new int[]{R.id.Sitem},
                0
        );

        LV.setAdapter(listAdapter);




    }
}
