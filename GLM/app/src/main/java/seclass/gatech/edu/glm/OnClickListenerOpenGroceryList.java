package seclass.gatech.edu.glm;

import android.content.Context;
import android.view.View;

/**
 * Created by SamuelSmall on 10/7/2016.
 */

public class OnClickListenerOpenGroceryList
    implements View.OnClickListener {
        private Context context;
        private String id;
        @Override
        public void onClick(View v) {
                context = v.getContext();
                id = v.getTag().toString();

        }
}
