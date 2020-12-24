package com.example.notes_with_a_smile.ui.game

import android.content.Context
import android.graphics.Color
import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.notes_with_a_smile.Helper.loadImage
import com.example.notes_with_a_smile.R
import pl.droidsonroids.gif.GifImageView

class GameAdapter(
    var list: MutableList<GameModel>? = f(),
    listener: Listener,
scoreListener: scoreListener,
    val context: Context
) : RecyclerView.Adapter<GameAdapter.ViewHolder>() {
private var listener:Listener?=null
  private var scoreListene:scoreListener?=null
    private var trueAnswerr:Int?=null

var score:Int=0
init {
    this.listener=listener
this.scoreListene=scoreListener

}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        val view:View=LayoutInflater.from(parent.context).inflate(R.layout.game_list, parent, false)


        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
   return list!!.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
val pos: GameModel = list!![position]

      holder.question.text=pos.question
        pos.photo.let { holder.image.loadImage(it) }
        holder.a?.text=pos.a
        holder.b?.text=pos.b
        holder.c?.text=pos.c
        holder.d?.text=pos.d


  //  holder.setIsRecyclable(true)

      trueAnswerr=pos.true_answer

        fun showRightAnswer(gameModel: GameModel) {
            holder.a?.setTextColor(Color.RED)
            holder.b?.setTextColor(Color.RED)
            holder.c?.setTextColor(Color.RED)
            holder.d?.setTextColor(Color.RED)

            when (gameModel.true_answer) {
                1 -> {
                    holder.a?.setTextColor(Color.GREEN)

                }
                2 -> {
                    holder.b?.setTextColor(Color.GREEN)

                }
                3 -> {
                    holder.c?.setTextColor(Color.GREEN)

                }
                4 -> {
                    holder.d?.setTextColor(Color.GREEN)

                }
            }


        }

        fun buttons(){

            val radioSelected = holder.itemView.findViewById<View>(holder.radioGroup!!.checkedRadioButtonId) as RadioButton?
            val answer = holder.radioGroup!!.indexOfChild(radioSelected)+1



            if (answer==pos.true_answer&&position>=0){
                when (position) {
                    0 -> {
                        holder.gifSunny?.visibility=View.VISIBLE

                    }
                    1 -> {
                        holder.gifSunny?.visibility=View.VISIBLE

                    }
                    2 -> {
                        holder.gifSunny?.visibility=View.VISIBLE

                    }

                }


                holder.gifSunny?.visibility=View.VISIBLE
            }else if (position!=pos.true_answer&&position>=0) {
                holder.gifSunny?.visibility=View.INVISIBLE
                holder.gifRainy?.visibility=View.VISIBLE
            }else holder.gifRainy?.visibility=View.VISIBLE


            if (answer == trueAnswerr) {
                score++

               // holder.gifRainy?.visibility=View.GONE
scoreListene?.onScoreView(score)
            }

        }

Toast.makeText(context, "it$trueAnswerr", Toast.LENGTH_LONG).show()


    holder.a?.setOnClickListener {
        listener?.onButtonClick(holder.adapterPosition, 1)

        if (holder.a!!.isChecked) {
            buttons()

        }
showRightAnswer(pos)
    }






        holder.b?.setOnClickListener {
            listener?.onButtonClick(holder.adapterPosition, 2)
            if (holder.b!!.isChecked) {
                buttons()

            }
                showRightAnswer(pos)

        }
        holder.c?.setOnClickListener {
            listener?.onButtonClick(holder.adapterPosition, 3)

            if (holder.c!!.isChecked) {
              buttons()


            }
showRightAnswer(pos)
          //  holder.gifRainy?.visibility=View.GONE
        }
        holder.d?.setOnClickListener {
            listener?.onButtonClick(holder.adapterPosition, 4)
            if (holder.d!!.isChecked) {
               buttons()

            }
            showRightAnswer(pos)

        }


    }







  inner  class  ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){



         var question:TextView=itemView.findViewById(R.id.question)
        var image : ImageView =itemView.findViewById(R.id.img)
      var  radioGroup:RadioGroup? =itemView.findViewById(R.id.radioGroup)
            var a :RadioButton?=itemView.findViewById(R.id.idA)
            var b :RadioButton?=itemView.findViewById(R.id.idB)
            var c :RadioButton?=itemView.findViewById(R.id.idC)
            var d :RadioButton?=itemView.findViewById(R.id.idD)
      var background:CardView?=itemView.findViewById(R.id.backgroundGame_list)
            var gifRainy:GifImageView?=itemView.findViewById(R.id.rainy)
            var gifSunny:GifImageView?=itemView.findViewById(R.id.sunny)



    }

   // override fun getItemViewType(position: Int): Int {
     //   return if (position % 1 == 1) {
    //        0
    //    } else 0
  //  }

    interface scoreListener{

        fun onScoreView(position: Int)
    }

    interface Listener {
        fun onButtonClick(position: Int, selectAnswerPosition: Int)}
}
