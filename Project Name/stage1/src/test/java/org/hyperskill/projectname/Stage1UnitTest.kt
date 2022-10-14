package org.hyperskill.projectname

import android.widget.Button
import org.hyperskill.projectname.internals.AbstractUnitTest
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class Stage1UnitTest : AbstractUnitTest<MainActivity>(MainActivity::class.java){

    private val button1 by lazy {
        activity.findViewByString<Button>("button1")
    }

    private val button2 by lazy {
        activity.findViewByString<Button>("button2")
    }


    @Test
    fun test0_checkCounter1IsOneAfterIncrement() {

        testActivity {
            button1.clickAndRun()
            assertLastToastMessageEquals(
                errorMessage = "this should pass",
                expectedMessage = "1"
            )
        }
    }

    @Test
    fun test1_checkAgainCounter1IsOneAfterIncrement() {
        testActivity {
            button1.clickAndRun()
            assertLastToastMessageEquals(
                errorMessage = "this should not pass if run after test0 because counter1 was not reset",
                expectedMessage = "1"
            )

            //test passes if run individually
        }
    }

    @Test
    fun test2_checkCounter2IsOneAfterIncrement() {

        testActivity {
            button2.clickAndRun()
            assertLastToastMessageEquals(
                errorMessage = "this should pass",
                expectedMessage = "1"
            )
        }
    }

    @Test
    fun test3_checkAgainCounter2IsOneAfterIncrement() {
        testActivity {
            button2.clickAndRun()
            assertLastToastMessageEquals(
                errorMessage = "this should not pass if run after test2 because counter2 was not reset",
                expectedMessage = "1"
            )

            //test passes if run individually
        }
    }
}