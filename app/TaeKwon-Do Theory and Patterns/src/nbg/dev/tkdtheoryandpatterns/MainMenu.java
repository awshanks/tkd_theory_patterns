package nbg.dev.tkdtheoryandpatterns;

import java.io.IOException;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;

public class MainMenu extends Activity implements OnClickListener {

	// buttons
	private Button bHistory;
	private Button bTheory;
	private Button bStepSparring;
	private Button bPatterns;
	private Button bQuiz;
	private Button bFlashCards;

	@SuppressWarnings("deprecation")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFormat(PixelFormat.RGBA_8888);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_DITHER);
		setContentView(R.layout.activity_main_menu);

		// Open Shared Preferences and set first open to 0
		// SharedPreferences prefs = getSharedPreferences("MyPreferences",
		// Context.MODE_PRIVATE);
		// boolean haveWeShownPreferences = prefs.getBoolean("FirstRun", false);
		// if (!haveWeShownPreferences) {
		// prefs = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
		// SharedPreferences.Editor ed = prefs.edit();
		// ed.putBoolean("FirstRun", true);
		// ed.commit();
		// }

		// Instantiate the buttons
		bHistory = (Button) findViewById(R.id.bHistory);
		bHistory.setOnClickListener(this);
		bTheory = (Button) findViewById(R.id.bTheory);
		bTheory.setOnClickListener(this);
		bStepSparring = (Button) findViewById(R.id.bStepSparring);
		bStepSparring.setOnClickListener(this);
		bPatterns = (Button) findViewById(R.id.bPatterns);
		bPatterns.setOnClickListener(this);
		//bQuiz = (Button) findViewById(R.id.bQuiz);
		//bQuiz.setOnClickListener(this);
		//bFlashCards = (Button) findViewById(R.id.bFlashCards);
		//bFlashCards.setOnClickListener(this);

		DataBaseHelper myDbHelper = new DataBaseHelper(this);

		try {
			myDbHelper.createDataBase();
			//Toast.makeText(getApplicationContext(),
			//		"database successfully copied", Toast.LENGTH_SHORT).show();

		} catch (IOException ioe) {
			throw new Error("Unable to create database");
		}

		try {

			myDbHelper.openDataBase();
			myDbHelper.close();
			//Toast.makeText(getApplicationContext(),
			//		"database successfully opened", Toast.LENGTH_SHORT).show();

		} catch (SQLException sqle) {
			throw sqle;
		}

		// populate buttons with text for the features found in the database
		SQLiteDatabase database = myDbHelper.openDataBaseHere();

		String QUERY = "SELECT _id, english FROM theory";
		Cursor c = null;

		try {

			if (database != null) {
				c = database.rawQuery(QUERY, null);
				startManagingCursor(c);
			}

		} catch (Exception ex) {
			ex.getMessage();
		}

	}
	
	//TODO : Complete other function of the application

	public void onClick(View v) {

		if (v == bHistory) {
			Intent myIntent = new Intent(this, History.class);
			startActivityForResult(myIntent, 0);
		}
		if (v == bTheory) {
			Intent myIntent = new Intent(this, Theory.class);
			startActivityForResult(myIntent, 0);
		}
		if (v == bStepSparring) {
			Intent myIntent = new Intent(this, StepSparring.class);
			startActivityForResult(myIntent, 0);
		}
		if (v == bPatterns) {
			Intent myIntent = new Intent(this, Patterns.class);
			startActivityForResult(myIntent, 0);
		}
		if (v == bQuiz) {
			//Intent myIntent = new Intent(this, Quiz.class);
			//startActivityForResult(myIntent, 0);
		}
		if (v == bFlashCards) {
			//Intent myIntent = new Intent(this, FlashCards.class);
			//startActivityForResult(myIntent, 0);
		}

	}

}
