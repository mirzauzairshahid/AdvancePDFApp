package pdf.pdftool.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import java.util.Map;
import butterknife.BindView;
import butterknife.ButterKnife;
import pdf.pdftool.R;

public class RecentListAdapter extends RecyclerView.Adapter<RecentListAdapter.RecentItemViewHolder>  {

    private List<String> mKeys;
    private List<Map<String, String>> mValues;
    private final View.OnClickListener mOnClickListener;

    public RecentListAdapter(View.OnClickListener listener) {
        this.mOnClickListener = listener;
    }


    /**
     * Updates the recent list
     * @param keys - list of all the feature viewId
     * @param recentList - list of the features
     * */
    public void updateList(List<String> keys, List<Map<String, String>> recentList) {
        this.mKeys = keys;
        this.mValues = recentList;
    }

    @NonNull @Override public RecentItemViewHolder onCreateViewHolder(
            @NonNull final ViewGroup viewGroup, final int i) {
        View mView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_recent_used, viewGroup, false);
        return new RecentListAdapter.RecentItemViewHolder(mView);
    }

    @Override public void onBindViewHolder(
            @NonNull final RecentItemViewHolder recentItemViewHolder, final int i) {


        recentItemViewHolder.name_.setText(recentItemViewHolder.itemView.getContext().getString(
                Integer.parseInt(mValues.get(i).keySet().iterator().next())));

        recentItemViewHolder.icon_.setImageDrawable(recentItemViewHolder.itemView.getContext()
                .getDrawable(Integer.parseInt(mValues.get(i).values().iterator().next())));


        recentItemViewHolder.itemView.setId(Integer.parseInt(mKeys.get(i)));
        recentItemViewHolder.itemView.setOnClickListener(mOnClickListener);
    }

    @Override public int getItemCount() {
        return mValues.size();
    }

    class RecentItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.option_image_) ImageView icon_;
        @BindView(R.id.option_name_) TextView name_;


        private RecentItemViewHolder(@NonNull final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
