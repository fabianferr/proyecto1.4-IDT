package com.applovin.mediation.nativeAds.adPlacer;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.applovin.impl.mediation.b.a.c;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.nativeAds.adPlacer.MaxAdPlacer;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.R;
import java.util.Collection;

public class MaxRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements MaxAdPlacer.Listener {
    /* access modifiers changed from: private */
    public final MaxAdPlacer a;
    /* access modifiers changed from: private */
    public final RecyclerView.Adapter b;
    private final a c;
    private RecyclerView d;
    private c e;
    private MaxAdPlacer.Listener f;
    /* access modifiers changed from: private */
    public int g = 8;
    /* access modifiers changed from: private */
    public AdPositionBehavior h = AdPositionBehavior.DYNAMIC_EXCEPT_ON_APPEND;

    public enum AdPositionBehavior {
        DYNAMIC_EXCEPT_ON_APPEND,
        DYNAMIC,
        FIXED
    }

    public static class MaxAdRecyclerViewHolder extends RecyclerView.ViewHolder {
        private final ViewGroup a;

        public MaxAdRecyclerViewHolder(View view) {
            super(view);
            this.a = (ViewGroup) view.findViewById(R.id.native_ad_view_container);
        }

        public ViewGroup getContainerView() {
            return this.a;
        }
    }

    private class a extends RecyclerView.AdapterDataObserver {
        private a() {
        }

        public void onChanged() {
            MaxRecyclerAdapter.this.notifyDataSetChanged();
        }

        public void onItemRangeChanged(int i, int i2) {
            int adjustedPosition = MaxRecyclerAdapter.this.a.getAdjustedPosition(i);
            MaxRecyclerAdapter.this.notifyItemRangeChanged(adjustedPosition, (MaxRecyclerAdapter.this.a.getAdjustedPosition((i + i2) - 1) - adjustedPosition) + 1);
        }

        public void onItemRangeInserted(int i, int i2) {
            int i3 = 0;
            boolean z = i + i2 >= MaxRecyclerAdapter.this.b.getItemCount();
            if (MaxRecyclerAdapter.this.h == AdPositionBehavior.FIXED || (MaxRecyclerAdapter.this.h == AdPositionBehavior.DYNAMIC_EXCEPT_ON_APPEND && z)) {
                MaxRecyclerAdapter.this.notifyDataSetChanged();
                return;
            }
            int adjustedPosition = MaxRecyclerAdapter.this.a.getAdjustedPosition(i);
            while (true) {
                MaxRecyclerAdapter maxRecyclerAdapter = MaxRecyclerAdapter.this;
                if (i3 < i2) {
                    maxRecyclerAdapter.a.insertItem(adjustedPosition);
                    i3++;
                } else {
                    maxRecyclerAdapter.notifyItemRangeInserted(adjustedPosition, i2);
                    return;
                }
            }
        }

        public void onItemRangeMoved(int i, int i2, int i3) {
            MaxRecyclerAdapter.this.notifyDataSetChanged();
        }

        public void onItemRangeRemoved(int i, int i2) {
            int itemCount = MaxRecyclerAdapter.this.b.getItemCount();
            boolean z = i + i2 >= itemCount;
            if (MaxRecyclerAdapter.this.h == AdPositionBehavior.FIXED || (MaxRecyclerAdapter.this.h == AdPositionBehavior.DYNAMIC_EXCEPT_ON_APPEND && z)) {
                MaxRecyclerAdapter.this.notifyDataSetChanged();
                return;
            }
            int adjustedPosition = MaxRecyclerAdapter.this.a.getAdjustedPosition(i);
            int adjustedCount = MaxRecyclerAdapter.this.a.getAdjustedCount(itemCount + i2);
            for (int i3 = 0; i3 < i2; i3++) {
                MaxRecyclerAdapter.this.a.removeItem(adjustedPosition);
            }
            int adjustedCount2 = MaxRecyclerAdapter.this.a.getAdjustedCount(itemCount);
            int i4 = adjustedCount - adjustedCount2;
            Collection<Integer> clearTrailingAds = MaxRecyclerAdapter.this.a.clearTrailingAds(adjustedCount2 - 1);
            if (!clearTrailingAds.isEmpty()) {
                i4 += clearTrailingAds.size();
            }
            MaxRecyclerAdapter.this.notifyItemRangeRemoved(adjustedPosition - (i4 - i2), i4);
        }
    }

    public MaxRecyclerAdapter(MaxAdPlacerSettings maxAdPlacerSettings, RecyclerView.Adapter adapter, Activity activity) {
        a aVar = new a();
        this.c = aVar;
        MaxAdPlacer maxAdPlacer = new MaxAdPlacer(maxAdPlacerSettings, activity);
        this.a = maxAdPlacer;
        maxAdPlacer.setListener(this);
        super.setHasStableIds(adapter.hasStableIds());
        this.b = adapter;
        adapter.registerAdapterDataObserver(aVar);
    }

    private int a(int i) {
        int pxToDp = AppLovinSdkUtils.pxToDp(this.d.getContext(), this.d.getWidth());
        RecyclerView.LayoutManager layoutManager = this.d.getLayoutManager();
        if (!(layoutManager instanceof GridLayoutManager)) {
            return layoutManager instanceof StaggeredGridLayoutManager ? pxToDp / ((StaggeredGridLayoutManager) layoutManager).getSpanCount() : pxToDp;
        }
        GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
        return (pxToDp / gridLayoutManager.getSpanCount()) * gridLayoutManager.getSpanSizeLookup().getSpanSize(i);
    }

