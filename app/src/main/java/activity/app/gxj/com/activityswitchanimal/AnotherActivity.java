package activity.app.gxj.com.activityswitchanimal;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;



public class AnotherActivity extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.another);

		findViewById(R.id.btn_exit).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
}
