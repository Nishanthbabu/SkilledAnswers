package com.skilledanswers.skilledanswers.Fragments;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skilledanswers.skilledanswers.Adapters.TopNewsAdapter;
import com.skilledanswers.skilledanswers.Database.DataBaseHelper;
import com.skilledanswers.skilledanswers.Model.TopNewsModel;
import com.skilledanswers.skilledanswers.R;
import com.skilledanswers.skilledanswers.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nishanth on 3/12/2016.
 */
public class TopNews extends Fragment {
    private String descStevJobs = "Steven Paul \"Steve\" Jobs (/ˈdʒɒbz/; February 24, 1955 – October 5, 2011) was an American information technology entrepreneur and inventor. He was the co-founder, chairman, and chief executive officer (CEO) of Apple Inc.; CEO and largest shareholder of Pixar Animation Studios;[3] a member of The Walt Disney Company's board of directors following its acquisition of Pixar; and founder, chairman, and CEO of NeXT Inc. Jobs is widely recognized as a pioneer of the microcomputer revolution of the 1970s, along with Apple co-founder Steve Wozniak. Shortly after his death, Jobs's official biographer, Walter Isaacson, described him as a \"creative entrepreneur whose passion for perfection and ferocious drive revolutionized six industries: personal computers, animated movies, music, phones, tablet computing, and digital publishing.\"[2]\n" +
            "\n" +
            "Jobs's countercultural lifestyle and philosophy was a product of the time and place of his upbringing. Jobs was adopted at birth in San Francisco, and raised in a hotbed of counterculture, the San Francisco Bay Area during the 1960s.[4] As a senior at Homestead High School in Cupertino, California, his two closest friends were the older engineering student (and Homestead High alumnus) Wozniak and his girlfriend, the artistically inclined and countercultural Homestead High junior Chrisann Brennan.[5] Jobs and Wozniak bonded over their mutual fascination with Job's musical idol Bob Dylan, discussing his lyrics and collecting bootleg reel-to-reel tapes of Dylan's concerts.[6] Jobs later dated Joan Baez who notably had a prior relationship with Dylan.[6] Jobs briefly attended Reed College in 1972 before dropping out.[5] He then decided to travel through India in 1974 and to study Zen Buddhism.[7] Job's declassified FBI report says an acquaintance knew that Jobs used illegal drugs in college including marijuana and LSD.[8] Jobs told a reporter once that taking LSD was “one of the two or three most important things” he did in his life.[9]";
    private String descIndiaWin = "So that concludes the 2016 Asia Cup. India have had great practice ahead of the World T20. They have won as many as 10 out of their last 11 games. Dhoni spoke about the side being well-settled and surely, they are red-hot favourites for the crown. We still have a bit of time though. A few teams have already arrived in India, while the rest will be there very soon. The qualifiers have already begun and Bangladesh will be playing the qualifiers for a place in the main tournament. Good luck to them, for they played excellent cricket here in the Asia Cup. It was great bringing all the action to you. Hope you enjoyed our coverage. Looking forward to your company for the qualifiers. Goodbye!";
    private String descModi = "Modi was born on 17 September 1950 to a family of grocers in Vadnagar, Mehsana district, Bombay State (present-day Gujarat).[21][22] His family belonged to the Modh-Ghanchi-Teli (oil-presser) community,[23][24][25] which is categorised as an Other Backward Class by the Indian government.[26][27][28] He was the third of six children born to Damodardas Mulchand (1915-1989) and Heeraben Modi (b. c. 1920).[29][30][31] As a child, Modi helped his father sell tea at the Vadnagar railway station, and later ran a tea stall with his brother near a bus terminus.[32][33] He completed his higher secondary education in Vadnagar in 1967, where a teacher described him as an average student and a keen debater with an interest in theatre.[32][34] An early gift for rhetoric in debates was noted by teachers and students.[35] Modi preferred playing larger-than-life characters in theatrical productions, which has influenced his political image.[36][37]";
    private String marshmello = "Android 6.0 \"Marshmallow\"[3] is a version of the Android mobile operating system. First unveiled in May 2015 at Google I/O under the codename \"Android 'M'\", it was officially released in October 2015.[4]\n" +
            "\n" +
            "Marshmallow primarily focuses on improving the overall user experience of Lollipop,[5] introducing a new permissions architecture, new APIs for contextual assistants (a feature notably leveraged by \"Google Now On Tap\"—a new capability of the Google Search app), a new power management system that reduces background activity when a device is not being physically handled, native support for fingerprint recognition and USB Type-C connectors, the ability to migrate data and applications to a microSD card and use it as primary storage, as well as other internal changes.";
    private String ios = "iOS 9 debuted at the Apple Worldwide Developers Conference on June 8, 2015, with iOS 9.0 beta 1 being made available to registered developers straight after the keynote, and a public beta made available to members of Apple's Beta Software Program in July.[5][6] iOS 9 was released publicly on September 16, 2015.[7][8][9]\n" +
            "\n" +
            "iOS 9.0.1 was released on September 23, 2015, as the first update to iOS 9. It fixed a major bug that caused the \"Slide to Upgrade\" screen to freeze when updating from earlier versions of iOS.[10][11]\n" +
            "\n" +
            "iOS 9.0.2 was released on September 30, 2015, to fix a major lock screen bypass issue.[12][13]\n" +
            "\n" +
            "iOS 9.1 was released on October 21, 2015.[14] It includes support for the iPad Pro and Apple Pencil and the 4th generation Apple TV.\n" +
            "\n" +
            "iOS 9.2 was released on December 8, 2015, with new features including adding Arabic language support for Siri and introducing iPhone support for the USB Camera Adapter, which lets users transfer photos from a camera to an iDevice without syncing to a computer first.[15]\n" +
            "\n" +
            "iOS 9.2.1 was released on January 19, 2016, with some bug fixes.\n" +
            "\n" +
            "iOS 9.3 beta was released on January 14, 2016. It included new features such as Night Shift, locking notes, News & Health improvements, more 3D Touch shortcuts, and Education features. It is in its sixth beta phase.";
    private  String iccSub = "The ICC World Twenty20 (also referred to as the World T20, and colloquially as the T20 World Cup) is the international championship of Twenty20 cricket. Organised by cricket's governing body,";
    private String icc = "The ICC World Twenty20 (also referred to as the World T20, and colloquially as the T20 World Cup) is the international championship of Twenty20 cricket. Organised by cricket's governing body, the International Cricket Council (ICC), the tournament currently consists of 16 teams, comprising all ten ICC full members and six other associate or affiliate members chosen through the World Twenty20 Qualifier. The event has generally been held every two years, although there is a four-year gap between the next two scheduled tournaments (2016 in India and 2020 in Australia). All matches played are accorded Twenty20 International status.\n" +
            "\n" +
            "Five tournaments have so far been played, and no team has yet won the tournament on multiple occasions. The inaugural event, the 2007 World Twenty20, was staged in South Africa, and won by India, who defeated Pakistan in the final at the Wanderers Stadium in Johannesburg. The 2009 tournament took place in England, and was won by the previous runner-up, Pakistan, who defeated Sri Lanka in the final at Lord's. The third tournament was held in 2010, hosted by the countries making up the West Indies cricket team. England defeated Australia in the final in Barbados, which was played at Kensington Oval. The fourth tournament, the 2012 World Twenty20, was held in Asia for the first time, with all matches played in Sri Lanka. The West Indies won the tournament by defeating Sri Lanka in the final, winning its first international tournament since the 2004 Champions Trophy.[3] The fifth tournament, the 2014 ICC World Twenty20, was hosted by Bangladesh, and was won by Sri Lanka, who became the first team to play in three finals.";
    private RecyclerView recyclerView = null;
    private Toolbar toolbar = null;
    private AppBarLayout appBarLayout = null;
    private TopNewsAdapter adapter = null;
    private CollapsingToolbarLayout collapsingToolbarLayout = null;
    ////////////
    public static int passimage=0;
    public static String passheading=null;
    public static String passShorddescription = null;
    public static String passDescription =null;
    public static String passTimestamp = null;
    public static String passNextstory = null;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycleview, container, false);


        recyclerView = (RecyclerView) view.findViewById(R.id.recycleviewID);



        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        final DataBaseHelper dataBaseHelper = new DataBaseHelper(getActivity());
