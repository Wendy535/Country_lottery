package com.example.country_lottery

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText

internal class MainActivity : AppCompatActivity() {

    private val country = Country()
    private var chosenCountry: Country = country.getRandomCountry()
    private var userGuess: String = ""
    private var counter = 1
    private var phrase = ""
    private var countryWithSymbols = chosenCountry.name.padEnd(15, '-')
    private var countryForHelp  = arrayListOf('*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*')


    private lateinit var buttonRestart: Button
    private lateinit var buttonNeedHelp: Button
    private lateinit var textViewResult: TextView
    private lateinit var buttonGuess: Button
    private lateinit var editTextUserInput: AppCompatEditText
    private lateinit var textViewWelcomer: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewWelcomer = findViewById(R.id.textViewWelcomer)
        buttonRestart = findViewById(R.id.buttonRestart)
        buttonNeedHelp = findViewById(R.id.buttonNeedHelp)
        textViewResult = findViewById(R.id.textViewResult)
        buttonGuess = findViewById(R.id.buttonGuess)
        editTextUserInput = findViewById(R.id.editTextIUserInput)
        countryQuiz()
    }

    private fun tipGetter(): String {
        when (counter) {
            1 -> phrase = chosenCountry.tips[0]
            2 -> phrase = chosenCountry.tips[1]
            3 -> phrase = chosenCountry.tips[2]
        }
        return phrase
    }


    private fun restartQuiz() {
        counter = 1
        editTextUserInput.text?.clear()
        chosenCountry = country.getRandomCountry()
        var countryForHelp  = arrayListOf('*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*')
        countryWithSymbols = chosenCountry.name.padEnd(15, '-')
        textViewWelcomer.text = "???? ???????????????? ????????????. ?????????????????? ???? ???????????????????"
        textViewResult.text = tipGetter()

    }

    private fun countryQuiz() {
        textViewWelcomer.text = "???? ???????????????? ????????????. ?????????????????? ???? ???????????????????"
        counter = 1
        textViewResult.text = tipGetter()

        buttonGuess.setOnClickListener {
            userGuess = editTextUserInput.text.toString()
            if (userGuess == chosenCountry.name) {
                textViewResult.text = "??????????????! ?????? ???????"
                textViewWelcomer.text = winComments()
            } else {
                textViewWelcomer.text = loseComments()
                counter += 1
                when (counter) {
                    2 -> {textViewResult.text = tipGetter()
                        editTextUserInput.text?.clear()}
                    3 -> {textViewResult.text = tipGetter()
                        editTextUserInput.text?.clear()}
                    else -> textViewResult.text = "???? ?????????????? :("
                }
            }
        }

        buttonNeedHelp.setOnClickListener {
            editTextUserInput.setText(littleHelp())
            countryForHelp  = arrayListOf('*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*')
        }

        buttonRestart.setOnClickListener {
            restartQuiz()
        }

        editTextUserInput.setOnClickListener {
            editTextUserInput.text?.clear()
        }

    }

        private fun littleHelp(): String {
            repeat(3) {
                val x = (0..14).random()
                for (i in 0..14) {
                    if (i == x) {
                        countryForHelp[x] = countryWithSymbols[x]
                    }
                }
            }
            return countryForHelp.joinToString(separator = "", prefix = "", postfix = "")
        }

        private fun winComments(): String {
            val winTexts = arrayOf(
            "??????????????!",
            "?????? ??????????????!",
            "??????????????!",
            "???? ?? ?????????????????????? ???? ???????????????",
            "??????????????, ???? ??????????????",
            "???? ???????????? ?? ???????? ?????????? ???? ????????????",
            "??????????!",
            "?????? ?????? ????????!"
            )

        return winTexts.random()
        }

        private fun loseComments(): String{
            val loseTexts = arrayOf(
                "????????????, ????????????",
                "???????????????????? ??????",
                "?????????? ?????? ??????????????",
                "???? ????????????????????",
                "???? ???? ?????????? ???????????? ??????????!",
                "?????????????? ?? ???????????? ??????",
                "?????????????? - ???? ????????????????????????????!",
                "???????? ???? ?????????????? ??????????????",
                "??????, ????????????????, ?? ?????????? ???????????? ??????????",
                "?????? ???????????????? ?? ??????????????????",
                "?????? ????????, ???? ?????????????????? ???????????? ??????????????",
                "?? ?????????? ???????????? ???????? ???? ?????????? ????????????????????",
                "???? ?? ??????????, ???? ???? ???????????? ???? ??????????????",
                "????????????????????!"
            )
            return loseTexts.random()
        }

}