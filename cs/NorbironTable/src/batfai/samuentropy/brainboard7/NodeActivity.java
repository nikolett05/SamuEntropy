
package batfai.samuentropy.brainboard7;

class NodeAdapter extends android.widget.BaseAdapter {
    private android.content.Context context;
    private int[] nodeIds = {
        R.drawable.nandironproci, R.drawable.nandironproci2,
        R.drawable.matyironproci, R.drawable.matyironproci2,
        R.drawable.gretironproci, R.drawable.gretironproci2
    };
    public NodeAdapter(android.content.Context context) {
        cinit(context);
    }
    public NodeAdapter(android.content.Context context, android.util.AttributeSet attrs) {
        cinit(context);
    }
    public NodeAdapter(android.content.Context context,
            android.util.AttributeSet attrs, int defStyle) {
        cinit(context);
    }
    private void cinit(android.content.Context context) {
        this.context = context;
    }
    public int getCount() {
        return nodeIds.length;
    }
    public long getItemId(int position) {
        return nodeIds[position];
    }
    public Object getItem(int position) {
        return nodeIds[position];
    }
    public android.view.View getView(int position, android.view.View oldView, android.view.ViewGroup parent) {
        android.widget.ImageView imageView;
        if (oldView != null) {
            imageView = (android.widget.ImageView) oldView;
        } else {
            imageView = new android.widget.ImageView(context);
        }
        imageView.setImageResource(nodeIds[position]);
        return imageView;
    }
}
/**
 *
 * @author nbatfai
 */
public class NodeActivity extends android.app.Activity {
public static int nandi = 0, nandi2 = 0, matyi = 0, matyi2 = 0, greti = 0, greti2 = 0;

    @Override
    public void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nodes);
        android.widget.GridView gridView = (android.widget.GridView) findViewById(R.id.nodelist);
        gridView.setAdapter(new NodeAdapter(this));
        gridView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            public void onItemClick(android.widget.AdapterView<?> parent, android.view.View view, int position, long id) {
                android.content.Intent intent = new android.content.Intent();
                intent.setClass(NodeActivity.this, NeuronGameActivity.class);
                intent.setFlags(android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP); //mindig a frissen lerakottal foglalkozik
                intent.putExtra("selectedNode", position); //lerakja a node-ot kiválasztás után
                startActivity(intent);
                switch (position) {
                    case 0: nandi++; break;
                    case 1: nandi2++; break;
                    case 2: matyi++; break;
                    case 3: matyi2++; break;
                    case 4: greti++; break;
                    case 5: greti2++; break;
                }
                NodeActivity.this.finish();
            }
        });
    }
}
