package com.example.notes_with_a_smile.ui.game


fun  f(  data: MutableList<GameModel> = mutableListOf()): MutableList<GameModel> {
val adapter:GameAdapter?=null

            (0..0).forEach()
            {_ ->
                data.add(
                    0,
                    GameModel(
                        "Барселона",
                        "Реал мадрид",
                        "Бавария",
                        "Челси",
                        photo = "https://www.thesportsdb.com/images/media/team/badge/xzqdr11517660252.png",
                        question = "как этот клуб называется",true_answer = 4,selectAnswerPosition = 0)
                )
                data.add(
                     1,
                    GameModel(
                       "незнаю",
                        "Англия",
                        "Испания",
                        "Италия",
                        "https://www.thesportsdb.com/images/media/team/badge/rsuswy1448813519.png",
                        "Это какая лига",1


                    ).apply {  }


                )
                data.add(
                    2,
                    GameModel(
                        "незнаю",
                        "Англия",
                        "Испания",
                        "Италия",
                        "https://www.thesportsdb.com/images/media/event/thumb/yt4ib61603140868.jpg",
                        "Это какая лига",true_answer = 1,selectAnswerPosition = 2
                    ))
            }
adapter?.notifyDataSetChanged()

         return data
         }