    public void destroy() {
        try {
            this.b.unregisterAdapterDataObserver(this.c);
        } catch (Exception unused) {
        }
        this.a.destroy();
        c cVar = this.e;
        if (cVar != null) {
            cVar.a();
        }
    }

    public MaxAdPlacer getAdPlacer() {
        return this.a;
    }

    public int getAdjustedPosition(int i) {
        return this.a.getAdjustedPosition(i);
    }

    public int getItemCount() {
        return this.a.getAdjustedCount(this.b.getItemCount());
    }

    public long getItemId(int i) {
        if (!this.b.hasStableIds()) {
            return -1;
        }
        return this.a.isFilledPosition(i) ? this.a.getAdItemId(i) : this.b.getItemId(this.a.getOriginalPosition(i));
    }

    public int getItemViewType(int i) {
        if (this.a.isAdPosition(i)) {
            return -42;
        }
        return this.b.getItemViewType(this.a.getOriginalPosition(i));
    }

    public int getOriginalPosition(int i) {
        return this.a.getOriginalPosition(i);
    }

    public void loadAds() {
        this.a.loadAds();
    }

    public void onAdClicked(MaxAd maxAd) {
        MaxAdPlacer.Listener listener = this.f;
        if (listener != null) {
            listener.onAdClicked(maxAd);
        }
    }

    public void onAdLoaded(int i) {
        notifyItemChanged(i);
        MaxAdPlacer.Listener listener = this.f;
        if (listener != null) {
            listener.onAdLoaded(i);
        }
    }

    public void onAdRemoved(int i) {
        MaxAdPlacer.Listener listener = this.f;
        if (listener != null) {
            listener.onAdRemoved(i);
        }
    }

    public void onAdRevenuePaid(MaxAd maxAd) {
        MaxAdPlacer.Listener listener = this.f;
        if (listener != null) {
            listener.onAdRevenuePaid(maxAd);
        }
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.d = recyclerView;
        c cVar = new c(recyclerView);
        this.e = cVar;
        cVar.a((c.a) new c.a() {
            public void a(int i, int i2) {
                MaxRecyclerAdapter.this.a.updateFillablePositions(i, Math.min(i2 + MaxRecyclerAdapter.this.g, MaxRecyclerAdapter.this.getItemCount() - 1));
            }
        });
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        this.e.a(viewHolder.itemView, i);
        if (this.a.isAdPosition(i)) {
            AppLovinSdkUtils.Size adSize = this.a.getAdSize(i, a(i));
            ViewGroup containerView = ((MaxAdRecyclerViewHolder) viewHolder).getContainerView();
            ViewGroup.LayoutParams layoutParams = containerView.getLayoutParams();
            if (adSize != AppLovinSdkUtils.Size.ZERO) {
                layoutParams.width = adSize.getWidth() < 0 ? adSize.getWidth() : AppLovinSdkUtils.dpToPx(containerView.getContext(), adSize.getWidth());
                layoutParams.height = adSize.getHeight() < 0 ? adSize.getHeight() : AppLovinSdkUtils.dpToPx(containerView.getContext(), adSize.getHeight());
                containerView.setLayoutParams(layoutParams);
                this.a.renderAd(i, containerView);
                return;
            }
            layoutParams.width = -2;
            layoutParams.height = -2;
            containerView.setLayoutParams(layoutParams);
            return;
        }
        this.b.onBindViewHolder(viewHolder, this.a.getOriginalPosition(i));
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i != -42) {
            return this.b.onCreateViewHolder(viewGroup, i);
        }
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.max_native_ad_recycler_view_item, viewGroup, false);
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        RecyclerView.LayoutManager layoutManager = this.d.getLayoutManager();
        if (layoutManager == null || !layoutManager.canScrollHorizontally()) {
            layoutParams.width = -1;
            layoutParams.height = -2;
        } else {
            layoutParams.width = -2;
            layoutParams.height = -1;
        }
        inflate.setLayoutParams(layoutParams);
        return new MaxAdRecyclerViewHolder(inflate);
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.d = null;
        c cVar = this.e;
        if (cVar != null) {
            cVar.a();
            this.e = null;
        }
    }

    public boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        return viewHolder instanceof MaxAdRecyclerViewHolder ? super.onFailedToRecycleView(viewHolder) : this.b.onFailedToRecycleView(viewHolder);
    }

    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof MaxAdRecyclerViewHolder) {
            super.onViewAttachedToWindow(viewHolder);
        } else {
            this.b.onViewAttachedToWindow(viewHolder);
        }
    }

    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof MaxAdRecyclerViewHolder) {
            super.onViewDetachedFromWindow(viewHolder);
        } else {
            this.b.onViewDetachedFromWindow(viewHolder);
        }
    }

    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        c cVar = this.e;
        if (cVar != null) {
            cVar.a(viewHolder.itemView);
        }
        if (viewHolder instanceof MaxAdRecyclerViewHolder) {
            if (this.a.isFilledPosition(viewHolder.getBindingAdapterPosition())) {
                ((MaxAdRecyclerViewHolder) viewHolder).getContainerView().removeAllViews();
            }
            super.onViewRecycled(viewHolder);
            return;
        }
        this.b.onViewRecycled(viewHolder);
    }

    public void setAdPositionBehavior(AdPositionBehavior adPositionBehavior) {
        this.h = adPositionBehavior;
    }

    public void setHasStableIds(boolean z) {
        super.setHasStableIds(z);
        this.b.unregisterAdapterDataObserver(this.c);
        this.b.setHasStableIds(z);
        this.b.registerAdapterDataObserver(this.c);
    }

    public void setListener(MaxAdPlacer.Listener listener) {
        this.f = listener;
    }

    public void setLookAhead(int i) {
        this.g = i;
    }
}
