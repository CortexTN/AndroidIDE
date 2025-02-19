/************************************************************************************
 * This file is part of AndroidIDE.
 *
 *  
 *
 * AndroidIDE is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * AndroidIDE is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with AndroidIDE.  If not, see <https://www.gnu.org/licenses/>.
 *
**************************************************************************************/


package com.itsaky.androidide.fragments.sheets;

import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.blankj.utilcode.util.ThrowableUtils;
import com.itsaky.androidide.R;
import com.itsaky.androidide.models.LogLine;
import android.annotation.SuppressLint;

public class LogSheet extends BaseBottomSheetFragment {
	
	private ScrollView verticalScroll;
	private LinearLayout mContainer;
	
	@Override
	protected void bind(LinearLayout container) {
		mContainer = new LinearLayout(getContext());
		mContainer.setOrientation(LinearLayout.VERTICAL);
		
		verticalScroll = new ScrollView(getContext());
		verticalScroll.setFillViewport(true);
		
		HorizontalScrollView scroll = new HorizontalScrollView(getContext());
		scroll.setFillViewport(true);
		
		container.removeAllViews();
		verticalScroll.removeAllViews();
		mContainer.removeAllViews();
		scroll.removeAllViews();
		
		container.addView(verticalScroll);
		verticalScroll.addView(scroll, new ScrollView.LayoutParams(-1, -1));
		scroll.addView(mContainer, new HorizontalScrollView.LayoutParams(-1, -1));
	}
	
	@Override
	protected String getTitle() {
		return getString(R.string.logs);
	}
	
	public void addLine(LogLine line) {
		if(line != null) {
			try {
				mContainer.addView(createLogTextView(line), new ViewGroup.LayoutParams(-1, -2));
				verticalScroll.scrollTo(0, mContainer.getChildAt(mContainer.getChildCount() - 1).getBottom());
			} catch (Throwable th) {}
		}
	}
	
    @SuppressLint("SetTextI18n")
	protected TextView createLogTextView(LogLine line) {
		TextView text = new TextView(getContext());
		text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
		text.setTextColor(line.getColor(getContext()));
		text.setText(line + "");
		text.setSingleLine(true);
		text.setMaxLines(1);
		text.setTypeface(Typeface.MONOSPACE);
		return text;
	}
}
