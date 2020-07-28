package mandar.gaikwad.arkids_version_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter3 extends ArrayAdapter<CustomClass> {

    static String catch_string;

    public CustomAdapter3(@NonNull Context context, ArrayList<CustomClass> resource) {
        super(context, 0, resource);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_list_wild, parent, false);


        CustomClass item = getItem(position);


        TextView title = convertView.findViewById(R.id.wildtext);
        title.setText(item.getTitle());
        catch_string = (String) title.getText();
        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.custom_listview_animation);
        convertView.startAnimation(animation);

        return convertView;
    }
}
