package lyp.bawei.com.pf.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import lyp.bawei.com.pf.R;
import lyp.bawei.com.pf.bean.FistHander;

/**
 * Created by Administrator on 2017/5/27.
 */

public class FreeClassAdapter extends BaseAdapter {
    private Context context;
    private List<FistHander.DataBean.TryBean> tryX;

    public FreeClassAdapter(Context context, List<FistHander.DataBean.TryBean> tryX) {
        this.context = context;
        this.tryX = tryX;
    }

    @Override
    public int getCount() {
        return tryX.size();
    }

    @Override
    public Object getItem(int position) {
        return tryX.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyHolder myHolder = null;
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = convertView.inflate(context, R.layout.free_item, null);
            myHolder = new MyHolder();
            viewHolder = new ViewHolder(convertView);
            myHolder.syItemImg = viewHolder.syItemImg;
            myHolder.syItemPrice = viewHolder.syItemPrice;
            myHolder.syItemTeacherName = viewHolder.syItemTeacherName;
            myHolder.syItemTitle = viewHolder.syItemTitle;
            myHolder.syItemTitle2 = viewHolder.syItemTitle2;
            myHolder.syItemTime = viewHolder.syItemTime;
            myHolder.syItemListen = viewHolder.syItemListen;
            convertView.setTag(myHolder);
        } else {
            myHolder = (MyHolder) convertView.getTag();
        }
        Glide.with(context).load(tryX.get(position).image).into(myHolder.syItemImg);

        myHolder.syItemPrice.setText("免费");
        myHolder.syItemTeacherName.setText("赵小猪");
        myHolder.syItemTitle.setText(tryX.get(position).title);
        myHolder.syItemTitle2.setText(tryX.get(position).title2);
        myHolder.syItemTime.setText(tryX.get(position).length + "秒");
        //myHolder.syItemListen.setImageResource(R.drawable.gray_radius);
        return convertView;
    }

    class MyHolder {
        ImageView syItemImg;
        ImageView syItemListen;
        TextView syItemTitle;
        TextView syItemTitle2;
        TextView syItemTeacherName;
        TextView syItemPrice;
        TextView syItemTime;
    }

    class ViewHolder {
        @BindView(R.id.sy_item_img)
        ImageView syItemImg;
        @BindView(R.id.sy_item_listen)
        ImageView syItemListen;
        @BindView(R.id.sy_item_title)
        TextView syItemTitle;
        @BindView(R.id.sy_item_title2)
        TextView syItemTitle2;
        @BindView(R.id.sy_item_teacherName)
        TextView syItemTeacherName;
        @BindView(R.id.sy_item_price)
        TextView syItemPrice;
        @BindView(R.id.sy_item_time)
        TextView syItemTime;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
