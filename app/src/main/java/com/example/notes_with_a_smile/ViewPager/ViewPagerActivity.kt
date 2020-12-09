package com.example.notes_with_a_smile.ViewPager

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.animation.Animation
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.notes_with_a_smile.MainActivity
import com.example.notes_with_a_smile.R
import kotlinx.android.synthetic.main.activity_view_pager.*
import java.lang.Exception


class ViewPagerActivity : AppCompatActivity() {
    var mediaPlayer: MediaPlayer? = null
    var mediaPlayer2: MediaPlayer? = null
    var mediaPlayer3: MediaPlayer? = null

    lateinit var animation: Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)
        viewPager.adapter = PagerAdapter(supportFragmentManager);
        tabLayout.setupWithViewPager(viewPager, true);

        animation_view1.visibility = VISIBLE
        viewPagerScrolling()

        if (viewPager.currentItem == 0) {
            textPager.setTextColor(Color.BLACK)
            backgroundCard.setBackgroundColor(Color.BLUE)
            mediaPlayer3?.stop()
            mediaPlayer2?.stop()

            mediaPlayer = MediaPlayer.create(this@ViewPagerActivity, R.raw.rainmusic)
            mediaPlayer?.start()
        }




        next.setOnClickListener {
            mediaPlayer?.stop()
            mediaPlayer3?.stop()
            mediaPlayer2?.stop()
            if (viewPager.currentItem < 2) {

                viewPager.setCurrentItem(viewPager.currentItem + 1, true)

            } else {

                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }


        skip.setOnClickListener {
            mediaPlayer?.stop()
            mediaPlayer3?.stop()
            mediaPlayer2?.stop()
            startActivity(Intent(this, MainActivity::class.java))
            finish()


        }

    }


    private fun viewPagerScrolling() {

        viewPager?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            @SuppressLint("SetTextI18n")
            override fun onPageSelected(position: Int) {
                try {

                    when (position) {
                        0 -> {
                            mediaPlayer3?.stop()
                            mediaPlayer2?.stop()

                            mediaPlayer = MediaPlayer.create(this@ViewPagerActivity, R.raw.rainmusic)
                            mediaPlayer?.start()

                        }
                        1 -> {
                            mediaPlayer3?.stop()
                            mediaPlayer?.stop()
                            mediaPlayer2 = MediaPlayer.create(this@ViewPagerActivity, R.raw.wind)
                            mediaPlayer2?.start()


                        }
                        2 -> {
                            mediaPlayer?.stop()
                            mediaPlayer2?.stop()
                            mediaPlayer3 = MediaPlayer.create(this@ViewPagerActivity, R.raw.heart)
                            mediaPlayer3?.start()


                        }
                    }


                    if (position == 0) {

                        next.text = "NEXT"
                        skip.visibility = INVISIBLE
                        animation_view1.visibility = VISIBLE
                        animation_view3.visibility = INVISIBLE
                        animation_view2.visibility = INVISIBLE
                        textPager.text = "Добро пожаловать \n         мой друг)))"
                        textPager.setTextColor(Color.BLACK)
                        backgroundCard.setBackgroundColor(Color.BLUE)


                    } else if (position == 1) {
                        next.text = "NEXT"
                        skip.visibility = VISIBLE
                        animation_view2.visibility = VISIBLE
                        animation_view3.visibility = INVISIBLE
                        animation_view1.visibility = INVISIBLE
                        textPager.text = "В наш яркий мир"
                        textPager.setTextColor(Color.YELLOW)
                        backgroundCard.setBackgroundColor(Color.WHITE)


                    } else {
                        next.text = "START"
                        skip.visibility = VISIBLE
                        animation_view3.visibility = VISIBLE
                        animation_view2.visibility = INVISIBLE
                        animation_view1.visibility = INVISIBLE
                        textPager.text = "Мы сделаем ваш день лучше"
                        textPager.setTextColor(Color.BLACK)
                        backgroundCard.setBackgroundColor(Color.RED)


                    }
                } catch (e: Exception) {
                }

            }
        })


    }


    class PagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {


        override fun getItem(position: Int): Fragment {
            val bundle = Bundle()
            bundle.putInt("keyForPosition", position)
            val fragment = ViewPagerFragment()
            fragment.arguments = bundle
            return fragment
        }

        override fun getCount(): Int {
            return 3
        }
    }
}


