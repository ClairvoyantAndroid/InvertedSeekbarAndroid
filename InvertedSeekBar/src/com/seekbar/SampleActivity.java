package com.seekbar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.VerticalSeekBar;
import android.widget.VerticalSeekBar_Reverse;

import com.sample.R;

	/**  A sample Activity which Invokes Vertical And Inverted SeekBar Implementation   */

	public class SampleActivity extends Activity {
   
	 VerticalSeekBar verticalSeekBar=null;
	 VerticalSeekBar_Reverse verticalSeekBar_Reverse=null;
	 TextView vsProgress,vs_reverseProgress=null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        verticalSeekBar=(VerticalSeekBar)findViewById(R.id.vertical_Seekbar);
        verticalSeekBar_Reverse=(VerticalSeekBar_Reverse)findViewById(R.id.seekbar_reverse);
        vsProgress=(TextView)findViewById(R.id.vertical_sb_progresstext);
        vs_reverseProgress=(TextView)findViewById(R.id.reverse_sb_progresstext);
        
        /** Assign SeekBar Change Event Listener to Our Vertical SeekBar*/
        
        verticalSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				
				/** Assign the Progress Value to TextView */
				vsProgress.setText(progress+"");
				
			}
		});
        
        /** Assign SeekBar Change Event Listener to Our Inverted Vertical SeekBar*/
        
        verticalSeekBar_Reverse.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				
				/** Assign the Progress Value to TextView */
				vs_reverseProgress.setText(progress+"");
				
			}
		});
        
    }
}