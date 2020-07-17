package nbg.dev.tkdtheoryandpatterns;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class History extends Activity {

	public TextView tvHistory;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_history);

		// Instantiate the TextView
		tvHistory = (TextView) findViewById(R.id.history_text_view);
		tvHistory.setText(Html.fromHtml(getString(R.string.history_text)));

	}
}
