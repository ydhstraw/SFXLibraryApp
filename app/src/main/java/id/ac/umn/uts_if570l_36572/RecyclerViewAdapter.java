package id.ac.umn.uts_if570l_36572;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private ArrayList<Integer> fotoEffects = new ArrayList<>();
    private ArrayList<String> namaEffects = new ArrayList<>();
    private ArrayList<String> infoEffect = new ArrayList<>();
    private ArrayList<Integer> soundEffect = new ArrayList<>();
    private Context context;


    public RecyclerViewAdapter(ArrayList<Integer> fotoEffect, ArrayList<String> namaEffect, ArrayList<String> infoEffect, ArrayList<Integer> soundEffect, Context context) {
        this.fotoEffects = fotoEffect;
        this.namaEffects = namaEffect;
        this.infoEffect = infoEffect;
        this.soundEffect = soundEffect;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.desain_layout_adapter, parent, false);
        ViewHolder holder = new ViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        Glide.with(context).asBitmap().load(fotoEffects.get(position)).into(holder.imageViewFotoEffect);

        holder.textViewNamaEffect.setText(namaEffects.get(position));
        holder.textViewInfoEffect.setText(infoEffect.get(position));

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(context, namaEffect.get(position), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, DetailActivity.class);

                intent.putExtra("foto_effect", fotoEffects.get(position));
                intent.putExtra("nama_effect", namaEffects.get(position));
                intent.putExtra("info_effect", infoEffect.get(position));
                intent.putExtra("sound_effect", soundEffect.get(position));

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return namaEffects.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        ImageView imageViewFotoEffect;
        TextView textViewNamaEffect, textViewInfoEffect;
        ConstraintLayout constraintLayout;

        Button buttonDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewFotoEffect = itemView.findViewById(R.id.imageViewFotoEffect);
            textViewNamaEffect = itemView.findViewById(R.id.textViewNamaEffect);
            textViewInfoEffect = itemView.findViewById(R.id.textViewInfoEffect);
            constraintLayout = itemView.findViewById(R.id.constraintLayout);

            buttonDelete = itemView.findViewById(R.id.buttonDelete);

            buttonDelete.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Toast.makeText(view.getContext(), "Goodbye "+namaEffects.get(position),Toast.LENGTH_LONG).show();
            namaEffects.remove(position);
            fotoEffects.remove(position);
            notifyItemRemoved(position);
        }


    }
}
