package nbg.dev.tkdtheoryandpatterns;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.support.v4.app.NavUtils;

public class TheoryView extends Activity {

	private ListView listContent;
	private int value1;
	private Bundle extras;
	private String QUERY;

	@SuppressWarnings("deprecation")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_theory_view);

		listContent = (ListView) findViewById(R.id.theorylistview);
		extras = getIntent().getExtras();
		if (extras != null) {
			value1 = extras.getInt("Category");
		}
		
		QUERY = GetQueryString(value1);

		if (QUERY != null) {

			DataBaseHelper myDbHelper = new DataBaseHelper(this);
			SQLiteDatabase database = myDbHelper.openDataBaseHere();
			Cursor c = null;
			try {
				if (database != null) {
					c = database.rawQuery(QUERY, null);
					startManagingCursor(c);
				}
			} catch (Exception ex) {
				ex.getMessage();
			}

			// create an array to specify which fields we want to display
			String[] from = new String[] { "english", "korean" };
			// create an array of the display item we want to bind our data to
			int[] to = new int[] { R.id.text1, R.id.text2 };
			// create simple cursor adapter
			SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
					R.layout.row, c, from, to);
			// get reference to our listview
			listContent.setAdapter(adapter);
			database.close();
			myDbHelper.close();
		}

	}

	private String GetQueryString(int value) {

		String queryString = null;

		if (value == 0) {
			queryString = "select _id, english, korean FROM theory WHERE category = 'parts of the body'";
		}
		if (value == 1) {
			queryString = "SELECT _id, english, korean FROM theory WHERE belt = '10'";
		}
		if (value == 2) {
			queryString = "SELECT _id, english, korean FROM theory WHERE belt = '9'";
		}
		if (value == 3) {
			queryString = "SELECT _id, english, korean FROM theory WHERE belt = '8'";
		}
		if (value == 4) {
			queryString = "SELECT _id, english, korean FROM theory WHERE belt = '7'";
		}
		if (value == 5) {
			queryString = "SELECT _id, english, korean FROM theory WHERE belt = '6'";
		}
		if (value == 6) {
			queryString = "SELECT _id, english, korean FROM theory WHERE belt = '5'";
		}
		if (value == 7) {
			queryString = "SELECT _id, english, korean FROM theory WHERE belt = '4'";
		}
		if (value == 8) {
			queryString = "SELECT _id, english, korean FROM theory WHERE belt = '3'";
		}
		if (value == 9) {
			queryString = "SELECT _id, english, korean FROM theory WHERE belt = '2'";
		}
		if (value == 10) {
			queryString = "SELECT _id, english, korean FROM theory WHERE belt = '1'";
		}

		return queryString;

	}

}
