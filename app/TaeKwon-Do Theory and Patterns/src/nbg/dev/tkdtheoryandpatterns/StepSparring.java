package nbg.dev.tkdtheoryandpatterns;

import android.os.Bundle;
import android.app.Activity;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.text.Html;

public class StepSparring extends Activity {

	public TextView tvStepSparring;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_step_sparring);

		// Instantiate the TextView
		tvStepSparring = (TextView) findViewById(R.id.stepsparring_text_view);
		tvStepSparring.setText(Html
				.fromHtml(getString(R.string.stepsparring_text)));
	}

}
