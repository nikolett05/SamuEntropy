
package batfai.samuentropy.brainboard7;

class Splash extends Thread {
    SplashActivity act;
    android.graphics.drawable.AnimationDrawable anim;

    public Splash(android.graphics.drawable.AnimationDrawable anim, SplashActivity act) {
        this.anim = anim;
        this.act = act;
    }
    public void st() {
        android.content.Intent intent = new android.content.Intent();
        intent.setClass(act, NeuronGameActivity.class);
        act.startActivity(intent);
        anim.stop();
    }
    @Override
    public void run() {
        anim.start();
    }
}
/**
 *
 * @author nbatfai
 */
public class SplashActivity extends android.app.Activity {

    private Splash splash;
    @Override
    public void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        android.widget.ImageView iv = (android.widget.ImageView) findViewById(R.id.neuronanimation);
        iv.setBackgroundResource(R.drawable.neuron_animation);
        final android.graphics.drawable.AnimationDrawable anim = (android.graphics.drawable.AnimationDrawable) iv.getBackground();

        splash = new Splash(anim, this);
        runOnUiThread(splash);
    }
    @Override
    public boolean onTouchEvent(android.view.MotionEvent evt) {
        if (evt.getAction() == android.view.MotionEvent.ACTION_DOWN) {
            splash.st();
        }
        return true;
    }
}
