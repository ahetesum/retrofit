package ali.com.retrofit.main;

import ali.com.retrofit.R;
import ali.com.retrofit.tutorial1.TutorialOneActivity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TutorialAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{

    private String[] itemList;
    private Context context;
    public TutorialAdapter(Context context, String[] itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tutorial_layout, parent, false);
        RecyclerView.ViewHolder myViewHolder = new ViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        TextView item = ((ViewHolder)holder).item;
        item.setText(itemList[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position)
                {
                    case 0:
                    Intent oneIntent= new Intent(context, TutorialOneActivity.class);
                    context.startActivity(oneIntent);
                    case 1:
                        Intent twoIntent= new Intent(context, TutorialOneActivity.class);
                        context.startActivity(twoIntent);
                    case 2:
                        Intent threeIntent= new Intent(context, TutorialOneActivity.class);
                        context.startActivity(threeIntent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList == null ? 0 : itemList.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView item;
        public ViewHolder(View itemView) {
            super(itemView);
            item = (TextView) itemView.findViewById(R.id.tutorialTextView);
        }


    }

}
