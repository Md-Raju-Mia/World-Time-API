package com.example.finalgetapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.finalgetapi.model.ResponseModel;

import java.util.List;

public class ResponseModelAdapter extends ArrayAdapter<ResponseModel> {
    private Context context;
    private List<ResponseModel> responseModels;

    public ResponseModelAdapter(Context context, List<ResponseModel> responseModels) {
        super(context, 0, responseModels);
        this.context = context;
        this.responseModels = responseModels;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ResponseModel responseModel = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        TextView abbreviation = convertView.findViewById(R.id.abbreviation);
        TextView clientIp = convertView.findViewById(R.id.client_ip);
        TextView datetime = convertView.findViewById(R.id.datetime);
        TextView dayOfWeek = convertView.findViewById(R.id.day_of_week);
        TextView dayOfYear = convertView.findViewById(R.id.day_of_year);
        TextView dst = convertView.findViewById(R.id.dst);
        TextView dstFrom = convertView.findViewById(R.id.dst_from);
        TextView dstOffset = convertView.findViewById(R.id.dst_offset);
        TextView dstUntil = convertView.findViewById(R.id.dst_until);
        TextView rawOffset = convertView.findViewById(R.id.raw_offset);
        TextView timezone = convertView.findViewById(R.id.timezone);
        TextView unixtime = convertView.findViewById(R.id.unixtime);
        TextView utcDatetime = convertView.findViewById(R.id.utc_datetime);
        TextView utcOffset = convertView.findViewById(R.id.utc_offset);
        TextView weekNumber = convertView.findViewById(R.id.week_number);

        abbreviation.setText(responseModel.getAbbreviation());
        clientIp.setText(responseModel.getClientIp());
        datetime.setText(responseModel.getDatetime());
        dayOfWeek.setText(String.valueOf(responseModel.getDayOfWeek()));
        dayOfYear.setText(String.valueOf(responseModel.getDayOfYear()));
        dst.setText(String.valueOf(responseModel.isDst()));
        dstFrom.setText(responseModel.getDstFrom());
        dstOffset.setText(String.valueOf(responseModel.getDstOffset()));
        dstUntil.setText(responseModel.getDstUntil());
        rawOffset.setText(String.valueOf(responseModel.getRawOffset()));
        timezone.setText(responseModel.getTimezone());
        unixtime.setText(String.valueOf(responseModel.getUnixtime()));
        utcDatetime.setText(responseModel.getUtcDatetime());
        utcOffset.setText(responseModel.getUtcOffset());
        weekNumber.setText(String.valueOf(responseModel.getWeekNumber()));

        return convertView;
    }
}
