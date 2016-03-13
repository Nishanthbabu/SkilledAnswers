package com.skilledanswers.skilledanswers.Holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.skilledanswers.skilledanswers.R;


/**
 * Created by Nishanth on 3/9/2016.
 */
public class Case1TextonImg extends RecyclerView.ViewHolder {
    private ImageView imageViewCase1 = null;
    private TextView textViewHeadingCase1 = null;
    private TextView textviewTimestampCase1 = null;
    private ImageView imageviewSeenCase1 =  null;

    public ImageView getImageViewCase1() {
        return imageViewCase1;
    }

    public void setImageViewCase1(ImageView imageViewCase1) {
        this.imageViewCase1 = imageViewCase1;
    }

    public TextView getTextViewHeadingCase1() {
        return textViewHeadingCase1;
    }

    public void setTextViewHeadingCase1(TextView textViewHeadingCase1) {
        this.textViewHeadingCase1 = textViewHeadingCase1;
    }

    public TextView getTextviewTimestampCase1() {
        return textviewTimestampCase1;
    }

    public void setTextviewTimestampCase1(TextView textviewTimestampCase1) {
        this.textviewTimestampCase1 = textviewTimestampCase1;
    }

    public ImageView getImageviewSeenCase1() {
        return imageviewSeenCase1;
    }

    public void setImageviewSeenCase1(ImageView imageviewSeenCase1) {
        this.imageviewSeenCase1 = imageviewSeenCase1;
    }

    public Case1TextonImg(View itemView) {
        super(itemView);
        imageViewCase1 = (ImageView) itemView.findViewById(R.id.case1_texton_image_imageviewID);
        textViewHeadingCase1 = (TextView) itemView.findViewById(R.id.case1_texton_image_textviewID);
        textviewTimestampCase1 = (TextView) itemView.findViewById(R.id.case1_texton_image__timestampID);
        imageviewSeenCase1 = (ImageView) itemView.findViewById(R.id.case1_texton_image__seenImageID);

    }


}
