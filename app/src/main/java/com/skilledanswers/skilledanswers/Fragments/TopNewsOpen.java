package com.skilledanswers.skilledanswers.Fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.skilledanswers.skilledanswers.Database.DataBaseHelper;
import com.skilledanswers.skilledanswers.MainActivity;
import com.skilledanswers.skilledanswers.Model.AroundTheWebModel;
import com.skilledanswers.skilledanswers.R;


/**
 * Created by Nishanth on 3/10/2016.
 */
public class TopNewsOpen extends Fragment {
        private ImageView titleImageview = null;
        private TextView titleTextview = null;
        private TextView descTextview = null;
        private TextView timestampTextview = null;
        private TextView nextstoryTextview = null;
        private ImageView arroundwebImage1 = null;
        private ImageView arroundwebImage2 = null;
        private ImageView arroundwebImage3 = null;
        private ImageView arroundwebImage4 = null;
        private TextView arroundwebtext1 = null;
        private TextView arroundwebtext2 = null;
        private TextView arroundwebtext3 = null;
        private TextView arroundwebtext4 = null;
        private Toolbar toolbar = null;
        private AppBarLayout appBarLayout = null;
        private CollapsingToolbarLayout collapsingToolbarLayout = null;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(getActivity(), "comment", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_news_open,container,false);
        ((MainActivity) getActivity()).getSupportActionBar().hide();
        arroundwebImage1 = (ImageView) view.findViewById(R.id.top_news_open_web1_image);
        arroundwebImage2 = (ImageView) view.findViewById(R.id.top_news_open_web2_image);
        arroundwebImage3 = (ImageView) view.findViewById(R.id.top_news_open_web3_image);
        arroundwebImage4 = (ImageView) view.findViewById(R.id.top_news_open_web4_image);
        arroundwebtext1 = (TextView) view.findViewById(R.id.top_news_open_web1_textview);
        arroundwebtext2 = (TextView) view.findViewById(R.id.top_news_open_web2_textview);
        arroundwebtext3 = (TextView) view.findViewById(R.id.top_news_open_web3_textview);
        arroundwebtext4 = (TextView) view.findViewById(R.id.top_news_open_web4_textview);

        toolbar = (Toolbar) view.findViewById(R.id.feeds_open_Toolbar);
        if(container.indexOfChild(view) != -1) {
            AppCompatActivity activity = (AppCompatActivity) getActivity();
            activity.setSupportActionBar(toolbar);
            toolbar.setTitle("Skilled Answers");
        }
        else {
        }
        toolbar.inflateMenu(R.menu.top_news_open_main);
        toolbar.setTitle("Top News");
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.top_news_share_icon:
                        shareText("hello", "message");
                        break;
                    case R.id.top_news_comment_icon:
                        Toast.makeText(getActivity(), "comment", Toast.LENGTH_SHORT).show();
                        break;
                }

                return false;
            }
        });
        appBarLayout = (AppBarLayout) view.findViewById(R.id.feeds_open_AppBAr);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbarLayout.setTitle("Skilled Answers");
                    isShow = true;
                } else if(isShow) {
                    collapsingToolbarLayout.setTitle("");
                    isShow = false;
                }
            }
        });
        collapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(R.id.feeds_open_Collapsable);
        titleImageview = (ImageView) view.findViewById(R.id.feeds_open_imageviewID);
        titleTextview = (TextView) view.findViewById(R.id.feeds_open_heading_id);
        descTextview = (TextView) view.findViewById(R.id.feeds_open_description_id);
        timestampTextview = (TextView) view.findViewById(R.id.feeds_open_timestamp_id);
        nextstoryTextview = (TextView) view.findViewById(R.id.feeds_open_nextstory_id);
        Bitmap bitmap = BitmapFactory.decodeResource(getActivity().getResources(), TopNews.passimage);
        Bitmap  resized = Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * 1.5), (int) (bitmap.getHeight() * 1.5), true);
        titleImageview.setImageBitmap(resized);
        titleTextview.setText(TopNews.passheading);
        descTextview.setText(TopNews.passDescription);
        timestampTextview.setText(TopNews.passTimestamp);
        nextstoryTextview.setText(TopNews.passNextstory);
        /////////// adding the data for the around the world
        DataBaseHelper dataBaseHelper = new DataBaseHelper(getActivity());
        dataBaseHelper.addAroundTheWeb(new AroundTheWebModel(1,R.drawable.redbus,"50% off to blore"));
        dataBaseHelper.addAroundTheWeb(new AroundTheWebModel(2,R.drawable.flipcart,"big sale tomm"));
        dataBaseHelper.addAroundTheWeb(new AroundTheWebModel(3,R.drawable.ola,"bikes got fail"));
        dataBaseHelper.addAroundTheWeb(new AroundTheWebModel(4,R.drawable.paytm,"50 cash back"));
        arroundwebImage1.setImageResource(dataBaseHelper.getSingleAroundTheWeb(1).get_image());
        arroundwebImage2.setImageResource(dataBaseHelper.getSingleAroundTheWeb(2).get_image());
        arroundwebImage3.setImageResource(dataBaseHelper.getSingleAroundTheWeb(3).get_image());
        arroundwebImage4.setImageResource(dataBaseHelper.getSingleAroundTheWeb(4).get_image());
        ///
        arroundwebtext1.setText(dataBaseHelper.getSingleAroundTheWeb(1).get_heading());
        arroundwebtext2.setText(dataBaseHelper.getSingleAroundTheWeb(2).get_heading());
        arroundwebtext3.setText(dataBaseHelper.getSingleAroundTheWeb(3).get_heading());
        arroundwebtext4.setText(dataBaseHelper.getSingleAroundTheWeb(4).get_heading());
        return  view;
    }

    public void shareText(String subject, String body) {
        Intent txtIntent = new Intent(android.content.Intent.ACTION_SEND);
        txtIntent .setType("text/plain");
        txtIntent .putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
        txtIntent .putExtra(android.content.Intent.EXTRA_TEXT, body);
        startActivity(Intent.createChooser(txtIntent, "Share"));
    }

}
