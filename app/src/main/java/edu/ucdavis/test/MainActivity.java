package edu.ucdavis.test;

import edu.ucdavis.test.FragmentTitle.OnTitleClickListener;

import android.app.FragmentManager;
import android.os.Bundle;
import android.app.Activity;

public class MainActivity extends Activity implements OnTitleClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		FragmentManager fm = getFragmentManager();

        fm.beginTransaction()
				.replace(R.id.titleList, new FragmentTitle(), FragmentTitle.TAG)
				.commit();
    }

	@Override
	public void onTitleClick(String content) {
		FragmentContent content2 = FragmentContent.getInstance(content);
		getFragmentManager().beginTransaction()
				.replace(R.id.mContent, content2).commit();
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
	}
}
