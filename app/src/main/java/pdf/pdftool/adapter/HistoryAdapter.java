package pdf.pdftool.adapter;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pdf.pdftool.R;
import pdf.pdftool.database.History;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHistoryHolder> {

    private final List<History> mHistoryList;
    private final OnClickListener mOnClickListener;
    private final HashMap<String, Integer> mIconsOperationList;

    public HistoryAdapter(Activity mActivity, List<History> mHistoryList, OnClickListener mOnClickListener) {
        this.mHistoryList = mHistoryList;
        this.mOnClickListener = mOnClickListener;
        mIconsOperationList = new HashMap<>();
        mIconsOperationList.put(mActivity.getString(R.string.printed), R.drawable.ic_print);
        mIconsOperationList.put(mActivity.getString(R.string.created), R.drawable.ic_file_create);
        mIconsOperationList.put(mActivity.getString(R.string.deleted), R.drawable.ic_delete);
        mIconsOperationList.put(mActivity.getString(R.string.renamed), R.drawable.ic_rename);
        mIconsOperationList.put(mActivity.getString(R.string.rotated), R.drawable.ic_rotate_page);
        mIconsOperationList.put(mActivity.getString(R.string.encrypted), R.drawable.ic_set_password);
        mIconsOperationList.put(mActivity.getString(R.string.decrypted), R.drawable.ic_unlock);
    }

    @NonNull
    @Override
    public ViewHistoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item_history, parent, false);
        return new HistoryAdapter.ViewHistoryHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHistoryHolder holder, int position) {

        final String filePath = mHistoryList.get(position).getFilePath();
        File file = new File(filePath);
        final String operationDate = mHistoryList.get(position).getDate();
        String[] formatDate = operationDate.split(" ");
        String date;
        if (formatDate.length >= 3) {
            String time = formatDate[3];
            String[] formatTime =  time.split(":");
            date = formatTime[0] + ":" + formatTime[1];
            date = formatDate[0] + ", " + formatDate[1] + " " + formatDate[2] + " at " + date;
        } else {
            date = operationDate;
        }

        final String operationType = mHistoryList.get(position).getOperationType();
        final String fileName = file.getName();

        holder.mFilename.setText(fileName);
        holder.mOperationDate.setText(date);
        holder.mOperationType.setText(operationType);
        if (mIconsOperationList != null && mIconsOperationList.containsKey(operationType))
            holder.mOperationImage.setImageResource(mIconsOperationList.get(operationType));
        else
            holder.mOperationImage.setImageResource(R.drawable.ic_create_black_24dp);
    }

    public void deleteHistory() {
        mHistoryList.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mHistoryList == null ? 0 : mHistoryList.size();
    }

    public class ViewHistoryHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.fileName)
        TextView mFilename;
        @BindView(R.id.operationDate)
        TextView mOperationDate;
        @BindView(R.id.operationType)
        TextView mOperationType;
        @BindView(R.id.operationImage)
        ImageView mOperationImage;

        ViewHistoryHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mOnClickListener.onItemClick(mHistoryList.get(getAdapterPosition()).getFilePath());
        }
    }

    public interface OnClickListener {
        void onItemClick(String path);
    }
}