//
        dataBaseHelper.addFeedsItems(new TopNewsModel(0,R.drawable.stevejobs,"Its jobs bday","It has to be 61st bday for apple founder",descStevJobs,"2min ago",0,0));//        dataBaseHelper.addFeedsItems(new TopNewsModel(1, R.drawable.indiawin, "Asia cup for India.. India beat host Bangladesh", "India beat Bangladesh", descIndiaWin, 1));
        dataBaseHelper.addFeedsItems(new TopNewsModel(1, R.drawable.modiattack, "Modi attack congress", "We may say anything for the sake of speech, but we all know that ", descModi,"3min ago",0, 2));
        dataBaseHelper.addFeedsItems(new TopNewsModel(2,R.drawable.marshmello,"Samsung galaxy to get Marshmallo","Samsung",marshmello,"5min ago",0,0));
        dataBaseHelper.addFeedsItems(new TopNewsModel(3,R.drawable.ios9, "iOS 9 debuted at the Apple ", "ios",descStevJobs,"7min ago",0, 1));
        dataBaseHelper.addFeedsItems(new TopNewsModel(4,R.drawable.iccindia, "ICCT20 World Cup Started", iccSub, icc,"10min ago",0, 2));
        dataBaseHelper.addFeedsItems(new TopNewsModel(5,R.drawable.indiawin, "India win asia cup ", "India win",descIndiaWin,"7min ago",0, 1));


        List<TopNewsModel> list = dataBaseHelper.getAllFeeds();

        adapter = new TopNewsAdapter((ArrayList<TopNewsModel>) list,getActivity());
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                passimage = dataBaseHelper.getSingleFeeds(position).get_newsImage();
                passheading = dataBaseHelper.getSingleFeeds(position).get_newsHeading();
                passShorddescription = dataBaseHelper.getSingleFeeds(position).get_newsShortDesriprition();
                passDescription = dataBaseHelper.getSingleFeeds(position).get_newsDescription();
                passTimestamp = dataBaseHelper.getSingleFeeds(position).get_timestamp();
                if (position + 1 < dataBaseHelper.getFeedsCount()) {
                    int nextpos = position + 1;
                    passNextstory = dataBaseHelper.getSingleFeeds(nextpos).get_newsHeading();
                }
                else
                {
                    passNextstory = "Not Available";
                }

                ///////// updating the seen in database
                dataBaseHelper.upDateSeen(position, 1);
                TopNewsOpen newsFeedOpen = new TopNewsOpen();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.main, newsFeedOpen);
                transaction.addToBackStack(newsFeedOpen.getTag());
                transaction.commit();

            }
        }));


        return  view;
    }



}
