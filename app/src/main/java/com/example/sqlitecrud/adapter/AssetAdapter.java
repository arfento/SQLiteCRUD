package com.example.sqlitecrud.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sqlitecrud.activity.HistoryActivity;
import com.example.sqlitecrud.R;
import com.example.sqlitecrud.model.PendingItem;

import java.util.List;
import java.util.prefs.Preferences;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class AssetAdapter extends RecyclerView.Adapter<AssetAdapter.ViewHolder> {

    Context context;
    List<PendingItem> pendingModels;
    Preferences preferences;

    public AssetAdapter (Context context, List<PendingItem> inquiryModels){
        this.context = context;
        this.pendingModels = inquiryModels;
//        preferences = App.getInstance().preferences();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_asset_barcode,viewGroup,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, @SuppressLint("RecyclerView") final int i) {
        viewHolder.bardoceNo.setText(pendingModels.get(i).getBarcode());
        viewHolder.stsMobile.setText(pendingModels.get(i).getStatusMob());
        viewHolder.kodeAsset.setText(pendingModels.get(i).getAssetCode());
        viewHolder.namaAsset.setText(pendingModels.get(i).getAssetName());
        viewHolder.merkOrtype.setText(pendingModels.get(i).getMerkType());
        viewHolder.kondisi.setText(pendingModels.get(i).getCondition());
//        viewHolder.stsMobile.setText(Base.rupiahFormat(Double.toString(inquiryModels.get(i).getLeased_value())));
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                preferences.saveSPString(Preferences.SP_AGREEMENT_NO, inquiryModels.get(i).getAgreementNo());
                Intent intent = new Intent(context, HistoryActivity.class);
//                intent.putExtra("IDQRMOB", Integer.toString(pendingModels.get(i).getIdqrmob()));
                intent.putExtra("IDQRMOB", pendingModels.get(i).getIdqrmob().toString());
                intent.putExtra("BARCODENO", pendingModels.get(i).getBarcode());
                intent.putExtra("KODEASSET", pendingModels.get(i).getAssetCode());
                intent.putExtra("NAMAASSET", pendingModels.get(i).getAssetName());
                intent.putExtra("MERK", pendingModels.get(i).getMerkType());
                intent.putExtra("KONDISI", pendingModels.get(i).getCondition());
                intent.putExtra("UNIT", pendingModels.get(i).getUnit());
                intent.putExtra("LOKASIASAL", pendingModels.get(i).getRegisterBranch());
                intent.putExtra("LOKASICURRENT", pendingModels.get(i).getCurrentBranch());
                intent.putExtra("TGLBELI", pendingModels.get(i).getPurchaseDate());
                intent.putExtra("NILAIPEROLEHAN", Double.toString(pendingModels.get(i).getAssetValue()));
                intent.putExtra("NORANGKA", pendingModels.get(i).getChassisNo());
                intent.putExtra("NOMESIN", pendingModels.get(i).getEngineNo());
                intent.putExtra("NOPOLISI", pendingModels.get(i).getPlatNo());
                intent.putExtra("STSASSET", pendingModels.get(i).getAssetStatus());
                intent.putExtra("STSMOB", pendingModels.get(i).getStatusMob());
                intent.putExtra("REMAKS", pendingModels.get(i).getRemarks());

                context.startActivity(intent);

                ((Activity) context).finish();
            }
        });
    }

    @Override
    public int getItemCount() {
        return pendingModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView bardoceNo, stsMobile, kodeAsset, namaAsset, merkOrtype, kondisi;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardViewHeader);
            bardoceNo = itemView.findViewById(R.id.barcodeNo);
            stsMobile = itemView.findViewById(R.id.statusMobile);
            kodeAsset = itemView.findViewById(R.id.assetCode);
            namaAsset = itemView.findViewById(R.id.assetName);
            merkOrtype = itemView.findViewById(R.id.merkOrType);
            kondisi = itemView.findViewById(R.id.kondisi);
        }
    }

//    public void updateList(List<PendingItem> pendingItems) {
//        this.pendingItems.clear();
//        this.mChatDetails.addAll(mChatDetails);
//    }
}
