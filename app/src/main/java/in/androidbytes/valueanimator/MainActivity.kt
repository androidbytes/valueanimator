package `in`.androidbytes.valueanimator

import android.animation.ValueAnimator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.OvershootInterpolator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ValueAnimator.AnimatorUpdateListener, View.OnClickListener {

    private val startValue = 1
    private val endValue = 100
    private val duration = 4000L
    private val valueAnimator = ValueAnimator.ofInt(startValue, endValue)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set background color
        window.decorView.setBackgroundResource(R.color.background)

        //set btn's click listener
        btn.setOnClickListener(this)

        //init animatedView (textview) with starting value
        animatedView.text = startValue.toString()

        //set value animator properties
        valueAnimator.duration = duration
        valueAnimator.addUpdateListener(this)
        valueAnimator.interpolator = OvershootInterpolator()
    }

    override fun onAnimationUpdate(animation: ValueAnimator) {
        val animatedValue = animation.animatedValue as Int
        animatedView.text = animatedValue.toString()
    }


    override fun onClick(view: View) = valueAnimator.start()
}
