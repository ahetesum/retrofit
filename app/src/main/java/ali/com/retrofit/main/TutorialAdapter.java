package ali.com.retrofit.main;

import ali.com.retrofit.R;
import ali.com.retrofit.tutorial1.TutorialOneActivity;
import ali.com.retrofit.tutorial2.TutorialTwoActivity;
import ali.com.retrofit.tutorial3.TutorialThreeActivity;
import ali.com.retrofit.tutorial4.TutorialFourActivity;
import ali.com.retrofit.tutorial5.TutorialFiveActivity;
import ali.com.retrofit.tutorial6.TutorialSixActivity;
import ali.com.retrofit.tutorial7.TutorialSevenActivity;
import ali.com.retrofit.tutorial8.TutorialEightActivity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TutorialAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

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
        TextView item = ((ViewHolder) holder).item;
        item.setText(itemList[position]);

        ((ViewHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectToTutorial(position);
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
            item = itemView.findViewById(R.id.tutorialTextView);
        }
    }

    private void redirectToTutorial(int position) {
        switch (position) {
            case 0:
                Intent oneIntent = new Intent(context, TutorialOneActivity.class);
                oneIntent.putExtra("TITLE",itemList[position]);
                context.startActivity(oneIntent);
                break;
            case 1:
                Intent twoIntent = new Intent(context, TutorialTwoActivity.class);
                twoIntent.putExtra("TITLE",itemList[position]);
                context.startActivity(twoIntent);
                break;
            case 2:
                Intent threeIntent = new Intent(context, TutorialThreeActivity.class);
                threeIntent.putExtra("TITLE",itemList[position]);
                context.startActivity(threeIntent);
                break;
            case 3:
                Intent fourIntent = new Intent(context, TutorialFourActivity.class);
                fourIntent.putExtra("TITLE",itemList[position]);
                context.startActivity(fourIntent);
                break;
            case 4:
                Intent fiveIntent = new Intent(context, TutorialFiveActivity.class);
                fiveIntent.putExtra("TITLE",itemList[position]);
                context.startActivity(fiveIntent);
                break;
            case 5:
                Intent sixIntent = new Intent(context, TutorialSixActivity.class);
                sixIntent.putExtra("TITLE",itemList[position]);
                context.startActivity(sixIntent);
                break;
            case 6:
                Intent sevenIntent = new Intent(context, TutorialSevenActivity.class);
                sevenIntent.putExtra("TITLE",itemList[position]);
                context.startActivity(sevenIntent);
                break;
            case 7:
                Intent eightIntent = new Intent(context, TutorialEightActivity.class);
                eightIntent.putExtra("TITLE",itemList[position]);
                context.startActivity(eightIntent);
                break;
        }
    }


}
