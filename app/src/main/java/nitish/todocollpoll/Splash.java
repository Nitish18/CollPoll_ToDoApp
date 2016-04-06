package nitish.todocollpoll;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

/**
 * Created by nitish on 4/6/2016.
 */

public class Splash extends Activity {


        ShimmerTextView tv;
        Shimmer shimmer;
        private static int SPLASH_TIME_OUT = 3500;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                requestWindowFeature(Window.FEATURE_NO_TITLE);
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                        WindowManager.LayoutParams.FLAG_FULLSCREEN);

                setContentView(R.layout.splash);

                tv = (ShimmerTextView) findViewById(R.id.shimmer_tv);

                shimmer = new Shimmer();

                shimmer.start(tv);
                shimmer.setDuration(2000);




                new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

                        @Override
                        public void run() {
                                // This method will be executed once the timer is over
                                // Start your app main activity
                                Intent i = new Intent(Splash.this, MainActivity.class);
                                startActivity(i);

                                // close this activity
                                finish();
                        }
                }, SPLASH_TIME_OUT);
        }


}