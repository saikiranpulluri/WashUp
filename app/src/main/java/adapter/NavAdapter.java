package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import in.lworks.washup.NavInformation;
import in.lworks.washup.R;

/**
 * Created by Saikiran Pulluri on 26-09-2015.
 */
public class NavAdapter extends RecyclerView.Adapter<NavAdapter.NavViewHolder> {

    private LayoutInflater inflater;
    List<NavInformation> data= Collections.emptyList();

    public NavAdapter(Context context,List<NavInformation> data) {
        inflater = LayoutInflater.from(context);
        this.data=data;
    }

    @Override
    public NavViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.custom_row, viewGroup, false);
        NavViewHolder viewHolder=new NavViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NavViewHolder viewHolder, int position) {
        NavInformation currentData=data.get(position);
        viewHolder.title.setText(currentData.title);
        viewHolder.icon.setImageResource(currentData.itemId);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class NavViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView icon;

        public NavViewHolder(View itemView) {
            super(itemView);
            title=(TextView)itemView.findViewById(R.id.listCaption);
            icon=(ImageView)itemView.findViewById(R.id.listIcon);
        }
    }
}
