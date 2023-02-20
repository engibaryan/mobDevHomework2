package com.example.gradecalculator_mobdevhmw3_khachik_yengibaryan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val buttonGrades = findViewById<Button>(R.id.homeworkButton)
        val buttonCalculate = findViewById<Button>(R.id.calculate)
        val buttonReset = findViewById<Button>(R.id.buttonReset)
        val midterm1Grade = findViewById<EditText>(R.id.midterm1Grade)
        val midterm2Grade = findViewById<EditText>(R.id.midterm2Grade)
        val participationGrade = findViewById<EditText>(R.id.participationGrade)
        val groupPresentationGrade = findViewById<EditText>(R.id.groupPresentationGrade)
        val finalProjectGrade = findViewById<EditText>(R.id.finalProjectGrade)
        val grade = findViewById<EditText>(R.id.homeworkGrade)
        val homeworkGradeList = findViewById<TextView>(R.id.homeworkGradeList)
        val finalGradeText = findViewById<TextView>(R.id.finalGrade)
        val logic = GradeCalculatorLogic()
        var counter = 0
        var counterForPrint = 1
        var result = homeworkGradeList.text.toString()
        var homeworkPoints: Double = 0.0
        var homeworkSum: Double = 0.0
        var midterm1Points = 0.0
        var midterm2Points = 0.0
        var participationPoints = 0.0
        var groupPresentationPoints = 0.0
        var finalProjectPoints = 0.0
        var finalGrade = 0.0

        buttonGrades.setOnClickListener {
            val gradeNumberST: String = grade.text.toString()
            try {
                val gradeNumber = gradeNumberST.toInt()
                if(gradeNumber>100) {
                    Toast.makeText(
                        applicationContext,
                        "Homework grade can not be more than 100!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else if(gradeNumberST.get(0)== '0') {
                    Toast.makeText(applicationContext, "Check homework grade! Number can not start with 0 ", Toast.LENGTH_SHORT).show()
                }
                else if(counter < 5) {
                    result =  result.plus("Homework$counterForPrint=")
                        .plus(logic.gradeGetter(gradeNumber, counter)[counter].toString())
                        .plus(" ")
                    homeworkSum += logic.gradeGetter(gradeNumber, counter)[counter]
                    homeworkPoints = (homeworkSum / 5) * 0.2
                    counter += 1
                    counterForPrint += 1
                    homeworkGradeList.text = result
                }
                else if(counter >= 5) {
                    Toast.makeText(
                        applicationContext,
                        "You have to enter 5 homeworks!",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }catch (e: NumberFormatException) {
                Toast.makeText(applicationContext, "Check your input for homework! ", Toast.LENGTH_SHORT).show()
            }

        }
        buttonReset.setOnClickListener{
            logic.arrayOfGrades[0] = 0
            logic.arrayOfGrades[1] = 0
            logic.arrayOfGrades[2] = 0
            logic.arrayOfGrades[3] = 0
            logic.arrayOfGrades[4] = 0
            counter = 0
            counterForPrint = 1
            homeworkPoints = 0.0
            homeworkSum = 0.0
            homeworkGradeList.text = " "
            result = " "
        }
        buttonCalculate.setOnClickListener{
            val midterm1Value: String = midterm1Grade.text.toString()
            try {
                if(midterm1Value.toInt()>100) {
                    Toast.makeText(
                        applicationContext,
                        "Midterm1 grade can not be more than 100!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else if(midterm1Value.get(0) == '0'){
                    Toast.makeText(applicationContext, "Check midterm1 grade!Number can not start with 0 ", Toast.LENGTH_SHORT).show()
                }
                else
                    midterm1Points = midterm1Value.toInt() * 0.1

            } catch (e: NumberFormatException) {
                Toast.makeText(applicationContext, "Check your input for midterm1! ", Toast.LENGTH_SHORT).show()
            }

            val midterm2Value: String = midterm2Grade.text.toString()
            try {
                if(midterm2Value.toInt()>100) {
                    Toast.makeText(
                        applicationContext,
                        "Midterm2 grade can not be more than 100!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else if(midterm2Value.get(0) == '0'){
                    Toast.makeText(applicationContext, "Check midterm2 grade!Number can not start with 0 ", Toast.LENGTH_SHORT).show()
                }
                else
                    midterm2Points = midterm2Value.toInt() * 0.2

            } catch (e: NumberFormatException) {
                Toast.makeText(applicationContext, "Check your input for midterm2! ", Toast.LENGTH_SHORT).show()
            }

            val participationValue: String = participationGrade.text.toString()
            try {
                if (participationValue.toInt() > 100) {
                    Toast.makeText(
                        applicationContext,
                        "Participation grade can not be more than 100!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else if(participationValue.get(0) == '0'){
                    Toast.makeText(applicationContext, "Check participation grade!Number can not start with 0 ", Toast.LENGTH_SHORT).show()
                }
                else
                    participationPoints = participationValue.toInt() * 0.1
            }
             catch (e: NumberFormatException) {
                Toast.makeText(applicationContext, "Check your input for participation! ", Toast.LENGTH_SHORT).show()
            }

            val groupPresentationValue: String = groupPresentationGrade.text.toString()
            try {
                if (groupPresentationValue.toInt() > 100) {
                    Toast.makeText(
                        applicationContext,
                        "Group presentation grade can not be more than 100!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else if(groupPresentationValue.get(0) == '0'){
                    Toast.makeText(applicationContext, "Check group presentation grade!Number can not start with 0 ", Toast.LENGTH_SHORT).show()
                }
                else
                groupPresentationPoints = groupPresentationValue.toInt() * 0.1
            } catch (e: NumberFormatException) {
                Toast.makeText(applicationContext, "Check your input for group presentation! ", Toast.LENGTH_SHORT).show()
            }

            val finalProjectValue: String = finalProjectGrade.text.toString()
            try {
                if (finalProjectValue.toInt() > 100) {
                    Toast.makeText(
                        applicationContext,
                        "Final Project Value grade can not be more than 100!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else if(finalProjectValue.get(0) == '0'){
                    Toast.makeText(applicationContext, "Check final project grade!Number can not start with 0 ", Toast.LENGTH_SHORT).show()
                }
                else
                finalProjectPoints = finalProjectValue.toInt() * 0.3
            } catch (e: NumberFormatException) {
                Toast.makeText(applicationContext, "Check your input for FinalProject! ", Toast.LENGTH_SHORT).show()
            }

            finalGrade = homeworkPoints + midterm1Points + midterm2Points + participationPoints + groupPresentationPoints + finalProjectPoints
            finalGradeText.text = finalGrade.toString()
        }

    }
}