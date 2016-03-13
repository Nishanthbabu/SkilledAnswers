package com.skilledanswers.skilledanswers.Holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.skilledanswers.skilledanswers.R;


/**
 * Created by Nishanth on 3/9/2016.
 */
public class Case2ParImgTxt extends RecyclerView.ViewHolder {
    private ImageView imageViewCase2 = null;
    private TextView textViewHeadingCase2 = null;
    private TextView textviewTimestampCase2 = null;
    private ImageView imageviewSeenCase2 =  null;

    public Case2ParImgTxt(View itemView) {
        super(itemView);
        imageViewCase2 = (ImageView) itemView.findViewById(R.id.case2_par_imgtxt_imageviewID);
        textViewHeadingCase2 = (TextView) itemView.findViewById(R.id.case2_par_imgtxt_textviewID);
        textviewTimestampCase2 = (TextView) itemView.findViewById(R.id.case2_par_imgtxt__timestampID);
        imageviewSeenCase2 = (ImageView) itemView.findViewById(R.id.case2_par_imgtxt__seenImageID);
    }

    public TextView getTextviewTimestampCase2() {
        return textviewTimestampCase2;
    }

    public void setTextviewTimestampCase2(TextView textviewTimestampCase2) {
        this.textviewTimestampCase2 = textviewTimestampCase2;
    }

    public ImageView getImageviewSeenCase2() {
        return imageviewSeenCase2;
    }

    public void setImageviewSeenCase2(ImageView imageviewSeenCase2) {
        this.imageviewSeenCase2 = imageviewSeenCase2;
    }

    public ImageView getImageViewCase2() {
        return imageViewCase2;
    }

    public void setImageViewCase2(ImageView imageViewCase2) {
        this.imageViewCase2 = imageViewCase2;
    }

    public TextView getTextViewHeadingCase2() {
        return textViewHeadingCase2;
    }

    public void setTextViewHeadingCase2(TextView textViewHeadingCase2) {
        this.textViewHeadingCase2 = textViewHeadingCase2;
    }
}
