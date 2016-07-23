package activity.app.gxj.com.activityswitchanimal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class OtherActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.other);

		findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				startActivity(new Intent(OtherActivity.this, AnotherActivity.class));
			}
		});

		findViewById(R.id.btn_exit).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
}
