package com.skilledanswers.skilledanswers.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skilledanswers.skilledanswers.Holders.Case1TextonImg;
import com.skilledanswers.skilledanswers.Holders.Case2ParImgTxt;
import com.skilledanswers.skilledanswers.Holders.Case3Lytext;
import com.skilledanswers.skilledanswers.Holders.SimpleHolder;
import com.skilledanswers.skilledanswers.Model.TopNewsModel;
import com.skilledanswers.skilledanswers.R;

import java.util.ArrayList;


/**
 * Created by Nishanth on 3/9/2016.
 */
public class TopNewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    private ArrayList<TopNewsModel> items;
    private final int CASE0=0,CASE1=1,CASE2=2;
    public TopNewsAdapter(ArrayList<TopNewsModel> items, Context context) {
        this.items = items;
        this.context=context;
    }
    @Override
    public int getItemCount() {
        return this.items.size();
    }
    @Override
    public int getItemViewType(int position) {
        switch(items.get(position).get_case()){
            case 0 : return CASE0;
            case 1 : return CASE1;
            default : return CASE2;
        }
    }
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, final int position) {
        try {
            switch (viewHolder.getItemViewType()) {
                case CASE0:
                    Case1TextonImg vh1 = (Case1TextonImg) viewHolder;
                    configureCase1Holder(vh1, position);
                    break;
                case CASE1:
                    Case2ParImgTxt vh2 = (Case2ParImgTxt) viewHolder;
                    configureCase2Holder(vh2, position);
                    break;
                case CASE2:
                    Case3Lytext vh3 = (Case3Lytext) viewHolder;
                    configureCase3Holder(vh3, position);
                    break;
                default:
                    SimpleHolder vh = (SimpleHolder) viewHolder;
                    configureDefaultViewHolder(vh, position);
                    break;
            }
        }catch (Exception e)
        {

        }
    }
    private void configureDefaultViewHolder(SimpleHolder vh, int position) {

    }
    ///case 1
    private void configureCase1Holder(Case1TextonImg vh1, final int position) {
        final TopNewsModel model=  items.get(position);
        if(model !=null) {
            Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), model.get_newsImage());
            Bitmap  resized = Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * 1.1), (int) (bitmap.getHeight() * 1.1), true);

            vh1.getImageViewCase1().setImageBitmap(resized);
            vh1.getTextViewHeadingCase1().setText(model.get_newsHeading());
            vh1.getTextviewTimestampCase1().setText(model.get_timestamp());
            int seen = model.get_seen();
            if(seen == 1)
            {
                vh1.getImageviewSeenCase1().setVisibility(View.VISIBLE);
            }
            else
            {
                vh1.getImageviewSeenCase1().setVisibility(View.INVISIBLE);

            }
        }
    }
    private void configureCase2Holder(Case2ParImgTxt vh2, final int position) {
        final TopNewsModel model= items.get(position);
        if(model !=null) {
            Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),model.get_newsImage());
            Bitmap resized = Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * 0.5), (int) (bitmap.getHeight() * 0.5),true);
           vh2.getImageViewCase2().setImageBitmap(resized);
            vh2.getTextViewHeadingCase2().setText(model.get_newsHeading());
            vh2.getTextviewTimestampCase2().setText(model.get_timestamp());
            int seen = model.get_seen();
            if(seen == 1)
            {
                vh2.getImageviewSeenCase2().setVisibility(View.VISIBLE);
            }
            else
            {
                vh2.getImageviewSeenCase2().setVisibility(View.INVISIBLE);

            }
        }
    }

    private void configureCase3Holder(Case3Lytext vh3, final int position) {
        final TopNewsModel model=  items.get(position);
        if(model !=null) {
            vh3.getTextViewHeadingCase3().setText(model.get_newsHeading());
            vh3.getTextViewshortDescCase3().setText(model.get_newsShortDesriprition());
            vh3.getTextviewTimestampCase3().setText(model.get_timestamp());
            int seen = model.get_seen();
            if(seen == 1)
            {
                vh3.getImageviewSeenCase3().setVisibility(View.VISIBLE);
            }
            else
            {
                vh3.getImageviewSeenCase3().setVisibility(View.INVISIBLE);
            }
        }
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        switch (viewType) {
            case CASE0:
                System.out.println("xml1");
                View v1 = inflater.inflate(R.layout.case1_texton_image, viewGroup,false);
                viewHolder = new Case1TextonImg(v1);
                break;
            case CASE1:
                System.out.println("xml2");
                View v2 = inflater.inflate(R.layout.case2_par_imgtxt, viewGroup, false);
                viewHolder = new Case2ParImgTxt(v2);
                break;
            case CASE2:
                System.out.println("xml3");
                View v3=inflater.inflate(R.layout.case3_lytext,viewGroup,false);
                viewHolder=new Case3Lytext(v3);
                break;

            default:
                System.out.println("default");
                View v = inflater.inflate(R.layout.recycleview, viewGroup, false);
                viewHolder = new SimpleHolder(v);
                break;
        }
        return viewHolder;
    }

}
