package com.rairmmd.facedetect;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.megvii.cloud.http.CommonOperate;
import com.megvii.cloud.http.FaceSetOperate;
import com.megvii.cloud.http.Response;
import com.megvii.facepp.sdk.Facepp;
import com.rairmmd.facedetect.bean.FaceModel;
import com.rairmmd.facedetect.constant.Constants;
import com.rairmmd.facedetect.utils.FaceUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class PictureActivity extends AppCompatActivity {

    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        ImageView ivPicture = findViewById(R.id.iv_picture);
        tvResult = findViewById(R.id.tv_result);
        tvResult.setMovementMethod(ScrollingMovementMethod.getInstance());

        String picturePath = getIntent().getStringExtra(Constants.PATH_KEY);
        Bitmap bitmap = FaceUtils.DetectionBitmap(BitmapFactory.decodeFile(picturePath));
        ivPicture.setImageBitmap(bitmap);

        Facepp facepp = new Facepp();
        facepp.init(this, getFileContent(this, R.raw.megviifacepp_0_5_2_model), 0);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        final byte[] datas = baos.toByteArray();

        Facepp.Face[] faces = facepp.detect(datas, bitmap.getWidth(), bitmap.getHeight(), Facepp.IMAGEMODE_RGB);
        Log.i("yoju", "(PictureActivity.java:50)-onCreate:->" + faces.length);

        new Thread() {

            @Override
            public void run() {
                CommonOperate commonOperate = new CommonOperate("3pMHpN3yzpRvgvYWGLBTEPpoMKD5yz53", "noqQ3P4Xm5FmqSvOV9wbYYp46jt0R1KQ", false);
                FaceSetOperate faceSetOperate = new FaceSetOperate("3pMHpN3yzpRvgvYWGLBTEPpoMKD5yz53", "noqQ3P4Xm5FmqSvOV9wbYYp46jt0R1KQ", false);
                try {
                    Response test = faceSetOperate.getDetailByOuterId("test");
                    Log.i("Rair", "(PictureActivity.java:49)-run:->" + new String(test.getContent()));
                    Response response = commonOperate.detectByte(datas, 1, null);
                    Log.i("yoju", "(FaceDetectorActivity.java:189)-face:->" + response.getStatus());
                    if (response.getStatus() == 200) {
                        final String faceJson = new String(response.getContent());
                        FaceModel faceResult = new Gson().fromJson(faceJson, FaceModel.class);
                        response = faceSetOperate.createFaceSet(null, "test", null, faceResult.getFaces().get(0).getFaceToken(), null, 1);
                        Log.i("yoju", "(PictureActivity.java:54)-run:->" + response.getStatus());
                        Log.i("yoju", "(PictureActivity.java:54)-run:->" + new String(response.getContent()));
                        tvResult.post(new Runnable() {
                            @Override
                            public void run() {
                                tvResult.setText(faceJson);
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private byte[] getFileContent(Context context, int id) {
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int count = -1;
        try {
            inputStream = context.getResources().openRawResource(id);
            while ((count = inputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, count);
            }
            byteArrayOutputStream.close();
        } catch (IOException e) {
            return null;
        }
        return byteArrayOutputStream.toByteArray();
    }
}
