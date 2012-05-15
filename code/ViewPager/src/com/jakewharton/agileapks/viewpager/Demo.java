package com.jakewharton.agileapks.viewpager;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Demo extends FragmentActivity {
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    ViewPager pager = (ViewPager) findViewById(R.id.the_view_pager);
    pager.setAdapter(new FakeMarketCategories(this));

    CirclePageIndicator indicator = (CirclePageIndicator) findViewById(R.id.view_pager);
    indicator.setViewPager(pager);
  }

  private static class FakeMarketCategories extends FragmentPagerAdapter {
    private static final int PAGES = 3;

    private final List<ListFragment> mCache = new ArrayList<ListFragment>(PAGES);
    private final Context mContext;

    FakeMarketCategories(FragmentActivity activity) {
      super(activity.getSupportFragmentManager());
      mContext = activity;
    }

    @Override public Fragment getItem(int i) {
      ListFragment frag;
      if (i < mCache.size()) {
        frag = mCache.get(i);
      } else {
        frag = new ListFragment();
        frag.setListAdapter(newFakeAdapter(mContext));
      }
      return frag;
    }

    @Override public int getCount() {
      return PAGES;
    }
  }

  private static ListAdapter newFakeAdapter(Context context) {
    List<String> categories = new ArrayList<String>();
    for (int i = 0; i < 10; i++) {
      categories.add(CATEGORIES[RANDOM.nextInt(CATEGORIES.length)]);
    }
    return new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, android.R.id.text1, categories);
  }

  private static final Random RANDOM = new Random();
  private static final String[] CATEGORIES = new String[]{
      //Music
      "Alternative/Indie",
      "Blues",
      "Children's Music",
      "Christian/Gospel",
      "Classical",
      "Comedy/Spoken Word/Other",
      "Country",
      "Dance/Electronic",
      "Folk",
      "Hip-hop/Rap",
      "Jazz",
      "Latin",
      "Metal",
      "New Age",
      "Pop",
      "Reggae/Ska",
      "Rock",
      "R&B/Soul",
      "Soundtracks/Cast Albums",
      "Vocal/Easy Listening",
      "World",

      //Books
      "Biographies & Memoirs",
      "Business & Investing",
      "Children's Books",
      "Computers & Internet",
      "Cooking, Food & Wine",
      "Fantasy",
      "Fiction",
      "History",
      "Humor",
      "Lifestyle & Home",
      "Mystery & Thrillers",
      "Parenting & Families",
      "Politics & Current Events",
      "Reference",
      "Religion & Spirituality",
      "Romance",
      "Science",
      "Science Fiction",
      "Sports",
      "Travel",

      //Movies
      "Action & Adventure",
      "Animation",
      "Comedy",
      "Drama",
      "Documentary",
      "Family",
      "Horror",

      //Games
      "Arcade & Action",
      "Brain & Puzzle",
      "Cards & Casino",
      "Casual",
      "Live Wallpaper",
      "Racing",
      "Sports Games",
      "Widgets",

      //Apps
      "Books & Reference",
      "Business",
      "Comics",
      "Communication",
      "Education",
      "Entertainment",
      "Finance",
      "Health & Fitness",
      "Libraries & Demo",
      "Lifestyle",
      "Live Wallpaper",
      "Media & Video",
      "Medical",
      "Music & Audio",
      "News & Magazines",
      "Personalization",
      "Photography",
      "Productivity",
      "Shopping",
      "Social",
      "Sports",
      "Tools",
      "Transportation",
      "Travel & Local",
      "Weather",
      "Widgets"
  };
}
