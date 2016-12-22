package edu.ucdavis.test;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

@SuppressLint("NewApi")
public class FragmentContent extends Fragment {
	private String strContent;

	public static FragmentContent getInstance(String strContent) {
		FragmentContent content = new FragmentContent();
		content.strContent = strContent;
		return content;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		ScrollView scrollView = new ScrollView(getActivity());
		TextView mTextView = new TextView(getActivity());
		mTextView.setPadding(5, 5, 5, 5);
		mTextView.setTextSize(15);
		mTextView.setText(strContent);
		scrollView.addView(mTextView);
		scrollView.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));

		return scrollView;
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

}
