package com.example.gradecalculator_mobdevhmw3_khachik_yengibaryan

import android.widget.Button
import android.widget.Toast

class GradeCalculatorLogic() {
        var arrayOfGrades = IntArray(5) {0}

   fun gradeGetter(grade: Int, counter: Int):IntArray {
       arrayOfGrades[counter] = grade
       return arrayOfGrades
   }


}

