package com.example.notes_with_a_smile.ui.game

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel  :ViewModel() {
  var currentPosition: MutableLiveData<Int> =   MutableLiveData()
  var point: MutableLiveData<Int?>? =   MutableLiveData()
    var list: MutableList<GameModel>?= f()
    var questions: MutableLiveData<List<GameModel>> = MutableLiveData()
     var i:Int=+0
     var pointInt:Int=0

    private val pos:Int? =currentPosition.value
















    fun  back(){
    if (list?.size!! >0) {
        currentPosition.value = --i
    }
else if (list?.size==-1){
        currentPosition.value = --i

} }
    fun next(){
    if (pos != null) {
                onButtonClick(pos, selectAnswerPosition = ++i)
             currentPosition.value=++i

    }
    currentPosition.value=++i

}

    fun onButtonClick(position: Int, selectAnswerPosition: Int?) {

        if (position != 0 && list?.size!! > position) {
            list?.get(position)?.selectAnswerPosition = selectAnswerPosition

        list?.get(position)?.isAnswered = true
        questions.value = list
            currentPosition.value=selectAnswerPosition

       currentPosition.value=++i
        }
        else
    {
        val seconds = 0
        val countDownTimer = object : CountDownTimer((seconds * 5000).toLong(), 5000) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                currentPosition.value = ++i
            }
        }.start()
    }}

    fun getCorrectAnswersAmount(): Int? {

        for ( question:GameModel in list!!) {
            val selectedAnswerPosition: Int? = question.selectAnswerPosition?.minus(1)
            if (selectedAnswerPosition != null && selectedAnswerPosition >= 0 ) {
           point?.value=pointInt++

            }
        }
        return point?.value
    }

}




