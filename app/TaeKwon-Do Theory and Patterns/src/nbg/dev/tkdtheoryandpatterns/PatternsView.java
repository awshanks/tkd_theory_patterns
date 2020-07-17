package nbg.dev.tkdtheoryandpatterns;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.Html;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class PatternsView extends Activity {

	private ListView listContent;
	private int value1;
	private Bundle extras;
	private String QUERY;
	private ImageView patterndiagram;
	private TextView tvPatternText;

	private SimpleCursorAdapter adapter;
	private DataBaseHelper myDbHelper = null;
	private Cursor c = null;
	private SQLiteDatabase database;

	// private final static String TAG = "TestActivity";

	@SuppressWarnings("deprecation")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_patterns_view);

		patterndiagram = (ImageView) findViewById(R.id.patterndiagram);
		listContent = (ListView) findViewById(R.id.patternlistview);
		tvPatternText = (TextView) findViewById(R.id.patternmovement);

		extras = getIntent().getExtras();
		if (extras != null) {
			value1 = extras.getInt("Category");
		}

		SetPatternTextAndImage(value1);
		QUERY = GetQueryString(value1);

		if (QUERY != null) {

			myDbHelper = new DataBaseHelper(this);
			database = myDbHelper.openDataBaseHere();
			c = null;
			try {
				if (database != null) {
					c = database.rawQuery(QUERY, null);
					// startManagingCursor(c);
				}
			} catch (Exception ex) {
				ex.getMessage();
			}
			
			//patternmovesnumber
			// create an array to specify which fields we want to display
			String[] from = new String[] { "beltname", "patternmeaning",
					"videourl", "numberofmovements" };
			// create an array of the display item we want to bind our data to
			int[] to = new int[] { R.id.patternbeltname, R.id.patternmeaning,
					R.id.patternvideolink, R.id.patternmovesnumber};
			// create simple cursor adapter
			adapter = new SimpleCursorAdapter(this, R.layout.pattern_row, c,
					from, to);
			// get reference to our listview
			listContent.setAdapter(adapter);
			// startManagingCursor(c);
			// myDbHelper.close();

		}
	}

	private void SetPatternTextAndImage(int value) {
		switch (value) {
		case 0:
			break;
		case 1:
			tvPatternText.setText(Html
					.fromHtml(getString(R.string.yellowtag_text)));
			patterndiagram.setImageResource(R.drawable.chon_ji);
			break;
		case 2:
			tvPatternText.setText(Html
					.fromHtml(getString(R.string.yellowbelt_text)));
			patterndiagram.setImageResource(R.drawable.dan_gun);
			break;
		case 3:
			tvPatternText.setText(Html
					.fromHtml(getString(R.string.greentag_text)));
			patterndiagram.setImageResource(R.drawable.do_san);
			break;
		case 4:
			tvPatternText.setText(Html
					.fromHtml(getString(R.string.greenbelt_text)));
			patterndiagram.setImageResource(R.drawable.won_hyo);
			break;
		case 5:
			tvPatternText.setText(Html
					.fromHtml(getString(R.string.bluetag_text)));
			patterndiagram.setImageResource(R.drawable.yul_gok);
			break;
		case 6:
			tvPatternText.setText(Html
					.fromHtml(getString(R.string.bluebelt_text)));
			patterndiagram.setImageResource(R.drawable.joong_gun);
			break;
		case 7:
			tvPatternText.setText(Html
					.fromHtml(getString(R.string.redtag_text)));
			patterndiagram.setImageResource(R.drawable.toi_gye);
			break;
		case 8:
			tvPatternText.setText(Html
					.fromHtml(getString(R.string.redbelt_text)));
			patterndiagram.setImageResource(R.drawable.hwa_rang);
			break;
		case 9:
			tvPatternText.setText(Html
					.fromHtml(getString(R.string.blacktag_text)));
			patterndiagram.setImageResource(R.drawable.choong_moo);
			break;
		}

	}

	private String GetQueryString(int value) {

		String queryString = null;

		queryString = "SELECT _id, numberofmovements, beltname, videourl, patternmeaning FROM patterns where patternnumber = '"
				+ value + "'";

		return queryString;

	}

	@Override
	protected void onResume() {
		super.onResume();
		// Log.i(TAG, "On Resume .....");
		// do the query again every time on resume
		myDbHelper = new DataBaseHelper(this);
		SQLiteDatabase database = myDbHelper.openDataBaseHere();
		Cursor c = database.rawQuery(QUERY, null);
		// mAdapter is a SimpleCursorAdapter, set its cursor to the new one
		adapter.changeCursor(c);
	}

	@Override
	protected void onPause() {
		super.onPause();
		// Log.i(TAG, "On Pause .....");
		// adapter is a SimpleCursorAdapter, invalidate its data and set it
		// cursor to null on Activity pause
		adapter.notifyDataSetInvalidated();
		adapter.changeCursor(null);
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		// Log.i(TAG, "On Restart .....");
		// do the query again every time on resume
		myDbHelper = new DataBaseHelper(this);
		SQLiteDatabase database = myDbHelper.openDataBaseHere();
		Cursor c = database.rawQuery(QUERY, null);
		// mAdapter is a SimpleCursorAdapter, set its cursor to the new one
		adapter.changeCursor(c);

	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		myDbHelper.close();
		// Log.i(TAG, "On Destroy .....");
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		// Log.i(TAG, "On Start .....");
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		myDbHelper.close();
		// adapter is a SimpleCursorAdapter, invalidate its data and set it
		// cursor to null on Activity pause
		adapter.notifyDataSetInvalidated();
		adapter.changeCursor(null);
		// Log.i(TAG, "On Stop .....");

	}
}
