package com.tfs.mkaratusi.mkaratusi.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tfs.mkaratusi.mkaratusi.R;
import com.tfs.mkaratusi.mkaratusi.pojo.CheckpointPrint;

import java.util.List;

/**
 * Created by Dell on 2/11/2018.
 */

public class CheckpointAdapter extends RecyclerView.Adapter<CheckpointAdapter.MyViewHolder> {

    List<CheckpointPrint> checkpoints;

    public CheckpointAdapter(List<CheckpointPrint> checkpoints) {
        this.checkpoints = checkpoints;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tp_route_list_row, parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final CheckpointPrint checkpoint = checkpoints.get(position);
        holder.checkpointName.setText("CP Name : " + checkpoint.getCheckpoint());
        holder.description.setText("More Info : " + checkpoint.getAdditionInformation());
        holder.checkpointStatus.setText("Status : " + checkpoint.getInspectionStatus());
       // holder.inspectedBy.setText("Inspected By : " + checkpoint.getInspectedBy());

    }



    @Override
    public int getItemCount() {
        return checkpoints.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView checkpointName, checkpointStatus, inspectedBy, description;
        LinearLayout linearLayout;
        public MyViewHolder(View itemView) {
            super(itemView);
            linearLayout =  itemView.findViewById(R.id.route_list_row);
            checkpointName =  itemView.findViewById(R.id.txt_checkpoint_name);
            checkpointStatus = itemView.findViewById(R.id.txt_checkpoint_status);
           // inspectedBy = (TextView) itemView.findViewById(R.id.txt_inspected_by);
            description =  itemView.findViewById(R.id.txt_description);


        }
    }
}