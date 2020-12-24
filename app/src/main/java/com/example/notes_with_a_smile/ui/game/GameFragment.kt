 package com.example.notes_with_a_smile.ui.game

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.example.notes_with_a_smile.R
import kotlinx.android.synthetic.main.fragment_game.*
import kotlin.math.absoluteValue


class GameFragment : Fragment(),GameAdapter.Listener,GameAdapter.scoreListener {

    var adapter: GameAdapter?=null

  var list: MutableList<GameModel>?= f()
private var  model: GameViewModel?=null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model = ViewModelProvider(this)[GameViewModel::class.java]

        recyclerView?. layoutManager=LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, true)

        recyclerView?.setOnTouchListener { v: View?, _: MotionEvent? -> true }
        recyclerView.setHasFixedSize(true)
        val snapHelper: SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)


        recyclerView?. adapter= list?.let {
            GameAdapter(it, this,this,requireContext()) }



      model?.getCorrectAnswersAmount()



      getPosition()


 click.setOnClickListener {
     model?.next() }
   back.setOnClickListener(View.OnClickListener {
       model?.back() })

    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return   inflater.inflate(R.layout.fragment_game, container, false)
    }

    @SuppressLint("ShowToast")
    override fun onButtonClick(position: Int, selectAnswerPosition: Int) {
        model?.onButtonClick(position, selectAnswerPosition)
   adapter?.notifyDataSetChanged()
    }

private fun getPosition(){
    model!!.currentPosition.observe(requireActivity(), Observer<Int> {
             it.absoluteValue
        if (it>-1) {
      recyclerView?.smoothScrollToPosition(it)
adapter?.notifyDataSetChanged()

  }  }) }

    override fun onScoreView(position: Int) {
        point.text=position.toString()
    }


}
