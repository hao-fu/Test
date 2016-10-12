package edu.ucdavis.test;

import edu.ucdavis.test.FragmentTitle.OnTitleClickListener;

import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;

/**
 * Class: MainActivity
 * Description:
 * Authors: Hao Fu(haofu@ucdavis.edu)
 * Date: 10/12/2016 1:55 PM
 */
public class MainActivity extends Activity implements OnTitleClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


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
