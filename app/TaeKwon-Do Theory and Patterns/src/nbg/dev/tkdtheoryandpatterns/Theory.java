package nbg.dev.tkdtheoryandpatterns;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.support.v4.app.NavUtils;

public class Theory extends Activity implements OnClickListener {

	private Button bBodyParts;
	private Button bWhiteBelt;
	private Button bYellowTag;
	private Button bYellowBelt;
	private Button bGreenTag;
	private Button bGreenBelt;
	private Button bBlueTag;
	private Button bBlueBelt;
	private Button bRedTag;
	private Button bRedBelt;
	private Button bBlackTag;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_theory);

		// Instantiate buttons, one for each grade
		bBodyParts = (Button) findViewById(R.id.bBodyParts);
		bBodyParts.setOnClickListener(this);
		bWhiteBelt = (Button) findViewById(R.id.bWhiteBelt);
		bWhiteBelt.setOnClickListener(this);
		bYellowTag = (Button) findViewById(R.id.bYellowTag);
		bYellowTag.setOnClickListener(this);
		bYellowBelt = (Button) findViewById(R.id.bYellowBelt);
		bYellowBelt.setOnClickListener(this);
		bGreenTag = (Button) findViewById(R.id.bGreenTag);
		bGreenTag.setOnClickListener(this);
		bGreenBelt = (Button) findViewById(R.id.bGreenBelt);
		bGreenBelt.setOnClickListener(this);
		bBlueTag = (Button) findViewById(R.id.bBlueTag);
		bBlueTag.setOnClickListener(this);
		bBlueBelt = (Button) findViewById(R.id.bBlueBelt);
		bBlueBelt.setOnClickListener(this);
		bRedTag = (Button) findViewById(R.id.bRedTag);
		bRedTag.setOnClickListener(this);
		bRedBelt = (Button) findViewById(R.id.bRedBelt);
		bRedBelt.setOnClickListener(this);
		bBlackTag = (Button) findViewById(R.id.bBlackTag);
		bBlackTag.setOnClickListener(this);

	}

	public void onClick(View v) {

		if (v == bBodyParts) {
			Intent myIntent = new Intent(this, TheoryView.class);
			myIntent.putExtra("Category", 0);
			startActivityForResult(myIntent, 0);
		}
		if (v == bWhiteBelt) {
			Intent myIntent = new Intent(this, TheoryView.class);
			myIntent.putExtra("Category", 1);
			startActivityForResult(myIntent, 0);
		}
		if (v == bYellowTag) {
			Intent myIntent = new Intent(this, TheoryView.class);
			myIntent.putExtra("Category", 2);
			startActivityForResult(myIntent, 0);
		}
		if (v == bYellowBelt) {
			Intent myIntent = new Intent(this, TheoryView.class);
			myIntent.putExtra("Category", 3);
			startActivityForResult(myIntent, 0);
		}
		if (v == bGreenTag) {
			Intent myIntent = new Intent(this, TheoryView.class);
			myIntent.putExtra("Category", 4);
			startActivityForResult(myIntent, 0);
		}
		if (v == bGreenBelt) {
			Intent myIntent = new Intent(this, TheoryView.class);
			myIntent.putExtra("Category", 5);
			startActivityForResult(myIntent, 0);
		}
		if (v == bBlueTag) {
			Intent myIntent = new Intent(this, TheoryView.class);
			myIntent.putExtra("Category", 6);
			startActivityForResult(myIntent, 0);
		}
		if (v == bBlueBelt) {
			Intent myIntent = new Intent(this, TheoryView.class);
			myIntent.putExtra("Category", 7);
			startActivityForResult(myIntent, 0);
		}
		if (v == bRedTag) {
			Intent myIntent = new Intent(this, TheoryView.class);
			myIntent.putExtra("Category", 8);
			startActivityForResult(myIntent, 0);
		}
		if (v == bRedBelt) {
			Intent myIntent = new Intent(this, TheoryView.class);
			myIntent.putExtra("Category", 9);
			startActivityForResult(myIntent, 0);
		}
		if (v == bBlackTag) {
			Intent myIntent = new Intent(this, TheoryView.class);
			myIntent.putExtra("Category", 10);
			startActivityForResult(myIntent, 0);
		}

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
