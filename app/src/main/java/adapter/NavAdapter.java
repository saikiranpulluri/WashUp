package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import in.lworks.washup.NavInformation;
import in.lworks.washup.R;

/**
 * Created by Saikiran Pulluri on 26-09-2015.
 */
public class NavAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEADER=0;
    private static final int TYPE_ITEM=1;

    private LayoutInflater inflater;
    List<NavInformation> data= Collections.emptyList();
    private Context context;

    public NavAdapter(Context context,List<NavInformation> data) {
        this.context=context;
        inflater = LayoutInflater.from(context);
        this.data=data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        if(viewType==TYPE_HEADER){
            View view = inflater.inflate(R.layout.drawer_header, viewGroup, false);
            HeaderHolder viewHolder=new HeaderHolder(view);
            return viewHolder;
        }else {
            View view = inflater.inflate(R.layout.custom_row, viewGroup, false);
            NavViewHolder viewHolder=new NavViewHolder(view);
            return viewHolder;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0){
            return TYPE_HEADER;
        }else {
            return TYPE_ITEM;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder,int position) {
        if(viewHolder instanceof HeaderHolder){

        }else {
            NavViewHolder holder=(NavViewHolder)viewHolder;
            NavInformation currentData = data.get(position-1);
            holder.title.setText(currentData.title);
            holder.icon.setImageResource(currentData.itemId);
       }
    }

    @Override
    public int getItemCount() {
        return data.size()+1;
    }

    class NavViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        ImageView icon;

        public NavViewHolder(View itemView) {
            super(itemView);
            //itemView.setOnClickListener(this);
            title=(TextView)itemView.findViewById(R.id.listCaption);
            icon=(ImageView)itemView.findViewById(R.id.listIcon);
        }

//        @Override
//        public void onClick(View v) {
//            context.startActivity(new Intent(context, AddressesActivity.class));
//        }
    }

    class HeaderHolder extends RecyclerView.ViewHolder{

        TextView title;

        public HeaderHolder(View itemView) {
            super(itemView);
            title=(TextView)itemView.findViewById(R.id.nav_header_text);
        }
    }
}
