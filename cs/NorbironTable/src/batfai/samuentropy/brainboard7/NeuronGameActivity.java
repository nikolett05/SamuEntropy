
package batfai.samuentropy.brainboard7;

/**
 *
 * @author nbatfai
 */

import android.widget.*;
import android.view.*;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.widget.TextView;
import android.preference.PreferenceManager;
import android.content.Context;
import android.app.Activity;
import android.os.Bundle;

public class NeuronGameActivity extends android.app.Activity {
    int snandi, snandi2, smatyi, smatyi2, sgreti, sgreti2;
    int nandi, nandi2, matyi, matyi2, greti, greti2;

    @Override
    public void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        android.content.SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
        setContentView(R.layout.main);
        Button bBuild = (Button) findViewById(R.id.build);
        bBuild.setOnClickListener(new OnClickListener() {
           public void onClick(View v){
               Intent i = new Intent(NeuronGameActivity.this, NodeActivity.class);
               startActivity(i);
           }
        });
        TextView counter = (TextView) findViewById(R.id.counter);
        if(savedInstanceState == null){
          counter.setText("  Nandi: " + NodeActivity.nandi + "\t  Nandi2: " + NodeActivity.nandi2
                      + "\t  Matyi: " + NodeActivity.matyi + "\t  Matyi2: " + NodeActivity.matyi2
                      + "\t Greti: " + NodeActivity.greti + "\t Greti2: " + NodeActivity.greti2 + " Osszesen: "
          + (NodeActivity.nandi+NodeActivity.nandi2+NodeActivity.matyi+NodeActivity.matyi2+NodeActivity.greti+NodeActivity.greti2));
        }
      /*  snandi = getPreferences(Context.MODE_PRIVATE).getInt("nandi",snandi);
        snandi2 = getPreferences(Context.MODE_PRIVATE).getInt("nandi2",snandi2);
        smatyi = getPreferences(Context.MODE_PRIVATE).getInt("matyi",smatyi);
        smatyi2 = getPreferences(Context.MODE_PRIVATE).getInt("matyi2",smatyi2);
        sgreti = getPreferences(Context.MODE_PRIVATE).getInt("greti",sgreti);
        sgreti2 = getPreferences(Context.MODE_PRIVATE).getInt("greti2",sgreti2);
          if(snandi!=0){ NodeActivity.nandi = snandi; }
          if(snandi2!=0){ NodeActivity.nandi2 = snandi2; }
          if(smatyi!=0){ NodeActivity.matyi = smatyi; }
          if(smatyi2!=0){ NodeActivity.matyi2 = smatyi2; }
          if(sgreti!=0){ NodeActivity.greti = sgreti; }
          if(sgreti2!=0){ NodeActivity.greti2 = sgreti2; }*/

          counter.setText("  Nandi: " + NodeActivity.nandi + "\t  Nandi2: " + NodeActivity.nandi2
                      + "\t  Matyi: " + NodeActivity.matyi + "\t  Matyi2: " + NodeActivity.matyi2
                      + "\t Greti: " + NodeActivity.greti + "\t Greti2: " + NodeActivity.greti2 + " Osszesen: "
          + (NodeActivity.nandi+NodeActivity.nandi2+NodeActivity.matyi+NodeActivity.matyi2+NodeActivity.greti+NodeActivity.greti2));
      }
    private void savesettings(){
        android.content.SharedPreferences.Editor ceditor = getPreferences(Context.MODE_PRIVATE).edit();
        ceditor.putInt("nandi", NodeActivity.nandi);
        ceditor.putInt("matyi",NodeActivity.matyi);
        ceditor.putInt("greti", NodeActivity.greti);
        ceditor.putInt("nandi2", NodeActivity.nandi2);
        ceditor.putInt("matyi2",NodeActivity.matyi2);
        ceditor.putInt("greti2", NodeActivity.greti2);
        ceditor.commit();
    }
    @Override
        public void onStop(){
          super.onStop();
          android.content.SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
          android.content.SharedPreferences.Editor editor = settings.edit();
          NorbironSurfaceView.saveData(editor);
          savesettings();
    }
    @Override
        public void onPause(){
          super.onStop();
          android.content.SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
          android.content.SharedPreferences.Editor editor = settings.edit();
          NorbironSurfaceView.saveData(editor);
          savesettings();
    }
}
