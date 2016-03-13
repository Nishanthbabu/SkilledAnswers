package com.skilledanswers.skilledanswers.Holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.skilledanswers.skilledanswers.R;


/**
 * Created by Nishanth on 3/9/2016.
 */
public class Case3Lytext extends RecyclerView.ViewHolder {
    private TextView textViewHeadingCase3 = null;
    private TextView textViewshortDescCase3 = null;
    private TextView textviewTimestampCase3 = null;
    private ImageView imageviewSeenCase3 =  null;
    public Case3Lytext(View itemView) {
        super(itemView);
        textViewHeadingCase3 = (TextView) itemView.findViewById(R.id.case3_lytext_headingTextviewID);
        textViewshortDescCase3 = (TextView) itemView.findViewById(R.id.case3_lytext_shortdescriptionTextviewID);
        textviewTimestampCase3 = (TextView) itemView.findViewById(R.id.case3_lytext_timestampID);
        imageviewSeenCase3 = (ImageView) itemView.findViewById(R.id.case3_lytext_seenImageID);

    }

    public TextView getTextviewTimestampCase3() {
        return textviewTimestampCase3;
    }

    public void setTextviewTimestampCase3(TextView textviewTimestampCase3) {
        this.textviewTimestampCase3 = textviewTimestampCase3;
    }

    public ImageView getImageviewSeenCase3() {
        return imageviewSeenCase3;
    }

    public void setImageviewSeenCase3(ImageView imageviewSeenCase3) {
        this.imageviewSeenCase3 = imageviewSeenCase3;
    }

    public TextView getTextViewHeadingCase3() {
        return textViewHeadingCase3;
    }

    public void setTextViewHeadingCase3(TextView textViewHeadingCase3) {
        this.textViewHeadingCase3 = textViewHeadingCase3;
    }

    public TextView getTextViewshortDescCase3() {
        return textViewshortDescCase3;
    }

    public void setTextViewshortDescCase3(TextView textViewshortDescCase3) {
        this.textViewshortDescCase3 = textViewshortDescCase3;
    }
}
