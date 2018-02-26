package com.zac4j.list.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.zac4j.list.R;
import com.zac4j.list.bean.Text;
import java.util.List;

/**
 * Adapter for item operation list view.
 * Created by Zaccc on 2018/2/26.
 */

public class ItemOperationListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

  private static final int ITEM_VIEW_TYPE_NORMAL = 0x00a;
  private static final int ITEM_VIEW_TYPE_INSERTED = 0x00b;
  private static final int ITEM_VIEW_TYPE_HEADER = 0x00c;
  private static final int ITEM_VIEW_TYPE_FOOTER = 0x00d;

  private Context mContext;
  private List<Text> mTextList;
  private int mCurrentItemCount;

  private int mInsertPosition;
  private boolean mIsShowHeader;
  private boolean mIsShowFooter;

  public ItemOperationListAdapter(Context context) {
    mContext = context;
  }

  public void setData(List<Text> textList) {
    mTextList = textList;
    if (mTextList == null || mTextList.size() == 0) {
      mCurrentItemCount = 0;
    } else {
      mCurrentItemCount = mTextList.size();
    }
    notifyDataSetChanged();
  }

  public void showHeader() {
    mIsShowHeader = true;
    mCurrentItemCount++;
    notifyItemInserted(0);
  }

  public void showFooter() {
    mIsShowFooter = true;
    mCurrentItemCount++;
    notifyItemInserted(mCurrentItemCount);
  }

  public void insertItem(int position) {
    mInsertPosition = position;
    mCurrentItemCount++;
    notifyItemInserted(position);
  }

  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(mContext);
    View itemView;
    if (viewType == ITEM_VIEW_TYPE_INSERTED
        || viewType == ITEM_VIEW_TYPE_HEADER
        || viewType == ITEM_VIEW_TYPE_FOOTER) {
      itemView = inflater.inflate(R.layout.list_item_view_insert, parent, false);
      return new InsertViewHolder(itemView);
    } else {
      itemView = inflater.inflate(R.layout.list_item_view_normal, parent, false);
    }
    return new MainViewHolder(itemView);
  }

  @Override
  public int getItemViewType(int position) {
    if (mIsShowHeader && position == 0) {
      return ITEM_VIEW_TYPE_HEADER;
    } else if (mIsShowFooter && position == mCurrentItemCount) {
      return ITEM_VIEW_TYPE_FOOTER;
    }
    if (mInsertPosition == position) {
      return ITEM_VIEW_TYPE_INSERTED;
    }
    return ITEM_VIEW_TYPE_NORMAL;
  }

  @Override
  public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    int viewType = holder.getItemViewType();
    if (viewType == ITEM_VIEW_TYPE_INSERTED) {
      ((InsertViewHolder) holder).mImageView.setImageResource(R.drawable.prism);
    } else if (viewType == ITEM_VIEW_TYPE_HEADER) {
      ((InsertViewHolder) holder).mImageView.setImageResource(R.drawable.header);
    } else if (viewType == ITEM_VIEW_TYPE_FOOTER) {
      ((InsertViewHolder) holder).mImageView.setImageResource(R.drawable.footer);
    } else if (viewType == ITEM_VIEW_TYPE_NORMAL) {
      System.out.println(
          "position >>> " + position + ", adapter position >>> " + holder.getAdapterPosition());

      position = position == 0 ? position : --position;
      Text text = mTextList.get(position);
      ((MainViewHolder) holder).mTitleView.setText(text.getTitle());
      ((MainViewHolder) holder).mContentView.setText(text.getContent());
    }
  }

  @Override
  public int getItemCount() {
    return mCurrentItemCount;
  }

  class MainViewHolder extends RecyclerView.ViewHolder {

    private TextView mTitleView;
    private TextView mContentView;

    MainViewHolder(View itemView) {
      super(itemView);
      mTitleView = itemView.findViewById(R.id.io_list_item_tv_title);
      mContentView = itemView.findViewById(R.id.io_list_item_tv_content);
    }
  }

  class InsertViewHolder extends RecyclerView.ViewHolder {

    private ImageView mImageView;

    InsertViewHolder(View itemView) {
      super(itemView);
      mImageView = itemView.findViewById(R.id.io_list_item_iv_image);
    }
  }
}
